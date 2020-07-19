package com.capgemini.obs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.VerificationCollector;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.obs.dao.BookDao;
import com.capgemini.obs.dao.OrderDao;
import com.capgemini.obs.entity.*;
import com.capgemini.obs.exception.OrderException;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceTest {
	@Rule
	public VerificationCollector verificationCollector = MockitoJUnit.collector();
	@Mock
	private OrderDao orderDao;
	@Mock
	private BookDao bookDao;
	//@InjectMocks
	@Mock
	private OrderServiceImpl orderService;
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void deleteOrder_pos1(){
		// Run the test
		orderDao.deleteOrder(2);
		// Verify the results
		verify(orderDao, times(1)).deleteOrder(2);
	}
	@Test
	public void deleteOrder_neg1(){
		// Run the test
		orderDao.deleteOrder(2);
		// Verify the results
		verify(orderDao, times(2)).deleteOrder(2);
	}
	@Test
	public void deleteOrder_neg2(){
		// Run the test
		orderDao.deleteOrder(7);
		// Verify the results
		verify(orderDao, times(1)).deleteOrder(2);
	}
	@Test
	public void deleteOrder_pos2(){

		// Run the test
		orderDao.deleteOrder(2);

		//Verify the results
		verify(orderDao, times(1)).deleteOrder(2);
	}
	@Test
	public void addOrder() {
		OrderInfo order=new OrderInfo();
		order.setOrder_Id(12);
		order.setQuantity(4);
		order.setSubToatl((float) 45.08);
		order.setTotal((float) 500.1);
		order.setOrderStatus("shipping");
		order.setPaymentMethod("upi");
	}

	@Test
	public void updateCustomerInfo_pos1() {
		CustomerInfo customer=new CustomerInfo();
		customer.setAddress("Lbnagar");
		customer.setCity("HYD");
		customer.setCountry("India");
		customer.setCustomerId(2);
		customer.setFullName("Harini");
		customer.setZipCode("507166");
		orderService.updateCustomerInfo(customer);
		verify(orderService,times(1)).updateCustomerInfo(customer);

	}


	@Test
	public void updateCustomerInfo_neg1() {
		CustomerInfo customer=new CustomerInfo();
		customer.setAddress("Lbnagar");
		customer.setCity("HYD");
		customer.setCountry("India");
		customer.setCustomerId(5);
		customer.setFullName("Bye");
		customer.setZipCode("507166");
		orderService.updateCustomerInfo(customer);
		verify(orderService,times(2)).updateCustomerInfo(customer);

	}

	@Test
	public void updateCustomerInfo_pos2() {
		CustomerInfo customer=new CustomerInfo();
		customer.setAddress("Lbnagar");
		customer.setCity("HYD");
		customer.setCountry("India");
		customer.setCustomerId(4);
		customer.setFullName("Hello");
		customer.setZipCode("507166");
		orderService.updateCustomerInfo(customer);
		verify(orderService,times(1)).updateCustomerInfo(customer);

	}

	@Test
	public void deletebook_pos1(){
		
		bookDao.deleteById(2);
		verify(bookDao, times(1)).deleteById(2);
	}
	@Test
	public void deletebook_neg1(){
		
		bookDao.deleteById(2);
		verify(bookDao, times(2)).deleteById(2);
	}
	@Test
	public void deletebook_neg2(){
		
		bookDao.deleteById(7);
		verify(bookDao, times(1)).deleteById(2);
	}
	@Test
	public void deletebook_pos2(){
		
		bookDao.deleteById(2);
		verify(bookDao, times(1)).deleteById(2);
	}
	@Test
	public void AddBook() {
		BookInfo book=new BookInfo();
		book.setBookId(16);
		book.setAuthor("author");
		book.setDescription("dream");
		book.setIsbn((long) 312);
		book.setPrice((float) 500.98);
		book.setPublishDate(LocalDate.now());
		bookDao.save(book);
	}
	
	@Test
	public void testAllOrderDetails_pos() {
		List<OrderInfo> orderList = new ArrayList<>();
		orderList.add(new OrderInfo(0,1234,(float) 321,(float) 321,"edj","kedj", Collections.singletonList(new BookInfo(0,"good","arun","one of the best version",(long) 123,(float) 234, LocalDate.now()))));
		orderList.add(new OrderInfo(0,1234,(float) 321,(float) 321,"edj","kedj", Collections.singletonList(new BookInfo(0,"good","arun","one of the best version",(long) 123,(float) 234, LocalDate.now()))));
		orderList.add(new OrderInfo(0,1234,(float) 321,(float) 321,"edj","kedj", Collections.singletonList(new BookInfo(0,"good","arun","one of the best version",(long) 123,(float) 234, LocalDate.now()))));

		Mockito.when(orderDao.getAllOrder()).thenReturn((ArrayList<OrderInfo>) orderList);

		List<OrderInfo> returnedData = (List<OrderInfo>) orderDao.getAllOrder();
		assertEquals(3,returnedData.size());		
		}
	@Test
	public void testAllOrderDetails_neg() {
		List<OrderInfo> orderList = new ArrayList<>();
		orderList.add(new OrderInfo(0,1234,(float) 321,(float) 321,"edj","kedj", Collections.singletonList(new BookInfo(0,"good","arun","one of the best version",(long) 123,(float) 234, LocalDate.now()))));
		orderList.add(new OrderInfo(0,1234,(float) 321,(float) 321,"edj","kedj", Collections.singletonList(new BookInfo(0,"good","arun","one of the best version",(long) 123,(float) 234, LocalDate.now()))));
		orderList.add(new OrderInfo(0,1234,(float) 321,(float) 321,"edj","kedj", Collections.singletonList(new BookInfo(0,"good","arun","one of the best version",(long) 123,(float) 234, LocalDate.now()))));

		Mockito.when(orderDao.getAllOrder()).thenReturn((ArrayList<OrderInfo>) orderList);

		List<OrderInfo> returnedData = (List<OrderInfo>) orderDao.getAllOrder();
		assertEquals(4,returnedData.size());		
		}
	
	@Test
	public void getOrderTest_pos() throws OrderException {
		OrderInfo order = new OrderInfo(0,1234,(float) 321,(float) 321,"edj","kedj", Collections.singletonList(new BookInfo(0,"good","arun","one of the best version",(long) 123,(float) 234, LocalDate.now())));
	     when(orderDao.getOrder(0)).thenReturn(order);
	   OrderInfo response= orderService.getOrder(0);
	   Assertions.assertNotNull(response);
	   Assertions.assertEquals(response, order);
	}
	
	@Test
	public void getOrderTest_neg() throws OrderException {
		OrderInfo order = new OrderInfo(12,432,(float) 324,(float) 444,"arun","kumar", Collections.singletonList(new BookInfo(12,"bad","aruna","one of the best version",(long) 123,(float) 234, LocalDate.now())));
	     when(orderDao.getOrder(0)).thenReturn(order);
	 
	   Assertions.assertThrows(OrderException.class, ()->orderService.getOrder(0));

	}
}