package com.test.interview.design.patterns;

public class User {
	
	private String fistName;
	private String lastName;
	private int id;
	private String emailId;
	public User(UserBuilder userBuilder) {
		this.fistName = userBuilder.fistName;
		this.lastName = userBuilder.lastName;
		this.id = userBuilder.id;
		this.emailId = userBuilder.emailId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [fistName=" + fistName + ", lastName=" + lastName + ", id=" + id + ", emailId=" + emailId + "]";
	}
	/**
	 * @return the fistName
	 */
	public String getFistName() {
		return fistName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	

}
