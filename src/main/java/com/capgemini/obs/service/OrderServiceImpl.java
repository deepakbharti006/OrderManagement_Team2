package com.capgemini.obs.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.obs.dao.CustomerDao;
import com.capgemini.obs.dao.OrderDao;
import com.capgemini.obs.dao.OrderDao1;
import com.capgemini.obs.entity.CustomerInfo;
import com.capgemini.obs.entity.OrderInfo;
import com.capgemini.obs.exception.OrderException;

@Transactional
@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderDao orderDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	OrderDao1 orderDao1;

	@Override
	public String deleteOrder(Integer orderId) throws OrderException {
		if (orderDao.deleteOrder(orderId))
			return "Order Deleted";
		else
			throw new OrderException("Order not found.");

	}
	
	@Override
	public CustomerInfo updateCustomerInfo(CustomerInfo customer) {
		  return customerDao.save(customer);
	}
	
	@Override
	public boolean getCustomerInfo(Integer customerId) {
		 return customerDao.existsById(customerId);
			
	}
	@Override
	public CustomerInfo displayOneInfo(Integer customerId) {
		CustomerInfo list= orderDao.getCustomer(customerId);
		return list;
	}
	
	@Override
	public ArrayList<OrderInfo> getAllOrder() throws OrderException {
		// TODO Auto-generated method stub
		if(orderDao.getAllOrder()!=null)
			return (ArrayList<OrderInfo>) orderDao.getAllOrder();
		else
			throw new OrderException("order is not present. ");
	}

	@Override
	public OrderInfo getOrder(Integer orderId) throws OrderException {
		// TODO Auto-generated method stub
		if(orderDao.getOrder(orderId)!= null)
		{
		return orderDao.getOrder(orderId);
		}
		else {
			throw new OrderException("order id not found.");
		}
	}
	
	@Override
	public String removeBook(Integer bookId) throws OrderException {
		// TODO Auto-generated method stub
		if (orderDao.removeBook(bookId))
			return "Book Removed from order";
		else
			throw new OrderException("Book not found in order.");

	}
	
	@Override 
	  public OrderInfo updateQuantity(OrderInfo orderInfo) throws OrderException{
		 Integer OrderId=orderInfo.getOrder_Id();
		  if(orderDao1.findByOrderId(OrderId)==null) {
			  throw new OrderException("No changes Found");
		  }
		  Integer tempQuantity=orderInfo.getQuantity();
		  Float tempSubTotal=orderInfo.getSubToatl();
		  Float temp=tempQuantity*tempSubTotal;
		  orderInfo.setTotal(temp);
		  return orderDao1.save(orderInfo);
	  }	
	
	

}
