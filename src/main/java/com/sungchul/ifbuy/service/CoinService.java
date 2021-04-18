package com.sungchul.ifbuy.service;


import com.sungchul.ifbuy.vo.CoinObject;
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
import java.util.logging.Logger;

@Service
@AllArgsConstructor
@Slf4j
public class CoinService {

    public void getCoinValue(){

        String url = "https://api.upbit.com/v1/market/all?isDetails=false";
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000); //타임아웃 설정 5초
        factory.setReadTimeout(5000);//타임아웃 설정 5초
        RestTemplate restTemplate = new RestTemplate(factory);
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);
        ResponseEntity<List<CoinObject>> resList = restTemplate.exchange(url.toString(), HttpMethod.GET, entity,new ParameterizedTypeReference<List<CoinObject>>() {});
       /* log.info("### resList : {}" ,resList);*/
        CoinObject coinObject = resList.getBody().get(1);
        log.info("### coinObject : {}" ,coinObject);

/*        for(int i=0;i< resList.getBody().size();i++){
            log.info("### resList : {}" , resList.getBody().get(i));
        }*/

    }
}

