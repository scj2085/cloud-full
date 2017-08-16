package com.cloud.consume_ribbon.vo;

public class User {
	
	private Long id;
	private String name1;
	private int age;
	
	public User() {
		super();
	}
	public User(String name1, int age) {
		super();
		this.name1 = name1;
		this.age = age;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
