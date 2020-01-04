package com.jett.jettmanager.repository;

import com.jett.jettmanager.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;


    @Test
    void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("111");
        orderDetail.setOrderId("111222");
        orderDetail.setProductId("xxxx");
        orderDetail.setProductName("皮蛋手头周");
        orderDetail.setProductPrice(new BigDecimal(12.2));
        orderDetail.setProductQuantity(1);
        orderDetail.setProductIcon("http://xxxx.jpg");

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    void findByOrderId() {

    }
}