package com.jett.jettmanager.exception;

import com.jett.jettmanager.enums.ResultEnum;

public class SellException extends RuntimeException{
    private Integer code;
    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
