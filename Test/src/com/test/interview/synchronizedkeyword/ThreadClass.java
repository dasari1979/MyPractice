package com.test.interview.synchronizedkeyword;

public class ThreadClass {

	private int number = 1;
	private int maxNum = 10;
	public  synchronized void evenNumber() throws InterruptedException {
		while(number<= maxNum) {
		if(number%2== 0) {
			wait();
			
		}
		else{
			
			number++;
			System.out.println("Even: "+number);
			notify();
		}
		}

		
	}
    public synchronized void oddNumber() throws InterruptedException {
    	while(number<= maxNum) {
    		if(number%2 != 0) {
    			wait();
    			
    		}
        	else{
    			number++;
    			System.out.println("Odd: "+number);
    			notify();
    			
    		}
    		}

	}
	
	public static void main(String[] args) {
		ThreadClass threadClass = new ThreadClass();
		Thread t1 = new Thread(()-> {			
		//	for(int i = 1;i<=10;i++) {
			//	System.out.println("Thread t1...."+i);
				try {
					threadClass.evenNumber();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Thread.sleep(100);
				//	wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       
		//	}
		}) ;

		Thread t2 = new Thread(()-> {			
		//	for(int i = 1;i<=10;i++) {
			//	System.out.println("Thread t2...."+i);
				try {
					threadClass.oddNumber();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
		//	}
		}) ;
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}

class A {
	public void add() {
		for(int i = 0;i<5;i++) {
			System.out.println("Thread A...."+i);			
		}

	}
}
class B {
	
	public void add() {
		
		for(int i = 0;i<5;i++) {
			System.out.println("Thread B...."+i);			
		}
	}
}