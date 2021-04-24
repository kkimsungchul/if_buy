package com.sungchul.ifbuy.coin.utils;

import java.util.Calendar;

public class DateUtil {
    /*yyyymmdd 로 현재 날짜 리턴*/
    public String getDate() {
        String value = "";
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
        value = formatter.format(new java.util.Date());
        return value;
    }
    /*HHmmss 로 현재 시간 리턴*/
    public String getTime() {
        String value = "";
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("HHmmss");
        value = formatter.format(new java.util.Date());
        return value;
    }
    public String getTime(String strformat){
        String value = "";
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(strformat);
        value = formatter.format(new java.util.Date());
        return value;
    }
    public String getTime(String strformat,int add,int nType /*0:년도,1:월,2:일*/){
        String value = "";
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(strformat);

        Calendar today = Calendar.getInstance();
        today.add(nType, add);
        value = formatter.format(today.getTime());
        return value;
    }
}