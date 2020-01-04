package com.jett.jettmanager.repository;

import com.jett.jettmanager.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findById(1).orElse(null);
        System.out.println(productCategory.toString());
    }

    @Test
    public void addOneTest(){
        ProductCategory p1 = new ProductCategory("热销榜",1001);
        ProductCategory p2 = new ProductCategory("水果",1002);
        ProductCategory p3 = new ProductCategory("饮料",1003);
        ProductCategory p4 = new ProductCategory("烧烤",1004);
        repository.save(p1);
        repository.save(p2);
        repository.save(p3);
        repository.save(p4);
    }

    @Test
    public void updateTest(){
        ProductCategory productCategory = repository.findById(1).orElse(null);
        productCategory.setCategoryType(10);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        System.out.println(result);
        Assert.assertNotEquals(0,result.size());
    }
}