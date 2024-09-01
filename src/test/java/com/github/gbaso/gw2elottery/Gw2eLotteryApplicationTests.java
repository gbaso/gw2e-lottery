package com.github.gbaso.gw2elottery;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;

import com.github.gbaso.gw2elottery.service.LotteryService;

@SpringBootTest
@MockBean(LotteryService.class)
@ImportTestcontainers(MongoDBContainers.class)
class Gw2eLotteryApplicationTests {

    @Test
    void contextLoads() {
    	assertTrue(true);
    }

}
