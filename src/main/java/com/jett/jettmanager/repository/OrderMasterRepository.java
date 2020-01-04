package com.jett.jettmanager.repository;

import com.jett.jettmanager.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    // 根据买家openid查出该卖家的带分页的所有的订单
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
