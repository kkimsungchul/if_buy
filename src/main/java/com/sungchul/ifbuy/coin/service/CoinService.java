package com.sungchul.ifbuy.coin.service;


import com.sungchul.ifbuy.coin.vo.CoinPriceVO;
import com.sungchul.ifbuy.coin.vo.CoinVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CoinService {

    public List<CoinVO> getCoinValue(){

        String url = "https://api.upbit.com/v1/market/all?isDetails=false";
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000); //타임아웃 설정 5초
        factory.setReadTimeout(5000);//타임아웃 설정 5초
        RestTemplate restTemplate = new RestTemplate(factory);
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);
        ResponseEntity<List<CoinVO>> resList = restTemplate.exchange(url.toString(), HttpMethod.GET, entity,new ParameterizedTypeReference<List<CoinVO>>() {});
       /* log.info("### resList : {}" ,resList);*/
        List<CoinVO> coinList =  resList.getBody();

/*        for(int i=0;i< resList.getBody().size();i++){
            log.info("### resList : {}" , resList.getBody().get(i));
        }*/
        return coinList;
    }

    public List<CoinVO> getCoinPrice(){
        List<CoinVO> coinPriceList = getCoinValue();
        String coinName;
        String url;
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000); //타임아웃 설정 5초
        factory.setReadTimeout(5000);//타임아웃 설정 5초
        RestTemplate restTemplate = new RestTemplate(factory);
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);

        //for(int i=0;i<coinPriceList.size();i++){
        for(int i=0;i<10;i++){
            coinName =coinPriceList.get(i).getMarket();
            url = "https://api.upbit.com/v1/candles/minutes/1?market="+coinName+"&count=1";
            //url = "https://api.upbit.com/v1/candles/minutes/1?market=KRW-BTC&count=1";
            ResponseEntity<List<CoinPriceVO>> res = restTemplate.exchange(url.toString(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<CoinPriceVO>>() {});
            log.info("### resList : {}" ,res);
            //받아온 값을 리스트로 변환
            List<CoinPriceVO> temp= res.getBody();
            log.info("### temp : {}" ,temp);

            //리스트에 들어있는 값을 VO로 변환
            CoinPriceVO coinPriceVO = temp.get(0);
            log.info("### cpv : {}" ,coinPriceVO);
            coinPriceList.get(i).setCoinPriceVO(coinPriceVO);

        }

        return coinPriceList;

    }
}

