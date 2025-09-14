package com.test.interview;

public class ThreadExample {

	public static void main(String[] args) {
     Counter counter = new Counter();
     
     Thread thread1 = new Thread(()->{   	 
    	 for(int i = 0;i < 50; i++){
    		 counter.increment();
    	 }
     });
     Thread thread2 = new Thread(()->{    	 
    	 for(int i = 0;i < 50; i++){
    		 counter.increment();
    	 }
     });
		thread1.start();
		thread2.start();
	}

}
