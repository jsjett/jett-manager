package com.jett.jettmanager.dataobject;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProductInfo {
    /**
     * 产品信息id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
}
