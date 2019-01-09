package com.ssm.test;

import com.ssm.domain.User;

public class TestMain {

	public static void main(String[] args) {
		User u = new User();
		
		u.setName("fyy");
		u.setPassword("123");
		
		System.out.println(u.toString());
		
	}

}
