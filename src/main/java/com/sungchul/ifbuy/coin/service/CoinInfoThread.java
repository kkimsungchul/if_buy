package com.sungchul.ifbuy.coin.service;

import com.sungchul.ifbuy.coin.utils.BeanUtils;
import com.sungchul.ifbuy.coin.vo.CoinVO;

import java.util.List;


public class CoinInfoThread extends Thread {
    CoinService coinService;
    public CoinInfoThread(){
        coinService =(CoinService) BeanUtils.getBean("coinService");
    }

    public void run(){
        List<CoinVO> coinList = coinService.getCoinValue();
        try {
            System.out.println("CoinInfoThread Start~~");
            CoinVO tempCoinVO = new CoinVO();
            for (int i =0;i<coinList.size();i++){

                tempCoinVO = coinService.getCoinPrice(coinList.get(i));
                coinList.get(i).setCoinPriceVO(tempCoinVO.getCoinPriceVO());
                if(i%10==0){
                    Thread.sleep(2000);
                }
            }

            //System.out.println(coinService.getCoinPrice());


            System.out.println("CoinInfoThread End~~");
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
