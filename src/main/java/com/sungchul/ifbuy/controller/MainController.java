package com.sungchul.ifbuy.controller;


import com.sungchul.ifbuy.vo.VO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MainController {

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




}
