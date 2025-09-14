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

public class CodingPractice {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,32,10);
		List<String> stringList = new ArrayList<>();
		stringList.add("srinu");
		stringList.add("dasari");
		stringList.add("vaasu");
		int arr[] = {10,15,8,49,25,98,32,10};
		System.out.print("Even Numbers: ");
		list.stream().filter(x->x%2==0).forEach(x->System.out.print(" "+x));
		System.out.println("");
		System.out.print("Strarts With 1 : ");
		list.stream().map(x->x.toString()).filter(x->x.startsWith("1")).forEach(x->System.out.print(" "+x));
		System.out.println("");
		System.out.print("Dublicate Elements : ");
		Set<Integer> set = new HashSet<>();
		list.stream().filter(x->!set.add(x)).forEach(x->System.out.print(" "+x));
		list.stream()
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream().filter(x-> x.getValue() > 1).map(x->x.getKey()).forEach(x->System.out.println(" "+x));;
        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
        .entrySet().stream().filter(x->x.getValue()>1).forEach(x->System.out.print(x));
		System.out.println("");
		System.out.print("Find First Element : ");
        System.out.println(list.stream().findFirst().get());
		System.out.print("No of Elements : ");
        System.out.print(list.stream().count());
		System.out.println("");
		System.out.print("Find Max Element : ");
        System.out.println(list.stream().max(Integer::compare).get());
        System.out.println(Arrays.stream(arr).boxed().max(Comparator.naturalOrder()).get());
        
		System.out.print("Find Non Repeated Element : ");
        String input = "Java articles are Awesome";
        System.out.println(Arrays.stream(input.split("")).filter(x->input.indexOf(x)==input.lastIndexOf(x)).findFirst().get());
        System.out.print("Find Repeated Element : ");
        System.out.println(Arrays.stream(input.split("")).filter(x->input.indexOf(x)!=input.lastIndexOf(x)).findFirst().get());
        System.out.print("Ascending Order : ");
        list.stream().sorted(Integer::compare).forEach(x->System.out.print(" "+x));
        System.out.println("");
        System.out.print("Descending Order : ");
        list.stream().sorted(Comparator.reverseOrder()).forEach(x->System.out.print(" "+x));
        System.out.println("");
        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
        .stream()
        .forEach(x->{
        if(x.getValue() == 2)
        System.out.print(x.getKey()+":"+true+" ");
        else if(x.getValue() == 1)
            System.out.print(x.getKey()+":"+false+" ");
        });
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");
        Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());
        System.out.println("");
        concatStream.forEach(x->System.out.print(x+" "));
        System.out.println("");
        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
        integerList.stream().map(x->x*x*x).filter(x->x > 50).forEach(x->System.out.print(x+" "));
        System.out.println("");
        list.stream().collect(Collectors.toMap(x->x,x->x,(x,y)->y))
        .entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey))
        .forEach(x->System.out.println(x.getKey()+" "+x.getValue()));
        System.out.println("");
        stringList.stream().collect(Collectors.toMap(x->x,x->x,(x,y)->y))
        .entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(System.out::println);
        System.out.println("");
        Arrays.stream(input.split("")).map(String::toLowerCase)
        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
         .forEach((x,y)->System.out.println(x+" "+y));
        int a[]= {1,5,4,3,6,7,8,9,1,2,3,4};
        
        long start = System.currentTimeMillis();
        for(int i =0;i<a.length-1;i++) {
        	if(a[i]%2==0)
        	  System.out.println("Even Number: "+a[i]);
        	else if(a[i]%2==1)
        	  System.out.println("Odd Number: "+a[i]);
        }
        long end = System.currentTimeMillis();
        System.out.println("*************Java 4**********************");
        System.out.println(end - start);
        System.out.println("*************Java 4**********************");
        long enhancedstart = System.currentTimeMillis();
        for(int i : a){
        	if(i%2==0)
        	  System.out.println("Even Number: "+a[i]);
        	else if(i%2==1)      	
        	  System.out.println("Odd Number: "+a[i]);
        }
        long enhancedEnd = System.currentTimeMillis();
        System.out.println("*************Java 5**********************");
        System.out.println(enhancedEnd - enhancedstart);
        System.out.println("*************Java 5**********************");
        long streamStart = System.currentTimeMillis();
        Arrays.stream(a).boxed().forEach(x->{
        	if(x%2==0)
        	  System.out.println("Even Number: "+x);
        	else if(x%2==1)       	
        	  System.out.println("Odd Number: "+x);
        });
        long streamEnd = System.currentTimeMillis();
        System.out.println("Java 8");
        System.out.println("*************Java 8**********************");
        System.out.println(streamEnd - streamStart);
        System.out.println("*************Java 8**********************");
        
        System.out.println(Arrays.stream(a).reduce(Integer::sum).getAsInt()+" "+Arrays.stream(a).reduce(0,Integer::sum));
        List<Integer> numbers = Arrays.asList(3, 7, 2, 4, 9, 5,5);
        System.out.println(Arrays.stream(a).max().getAsInt()+" "+
                           Arrays.stream(a).reduce(Integer::max).getAsInt()
                           +" "+numbers.stream().reduce(Integer::max).get());
        System.out.println(numbers.stream().anyMatch(x->x == 5));

        System.out.println(numbers.stream().filter(x->x%2 == 0).mapToInt(x->x).reduce(Integer::sum).getAsInt());
        System.out.println(numbers.stream().filter(x->x%2 == 0).reduce(Integer::sum).get());
        List<String> strings = Arrays.asList("Hello", " ", "World", "!");

        System.out.println(strings.stream().collect(Collectors.joining()));
        System.out.println(strings.stream().map(String::length).mapToInt(x->x).average().getAsDouble());
        
        strings = Arrays.asList("apple", "banana", "cherry");
        
        long ct = Arrays.stream(strings.stream().collect(Collectors.joining()).split("")).filter(x->x.equalsIgnoreCase("a")).count();
         System.out.println(ct);
         
         ct = strings.stream().flatMapToInt(word -> word.chars()).filter(ch -> ch == 'a')
         .count();
         System.out.println(ct);
      //  {
     //   Arrays.stream(x.split("")).filter(b->"a".equalsIgnoreCase(b)).count();
     //   });
         System.out.println(numbers.stream().max(Integer::compareTo).get());
         System.out.println(strings.stream().flatMapToInt(CharSequence::chars).filter(x->x == 'a').count());
         System.out.println("************************");
         list = numbers.stream().filter(x-> x > 1).collect(Collectors.toList());
         System.out.println(list);
         boolean isGrathan = numbers.stream().allMatch(n -> n > 1);
         System.out.println(isGrathan);
         int factorial = 5;
         int multiple = IntStream.rangeClosed(1, factorial).reduce(1, (x, y) -> x * y);
         System.out.println(multiple);
         numbers = Arrays.asList(3, 7, 2, 4, 9, 5,5);
         System.out.println(numbers.stream().distinct().collect(Collectors.toList()));
         System.out.println(strings.stream().max((x,y)->x.length() - y.length()).get());
         numbers.stream().filter(x->x%2 ==0).mapToInt(x->x).average().getAsDouble();
         System.out.println(numbers.stream().map(x->x.toString()).collect(Collectors.joining(",")));
     //    System.out.println(numbers.stream().filter(x->x == numbers.get(numbers.size()-1)).findFirst().get());
         System.out.println(numbers.stream().reduce((x,y)->y).get());
         //Arrays.asList(3, 7, 2, 4, 9, 5,5);
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
         //System.out.println(numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).forEach(System.out::println);.get());
         System.out.println(numbers.size()-1);
         numbers.stream().distinct().sorted().skip(0).forEach(x->System.out.print(" "+x));
         System.out.println("");
         System.out.println("+++++++++++++++++++++Ascending Order++++++++++++++++++++++++++++");
         System.out.println(numbers.stream().distinct().sorted().limit(numbers.size()-1).findFirst().get());
       //  System.out.println("");
         System.out.println("+++++++++++++++++++++Decending Order++++++++++++++++++++++++++++");
         numbers.parallelStream().distinct().sorted(Comparator.reverseOrder()).limit(numbers.size()-1).forEach(x->System.out.print(" "+x));
         System.out.println("");
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
         List<String> words = Arrays.asList("apple banana apple", "banana cherry", "apple banana cherry");
      //   words.stream().flatMap(line -> List.of(line.split("\\s+")).stream())
      //   .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
         
         
        Stream<Object> stringsArray = words.stream().flatMap(x-> Arrays.stream(x.split("\\s")));
        Map<Object, Long> counting = stringsArray.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(counting);
        Set<String> distinctChars = Arrays.stream(strings.stream().collect(Collectors.joining()).split("")).collect(Collectors.toSet());
        System.out.println(distinctChars);
        numbers = Arrays.asList(223, 234, 145, 367, 289, 2001, 2289);
        List<String> startsWith2 = numbers.stream().map(x->x.toString()).filter(x->x.startsWith("2")).collect(Collectors.toList());
        System.out.println(startsWith2);
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> setOfEvenOrOdd = numbers.stream().collect(Collectors.partitioningBy(x->x%2==0));
        System.out.println(setOfEvenOrOdd.get(true));
        System.out.println(setOfEvenOrOdd.get(false));
        
        IntStream.iterate(1, n -> n + 2)  // Start at 1, increment by 2 to get odd numbers
        .limit(10)              // Limit to the first 10 odd numbers
        .forEach(x->System.out.print(x+" "));
        
        numbers.forEach(x->System.out.print("Hai........... "+x));
     }
}
