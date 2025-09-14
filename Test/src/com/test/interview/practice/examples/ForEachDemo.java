package com.test.interview.practice.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class ForEachDemo {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("ac");
		list.add("bv");
		list.add("cc");
		
	//	list.forEach(t->System.out.println(t));
		list.stream().filter(t->t.startsWith("a")).forEach(System.out::println);
		Map<Object, String> convertedMap = list.stream().collect(Collectors.toMap(Function.identity(),Function.identity()));
		System.out.println(convertedMap);
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "dasari");
		map.put(2, "vaasu");
		map.put(3, "c");
		map.put(4, "d");
		
		map.entrySet().forEach(t-> System.out.println(t.getKey()+","+t.getValue()));
		map.entrySet().stream().filter(x-> x.getValue().startsWith("d")).forEach(System.out::println);
	}

}
