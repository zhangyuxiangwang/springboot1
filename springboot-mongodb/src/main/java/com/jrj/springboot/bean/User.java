package com.jrj.springboot.bean;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	private String _id;

	private int id;
	
	private String username;
	
	private int age;

	public User(int id, String username, int age) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
	}
	
	
}
