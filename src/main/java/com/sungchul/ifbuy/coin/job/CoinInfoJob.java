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





    //아침 9시 1분마다 전날 코인의 가격 가져오기
    @Scheduled(cron ="0 1 9 * * *")
    public void getUpbitCoinInfoDay(){
        log.info("# getUpbitCoinInfoDay Scheduled Start ! ");
        String period = "days";
        CoinInfoThread coinInfoThread = new CoinInfoThread();
        coinInfoThread.run(period);
    }

    //매분마다 코인가격정보 가져오기
    @Scheduled(cron ="* */1 * * * *")
    public void getUpbitCoinInfoMinute(){
        log.info("# Scheduled Scheduled Start ! ");
        String period = "minutes";
        CoinInfoThread coinInfoThread = new CoinInfoThread();
        coinInfoThread.run(period);
    }

    //아침9시에 1분단위로 저장한 코인가격 삭제
    @Scheduled(cron ="0 0 9 * * *")
    public void deleteCoinInfoMinute(){
        log.info("# CoinInfoMinute Scheduled Start ! ");
        coinService.deleteCoinInfoMinute();

    }
}
