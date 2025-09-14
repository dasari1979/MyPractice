package com.test.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {
	public  static boolean prime(int number){
	return !IntStream.rangeClosed(2,number/2).anyMatch(i->number%i==0);
	}
	public static void main(String[] args) {
        String string = "dasari$";
		Stream.of(string)
        .map(word->new StringBuilder(word).reverse())
        .collect(Collectors.joining(" "));
		System.out.println(Stream.of(string).map(str -> new StringBuffer(str).reverse()).collect(Collectors.joining()));
		
		List<Integer> list
        = Arrays.asList(0, 2, 4, 6, 8, 10);
    System.out.println("Peek started...");
    
    Stream.of("one", "two", "three", "four")
    .filter(e -> e.length() > 3)
    .peek(e -> System.out.println("Filtered value: " + e))
    .map(String::toUpperCase)
    .peek(e -> System.out.println("Mapped value: " + e))
    .collect(Collectors.toList());
    
    list.forEach(new Consumer<Integer>() {

    	   public void accept(Integer t) {
    	    System.out.println("forEach anonymous class Value::"+t);
    	   }

    	  });
    
    // Using peek without any terminal
    // operation does nothing
    list.stream().peek(System.out::println);
    System.out.println("Peek end...");
		
	//	System.out.println(Stream.of(string).map(x-> Pattern.compile("[A-Za-z]")).filter(Matcher::find));
		
		String s[] = {"dd","da","d","a","da"};
		
		List<String> arryList = Arrays.asList("dd","da","d","a","da");
		 System.out.println("***********************************************************");
		System.out.println(arryList.stream().findAny().orElseGet(()->"Hi"));
		System.out.println(Arrays.stream(s).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
		
		List<Integer> sort = Arrays.asList(5,2,4,8,6,9,8);

	//	sort.stream().distinct().sorted().forEach(System.out::println);
		
		System.out.println(sort.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
		List<Integer> dublicates = new ArrayList<Integer>(sort);

		sort.stream().filter(x -> Collections.frequency(sort, x)>1).collect(Collectors.toSet()).forEach(System.out::println);
        int number = 5;
		System.out.println(IntStream.rangeClosed(1,number).reduce(1,(x,y)-> x*y));
		
		System.out.println(sort.stream().distinct().collect(Collectors.toMap(x->x, x -> x)));
		
		sort.stream().filter(x -> x%2 == 1).forEach(System.out::println);
		
		int a[] = {1,4,5,3,9,7,2,11};
		System.out.println(Arrays.stream(a).filter(StreamAPI::prime).sum());

		int array[] = {11,12,1,2,3,7,9};
        System.out.println("Starts with 1 : ");
		Arrays.stream(array).boxed().map(x-> x+"").filter(x-> x.startsWith("1")).forEach(System.out::println);
		int dub[] = {5,6,4,8,6} ;
		/*System.out.println("Dublicates: ");
		Arrays.stream(dub).distinct().forEach(x->System.out.print(x));*/
		System.out.println(Arrays.stream(dub).boxed().distinct().collect(Collectors.toList()));
		List<Integer> _sort = Arrays.asList(5,6,4,8,6);
		System.out.println(_sort.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
		Set<Integer> set = new HashSet();
		_sort.stream()
              .filter(n -> !set.add(n))
              .forEach(System.out::println);
		System.out.println("No of elements: "+Arrays.stream(dub).count());
		System.out.println("max element: "+Arrays.stream(dub).max().getAsInt());
		Stream.concat(dublicates.stream(), dublicates.stream()).forEach(System.out::print);
		
		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        
        List<String> uniqueStrngs = listOfStrings.stream().distinct().collect(Collectors.toList());
        String s1[] = {"dd","da","d","a","da"};
        System.out.println("");
        System.out.println("99999999");
        
        int a1[] = {2,3,4};
        int a2[] = {2,3,4};
        
        String str = "23456";
        
        System.out.println(Arrays.stream(str.split("")).map(x->Integer.parseInt(x)).reduce(0, (z,y)->z+y));
        
        System.out.println("Remove duplicate.....Start.........");
        
        Map<String, Long> sorting = Arrays.stream(s1).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        sorting.entrySet().stream().filter(x->x.getValue() == 1).forEach(x->System.out.println(x.getKey()));
        System.out.println("Remove duplicate.....End.........");
        System.out.println("");
    //    System.out.println(uniqueStrngs);
    //   Arrays.stream(array).limit(3).forEach(System.out::println);
        _sort.stream().sorted().limit(2).forEach(System.out::print);
        
        Arrays.stream(array).sum();
        int aa[] = {2,3,4,15};

        Arrays.stream(aa).filter(n->n%2==0).forEach(System.out::println);
        Arrays.stream(aa).forEach(
        		x->
        		{
        			String strarts = String.valueOf(x);
        			if(strarts.startsWith("1"))
        				System.out.println("Starts with: "+x);
        	});
       List<String> sss = Arrays.asList(s1);
       System.out.println(sss.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.joining())));
       System.out.println(Arrays.stream(s1).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
     //  sss.add(null);
       System.out.println(sss);
       LinkedHashSet<String> _set = new LinkedHashSet<>();
       _set.add(null);
       System.out.println(_set);
	}

}
