package com.test.interview.practice.examples;

public class Employee implements Comparable<Employee> {
	private int id;
	private long salary;
	private String name;

	/**
	 * @param id
	 * @param salary
	 * @param name
	 */
	public Employee(int id, long salary, String name) {
		super();
		this.id = id;
		this.salary = salary;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + "]";
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
	 * @return the salary
	 */
	public Long getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(Long salary) {
		this.salary = salary;
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

	//@Override
	public int compareTo(Employee o) {

		return id - o.getId();
	}
}
