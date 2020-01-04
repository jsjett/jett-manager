package com.jett.jettmanager.repository;

import com.jett.jettmanager.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMasterRepositoryTest {

    private final String OPENID = "xxsss";

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("112");
        orderMaster.setBuyerName("jett");
        orderMaster.setBuyerPhone("13333333333");
        orderMaster.setBuyerAddress("深圳");
        orderMaster.setBuyerOpenid("xxsss");
        orderMaster.setBuyerAmount(new BigDecimal(4.5));

        OrderMaster result = repository.save(orderMaster);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    void findByBuyerOpenid() {
        PageRequest request = PageRequest.of(1,1);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID,request);
        System.out.println(result);
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}