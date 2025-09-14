package com.test.interview;

public class RunnableClass implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable thread class...");

	}
	public static void main(String[] args) {
		
		RunnableClass runnableClass = new RunnableClass();
		Thread thread = new Thread(runnableClass);
		thread.start();
		
		Runnable r = ()->{
			System.out.println("Thread -1 ");
		};
		
		Thread t1 = new Thread(r);
		t1.start();
		Thread t2 = new Thread(() ->{
			System.out.print("Thread -2");
		});
		t2.start();
	}
}
