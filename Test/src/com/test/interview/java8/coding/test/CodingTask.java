package com.test.interview.java8.coding.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class CodingTask {

	public static void main(String[] args) {
		
		String str = "hello";
		
		String[] splitStr = str.split("");
		
		StringBuffer buffer = new StringBuffer(str);
		System.out.println(buffer.reverse());
		
		for(int i = splitStr.length - 1; i>=0; i--)
		{
			System.out.print(splitStr[i]);
		}
		System.out.println("");
		
		Optional num= Stream.of(9, 5, 8, 7, 4, 9, 2, 11, 10, 3)
                .filter(n -> n > 10)             
                .filter(n -> n % 5 == 0)    
                .findFirst();
		System.out.println(num);
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5); 
		int result= numbers.stream()
		                   .filter(n -> n % 2 == 0)
		                   .mapToInt(Integer::intValue)
		                   .sum();
		System.out.println(result);
		List<Integer> list = Arrays.asList(2,5,7,6,3,8,1);
		
		System.out.println("********");
		list.stream().sorted(Comparator.naturalOrder()).skip(list.size() - 1).forEach(x->System.out.print(x+" "));
		System.out.println("");
		System.out.println("111111");
		list.stream().sorted(Integer::compare).skip(list.size() -1).forEach(x->System.out.print(x+" "));;
		System.out.println("");
		System.out.println("22222");
		System.out.println("********");
	}
}
