package com.capgemini.obs.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.obs.entity.BookInfo;
import com.capgemini.obs.entity.CustomerInfo;
import com.capgemini.obs.entity.OrderInfo;
import com.capgemini.obs.exception.InvalidDetailsException;
import com.capgemini.obs.exception.OrderException;
import com.capgemini.obs.service.BookService;
import com.capgemini.obs.service.OrderServiceImpl;

@CrossOrigin
@RestController
public class OrderController {
	
	@Autowired
	OrderServiceImpl orderServiceImpl;
	@Autowired
	BookService bookService;
	
	/*************************************************
	 * Method: deleteOrder
     *Description: 			To remove order
	 * @param order_Id         - order id
	 * @returns String       - Order deleted.
	 * @throws Order Exception - Order already exists.
	 **************************************************/
	@DeleteMapping("/deleteOrder/{orderId}")
	public String deleteOrder(@PathVariable Integer orderId) throws OrderException {
		try {
			return orderServiceImpl.deleteOrder(orderId);
		} catch (Exception exception) {
			throw new OrderException(exception.getMessage());
		}

	}
	
	@PostMapping("/updateCustomer")
	public ResponseEntity<Boolean> updateCustomer(@Valid @RequestBody CustomerInfo customer) {
		customer.setCustomerId(customer.getCustomerId());
		customer = orderServiceImpl.updateCustomerInfo(customer);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/get/{customerId}")
	public String displayCustomerInfo(@PathVariable Integer customerId) throws InvalidDetailsException {	
		Boolean info=orderServiceImpl.getCustomerInfo(customerId);
		if(Boolean.TRUE.equals(info))
		{
		CustomerInfo data = orderServiceImpl.displayOneInfo(customerId);
		return "Default Shipping Address Of the customer"+ data.toString();
		}
		else {
			throw new InvalidDetailsException("enter proper customer Id!!!!!!!!!");
		}
	}
	
	@GetMapping("/orders")
	public ArrayList<OrderInfo> getAllOrder() throws OrderException {
		try{
			return orderServiceImpl.getAllOrder();
		}catch (Exception exception) {
			throw new OrderException(exception.getMessage());
		}
	}
	
	@GetMapping("/order/{orderId}")
	public OrderInfo getOrder(@PathVariable Integer orderId) throws OrderException {
		try{
			return orderServiceImpl.getOrder(orderId);
		}catch (Exception exception) {
			throw new OrderException(exception.getMessage());
		}
	}
	
	@DeleteMapping("/removeBook/{bookId}")
	public String removeTest(@PathVariable Integer bookId) throws OrderException {
		try {
			return orderServiceImpl.removeBook(bookId);
		} catch (Exception exception) {
			throw new OrderException(exception.getMessage());
		}
}
	
	@PutMapping("/updateQuantity") 
	  public ResponseEntity<OrderInfo> updateOrder(@Valid @RequestBody OrderInfo orderInfo) throws OrderException{
		try { 
		OrderInfo order=orderServiceImpl.updateQuantity(orderInfo);
	  	return new ResponseEntity<OrderInfo>(order, HttpStatus.OK); 
	  	}catch (Exception exception) {
			throw new OrderException(exception.getMessage());
		}
}

	@PostMapping("/addBook")
	public ResponseEntity<String> addBook(@Valid @RequestBody BookInfo bookInfo)
			throws OrderException {
		try {
			bookService.addBook(bookInfo);
			return new ResponseEntity<String>("Book added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new OrderException("ID already exists");
		}
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerInfo customerInfo)
			throws OrderException {
		try {
			bookService.addCustomer(customerInfo);
			return new ResponseEntity<String>("Customer added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new OrderException("ID already exists");
		}
	}
	
	@PostMapping("/addOrder")
	public ResponseEntity<String> addOrder(@Valid @RequestBody OrderInfo orderInfo)
			throws OrderException {
		try {
			bookService.addOrder(orderInfo);
			return new ResponseEntity<String>("Order added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new OrderException("ID already exists");
		}
	}


}
