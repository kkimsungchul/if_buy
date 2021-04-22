package com.sungchul.ifbuy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling   //스케쥴러
//@EnableJpaAuditing  //JPA
@SpringBootApplication
@MapperScan(value={"com.sungchul.ifbuy.coin.mapper"})
public class IfbuyApplication {

    public static void main(String[] args) {

        SpringApplication.run(IfbuyApplication.class, args);
    }

}
