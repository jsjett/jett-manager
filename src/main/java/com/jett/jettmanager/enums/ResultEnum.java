package com.jett.jettmanager.enums;

public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_NOT_ENOUGH(9,"商品库存不足"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
