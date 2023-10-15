package com.github.gbaso.gw2elottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

import com.github.gbaso.gw2elottery.config.HibernateHints;

@SpringBootApplication
@ImportRuntimeHints(HibernateHints.class)
public class Gw2eLotteryApplication {

    public static void main(String[] args) {
        SpringApplication.run(Gw2eLotteryApplication.class, args);
    }

}
