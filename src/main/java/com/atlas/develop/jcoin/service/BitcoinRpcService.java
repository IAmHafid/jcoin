package com.atlas.develop.jcoin.service;

import com.atlas.develop.jcoin.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class BitcoinRpcService {

    @Value("${bitcoin.rpc.url}")
    private String rpcUrl;

    @Value("${bitcoin.rpc.username}")
    private String rpcUsername;

    @Value("${bitcoin.rpc.password}")
    private String rpcPassword;

    private RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> callRpcMethod(String method, Object... params) {
        // Création du corps de la requête RPC
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("jsonrpc", "1.0");
        requestBody.put("id", "curltest");
        requestBody.put("method", method);
        requestBody.put("params", params);

        // Création de l'en-tête de la requête HTTP avec authentification
        HttpHeaders headers = new HttpHeaders();
        String auth = rpcUsername + ":" + rpcPassword;
        headers.add("Authorization", "Basic " + Base64.getEncoder().encodeToString(auth.getBytes()));

        // Création de la requête HTTP
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        // Envoi de la requête et retour de la réponse
        try {
            ResponseEntity<Map> response = restTemplate.exchange(rpcUrl, HttpMethod.POST, request, Map.class);
            return response.getBody();  // Traiter la réponse ici
        } catch (HttpClientErrorException e) {
            // Gestion des erreurs HTTP (4xx, 5xx)
            throw new BadRequestException("Erreur HTTP lors de l'appel RPC: " + e.getStatusCode());
        }
        /*} catch (ResourceAccessException e) {
            // Gestion des erreurs de connexion (par exemple, le nœud est inaccessible)
            System.err.println("Erreur de connexion au nœud Bitcoin: " + e.getMessage());
        } catch (Exception e) {
            // Gestion des autres types d'erreurs
            System.err.println("Erreur inattendue: " + e.getMessage());
        }*/
    }
}
