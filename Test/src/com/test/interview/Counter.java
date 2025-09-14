package com.test.interview;

public class Counter {

	
	int count = 0;
	public synchronized void  increment() {
		count++;
		System.out.println(" Count value "+count);
	}
}
