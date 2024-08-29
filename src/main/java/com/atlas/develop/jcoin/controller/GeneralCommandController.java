package com.atlas.develop.jcoin.controller;


import com.atlas.develop.jcoin.service.BitcoinRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/generalcommand")
public class GeneralCommandController {

    @Autowired
    private BitcoinRpcService bitcoinRpcService;

    @GetMapping("/getblockchaininfo")
    public Map<String, Object> getBlockchainInfo() {
        return bitcoinRpcService.callRpcMethod("getblockchaininfo");
    }

    @GetMapping("/getnetworkinfo")
    public Map<String, Object> getNetworkInfo() {
        return bitcoinRpcService.callRpcMethod("getnetworkinfo");
    }

    @GetMapping("/getmininginfo")
    public Map<String, Object> getMiningInfo() {
        return bitcoinRpcService.callRpcMethod("getmininginfo");
    }

    @GetMapping("/getpeerinfo")
    public Map<String, Object> getPeerInfo() {
        return bitcoinRpcService.callRpcMethod("getpeerinfo");
    }

    @GetMapping("/getmempoolinfo")
    public Map<String, Object> getMempoolInfo() {
        return bitcoinRpcService.callRpcMethod("getmempoolinfo");
    }

    @GetMapping("/uptime")
    public Map<String, Object> getUptime() {
        return bitcoinRpcService.callRpcMethod("uptime");
    }
}
