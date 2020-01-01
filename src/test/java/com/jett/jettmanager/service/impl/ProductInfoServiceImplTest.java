package com.jett.jettmanager.service.impl;

import com.jett.jettmanager.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoServiceImplTest {
    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    void findById() {
        ProductInfo productInfo = productInfoService.findById("123456111");
        System.out.println(productInfo);
    }

    @Test
    void findUpAll() {
        List<ProductInfo> list = productInfoService.findUpAll();
        System.out.println(list);
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    void findAll() {
        PageRequest request = PageRequest.of(0,2);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
    }

    @Test
    void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("12111");
        productInfo.setProductName("皮蛋瘦肉粥");
        productInfo.setProductDesc("很好喝的");
        productInfo.setProductPrice(new BigDecimal(3.4));
        productInfo.setProductStock(10);
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        productInfoService.save(productInfo);
    }
}