package com.jett.jettmanager.service;

import com.jett.jettmanager.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

    /**
     * 通过id查找单个
     */
    ProductCategory findById(Integer categoryId);

    /**
     * 查找商品类目所有
     */
    List<ProductCategory> findAll();

    /**
     * 通过列表查找所有
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> CategoryTypeList);

    /**
     * 添加
     */
    ProductCategory save(ProductCategory productCategory);
}
