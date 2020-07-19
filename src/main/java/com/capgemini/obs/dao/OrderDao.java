package com.capgemini.obs.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.obs.entity.BookInfo;
import com.capgemini.obs.entity.CustomerInfo;
import com.capgemini.obs.entity.OrderInfo;

@Repository
public class OrderDao {
	
	@PersistenceContext
	EntityManager em;
	
	public boolean deleteOrder(Integer orderId) {
		OrderInfo order = em.find(OrderInfo.class, orderId);
		if (order != null) {
			em.remove(order);
			return true;
		} else {
			return false;
		}
	}
	
	public CustomerInfo getCustomer(Integer customerId) {
		String str="SELECT customer FROM CustomerInfo customer WHERE customer.customerId="+customerId;
		TypedQuery<CustomerInfo> query=em.createQuery(str, CustomerInfo.class);
		return query.getSingleResult();
	}
	
	public ArrayList<OrderInfo> getAllOrder() {
		String str = "SELECT orderInfo FROM OrderInfo orderInfo";
		TypedQuery<OrderInfo> query = em.createQuery(str, OrderInfo.class);
		return (ArrayList<OrderInfo>) query.getResultList();
	}
	
	public OrderInfo getOrder(Integer orderId) {
		// TODO Auto-generated method stub
			String str = "SELECT orderInfo FROM OrderInfo orderInfo WHERE orderInfo.orderId="
					+ orderId;
			TypedQuery<OrderInfo> query = em.createQuery(str, OrderInfo.class);
			return query.getSingleResult();
		}

	public boolean removeBook(Integer bookId) {
		// TODO Auto-generated method stub
		BookInfo bookInfo = em.find(BookInfo.class, bookId);
		if (bookInfo != null) {
			em.remove(bookInfo);
			return true;
		} else {
			return false;
		}
	}
}
