package com.sungchul.ifbuy.coin.job;

import com.sungchul.ifbuy.coin.service.CoinInfoThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CoinInfoJob {

    @Scheduled(fixedDelay = 30000)
    public void getUpbitCoinInfo(){
        log.info("# Scheduled Start ! ");
        CoinInfoThread coinInfoThread = new CoinInfoThread();
        coinInfoThread.run();

    }
}
