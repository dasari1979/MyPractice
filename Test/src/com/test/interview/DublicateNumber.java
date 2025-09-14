package com.test.interview;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DublicateNumber {

	public static void main(String[] args) {
		
		List _list = Arrays.asList(3,4,5,4);


		System.out.println(_list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
		int a[] = { 1, 4, 5, 2, 12, 34, 2, 11 };
		List<Integer> list = Arrays.asList(1, 4, 5, 2, 12, 34, 2, 11);
		System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
        
		int x = 164351;
		String value = String.valueOf(x);
		int len = value.length();
		System.out.println(len/2);
		System.out.println(IntStream.range(0, len/2).anyMatch(index -> value.charAt(index) == value.charAt(len-index-1)));
		
		String input = "JavaAPppI";
		List<Character> dublicateList = input.chars().mapToObj(y -> ((char) y)).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting())).
		entrySet().stream().filter(z -> z.getValue() > 1L).map(Entry::getKey).collect(Collectors.toList());
		System.out.println(dublicateList);
		int b[] = { 2, 3, 1, 22, 11, 33, 5 };
		System.out.println(Arrays.stream(b).sorted().skip(b.length-2).findFirst().getAsInt());
	}

}
