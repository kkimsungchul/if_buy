package com.sungchul.ifbuy.coin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoinViewController {

    @GetMapping("coin")
    public String write(){
        return "coin/coinList.html";
    }
}
