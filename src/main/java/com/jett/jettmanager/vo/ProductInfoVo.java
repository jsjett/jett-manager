package com.jett.jettmanager.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ProductInfoVo {

    /**
     * 商品id
     */
    @JsonProperty("id")
    private String productId;
    /**
     * 商品名字
     */
    @JsonProperty("name")
    private String productName;
    /**
     * 商品单价
     */
    @JsonProperty("price")
    private BigDecimal productPrice;
    /**
     * 商品描述
     */
    @JsonProperty("desc")
    private String productDesc;
    /**
     * 商品小图
     */
    @JsonProperty("icon")
    private String productIcon;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }
}
