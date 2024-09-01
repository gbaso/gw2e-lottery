package com.github.gbaso.gw2elottery;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;

@SpringBootTest
@ImportTestcontainers(MongoDBContainers.class)
class Gw2eLotteryApplicationTests {

    @Test
    void contextLoads() {
    	assertTrue(true);
    }

}
