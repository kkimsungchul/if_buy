package com.sungchul.ifbuy.coin.controller;


import com.sungchul.ifbuy.coin.mapper.CoinMapper;
import com.sungchul.ifbuy.coin.service.CoinService;
import com.sungchul.ifbuy.coin.vo.CoinVO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("coin")
public class CoinController {


    private CoinService coinService;
    private CoinMapper coinMapper;

    @GetMapping("/coinList")
    public List<CoinVO> newCoin(){
        return coinService.getCoinValue();
    }

    @GetMapping("/dbTest")
    public void dbTest(){
        System.out.println(coinMapper.time());
    }
/*    @GetMapping("/coinPrice")
    public List<CoinVO> coinPrice(){
        return coinService.getCoinPrice();
    }*/



    /*
    @RequestMapping(value="/" , method = RequestMethod.GET)
    public HashMap<String,String> temp1(){
        HashMap<String,String> temp01Map = new HashMap<>();
        temp01Map.put("name","김성철");
        temp01Map.put("age","31");
        return temp01Map;
    }

    @RequestMapping(value="/" , method = RequestMethod.DELETE)
    public VO temp2(){
        VO vo = new VO();
        vo.setAge("27");
        vo.setName("김범수");

        return vo;
    }

    @RequestMapping(value="/" , method = RequestMethod.POST)
    public String temp3(){

        return "hello Springboot POST";
    }

    @RequestMapping(value="/" , method = RequestMethod.PUT)
    public String temp4(){

        return "hello Springboot PUT";
    }
*/



/*
    @GetMapping("temperature")
    public String temperature(){
        HashMap<String, Object> result = new HashMap<String, Object>();

        String jsonInString = "";

        try {

            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
            factory.setConnectTimeout(5000); //타임아웃 설정 5초
            factory.setReadTimeout(5000);//타임아웃 설정 5초
            RestTemplate restTemplate = new RestTemplate(factory);

            HttpHeaders header = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(header);

            String url = "https://api.hangang.msub.kr/";


            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

            //이 한줄의 코드로 API를 호출해 MAP타입으로 전달 받는다.
            ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
            result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
            result.put("body", resultMap.getBody()); //실제 데이터 정보 확인

            //데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(resultMap.getBody());

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("dfdfdfdf");
            System.out.println(e.toString());

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion오류");
            System.out.println(e.toString());
        }
        return jsonInString;
    }

    @GetMapping("coin")
    public String coin(){
        HashMap<String, Object> result = new HashMap<String, Object>();

        String jsonInString = "";

        try {
*//*
            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
            factory.setConnectTimeout(5000); //타임아웃 설정 5초
            factory.setReadTimeout(5000);//타임아웃 설정 5초*//*
//            RestTemplate restTemplate = new RestTemplate(factory);
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders header = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(header);


            //String url = "https://api.hangang.msub.kr/";
            String url = "https://api.upbit.com/v1/market/all?isDetails=false";

            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

            //이 한줄의 코드로 API를 호출해 MAP타입으로 전달 받는다.
            ResponseEntity<Object> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Object.class);
            //엔티티안에 헤더값 들어감
            //바디도 넣어서 보냄
            //엔티티안에다가 이런저런 필요한 값도 넣어서함


            result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
            result.put("body", resultMap.getBody()); //실제 데이터 정보 확인

            //데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(resultMap.getBody());

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("dfdfdfdf");
            System.out.println(e.toString());

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion오류");
            System.out.println(e.toString());
        }
        return jsonInString;
    }




    @GetMapping("coinValue")
    public String coinValue(){
        HashMap<String, Object> result = new HashMap<String, Object>();

        String jsonInString = "";

        try {

            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
            factory.setConnectTimeout(5000); //타임아웃 설정 5초
            factory.setReadTimeout(5000);//타임아웃 설정 5초
            RestTemplate restTemplate = new RestTemplate(factory);

            HttpHeaders header = new HttpHeaders();

            HttpEntity<?> entity = new HttpEntity<>(header);

            //String url = "https://api.hangang.msub.kr/";
            String url = "https://api.upbit.com/v1/candles/days?market=KRW-BTC&count=1";

            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

            //이 한줄의 코드로 API를 호출해 MAP타입으로 전달 받는다.
            ResponseEntity<Object> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Object.class);
            result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
            result.put("body", resultMap.getBody()); //실제 데이터 정보 확인

            //데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(resultMap.getBody());

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("dfdfdfdf");
            System.out.println(e.toString());

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion오류");
            System.out.println(e.toString());
        }
        return jsonInString;
    }



    //코인정보
    @GetMapping("test1")
    public Object test1(){
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(5000); // 읽기시간초과, ms
        factory.setConnectTimeout(3000); // 연결시간초과, ms
        HttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(100) // connection pool 적용
                .setMaxConnPerRoute(5) // connection pool 적용
                .build();
        factory.setHttpClient(httpClient); // 동기실행에 사용될 HttpClient 세팅
        RestTemplate restTemplate = new RestTemplate(factory);
        String url = "https://api.upbit.com/v1/candles/days?count=1"; // 예제니까 애초에 때려박음..
        Object obj = restTemplate.getForObject(url , Object.class);
        System.out.println(obj);

        return obj;
    }*/

}
