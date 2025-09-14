package com.test.interview.synchronizedkeyword;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronizedTest {

	public static void main(String[] args) {

		List<String> list = new CopyOnWriteArrayList<>();
		ConcurrentHashMap<String, String> map = null;
		list.add("A");
		list.add("B");
		list.add("C");
		list.remove("C");

		Iterator<String> iterator = list.iterator();

		// Fail-fast behavior: Concurrent modification
		while (iterator.hasNext()) {
			String item = iterator.next();
			if ("B".equals(item)) {
				list.remove(item); // Modify the list during iteration
			}
		}

		list.stream().forEach(x -> System.out.print(x + " "));

		System.out.println("");
		Counter counter = new Counter();

		ThreadDemo t1 = new ThreadDemo(counter);
		ThreadDemo t2 = new ThreadDemo(counter);

		t1.start();
		t2.run();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Final count: " + counter.getCount());
	}

}

class ThreadDemo extends Thread {

	Counter counter;

	ThreadDemo(Counter counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 0; i < 1000; i++) {
			counter.increment();
		}
	}
}

class Counter {
	private int counter = 0;

	public void increment() {
		counter++;
	}

	public int getCount() {
		return counter;

	}
}