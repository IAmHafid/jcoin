package com.atlas.develop.jcoin.controller;

import com.atlas.develop.jcoin.service.BitcoinRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/blockchain")
public class BlockchainController {

    @Autowired
    private BitcoinRpcService bitcoinRpcService;

    @GetMapping("/getblockcount")
    public Map<String, Object> getblockcount(){
        return null;
    }

    //Renvoie le nombre de blocs dans la meilleure chaîne.

    @GetMapping("/getbestblockhash")
    public Map<String, Object> getbestblockhash(){
        return null;
    }
    //: Renvoie le hachage du meilleur bloc actuel.

    @GetMapping("/getblockhash")
    public Map<String, Object> getblockhash(){
        return null;
    }
    //: Renvoie le hachage d'un bloc à un certain index.

    @GetMapping("/getblock")
    public Map<String, Object> getblock(){
        return null;
    }
    // : Renvoie les informations sur un bloc, donné son hachage.

    @GetMapping("/getchaintips")
    public Map<String, Object> getchaintips(){
        return null;
    }
    // : Renvoie les informations sur tous les tips de chaînes connues.

    @GetMapping("/getdifficulty")
    public Map<String, Object> getdifficulty(){
        return null;
    }
    //: Renvoie la difficulté actuelle du réseau.

}
