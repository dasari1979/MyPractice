package com.practice.interview;

public class RunnableExample {

	public static void main(String[] args) {
		Runnable run1 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hi... "+Thread.currentThread().getName());
				
			}
		};
			Thread t1 = new Thread(run1,"1");
			t1.start();
			
			Runnable run2 = () ->System.out.println("Hello "+Thread.currentThread().getName());
			Thread t2 = new Thread(run2,"1");
			t2.start();
		}

}
