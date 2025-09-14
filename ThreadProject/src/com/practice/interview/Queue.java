package com.practice.interview;

public class Queue {

	public static void main(String s[])
	{
		QueueSynch q = new QueueSynch();
		new Producer(q);
		new Consumer(q);
	}
}
class QueueSynch {
    int num ;
    boolean isValueset = false;
    
	public synchronized void put(int n) {
		while(isValueset)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Put..."+n);
		this.num = n;
		isValueset = true;
		notify();

	}
	public synchronized void get() {
		while(!isValueset)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Get..."+num);
		isValueset = false;
		notify();

	}
}
class Producer implements Runnable
{
	QueueSynch q;
	public Producer(QueueSynch q) {
		this.q = q;
		Thread t = new Thread(this,"Producer");
		t.start();
	}

	@Override
	public void run() {
		System.out.println("Hello Producer...");
		int i =0 ;
		
		while(true)
		{
			q.put(i++);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
class Consumer implements Runnable
{
	QueueSynch q;
	public Consumer(QueueSynch q) {
		this.q = q;
		Thread t = new Thread(this,"Consumer");
		t.start();
	}
	@Override
	public void run() {
		System.out.println("Hello Consumer...");
		while(true) {
			q.get();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}