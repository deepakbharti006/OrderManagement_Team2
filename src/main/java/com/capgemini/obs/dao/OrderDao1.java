package com.capgemini.obs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.obs.entity.OrderInfo;

public interface OrderDao1 extends JpaRepository<OrderInfo, Integer>{

	List<OrderInfo> findByOrderId(Integer orderId);
}
