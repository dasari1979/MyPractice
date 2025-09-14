package com.test.interview.streamapi.coding.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIPractice {

	public static void main(String[] args) {
		// find prime number
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.stream().filter(x -> x % 2 == 0).forEach(x -> System.out.print(x + " "));
		Map<Boolean, List<Integer>> evenOddNumbersMap = numbers.stream()
				.collect(Collectors.partitioningBy(x -> x % 2 == 1));
		System.out.println("");
		System.out.println(evenOddNumbersMap);
		Map<Boolean, Long> evenOddNumberMap = numbers.stream()
				.collect(Collectors.partitioningBy(x -> x % 2 == 1, Collectors.counting()));
		// System.out.println("");
		System.out.println(evenOddNumberMap);
		List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "apple", "banana");
		Map<Integer, Long> grouped = words.stream().collect(
				Collectors.groupingByConcurrent(String::length, ConcurrentHashMap::new, Collectors.counting()));
		System.out.println(grouped);
		// Find sum of Integers
		// int sumOfIntegers = numbers.stream().mapToInt(Integer::sum);
		int sumOfIntegers = numbers.stream().reduce(Integer::sum).get();
		System.out.println(sumOfIntegers);
		sumOfIntegers = numbers.stream().reduce(0, (a, b) -> a + b);

		numbers.stream().filter(x -> x > 7).collect(Collectors.toList());
		System.out.println(sumOfIntegers);
		// Find Maximum number
		/*
		 * Comparator<Integer> com = new Comparator<Integer>(){
		 * 
		 * @Override public int compare(Integer o1, Integer o2) { // TODO Auto-generated
		 * method stub return o1 - o2; }
		 * 
		 * };
		 */
		// Comparator<Integer> com = (o1,o2)-> o1 - o2;
		numbers = Arrays.asList(3, 7, 2, 4, 8, 9, 5);
		int maximumNumber = numbers.stream().max(Comparator.comparing(Integer::intValue)).get();
		System.out.println(maximumNumber);
		Optional<Integer> oPtionalmaximumNumber = numbers.stream().max(Comparator.comparing(Integer::intValue));
		if (oPtionalmaximumNumber.isPresent())
			System.out.println(oPtionalmaximumNumber.get());
		maximumNumber = numbers.stream().max(Integer::compare).get();
		System.out.println(maximumNumber);
		// Find given number
		System.out.println(numbers.stream().anyMatch(x -> x == 7));
		// Find sum of even numbers
		System.out.println(numbers.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum));
		System.out.println(numbers.stream().filter(x -> x % 2 == 0).mapToInt(n -> n).sum());
		// Concatenate all the strings in the list
		List<String> strings = Arrays.asList("apple", "banana", "cherry", "grapefruit");
		System.out.println(strings.stream().collect(Collectors.joining(",")));
		List<Integer> _numbers = Arrays.asList(3, 7, 2, 4, 8, 9, 5);
		Stream<Integer> mergeTwoLists = Stream.concat(numbers.stream(), _numbers.stream());
		mergeTwoLists.filter(x -> x % 2 == 1).forEach(System.out::print);
		// average length of strings
		System.out.println(strings.stream().mapToInt(String::length).average().getAsDouble());
		System.out.println(strings.stream().map(x -> x.length()).reduce(Integer::sum).get() / strings.size());
		// count the occurances of the given character in a list of strings.
		Long charGiven = Arrays.stream(strings.stream().collect(Collectors.joining()).split(""))
				.filter(x -> x.equalsIgnoreCase("a")).collect(Collectors.counting());
		System.out.println("Count of: " + 'a' + " is " + charGiven);
		System.out.println(strings.stream().flatMapToInt(CharSequence::chars).filter(x -> x == 'a').count());
		// check if all elements in a list are greater than a given value
		System.out.println(numbers.stream().allMatch(x -> x > 3));
		System.out.println(IntStream.rangeClosed(1, 7).reduce((a, b) -> a * b).getAsInt());
		// length of string in list of the string
		System.out.println(strings.stream().max((s1, s2) -> s1.length() - s2.length()).get());
		// string to upper case
		System.out.println(strings.stream().map(String::toUpperCase).collect(Collectors.toList()));
		// sort alphbatical order
		System.out.println(strings.stream().sorted().collect(Collectors.toList()));
		// Average of the list of integers in list
		numbers = Arrays.asList(3, 7, 2, 4, 8, 9, 5);
		System.out.println(numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()).stream()
				.mapToInt(Integer::intValue).average().getAsDouble());
		System.out.println(numbers.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).average().getAsDouble());
		// convert a list of integers to comma separated string.
		System.out.println(numbers.stream().map(x -> x.toString()).collect(Collectors.joining(",")));
		// last element
		System.out.println(numbers.stream().skip(numbers.size() - 1).collect(Collectors.toList()));
		System.out.println(numbers.stream().reduce((a, b) -> b).get());
		// Second smallest element
		System.out.println(numbers.stream().sorted().skip(1).findFirst().get());
		// frequency of each word from list of strings
		strings = Arrays.asList("apple banana apple", "banana", "cherry", "cherry");

		Stream<Object> stringList = strings.stream().flatMap(line -> Arrays.asList(line.split(" ")).stream());
		Map<Object, Long> stringMap = stringList.collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.println(stringMap);
		// stringList.forEach(x->System.out.println(" "+x.toString()));
		stringMap = strings.stream().flatMap(x -> Arrays.asList(x.split(" ")).stream())
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.println(stringMap);
		Map<Object, Long> mapString = strings.stream().flatMap(x -> Arrays.asList(x.split(" ")).stream())
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.println(mapString);
		// some of the digists of the integers
		int number = 123456;
		System.out.println(Arrays.stream(String.valueOf(number).split("")).map(x -> Integer.parseInt(x))
				.reduce(Integer::sum).get());
		// find the distinct characters in a list of strings
		strings = Arrays.asList("apple", "banana", "cherry");
		strings.stream().flatMap(x -> Arrays.asList(x.split("")).stream()).collect(Collectors.toSet())
				.forEach(x -> System.out.print(x + " "));
		System.out.println("");
		// find all the numbers starts with 2
		numbers = Arrays.asList(223, 234, 145, 367, 289, 2001, 2289);
		numbers.stream().map(x -> x.toString()).filter(x -> x.startsWith("2")).collect(Collectors.toList())
				.forEach(x -> System.out.print(x + " "));
		// find first element of the list
		numbers = Arrays.asList(10, 20, 30, 40, 50);
		System.out.print("\n" + numbers.stream().findFirst().get());
		// count the total numbers of elements in the given integers list
		System.out.print("\n" + numbers.stream().count() + "\n");
		// to sort all the values of the list in ascending order
		numbers = Arrays.asList(5, 2, 8, 1, 9, 3);
		numbers.stream().sorted().forEach(x -> System.out.print(x + " "));
		// to sort all the values of the list in descending order
		System.out.println("");
		numbers.stream().sorted(Comparator.reverseOrder()).forEach(x -> System.out.print(x + " "));
		System.out.println("");
		// find second highest
		System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
		// check if given integer array contains duplicate or not
		int[] nums = { 1, 2, 3, 4, 5, 5 };
		System.out.println(Arrays.stream(nums).distinct().count() != nums.length);
		// concat streams Stream.concat(stream1, stream2);
		// perform square on list and check if it grater thatn 10000
		numbers = Arrays.asList(10, 20, 30, 40, 50, 110, 120, 11);
		numbers.stream().map(x -> x * x).filter(x -> x > 1000).collect(Collectors.toList())
				.forEach(x -> System.out.print(x + " "));
		// how to separate odd and even number from given list
		System.out.println("");
		numbers.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0, Collectors.toList()))
				.forEach((x, y) -> System.out.print(x + " " + y));
		;
		// print the numbers which are multiples of 3
		System.out.println("");
		numbers.stream().filter(x -> x % 3 == 0).forEach(x -> System.out.print(x + " "));
		// merge two unsorted arrays into single sorted array
		int[] arr1 = { 3, 6, 8, 10, 10 };
		int[] arr2 = { 1, 2, 4, 5 };
		IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
		// first three maximum numbers and three minimum numbers from the given list of
		// integers
		System.out.println("");
		System.out.println("Three minimum nubers: ");
		numbers = Arrays.asList(10, 5, 20, 15, 25, 3, 30, 1, 8);
		numbers.stream().sorted().limit(3).forEach(x -> System.out.print(x + " "));
		// numbers.stream().sorted().skip(numbers.size()-3).forEach(x->System.out.print(x+"
		// "));
		System.out.println("");
		System.out.println("Three maximum nubers: ");
		numbers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(x -> System.out.print(x + " "));
		// check if two strings are anagrams or not
		String str1 = "listen";
		String str2 = "silent";
		System.out.println("");
		IntStream.iterate(2, n -> n + 2).limit(10).forEach(x -> System.out.print(x + " Hai.......... "));
		String sortedStr1 = Arrays.stream(str1.split("")).sorted().reduce((s1, s2) -> s1 + s2).get();
		System.out.println(sortedStr1);
		String sortedStr2 = Arrays.stream(str2.split("")).sorted().reduce((s1, s2) -> s1 + s2).get();
		System.out.println(sortedStr2);
		System.out.println(sortedStr1.equalsIgnoreCase(sortedStr2));
		// sort given list of strings according to decreasing order of their length
		strings = Arrays.asList("banana", "apple", "orange", "grape", "kiwi");
		strings.stream().sorted((s1, s2) -> s1.length() - s2.length()).collect(Collectors.toList())
				.forEach(x -> System.out.print(x + " "));
		// Find common elements between two lists
		List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8));
		System.out.println("");
		list2.stream().filter(x -> list1.contains(x)).forEach(x -> System.out.print(x + " "));
		// prints the first 5 odd numbers
		System.out.println("");
		IntStream.iterate(1, n -> n + 2).limit(10).forEach(x -> System.out.print(x + " "));
		// print the most repeated element in an array
		int[] array = { 1, 2, 3, 4, 2, 2, 3, 4, 4, 4, 5, 5, 4 };
		Entry<Integer, Long> mostRepeatedNumber = Arrays.stream(array).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).get();
		System.out.println("");
		System.out.println(mostRepeatedNumber);
		// print duplicate elements from an array
		int[] arrayarray = { 1, 2, 3, 4, 2, 3, 5, 6, 7, 8, 9, 1, 4 };
		Arrays.stream(arrayarray).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() > 1).forEach(x -> System.out.print(x.getKey() + " "));
		// find first repeated character in the given string
		String str = "hello world";
		Entry<String, Long> firstRepeatedchar = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() > 1).findFirst().get();
		System.out.println("");
		System.out.print(firstRepeatedchar.getKey());
		// check if a list contains a specific string
		List<String> list = Arrays.asList("apple", "banana", "orange", "grape");
		String searchString = "orange";
		System.out.println("");
		System.out.println(list.stream().anyMatch(x -> x.contains(searchString)));
		// print all the strings of given length
		list = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
		int targetLength = 6;
		list.stream().filter(x -> x.length() == targetLength).forEach(x -> System.out.print(x + " "));
		// find the product of all elements in a list
		numbers = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println("");
		System.out.println(numbers.stream().reduce(1, (a, b) -> a * b));
		// find duplicate elements from list of integers
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		System.out.println("");
		myList.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() > 1).forEach(x -> System.out.print(x.getKey() + " "));
	}
}
