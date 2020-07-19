package com.capgemini.obs;


import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.capgemini.obs.entity.BookInfo;
import com.capgemini.obs.service.BookService;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class OnlineBookStoreApplicationTests 
{
	@Autowired
	TestRestTemplate testRestTemplate;
	public void setTestRestTemplate(TestRestTemplate testRestTemplate)
	{
		this.testRestTemplate=testRestTemplate;
	}
	
	@LocalServerPort
	int localServerPort;
	
	@Autowired
	BookService bookService;
	
	@Test
	public void testUpdateBook_Positive() throws Exception
	{
		String url="http://localhost:"+localServerPort+"/updateBook";
		BookInfo book=new BookInfo(1000000003,"Product", "Gangu", "Abvvdfjjydcdrdfurl",912345678L,(float) 56.4, LocalDate.now());
		ResponseEntity<String> response=testRestTemplate.postForEntity(url, book, String.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	public void testUpdateBook_Negative() throws Exception
	{
		String url="http://localhost:"+localServerPort+"updateBook";
		BookInfo book=new BookInfo();
		ResponseEntity<String> response=testRestTemplate.postForEntity(url, book, String.class);
		Assertions.assertEquals(500, response.getStatusCodeValue());
	}
}