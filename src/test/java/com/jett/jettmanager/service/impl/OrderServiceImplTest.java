package com.jett.jettmanager.service.impl;


import com.jett.jettmanager.dataobject.OrderDetail;
import com.jett.jettmanager.dto.OrderDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("jett");
        orderDTO.setBuyerPhone("13620990072");
        orderDTO.setBuyerAddress("深圳");
        orderDTO.setBuyerOpenid("110110");
        List<OrderDetail> orderDetails = new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("15780533059081770725");
        o1.setProductQuantity(1);
        OrderDetail o2 = new OrderDetail();
        o2.setProductId("15780533059961766292");
        o2.setProductQuantity(5);
        orderDetails.add(o1);
        orderDetails.add(o2);

        orderDTO.setOrderDetailList(orderDetails);
        OrderDTO result = orderService.create(orderDTO);
        System.out.println(result);
    }
}