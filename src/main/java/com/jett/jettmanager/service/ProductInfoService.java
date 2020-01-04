package com.jett.jettmanager.service;

import com.jett.jettmanager.dataobject.ProductInfo;
import com.jett.jettmanager.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {
    /**
     * 通过id查找单个
     * @param productId id
     * @return Object
     */
    ProductInfo findById(String productId);

    /**
     * 查找所有状态是0在架的商品
     * @return list
     */
    List<ProductInfo> findUpAll();

    /**
     * 查找所有商品
     * @param pageable 分页
     * @return list
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 添加单个商品
     * @param productInfo ProductInfo
     * @return object
     */
    ProductInfo save(ProductInfo productInfo);

    // 扣库存
    void decreaseStock(List<CartDTO> cartDTO);
    // 加库存
    void increaseStock(List<CartDTO> cartDTO);
}
