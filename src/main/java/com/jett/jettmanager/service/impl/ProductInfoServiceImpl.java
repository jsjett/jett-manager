package com.jett.jettmanager.service.impl;

import com.jett.jettmanager.dataobject.ProductInfo;
import com.jett.jettmanager.dto.CartDTO;
import com.jett.jettmanager.enums.ProductStatusEnum;
import com.jett.jettmanager.enums.ResultEnum;
import com.jett.jettmanager.exception.SellException;
import com.jett.jettmanager.repository.ProductInfoRepository;
import com.jett.jettmanager.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findById(String productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    // 扣库存
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTO) {
        for(CartDTO obj:cartDTO){
            ProductInfo productInfo = repository.findById(obj.getProductId()).orElse(null);
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            int result = productInfo.getProductStock() - obj.getProductQuantity();
            if(result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_NOT_ENOUGH);
            }

            productInfo.setProductStock(result);
            System.out.println("--->");
            System.out.println(result);
            repository.save(productInfo);
        }
    }
    // 加库存
    @Override

    public void increaseStock(List<CartDTO> cartDTO) {

    }
}
