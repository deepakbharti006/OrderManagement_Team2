package com.capgemini.obs.service;

import java.util.ArrayList;

import com.capgemini.obs.entity.CustomerInfo;
import com.capgemini.obs.entity.OrderInfo;
import com.capgemini.obs.exception.OrderException;

public interface OrderService {
	
	 String deleteOrder(Integer orderId) throws OrderException;
	
	 CustomerInfo updateCustomerInfo(CustomerInfo customer);
	 
	 boolean getCustomerInfo(Integer customerId);
	 
     CustomerInfo displayOneInfo(Integer customerId);
     
     ArrayList<OrderInfo> getAllOrder() throws OrderException;
     
 	 OrderInfo getOrder(Integer orderId) throws OrderException ;
 	
 	 String removeBook(Integer bookId) throws OrderException;
 	
 	 OrderInfo updateQuantity(OrderInfo orderInfo) throws OrderException;

}
