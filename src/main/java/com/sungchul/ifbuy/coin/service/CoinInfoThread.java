package com.sungchul.ifbuy.coin.service;

import com.sungchul.ifbuy.coin.utils.BeanUtils;
import com.sungchul.ifbuy.coin.utils.DateUtil;
import com.sungchul.ifbuy.coin.vo.CoinVO;

import java.util.List;


public class CoinInfoThread extends Thread {
    CoinService coinService;
    public CoinInfoThread(){
        coinService =(CoinService) BeanUtils.getBean("coinService");
    }

    public void run(String period){
//        List<CoinVO> coinList = coinService.getCoinInfo();
//        String url;
//        try {
//            System.out.println("CoinInfoThread Start~~");
//            for (int i =0;i<coinList.size();i++){
//                //원화마켓만
//                if (coinList.get(i).getMarket().contains("KRW")){
//                    url = getUpbitURL(period,coinList.get(i).getMarket());
//                    coinService.getCoinPrice(coinList.get(i) , url,period);
//                }
//                if(i%10==0){
//                    Thread.sleep(1000);
//                }
//            }
//            System.out.println("CoinInfoThread End~~");
//        }catch (InterruptedException e){
//            System.out.println(e);
//        }
    }


    ///https://api.upbit.com/v1/market/all?isDetails=false
    //https://api.upbit.com/v1/candles/minutes/1?market=KRW-BTC

    public String getUpbitURL(String period,String market){
        String url="";
        if(period.equalsIgnoreCase("minutes")){
            url="https://api.upbit.com/v1/candles/minutes/1?market="+market;
        }else if(period.equalsIgnoreCase("days")){
            DateUtil dateUtil = new DateUtil();
            String date = dateUtil.getTime("yyyy-MM-dd ") + "08:59:59";
            url="https://api.upbit.com/v1/candles/days?market="+market+"&to=";
        }else if(period.equalsIgnoreCase("weeks"+market)){
            url="https://api.upbit.com/v1/candles/weeks?market="+market;
        }else if(period.equalsIgnoreCase("months")){
            url="https://api.upbit.com/v1/candles/months?market="+market;
        }
        return url;
    }

}
