package com.sungchul.ifbuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class IfbuyApplication {

    public static void main(String[] args) {

        SpringApplication.run(IfbuyApplication.class, args);
    }

}
