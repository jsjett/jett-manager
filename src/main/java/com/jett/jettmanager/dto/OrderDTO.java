package com.jett.jettmanager.dto;

import com.jett.jettmanager.dataobject.OrderDetail;


import java.math.BigDecimal;
import java.util.List;

public class OrderDTO {
    private String orderId;
    /** 购买用户的名字 **/
    private String buyerName;
    /** 购买用户的电话 **/
    private String buyerPhone;
    /** 购买用户的地址 **/
    private String buyerAddress;
    /** 购买用户的openid **/
    private String buyerOpenid;
    /** 订单总金额 **/
    private BigDecimal buyerAmount;
    /** 订单状态，默认0,新下单 **/
    private Integer orderStatus;
    /** 订单支付状态，默认0,未支付 **/
    private Integer payStatus;
    /** 订单详情列表 */
    private List<OrderDetail> orderDetailList;





    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerOpenid() {
        return buyerOpenid;
    }

    public void setBuyerOpenid(String buyerOpenid) {
        this.buyerOpenid = buyerOpenid;
    }

    public BigDecimal getBuyerAmount() {
        return buyerAmount;
    }

    public void setBuyerAmount(BigDecimal buyerAmount) {
        this.buyerAmount = buyerAmount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
