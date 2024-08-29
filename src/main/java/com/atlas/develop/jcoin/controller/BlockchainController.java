package com.atlas.develop.jcoin.controller;

import com.atlas.develop.jcoin.service.BitcoinRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/blockchain")
public class BlockchainController {

    @Autowired
    private BitcoinRpcService bitcoinRpcService;

    // Renvoie le nombre de blocs dans la meilleure chaîne.
    @GetMapping("/getblockcount")
    public Map<String, Object> getblockcount(){
        return bitcoinRpcService.callRpcMethod("getblockcount");
    }

    // Renvoie le hachage du meilleur bloc actuel.
    @GetMapping("/getbestblockhash")
    public Map<String, Object> getbestblockhash(){
        return bitcoinRpcService.callRpcMethod("getbestblockhash");
    }


    // Renvoie le hachage d'un bloc à un certain index.
    @GetMapping("/getblockhash/{height}")
    public Map<String, Object> getblockhash(@PathVariable("height") Long height) {
        return bitcoinRpcService.callRpcMethod("getblockhash", height);
    }


    // Renvoie les informations sur un bloc, donné son hachage.
    @GetMapping("/getblock/{hash}")
    public Map<String, Object> getblock(@PathVariable("hash") String hash){
        return bitcoinRpcService.callRpcMethod("getblock", hash);
    }


    // Renvoie les informations sur tous les tips de chaînes connues.
    @GetMapping("/getchaintips")
    public Map<String, Object> getchaintips(){
        return null;
    }


    // Renvoie la difficulté actuelle du réseau.
    @GetMapping("/getdifficulty")
    public Map<String, Object> getdifficulty(){
        return bitcoinRpcService.callRpcMethod("getdifficulty");
    }


}
