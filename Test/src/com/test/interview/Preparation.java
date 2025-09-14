package com.test.interview;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Preparation {

	public static boolean isPrime(int x) {
		return !IntStream.rangeClosed(2, x/2).anyMatch(i->x%i==0);
	}
	
	public static void main(String[] args) {

		// Find prime numbers and its sum
		int array[] = {3,5,9,8,20,19,56,21,23};
		Arrays.stream(array).forEach(x->{
			
			if(!IntStream.rangeClosed(2, x/2).anyMatch(i->x%i==0)) {
				System.out.println(x +" is prime number");
			}
		});
		System.out.println(Arrays.stream(array).filter(Preparation::isPrime).sum());
		
		// Find the even numbers
		
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
		
		list.stream().filter(x->x%2 == 0).forEach(System.out::println);
		
		// find out a all the numbers starts with 1
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32,11);
		System.out.println(myList.stream().filter(x-> String.valueOf(x).startsWith("1")).collect(Collectors.toList()));
		
		// Find out dublicate numbers in the list 
		 myList = Arrays.asList(10,15,8,49,25,98,98,32,15,8);
		List<Integer> result = myList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
		 .stream().filter(x-> x.getValue()>1).map(entry -> entry.getKey())
         .collect(Collectors.toList());
		System.out.println(result);
		
		// Find out total number of integers
		myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		System.out.println("Total no of integers: "+myList.stream().count());
		
		// Find maximum value
		
		myList = Arrays.asList(10,15,8,49,25,98,98,32,15,99);
		System.out.println(myList.stream().max(Integer::compare).get());
		
		// Find non repeated character
		String input = "Java articles are Awesome";
	    List<Character> _result = input.chars() // Stream of String       
	            .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
	            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
	            .entrySet()
	            .stream()
	            .filter(entry -> entry.getValue() == 1L)
	            .map(entry -> entry.getKey()).collect(Collectors.toList());
	    System.out.println(_result);
		
	    // Find whether a string or number is palindrome or not.
	    
	    String polindrom = "refer";
	    String value = String.valueOf(polindrom.toCharArray());
	    int len = value.length();
	    boolean isPalindromeNumber = IntStream.range(0, len)
	      .anyMatch(index -> value.charAt(index) == value.charAt(len - index - 1));
	    System.out.println(isPalindromeNumber);
	}

}
