package com.atlas.develop.jcoin.controller;

import com.atlas.develop.jcoin.service.BitcoinRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/mining")
public class MiningController {

    @Autowired
    private BitcoinRpcService bitcoinRpcService;

    //Fournit un modèle de bloc à miner.
    @GetMapping("/getblocktemplate")
    public Map<String, Object> getblocktemplate(){
        // do nothing yet
        return null;
    }

    // Renvoie des informations liées au minage.
    @GetMapping("getmininginfo")
    public Map<String, Object> getmininginfo(){
        return bitcoinRpcService.callRpcMethod("getmininginfo");
    }

    //Soumet un bloc complet au réseau.
    @PostMapping("/submitblock")
    public Map<String, Object> submitblock()
    {
        // do nothing yet
        return null;
    }
}
