package com.jett.jettmanager.enums;

public enum PayStatusEnum {
    WAIT(0, "未支付"),

    SUCCESS(1, "已支付");

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
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
