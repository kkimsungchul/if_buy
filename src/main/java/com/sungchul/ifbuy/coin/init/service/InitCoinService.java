package com.sungchul.ifbuy.coin.init.service;

import com.sungchul.ifbuy.coin.mapper.CoinMapper;
import com.sungchul.ifbuy.coin.service.CoinService;
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


@Service("initCoinService")
@AllArgsConstructor
@Slf4j
public class InitCoinService {

    CoinMapper coinMapper;
    CoinService coinService;

    //일자별 초기 코인값 세팅을 위해 작성
    public List<CoinPriceVO> getAllCoinPrice(CoinVO coinVO){

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000); //타임아웃 설정 5초
        factory.setReadTimeout(5000);//타임아웃 설정 5초
        RestTemplate restTemplate = new RestTemplate(factory);
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);
        String url="https://api.upbit.com/v1/candles/days?market="+coinVO.getMarket()+"&count=120";
        ResponseEntity<List<CoinPriceVO>> res = restTemplate.exchange(url.toString(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<CoinPriceVO>>() {});
        //받아온 값을 리스트로 변환
        List<CoinPriceVO> temp= res.getBody();
        for(int i=0;i<temp.size();i++){
            CoinPriceVO coinPriceVO = temp.get(i);
            coinService.replaceDate(coinPriceVO);
            coinVO.setCoinPriceVO(coinPriceVO);
            coinMapper.insertCoinPriceDay(coinVO);
        }
        return temp;
    }
}
