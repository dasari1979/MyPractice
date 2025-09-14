package com.test.interview.streamapi.coding.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EvenNumber {

	public static void test() {
		System.out.println("****************************************");
	}

	public static void main(String[] args) {

		EvenNumber test = null;
		test.test();

		IntStream.range('A', 'd').forEach(i -> System.out.println(i - 'A'));

		List<Integer> list = Arrays.asList(1, 2, 5, 8, 6, 4, 3, 11, 10, 17, 21, 23);
		list.stream().filter(t -> t % 2 == 0).forEach(System.out::println);

		List<Integer> stringList = Arrays.asList(1, 2, 15, 81, 6, 14, 31);
		stringList.stream().filter(x -> x.toString().startsWith("1")).forEach(System.out::println);

		List<Integer> dublicateList = Arrays.asList(1, 2, 15, 81, 6, 2, 14, 1, 31, 6);

		Set<Integer> set = new HashSet<>();

		dublicateList.stream().filter(x -> !set.add(x)).forEach(System.out::println);

		System.out.println("Prime Numbers.....");
		int a[] = { 3, 7, 6, 8, 3, 9, 11, 15, 13, 17, 21, 23 };
		int b[] = new int[9];
		Arrays.stream(a).filter(EvenNumber::isPrime).distinct().forEach(System.out::println);

		System.out.println("Sum:  " + Arrays.stream(a).map(x -> x).sum());

		System.out.println("Prime Numbers.....");
		Arrays.stream(a).filter(x -> x % 2 != 0 && x % 3 != 0).forEach(System.out::println);
		System.out.println("Second highst no...");
		Arrays.stream(a).sorted().distinct().limit(a.length - 3).forEach(System.out::println);
		System.out.println("List...");
		dublicateList.stream().sorted(Comparator.reverseOrder()).limit(2).forEach(System.out::println);

		String str = "SrinivasDasari";
		System.out.println("Hai.................");
		Stream<String> element = Arrays.stream(str.toLowerCase().split(""))
				.filter(x -> str.indexOf(x) == str.lastIndexOf(x)).limit(1);
		System.out.println(element.findFirst().get());

		List<Notes> noteLst = new ArrayList<>();
		noteLst.add(new Notes(1, "note1", 11));
		noteLst.add(new Notes(2, "note2", 22));
		noteLst.add(new Notes(6, "note4", 66));
		noteLst.add(new Notes(3, "note3", 33));
		noteLst.add(new Notes(4, "note4", 44));
		noteLst.add(new Notes(5, "note5", 55));
		noteLst.add(new Notes(6, "note4", 66));

		list = new ArrayList<Integer>();

		list.add(1);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println("Hai..");
		Map<Integer, Integer> _map = list.stream()
				.collect(Collectors.toMap(x -> x, x -> x, (oldValue, newValue) -> oldValue));

		System.out.println(_map);

		Map<Integer, Object> map = noteLst.stream().sorted(Comparator.comparing(Notes::getId)).collect(
				Collectors.toMap(Notes::getId, obj -> new Notes(), (oldValue, newValue) -> oldValue + ":" + newValue));

		System.out.println(map);

		List<String> names = Arrays.asList("AA", "BB", "AA", "CC");

		String ss = "srinivas";

		Map<String, Long> counting = names.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("All charactors count: " + counting);
		counting = Arrays.stream(ss.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("All dublicate charactors count: " + counting);

		StringBuffer reverseString = Arrays.stream(ss.split(""))
				.collect(StringBuffer::new, StringBuffer::append, StringBuffer::append).reverse();
		System.out.println(reverseString.toString());

		String polindrom = "mom";

		boolean isPolindrom = Arrays.stream(polindrom.split(""))
				.allMatch(x -> polindrom.charAt(polindrom.indexOf(x)) == polindrom.charAt(polindrom.lastIndexOf(x)));

		System.out.println(isPolindrom);
	}

	public static boolean isPrime(int n) {
		boolean isPrimNo = !IntStream.range(2, n).filter(i -> n % i == 0).findAny().isPresent();
		return isPrimNo;

	}
}
