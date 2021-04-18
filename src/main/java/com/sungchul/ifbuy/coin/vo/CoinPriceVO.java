package com.sungchul.ifbuy.coin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor //매게변수 없는 생성자
@AllArgsConstructor //매게변수 있는 생성자
public class CoinPriceVO {

    //캔들 기준 시각(UTC 기준)
    @JsonProperty("candle_date_time_utc")
    String candleDateTimeUtc;

    //캔들 기준 시각(KST 기준)
    @JsonProperty("candle_date_time_kst")
    String candleDateTimeKst;

    //시가
    @JsonProperty("opening_price")
    String openingPrice;

    //고가
    @JsonProperty("high_price")
    String highPrice;

    //저가
    @JsonProperty("low_price")
    String lowPrice;

    //종가
    @JsonProperty("trade_price")
    String tradePrice;

    //누적 거래 금액
    @JsonProperty("candle_acc_trade_price")
    String candleAccTradePrice;

    //누적 거래량
    @JsonProperty("candle_acc_trade_volume")
    String candleAccTradeVolume;

    //분단위
    @JsonProperty("unit")
    String unit;

}
