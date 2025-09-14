package com.test.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlatMap {

	public static void main(String[] args) {
		
		
		List<List<String>> list =  Arrays.asList(Arrays.asList("d","ABC","DEF"),Arrays.asList("x","XYZ","MNO"),Arrays.asList("p","PQR","JKL"));
		List<String> flatList = list.stream().flatMap(x-> x.stream().map(y->y.toLowerCase())).sorted().collect(Collectors.toList());
	    System.out.println(flatList);
	    
	    int a[] = {2,3,5,1,9};
	    
	    List<Integer> intList = Arrays.asList(2,3,5,1,9);
	    
	    List<Integer> filteredList = intList.stream().filter(x-> x > 3).collect(Collectors.toList());
        System.out.println(filteredList);
        
        Arrays.stream(a).filter(x-> x<2).forEach(System.out::println);
        
        intList.stream().filter(x-> x % 2 == 0).forEach(System.out::println);
        
       // int a[] = {"3","6","8","9","2"};


        List<String> parseInt = Arrays.asList("3","6","8","9","2");

       List<Integer> evenList = parseInt.stream().map(s-> Integer.valueOf(s)).filter(y-> y % 2 == 0).collect(Collectors.toList());
       
       System.out.println(evenList);
       String str = "dasarisrinivas";

      // List<String> s = Arrays.asList(str);

       System.out.println(str.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
       
       List<Integer> primNumbers = Arrays.asList(3,4,6,7,9,10,17);

       primNumbers.stream().forEach(x->{

       boolean isPrime = IntStream.rangeClosed(2, x / 2).anyMatch(i->x % i == 0);
       if(!isPrime)
         System.out.println("Prime number "+x);
       });
       // int a[] = { 1, 4, 5, 2, 12, 34, 2, 11 };
        List<Integer> dublicate = Arrays.asList(1, 4, 5, 2, 12, 34, 2, 11 );
        Map<Integer, Long> map = dublicate.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        
        map.keySet().stream().filter(x -> map.get(x) > 1).forEach(System.out::println);
        
        String poly = "aabcc";
        
         Map<Character, Long> map1 = poly.chars().mapToObj(x-> Character.toUpperCase((char)x)).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
         System.out.println(map1.entrySet().stream().filter(x -> x.getValue()> 1L).collect(Collectors.toList()));
         
         int arr[] = { 2, 3, 1, 22, 11, 33, 5 };
         
         System.out.println(Arrays.stream(arr).sorted().skip(arr.length-3).findFirst().getAsInt());
	
	}

}
