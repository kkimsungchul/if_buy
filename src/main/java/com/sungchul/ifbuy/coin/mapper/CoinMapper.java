package com.sungchul.ifbuy.coin.mapper;

import com.sungchul.ifbuy.coin.vo.CoinVO;
import org.apache.ibatis.annotations.*;

import java.util.List;


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
            "#{openingPrice}, " +
            "#{highPrice}, " +
            "#{lowPrice}, " +
            "#{tradePrice}, " +
            "#{candleAccTradePrice}, " +
            "#{candleAccTradeVolume}, " +
            "#{unit}, " +
            "#{candleDateTimeKst}, " +
            "#{candleDateTimeUtc}) ")
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
            "#{openingPrice}, " +
            "#{highPrice}, " +
            "#{lowPrice}, " +
            "#{tradePrice}, " +
            "#{candleAccTradePrice}, " +
            "#{candleAccTradeVolume}, " +
            "#{unit}, " +
            "#{candleDateTimeKst}, " +
            "#{candleDateTimeUtc}) ")
    public void insertCoinPriceDay(CoinVO coinVO);


    @Delete("TRUNCATE coin_price_minute")
    public void deleteCoinInfoMinute();


    @Select("SELECT  " +
            "market,  " +
            "english_name,  " +
            "korean_name ,  " +
            "trade_price , " +
            "candle_date_time_kst , " +
            "create_time " +
            "FROM coin_price_minute  " +
            "WHERE (korean_name,create_time) IN ( " +
            "SELECT korean_name, max(create_time) FROM coin_price_minute " +
            "GROUP BY korean_name " +
            ")ORDER BY candle_date_time_kst DESC")
    public List<CoinVO> getCoinList();

    @Select("SELECT * FROM coin_price_day " +
            "WHERE market = #{coinName}")
    public List<CoinVO> selectCoinPrice(String coinName);
}
