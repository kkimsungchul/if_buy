package com.sungchul.ifbuy.coin.init.controller;

import com.sungchul.ifbuy.coin.init.service.InitCoinThread;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("admin")
public class InintController {

    @GetMapping("/InitCoin")
    public void InitCoin(){
        InitCoinThread initCoinThread = new InitCoinThread();
        initCoinThread.run();
    }
}
