package com.test.interview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) throws Exception {
		ExecutorService executors = Executors.newFixedThreadPool(3);		
		Callable<String> callable = ()->{			
			System.out.println("Callable statement...");
			return "Hai Thread...";
		};
		String result = callable.call();
		System.out.println(result);
		executors.submit(callable);
		executors.shutdown();
	}

}
