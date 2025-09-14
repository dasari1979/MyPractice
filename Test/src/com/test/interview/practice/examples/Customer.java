package com.test.interview.practice.examples;

public class Customer {// implements Comparator<Customer> {
	private int id;
	private String name;
	private String email;
	// private List<String> phoneNumbers;

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param phoneNumbers
	 */
	public Customer(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		// this.phoneNumbers = phoneNumbers;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNumbers
	 */
	/*
	 * public List<String> getPhoneNumbers() { return phoneNumbers; }
	 *//**
		 * @param phoneNumbers
		 *            the phoneNumbers to set
		 *//*
			 * public void setPhoneNumbers(List<String> phoneNumbers) { this.phoneNumbers =
			 * phoneNumbers; }
			 */
/*	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}*/
}
