package com.capgemini.obs.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="Category")
public class Category {
	
	@Id
	@Column(name="category_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
	@SequenceGenerator(sequenceName = "category_sequence", allocationSize = 10, name = "category_seq")
	private Integer categoryId;
	
	@Column(name="categoryName")
	private String categoryName;
	
	@OneToMany(fetch=FetchType.EAGER,targetEntity = BookInfo.class, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "category_Id", referencedColumnName = "category_Id")
	private List<BookInfo> BookInfo;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<BookInfo> getBookInfo() {
		return BookInfo;
	}

	public void setBookInfo(List<BookInfo> bookInfo) {
		BookInfo = bookInfo;
	}

	public Category(Integer categoryId, String categoryName, List<com.capgemini.obs.entity.BookInfo> bookInfo) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		BookInfo = bookInfo;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", BookInfo=" + BookInfo + "]";
	}
	
	

}
