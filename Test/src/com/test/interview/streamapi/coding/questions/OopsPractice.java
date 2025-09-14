package com.test.interview.streamapi.coding.questions;

public class OopsPractice {

	public static void main(String[] args) {

		Thread1 th1 = new Thread1();
		System.out.println(th1.getState().name());

		th1.start();
		System.out.println(th1.getState().name());
		System.out.println(Thread1.amount);
		Thread1.amount++;
		System.out.println(Thread1.amount);

		/*
		 * Thread2 th2 = new Thread2(); th2.start();
		 * 
		 * Thread3 th3 = new Thread3(); Thread threadRunnbale = new Thread(th3);
		 * 
		 * threadRunnbale.start();
		 * 
		 * Map<Integer,Integer> map = new HashMap<>(); map.put(null, 1); Set<Integer>
		 * set = map.keySet(); Iterator<Integer> iterator = set.iterator();
		 * while(iterator.hasNext()) { // System.out.println(iterator.next()); }
		 */
	}

}

class Thread1 extends Thread {
	public static int amount = 0;

	public void run() {
		System.out.println("Running Thread1");
		try {
			System.out.println("Waiting Thread1");
			amount++;
			Thread.currentThread().sleep(1000);
			System.out.println(Thread.currentThread().getState().name());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().isAlive());
		System.out.println(Thread.currentThread().getState());
	}
}

class Thread2 extends Thread {
	public void run() {
		System.out.println("Running Thread2...");
	}
}

class Thread3 implements Runnable {

	@Override
	public void run() {
		System.out.println("Running Thread3...");

	}
}