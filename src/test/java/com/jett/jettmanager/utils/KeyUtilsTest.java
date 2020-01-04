package com.jett.jettmanager.utils;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class KeyUtilsTest {

    @Test
    void genUniqueKey() {
        System.out.println(KeyUtils.genUniqueKey());
    }
}