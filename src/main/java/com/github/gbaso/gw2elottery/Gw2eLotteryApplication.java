package com.github.gbaso.gw2elottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableConfigurationProperties(Gw2Properties.class)
@SpringBootApplication
public class Gw2eLotteryApplication {

    public static void main(String[] args) {
        SpringApplication.run(Gw2eLotteryApplication.class, args);
    }

}
