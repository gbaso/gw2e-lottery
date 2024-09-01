package com.github.gbaso.gw2elottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;

@TestConfiguration(proxyBeanMethods = false)
@ImportTestcontainers(MongoDBContainers.class)
public class TestGW2eLotteryApplication {

    public static void main(String[] args) {
        SpringApplication
                .from(Gw2eLotteryApplication::main)
                .with(TestGW2eLotteryApplication.class)
                .run(args);
    }

}
