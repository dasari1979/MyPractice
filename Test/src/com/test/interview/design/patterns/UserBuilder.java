package com.test.interview.design.patterns;

public class UserBuilder {
	
	public String fistName;
	public String lastName;
	public int id;
	public String emailId;
	
	public UserBuilder(String firstName,String lastName) {
		this.fistName = firstName;
		this.lastName = lastName;
	}
	public UserBuilder id(int id) {
		this.id = id;
		return this;
	}
	public UserBuilder emailId(String emailId) {
		this.emailId = emailId;
		return this;
	}
	
	public User build() {
		User user = new User(this);
		return user;
		
	}
}
