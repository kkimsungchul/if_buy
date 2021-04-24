package com.sungchul.ifbuy.coin.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CoinControllerTest1 {


    @GetMapping("/a")
    public String test(){

        return "test~~~~";
    }


}
