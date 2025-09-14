package com.test.coding.task;

public class Employee {
    private int salary;

    // Constructor to initialize the salary of the employee
    public Employee(int salary) {
        this.salary = salary;
    }
    public Employee() {

    }
    
    // Method to simulate the employee working
    public void work() {
        // Print a message indicating the employee is working
        System.out.println("working as an employee!");
    }

    // Getter method to retrieve the salary of the employee
    public int getSalary() {
        return salary;
    }
}
