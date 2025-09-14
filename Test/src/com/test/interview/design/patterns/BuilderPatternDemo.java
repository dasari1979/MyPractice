package com.test.interview.design.patterns;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BuilderPatternDemo {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("apple","apple", "banana", "orange", "grape", "kiwi");
		Map<Object, Object> map = list.stream().collect(Collectors.toMap(x->x.toString(), x->x.toString(),(old,newValue)->newValue))
				.entrySet().stream().filter(x->x.getKey().length() > 4)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(x,y)->y));
		System.out.println(map);
		User user = new UserBuilder("Srinu","Dasari")
				.id(2)
				.emailId("ss@gmail.com")
				.build();
	System.out.println(user);
	}

}
