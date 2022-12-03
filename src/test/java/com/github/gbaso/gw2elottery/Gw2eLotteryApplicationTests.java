package com.github.gbaso.gw2elottery;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.github.gbaso.gw2elottery.service.LotteryService;

@SpringBootTest
@MockBean(LotteryService.class)
class Gw2eLotteryApplicationTests {

    @Test
    void contextLoads() {
    	assertTrue(true);
    }

}
