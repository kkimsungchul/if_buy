package com.sungchul.ifbuy.coin.utils;


import org.springframework.context.ApplicationContext;

public class BeanUtils {
    public static Object getBean(String bean){
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        return applicationContext.getBean(bean);
    }
}
