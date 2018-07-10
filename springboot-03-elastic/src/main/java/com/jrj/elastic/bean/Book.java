package com.jrj.elastic.bean;

import java.util.Date;

import javax.xml.crypto.Data;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import io.searchbox.annotations.JestId;

@Document(indexName="jrj",type="book1")
public class Book {
	
	@JestId //这个是指定es的id
	private Integer id;
	
	private String bookName;
	
	private String author;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date createTime;
	
	private Integer count;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", createTime=" + createTime
				+ ", count=" + count + "]";
	}
	
	

}
