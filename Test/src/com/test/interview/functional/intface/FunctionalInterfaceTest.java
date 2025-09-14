package com.test.interview.functional.intface;


public interface FunctionalInterfaceTest {
	int add(int a, int b);
	//int sqr();
	default void sub() {};
	static int mul(int a, int b) {
		System.out.println("Called mul method...");
		return a * b;
	};

}
