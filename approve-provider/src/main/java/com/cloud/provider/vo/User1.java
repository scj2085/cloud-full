package com.cloud.provider.vo;

import java.util.List;
import java.util.Map;

public class User1 {
	
	Map<String,List<User>> name;

	public User1() {
		super();
	}

	public User1(Map<String, List<User>> name) {
		super();
		this.name = name;
	}

	public Map<String, List<User>> getName() {
		return name;
	}

	public void setName(Map<String, List<User>> name) {
		this.name = name;
	}
	
}
