package com.test.interview;

import java.util.Arrays;

public class FlatMap_ {

	public static void main(String[] args) {
	 
	 String[] str = {"One", "Two", "Three", "Four", "Five", "Six"};
	 
	 Arrays.stream(str).peek(x->System.out.println(x+" Before peek")).skip(str.length-1)
	 .peek(x->System.out.println(x+" After peek"))
	 .forEach(x->System.out.println(x));
	 	 
	// Arrays.stream(str).flatMap(x->Arrays.stream(x.split(""))).forEach(x->System.out.print(x+" "));

	}

}
