package com.jett.jettmanager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){
        System.out.println("--->");
        System.out.println(LoggerTest.class);
        System.out.println("--->");

        logger.debug("debugger...");
        logger.info("info...");
        logger.error("error...");
    }
}
