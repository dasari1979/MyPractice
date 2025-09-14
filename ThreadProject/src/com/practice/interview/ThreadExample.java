package com.practice.interview;

public class ThreadExample {

	public static void main(String[] args) throws InterruptedException {
		Employee emp = new Employee();
		emp.start();
		System.out.println(emp.getState());
		emp.sleep(100);
		System.out.println(emp.getState());
	}

}

class Employee extends Thread
{
@Override
public void run()
{
	System.out.println("Hello....");
}

}