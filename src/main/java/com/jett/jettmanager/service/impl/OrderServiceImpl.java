package com.jett.jettmanager.service.impl;

import com.jett.jettmanager.dataobject.OrderDetail;
import com.jett.jettmanager.dataobject.OrderMaster;
import com.jett.jettmanager.dataobject.ProductInfo;
import com.jett.jettmanager.dto.CartDTO;
import com.jett.jettmanager.dto.OrderDTO;
import com.jett.jettmanager.enums.OrderStatusEnum;
import com.jett.jettmanager.enums.PayStatusEnum;
import com.jett.jettmanager.enums.ResultEnum;
import com.jett.jettmanager.exception.SellException;
import com.jett.jettmanager.repository.OrderDetailRepository;
import com.jett.jettmanager.repository.OrderMasterRepository;
import com.jett.jettmanager.repository.ProductInfoRepository;
import com.jett.jettmanager.service.OrderService;
import com.jett.jettmanager.service.ProductInfoService;
import com.jett.jettmanager.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductInfoService productInfoService;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtils.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(0);
        // 查询商品（单价,库存）
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productInfoRepository.findById(orderDetail.getProductId()).orElse(null);
            // 根据产品id去查找商品信息
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //  计算商品总结并累加
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            // 订单详情写入数据库
            orderDetail.setDetailId(KeyUtils.genUniqueKey());
            orderDetail.setOrderId(orderId);
            orderDetail.setProductName(productInfo.getProductName());
            orderDetail.setProductPrice(productInfo.getProductPrice());
            orderDetail.setProductIcon(productInfo.getProductIcon());
            orderDetailRepository.save(orderDetail);
        }
        // 写入订单数据库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setBuyerAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        // 减库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList()
                .stream()
                .map(e -> new CartDTO(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());
        productInfoService.decreaseStock(cartDTOList);
        System.out.println("-------------***********>>>");
        return orderDTO;
    }

    @Override
    public OrderDTO findById(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
