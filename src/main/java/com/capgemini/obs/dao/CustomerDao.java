package com.capgemini.obs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.obs.entity.CustomerInfo;

public interface CustomerDao extends JpaRepository<CustomerInfo, Integer>{

}
