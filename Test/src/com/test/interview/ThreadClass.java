package com.test.interview;

public class ThreadClass extends Thread{

	public void run()
	{
		
		System.out.println("Run method called...");
	}
	public static void main(String[] args) throws InterruptedException {
		
		ThreadClass thread1 = new ThreadClass();
		ThreadClass thread2 = new ThreadClass();
		thread1.start();;
		thread1.join();
		thread2.join();
		thread2.start();
		thread2.join();
	}

}
