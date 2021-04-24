package com.sungchul.ifbuy.coin.job;

import com.sungchul.ifbuy.coin.service.CoinInfoThread;
import com.sungchul.ifbuy.coin.service.CoinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CoinInfoJob {

    @Autowired
    CoinService coinService;



//
//
//    @Scheduled(cron ="0 1 9 * * *")
//    public void getUpbitCoinInfoDay(){
//        log.info("# getUpbitCoinInfoDay Scheduled Start ! ");
//        String period = "days";
//        CoinInfoThread coinInfoThread = new CoinInfoThread();
//        coinInfoThread.run(period);
//    }
//
//    @Scheduled(cron ="* */1 * * * *")
//    public void getUpbitCoinInfoMinute(){
//        log.info("# Scheduled Scheduled Start ! ");
//        String period = "minutes";
//        CoinInfoThread coinInfoThread = new CoinInfoThread();
//        coinInfoThread.run(period);
//    }
//
//
//    @Scheduled(cron ="0 0 9 * * *")
//    public void deleteCoinInfoMinute(){
//        log.info("# CoinInfoMinute Scheduled Start ! ");
//        coinService.deleteCoinInfoMinute();
//
//    }
}
