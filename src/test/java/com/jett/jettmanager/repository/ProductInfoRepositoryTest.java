package com.jett.jettmanager.repository;

import com.jett.jettmanager.dataobject.ProductInfo;

import com.jett.jettmanager.utils.KeyUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void saveTest() {
        String [] names = {"烤肠","羊肉串","牛肉串","鸡腿"};
        for (int i = 0; i < 4; i++) {
            ProductInfo productInfo = new ProductInfo();
            productInfo.setProductId(KeyUtils.genUniqueKey());
            productInfo.setProductName(names[i]);
            productInfo.setProductDesc("很好喝的饮料");
            productInfo.setProductPrice(new BigDecimal(8.5));
            productInfo.setProductStock(50);
            productInfo.setProductIcon("http://xxxxx.jpg");
            productInfo.setProductStatus(0);
            productInfo.setCategoryType(1004);
            ProductInfo result = repository.save(productInfo);
            Assert.assertNotNull(result);
        }

    }
}