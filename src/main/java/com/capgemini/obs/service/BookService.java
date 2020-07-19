package com.capgemini.obs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.obs.dao.BookDao;
import com.capgemini.obs.dao.CustomerDao;
import com.capgemini.obs.dao.OrderDao1;
import com.capgemini.obs.entity.BookInfo;
import com.capgemini.obs.entity.CustomerInfo;
import com.capgemini.obs.entity.OrderInfo;


@Service
public class BookService {

	@Autowired
	BookDao bookDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	OrderDao1 orderDao1;
	
	 public boolean addBook(BookInfo bookInfo)
		{
			return bookDao.save(bookInfo) != null;
		}
	 
	 public boolean addCustomer(CustomerInfo customerInfo)
		{
		 return customerDao.save(customerInfo) !=null;
		}
	 
	 public boolean addOrder(OrderInfo orderInfo)
		{
			return orderDao1.save(orderInfo) != null;
		}

}
