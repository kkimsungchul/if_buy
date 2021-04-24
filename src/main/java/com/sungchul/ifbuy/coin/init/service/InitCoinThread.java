package com.sungchul.ifbuy.coin.init.service;

import com.sungchul.ifbuy.coin.service.CoinService;
import com.sungchul.ifbuy.coin.utils.BeanUtils;
import com.sungchul.ifbuy.coin.vo.CoinVO;

import java.util.List;

public class InitCoinThread extends Thread{
    CoinService coinService;
    InitCoinService initCoinService;
    public InitCoinThread(){

        coinService =(CoinService) BeanUtils.getBean("coinService");
        initCoinService = (InitCoinService)BeanUtils.getBean("initCoinService");
    }

    public void run(){
        List<CoinVO> coinList = coinService.getCoinInfo();
        try {
            for(int i=0;i<coinList.size();i++){
                if (coinList.get(i).getMarket().contains("KRW")){
                    initCoinService.getAllCoinPrice(coinList.get(i));
                }
                if(i%10==0){
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e){
        }
    }
}
