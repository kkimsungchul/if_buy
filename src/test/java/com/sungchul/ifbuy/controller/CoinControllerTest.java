package com.sungchul.ifbuy.controller;


import com.sungchul.ifbuy.coin.controller.CoinControllerTest1;
import com.sungchul.ifbuy.coin.service.CoinService;
import com.sungchul.ifbuy.coin.vo.CoinVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestController;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RestController
@Slf4j
public class CoinControllerTest {

    @Autowired
    CoinControllerTest1 coinControllerTest1;

    @Autowired
    CoinService coinServices;

    @Test
    @Order(2)
    void test(){
        assertThat(coinControllerTest1.test().equals("test~~~~"));
    }

    @Test
    @Order(1)
    void test2(){
        CoinVO coinVO = new CoinVO();
        coinVO.setMarket("KRW-BTC");
        //log.info("### price : {}",coinServices.getCoinPrice(coinVO).toString());

    }



}
