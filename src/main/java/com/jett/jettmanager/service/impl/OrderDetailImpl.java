package com.jett.jettmanager.service.impl;

import com.jett.jettmanager.dataobject.OrderDetail;
import com.jett.jettmanager.repository.OrderDetailRepository;
import com.jett.jettmanager.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository repository;

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return repository.save(orderDetail);
    }
}
