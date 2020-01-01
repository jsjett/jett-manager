package com.jett.jettmanager.controller;

import com.jett.jettmanager.dataobject.ProductCategory;
import com.jett.jettmanager.dataobject.ProductInfo;
import com.jett.jettmanager.service.CategoryService;
import com.jett.jettmanager.service.ProductInfoService;
import com.jett.jettmanager.utils.ResultUtil;
import com.jett.jettmanager.vo.ProductInfoVo;
import com.jett.jettmanager.vo.ProductVo;
import com.jett.jettmanager.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/list")
    public ResultVo list(){
        // 查询所有上架的商品
        List<ProductInfo> productInfos = productInfoService.findUpAll();
        // 查询所有类目
        List<Integer> categoryTypes = productInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(categoryTypes);
        // 数据拼装
        // 遍历分类
        List<ProductVo> productVos = new ArrayList<>();
        for (ProductCategory productCategory:productCategories){
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVo> productInfoVos = new ArrayList<>();
            for (ProductInfo productInfo:productInfos){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVos.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVos);
            productVos.add(productVo);
        }

        return ResultUtil.success(productVos);
    }
}
