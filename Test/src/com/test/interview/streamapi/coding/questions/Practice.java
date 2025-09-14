package com.test.interview.streamapi.coding.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {

	public static void main(String[] args) {
		// Find even numbers
		int arr[] = { 10, 15, 8, 49, 25, 98, 32 };
		Arrays.stream(arr).filter(x -> x % 2 == 0).forEach(System.out::println);

		// Strarts with 1 in given list
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		List<String> stringList = myList.stream().map(x -> String.valueOf(x)).filter(x -> x.startsWith(""))
				.collect(Collectors.toList());
		System.out.println(stringList);

		// Convert list to map
		Map<String, String> map = myList.stream().map(x -> x.toString()).filter(x -> x.startsWith(""))
				.collect(Collectors.toMap(x -> x, x -> x));
		System.out.println(map);

		// Find dublicate elements
		myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Set<Integer> set = new HashSet<>();

		List<Entry<Integer, Long>> dublicates = myList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() > 1).collect(Collectors.toList());

		System.out.println(dublicates);

		/*
		 * List<Entry<Integer,Integer>> dublicate =
		 * Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),
		 * Collectors.counting())) .entrySet().stream().filter(x-> x.getValue() >
		 * 1).collect(Collectors.toList());
		 */
		// Find first element
		myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Integer firstEle = myList.stream().findFirst().get();
		System.out.println(firstEle);

		// find count
		myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		long count = myList.stream().count();
		System.out.println("Count() " + count + " size() " + myList.size());

		// Find maximum value
		// myList.stream().sorted().findFirst().ifPresent(System.out::print);
		myList = myList.stream().sorted(Comparator.comparingInt(Integer::intValue)).collect(Collectors.toList());
		System.out.println(myList.get(myList.size() - 1));

		List<Integer> _myList = myList.stream().sorted().filter(x -> x > 1).skip(myList.size() - 1)
				.collect(Collectors.toList());
		System.out.println(_myList);

		// find first non repeated character
		String _input = "dDjava Jarticles are Awesome";
		String input = _input.toLowerCase();
		String str = Arrays.stream(input.toLowerCase().split("")).filter(x -> input.indexOf(x) == input.lastIndexOf(x))
				.findFirst().get();
		System.out.println(str);

		// find first repeated character
		String repeatedStr = "dDjava Jarticles are Awesome";

		String repeatedChar = Arrays.stream(repeatedStr.split(""))
				.filter(x -> repeatedStr.indexOf(x) != repeatedStr.lastIndexOf(x)).findFirst().get();
		System.out.println(repeatedChar);
		repeatedChar = Arrays.stream(repeatedStr.split(""))
				.filter(x -> repeatedStr.indexOf(x) != repeatedStr.lastIndexOf(x)).findFirst().get();

		List<Integer> sortList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

		sortList = sortList.stream().sorted(Comparator.comparingInt(Integer::intValue)).collect(Collectors.toList());
		;
		System.out.println(sortList);

		sortList = sortList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(sortList);

		// Arrays.stream(arr).collect(Collectors.toList());

		Arrays.stream(arr).filter(x -> x > 1 ? true : false).forEach(System.out::print);
		;
		// return true or false
		int _arr[] = { 10, 15, 8, 49, 25, 98, 98, 32, 15 };
		int ct = 0;
		int dublicate = 0;
		for (int i = 0; i < _arr.length; i++) {
			ct++;
			for (int j = i + 1; j < _arr.length; j++) {

				if (_arr[i] == _arr[j]) {
					ct++;
					dublicate = _arr[i];
				}
			}
			if (ct == 2)
				System.out.println(true + " " + dublicate);
			else
				System.out.println(false);

			ct = 0;
		}
		List<String> list1 = Arrays.asList("Java", "8");
		List<String> list2 = Arrays.asList("explained", "through", "programs");

		Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());
		concatStream.forEach(s -> System.out.print(s + " "));

		List<Integer> sortedList = myList.stream().sorted(Comparator.comparingInt(Integer::intValue))
				.collect(Collectors.toList());
		System.out.println(sortedList);
		Map<Integer, Integer> _map = sortedList.stream().sorted()
				.collect(Collectors.toMap(x -> x, x -> x, (x, y) -> y));
		System.out.println(_map);

		// Sort the HashMap by keys using streams
		Map<Integer, Integer> sortedByValue = _map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		// Printing the sorted map
		sortedByValue.forEach((key, value) -> System.out.println(key + ": " + value));
		List<Integer> listTosort = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

		Map<Integer, Integer> newMap = listTosort.stream().collect(Collectors.toMap(x -> x, x -> x, (x, y) -> y));
		Comparator<Integer> keyComparator = Comparator.reverseOrder();
		Map<Integer, Integer> sortedNewMap = newMap.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getKey, keyComparator))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
		// sortedNewMap.forEach((x,y)->System.out.println(x+" "+y));
		System.out.println(sortedNewMap);

		List<String> names = Arrays.asList("AA", "BB", "AA", "CC");

		Map<String, Long> countNamsMap = names.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(countNamsMap);
		Map<Object, Object> dublicateNamsMap = names.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
		System.out.println(dublicateNamsMap);
		String countString = "explainedthroughprograms";
		Map<String, Long> countStringMap = Arrays.stream(countString.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(countStringMap);

		List<Integer> sum = Arrays.asList(10, 15, 8, 49, 25, 98, 32);

		System.out.println(sum.stream().mapToInt(Integer::intValue).sum());

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		numbers.stream().peek(n -> System.out.print("Processing: " + n + " ")).map(n -> n * n)
				.forEach(System.out::println); // Ou

		numbers = Arrays.asList(1, 2, 3, 4);
		int prod = numbers.stream().reduce(0, (a, b) -> a * b);
		System.out.println(prod); // Output: 24
	}

}
