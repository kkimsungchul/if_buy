package com.sungchul.ifbuy.coin.mapper;

import com.sungchul.ifbuy.coin.vo.CoinVO;
import org.apache.ibatis.annotations.*;




public interface CoinMapper {

    @Select("SELECT now()")
    public String time();

    @Insert("INSERT INTO coin_price_minute (" +
            "korean_name, " +
            "english_name, " +
            "market, " +
            "opening_price, " +
            "high_price, " +
            "low_price, " +
            "trade_price, " +
            "candle_acc_trade_price, " +
            "candle_acc_trade_volume, " +
            "unit, " +
            "candle_date_time_kst, " +
            "candle_date_time_utc )" +
            "VALUES(" +
            "#{koreanName}, " +
            "#{englishName}, " +
            "#{market}, " +
            "#{coinPriceVO.openingPrice}, " +
            "#{coinPriceVO.highPrice}, " +
            "#{coinPriceVO.lowPrice}, " +
            "#{coinPriceVO.tradePrice}, " +
            "#{coinPriceVO.candleAccTradePrice}, " +
            "#{coinPriceVO.candleAccTradeVolume}, " +
            "#{coinPriceVO.unit}, " +
            "#{coinPriceVO.candleDateTimeKst}, " +
            "#{coinPriceVO.candleDateTimeUtc}) ")
    public void insertCoinPriceMinute(CoinVO coinVO);


    @Insert("INSERT INTO coin_price_day (" +
            "korean_name, " +
            "english_name, " +
            "market, " +
            "opening_price, " +
            "high_price, " +
            "low_price, " +
            "trade_price, " +
            "candle_acc_trade_price, " +
            "candle_acc_trade_volume, " +
            "unit, " +
            "candle_date_time_kst, " +
            "candle_date_time_utc )" +
            "VALUES(" +
            "#{koreanName}, " +
            "#{englishName}, " +
            "#{market}, " +
            "#{coinPriceVO.openingPrice}, " +
            "#{coinPriceVO.highPrice}, " +
            "#{coinPriceVO.lowPrice}, " +
            "#{coinPriceVO.tradePrice}, " +
            "#{coinPriceVO.candleAccTradePrice}, " +
            "#{coinPriceVO.candleAccTradeVolume}, " +
            "#{coinPriceVO.unit}, " +
            "#{coinPriceVO.candleDateTimeKst}, " +
            "#{coinPriceVO.candleDateTimeUtc}) ")
    public void insertCoinPriceDay(CoinVO coinVO);


    @Delete("TRUNCATE coin_price_minute")
    public void deleteCoinInfoMinute();

}
