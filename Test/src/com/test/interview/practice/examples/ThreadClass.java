package com.test.interview.practice.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ThreadClass extends Thread {
	private static int counter = 0;
	static Vector<String> v = new Vector<>();
	static List<String> list = new ArrayList<>();
	@Override
	public void run(){
		
		for (int i = 0; i < 100; i++) {
			printVectorValues();
        }
	}
	private void printVectorValues() {
		counter++;
	//	v.add("sss");
		list.add("sss");
        try {
            Thread.sleep(100); // artificial delay to magnify the problem
        } catch (InterruptedException ie) {return;}
      //  v.remove("sss");
      //  list.remove("sss");
        System.out.println("counter = " + list);
	}
	public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
        	ThreadClass client = new ThreadClass();
            client.start();
        }

	}

}
