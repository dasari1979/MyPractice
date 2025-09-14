package com.test.interview;
import java.lang.FunctionalInterface;

@FunctionalInterface
public interface FunctionalInterfaceExample {
	void m1();
	
	default void m2()
	{
		System.out.println("Default method m2");
	}
	default void m3()
	{
		System.out.println("Default method m3");
	}
	
	static void m4()
	{
		System.out.println("Default method m4");
	}
}
