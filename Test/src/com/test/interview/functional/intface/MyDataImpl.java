package com.test.interview.functional.intface;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class MyDataImpl
{
	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}
	static void sub() {
		
	}
	public static void main(String args[]){
		
		FunctionalInterfaceTest test  =	(a,b) -> a+b;
		
		System.out.println(test.add(4, 8));
		Supplier<Integer> supplier = () ->FunctionalInterfaceTest.mul(4,8);
		System.out.println("Result with Supplier: "+supplier.get());
		
		BiFunction<Integer,Integer,Integer> biFunction = (a,b)->FunctionalInterfaceTest.mul(a,b);
		System.out.println("Result with BiFunction: "+biFunction.apply(4, 7));
		
		FunctionalIntExampleImpl funImpl = new FunctionalIntExampleImpl();
		funImpl.add();
		MyDataImpl obj = new MyDataImpl();
		obj.isNull("abc");

		MyData result = () -> 0;
		 
        System.out.println("Result is " + result.add());
 
	}
}
