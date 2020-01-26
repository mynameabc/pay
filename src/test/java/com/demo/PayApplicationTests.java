package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PayApplicationTests {

    @Test
    public void contextLoads() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("{}---商户下单, 参数:" + "\n")
                .append("---");

        log.info(stringBuilder.toString());
    }

}
