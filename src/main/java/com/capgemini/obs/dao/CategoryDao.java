package com.capgemini.obs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.obs.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

}
