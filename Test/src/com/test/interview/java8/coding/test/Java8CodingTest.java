package com.test.interview.java8.coding.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8CodingTest {

	public static void main(String[] args) {
		// find out all the even numbers
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		list.stream().filter(x -> x % 2 == 0).forEach(x -> System.out.print(x + " "));
		int[] arr = { 10, 15, 8, 49, 25, 98, 32 };

		int[] array1 = { 10, 15, 8, 49, 25, 98, 32 };
		int[] array2 = { 10, 15, 8, 49, 25, 98, 32 };

		IntStream.concat(Arrays.stream(array1), Arrays.stream(array2));

		System.out.println("");
		Arrays.stream(arr).filter(x -> x % 2 == 0).forEach(x -> System.out.print(x + " "));
		Map<Boolean, List<Integer>> evenNumbers = Arrays.stream(arr).boxed()
				.collect(Collectors.partitioningBy(num -> num % 2 == 0));
		System.out.println(evenNumbers);

		// find out all the numbers starting with 1
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		List<String> startsWithOneList = myList.stream().map(x -> String.valueOf(x)).filter(x -> x.startsWith("1"))
				.collect(Collectors.toList());
		System.out.println(startsWithOneList);

		// find duplicate elements in a given integers list
		myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15, 10);
		myList.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() > 1).forEach(x -> System.out.print(x.getKey() + " "));
		System.out.println("");

		// find the first element of the list using
		myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		System.out.println(myList.stream().findFirst().get());

		// find the total number of elements present in the list
		myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		System.out.println(myList.stream().count());
		System.out.println(myList.stream().reduce(0, (x, y) -> x + y));

		// find the maximum value element present
		myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		System.out.println(myList.stream().sorted(Comparator.naturalOrder()).findFirst().get());
		System.out.println(myList.stream().sorted(Comparator.reverseOrder()).findFirst().get());
		System.out.println(myList.stream().max(Comparator.naturalOrder()).get());
		System.out.println(myList.stream().max(Comparator.reverseOrder()).get());
		int[] array = { 10, 15, 8, 49, 25, 98, 98, 32, 15 };
		System.out.println("Int Array");
		System.out.println(Arrays.stream(array).max().getAsInt());
		System.out.println(Arrays.stream(array).min().getAsInt());
		System.out.println(Arrays.stream(array).boxed().max(Integer::compare).get());
		System.out.println(Arrays.stream(array).boxed().min(Integer::compare).get());
		System.out.println("Int Array End min and max...");
		System.out.println(myList.stream().max(Integer::compare).get());
		System.out.println(myList.stream().min(Integer::compare).get());

		// find the first non-repeated character
		String input = "Java articles are Awesome";
		System.out.println(
				Arrays.stream(input.split("")).filter(x -> input.indexOf(x) == input.lastIndexOf(x)).findFirst().get());

		String nonRepeatedChar = Arrays.stream(input.split("")).map(x -> x.toLowerCase())
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey();
		System.out.println(nonRepeatedChar);

		// find the first repeated character
		System.out.println(
				Arrays.stream(input.split("")).filter(x -> input.indexOf(x) != input.lastIndexOf(x)).findFirst().get());

		// sort all the values present
		myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		System.out.println(myList.stream().sorted().collect(Collectors.toList()));

		// sort all the values present in it in descending
		myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		System.out.println(myList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

		// return true if any value appears at least twice in the array, and return
		// false
		int[] arrayCountNums = { 10, 15, 8, 49, 25, 98, 98, 32, 15 };
		Map<Integer, Long> mapDuplicateCount = Arrays.stream(arrayCountNums).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		HashMap<Integer, Boolean> duplicateMap = new HashMap<>();
		mapDuplicateCount.entrySet().stream().forEach(x -> {
			if (x.getValue() > 1)
				duplicateMap.put(x.getKey(), true);
			else
				duplicateMap.put(x.getKey(), false);
		});
		System.out.println(duplicateMap);

		// How will you get the current date and time using Java 8 Date and Time
		System.out.println(java.time.LocalDate.now());

		// to concatenate two Streams
		List<String> list1 = Arrays.asList("Java", "8");
		List<String> list2 = Arrays.asList("explained", "through", "programs");
		Stream<String> concateNateList = Stream.concat(list1.stream(), list2.stream());
		concateNateList.forEach(x -> System.out.print(x + " "));
		
		list2.stream().flatMap(x->Arrays.stream(x.split(""))).forEach(x->System.out.print(" "+x));;

		// perform cube on list elements and filter numbers greater than 50
		List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
		integerList.stream().map(x -> x * x * x).filter(x -> x > 50).forEach(x -> System.out.print(x + " "));

		// sort an array and then convert the sorted array into Stream
		int sortArray[] = { 99, 55, 203, 99, 4, 91 };
		Arrays.stream(sortArray).sorted().boxed();
		Arrays.stream(sortArray).min();
		Arrays.stream(sortArray).average().getAsDouble();

		// map to convert object into Uppercase
		System.out.println("");
		list1.stream().map(x -> x.toUpperCase()).forEach(x -> System.out.print(x + " "));

		// convert a List of objects into a Map by considering duplicated keys and store
		// them in sorted order
		class Notes {
			public Notes(int i, String string, int j) {
				this.id = i;
				this.str = string;
				this.empId = j;
			}

			int id;

			/**
			 * @return the id
			 */
			public int getId() {
				return id;
			}

			/**
			 * @param id
			 *            the id to set
			 */
			public void setId(int id) {
				this.id = id;
			}

			String str;

			/**
			 * @return the str
			 */
			public String getStr() {
				return str;
			}

			/**
			 * @param str
			 *            the str to set
			 */
			public void setStr(String str) {
				this.str = str;
			}

			int empId;
		}
		System.out.println("");
		List<Notes> noteLst = new ArrayList<>();
		noteLst.add(new Notes(1, "note1", 11));
		noteLst.add(new Notes(2, "note2", 22));
		noteLst.add(new Notes(3, "note3", 33));
		noteLst.add(new Notes(4, "note4", 44));
		noteLst.add(new Notes(5, "note5", 55));
		noteLst.add(new Notes(5, "note5", 55));
		Map<Integer, String> sortedMap = noteLst.stream().sorted(Comparator.comparing(Notes::getId).reversed())
				.collect(Collectors.toMap(Notes::getId, Notes::getStr, (oldValue, newValue) -> oldValue));
		System.out.println("******* "+sortedMap);
		Map<Integer, Integer> intMap = Arrays.stream(sortArray).boxed()
				.collect(Collectors.toMap(x -> x, x -> x, (oldValue, newValue) -> oldValue));
		System.out.println(intMap);

		// count each element/word from the String
		List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
		Map<Object, Long> wordCount = names.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.println(wordCount);

		// find only duplicate elements with its count from the String
		List<String> _names = Arrays.asList("AA", "BB", "AA", "CC", "CC");
		Map<String, Long> countWords = _names.stream().filter(x -> Collections.frequency(_names, x) > 1)
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		System.out.println(countWords);
		System.out.println("");

		Arrays.asList("AA", "BB", "AA", "CC", "CC");
		_names.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() > 1).forEach(x -> System.out.print(x.getKey() + " " + x.getValue() + " "));
		System.out.println("");

		// find maximum value
		System.out.println(Arrays.stream(sortArray).max().getAsInt());

		// print the count of each character in a String
		String s = "string data to count each character";
		System.out.println("******************");
		Arrays.stream(s.split("")).collect(Collectors.groupingBy(x->x,Collectors.counting()))
		.entrySet().forEach(x->
		{
			if(!x.getKey().trim().isEmpty())
			System.out.print(x.getKey()+"="+x.getValue()+" ");	
		});
		System.out.println("");
		System.out.println("******************");	
		
		Map<String, Long> countChar = Arrays.stream(s.split("")).map(String::toLowerCase).filter(x -> !x.isEmpty())
				.collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()));
		System.out.println(countChar);

		// group strings by their lengths and print the groups
		List<String> words = Arrays.asList("a", "bb", "ccc", "dd");
		Map<Integer, List<String>> lengthMap = words.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(lengthMap);

		// collect squares of numbers into a new list
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		numbers.stream().map(x -> x * x).collect(Collectors.toList()).forEach(x -> System.out.print(x + " "));

		// sort list of strings in increasing order of their length
		list2 = Arrays.asList("explained", "through", "programs", "dasari", "srinu");
		System.out.println("");
		list2.stream().sorted(Comparator.comparing(String::length)).forEach(x -> System.out.print(x + " "));

		// reverse the int array
		int[] reverseArray = { 10, 15, 8, 49, 25, 98, 32 };
		System.out.println("");
		IntStream.range(0, reverseArray.length).map(x -> (reverseArray.length - 1) - x)
				.forEach(x -> System.out.print(x + " "));

		// sum of all digits of a number
		long num = 2345678;
		System.out.println("");
		System.out.println(Arrays.stream(String.valueOf(num).split("")).map(x -> Integer.parseInt(x))
				.reduce(0, (a, b) -> a + b).intValue());

		// check palindrome
		String poly = "did";
		System.out.println(poly.indexOf("d") + " " + poly.lastIndexOf("d"));
		boolean isPalindrom = Arrays.stream(poly.split(""))
				.allMatch(x -> poly.charAt(poly.indexOf(x)) == poly.charAt(poly.lastIndexOf(x)));
		System.out.println(isPalindrom);
		// reverse string

		String str = "123";
		StringBuffer buffer = new StringBuffer();
		Arrays.stream(str.split("")).forEach(x -> {
			buffer.append(x);
		});
		System.out.println(buffer.reverse());

		// check number is a prime or not
		int[] arrayPrime = { 10, 15, 17, 8, 49, 25, 98, 32 };

		Arrays.stream(arrayPrime).forEach(x -> {

			if (IntStream.range(2, x).noneMatch(a -> x % a == 0)) {
				System.out.println(x + " is not a prime number..");
			}
		});
		// Find maximum number

		int a[] = { 2, 3, 1, 22, 11, 33, 5 };
		Arrays.stream(a).max();
		int arrwihtoutMax[] = { 2, 3, 1, 22, 11, 33, 5 };
		Arrays.stream(arrwihtoutMax).boxed().sorted().findFirst().get();
		Arrays.stream(arrwihtoutMax).boxed().reduce(Integer.MAX_VALUE, (x, b) -> Integer.max(x, b)).intValue();
		// to sum an array
		Arrays.stream(a).boxed().reduce(0, (x, y) -> x + y).intValue();
		Arrays.stream(a).boxed().collect(Collectors.summingInt(Integer::intValue));

		// Iterate over a Stream with Indices
		// String[] strinArray = { "G", "E", "E", "k" };
		IntStream.range(0, a.length).map(x -> x).forEach(x -> System.out.print(x + ":" + a[x] + " "));

		String duplicateCount = "HJJJJDDJ";
		System.out.println("");
		Arrays.stream(duplicateCount.split("")).collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet()
				.stream().filter(x -> x.getValue() >= 1)
				.forEach(x -> System.out.print(x.getKey() + ":" + x.getValue() + " "));
		System.out.println("");

		StringBuilder result = new StringBuilder();
		String _input = "HJJJJDDJ";
		int count = 1;
		for (int i = 1; i < _input.length(); i++) {
			if (_input.charAt(i) == _input.charAt(i - 1)) {
				count++;
			} else {
				result.append(_input.charAt(i - 1)).append("=").append(count).append(", ");
				count = 1;
			}
		}

		// Append the last group
		result.append(_input.charAt(_input.length() - 1)).append("=").append(count);

		System.out.println(result.toString());

		int ct = 1;
		String pre = "";
		StringBuffer duplicateBuffer = new StringBuffer();
		for (String splitStr : duplicateCount.split("")) {
			if (pre.equalsIgnoreCase(splitStr))
				ct++;
			else {
				if (!pre.isEmpty())
					duplicateBuffer.append(pre + ":" + ct + " ");
				ct = 1;
			}
			pre = splitStr;
		}
		duplicateBuffer.append(pre + ":" + ct + " ");
		System.out.println(duplicateBuffer);

	}

}
