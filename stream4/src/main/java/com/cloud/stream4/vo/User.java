package com.cloud.stream4.vo;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -2486956058336561665L;
	private String name;
	private int age;
	
	public User() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
