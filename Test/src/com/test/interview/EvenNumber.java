package com.test.interview;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import sun.security.pkcs11.wrapper.Functions;

public class EvenNumber {

	public static void main(String[] args) {
		
        new EvenNumber().findEvenNumber();
	}
	public static boolean prime(int n) {
		
		return !IntStream.rangeClosed(2, n/2).anyMatch(x->n%x==0);
	}
	public void findEvenNumber() {
		int a[] = {3,4,5,6,3,8};
		
		List<Integer> integer = Arrays.asList(3,4,5,6,3,8);
		
		Arrays.stream(a).filter(x->x%2==1).forEach(System.out::println);
		
		System.out.println(integer.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
		
		Arrays.stream(a).filter(EvenNumber::prime).count();
		
		List<Integer> list = Arrays.asList(2,5,6,4,8,7);

	/*//	list.stream().filter(n -> n%2 == 0).forEach(System.out::print);
	//	list.stream().filter(n -> n%2 == 0).forEach(System.out::println);
		
		list.stream().filter(n->n%2 == 0).forEach(System.out::println);
		System.out.println("Odd Number....");
		list.stream().filter(n->n%2 ==1 ).forEach(System.out::println);*/
		
		
	}

}
