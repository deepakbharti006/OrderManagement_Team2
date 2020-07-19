package com.capgemini.obs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.obs.entity.BookInfo;

public interface BookDao extends JpaRepository<BookInfo, Integer>{

}
