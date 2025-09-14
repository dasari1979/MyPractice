package com.test.interview;

import java.util.stream.IntStream;

public class Factorial {

	public static void main(String[] args) {
		int n = 5;  //5 4 3 2  
		int fact [] = null;
		System.out.println(IntStream.rangeClosed(1, n).reduce(1,(int x, int y)->x * y));

	}

}
