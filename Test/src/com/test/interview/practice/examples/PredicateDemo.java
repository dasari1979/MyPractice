package com.test.interview.practice.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo // implements Predicate<Integer>
{

	public static void main(String[] args) {
		// System.out.println(new PredicateDemo().test(10));
		Predicate<Integer> predicate = (t) -> t > 0;
	//	System.out.println(predicate.test(-1));
		
		
		List<Integer> list = Arrays.asList(1, 2, 3,-1);
		list.stream().filter(predicate).forEach(System.out::print);
		System.out.println("another way");
		list.stream().filter(t -> t > 1).forEach(System.out::print);
	}

}
