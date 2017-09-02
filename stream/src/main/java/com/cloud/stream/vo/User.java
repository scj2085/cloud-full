package com.cloud.stream.vo;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -6762704906505631257L;
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
