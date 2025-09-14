package com.test.interview.streamapi.coding.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AlternateNumber {
	  // Function to right rotate the subarray between out-of-place
    // element and next opposite sign element
    static void rightRotate(int[] arr, int start, int end) {
        int temp = arr[end];
        for (int i = end; i > start; i--) {
            arr[i] = arr[i - 1];
        }
        arr[start] = temp;
    }

    // Function to rearrange the array
    static void rearrange(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            
            // Check if the current positive element is out of place
            if (arr[i] >= 0 && i % 2 == 1) {
                
                // Find the next negative element and rotate the subarray
                // between these two elements
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < 0) {
                        rightRotate(arr, i, j);
                        break;
                    }
                }
            }
            
            // Check if the current negative element is out of place
            else if (arr[i] < 0 && i % 2 == 0) {
                
                // Find the next positive element and rotate the subarray
                // between these two elements
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] >= 0) {
                        rightRotate(arr, i, j);
                        break;
                    }
                }
            }
        }
    }
	public static void main(String[] args) {
	       int[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
	        rearrange(arr);
	        for (int i = 0; i < arr.length; i++) {
	          //  System.out.print(arr[i] + " ");
	        }
			 Arrays.stream(arr).forEach(x->{
				 if(x > 1)
				 if(!IntStream.rangeClosed(2, x/2).anyMatch(i->x%i==0)) {
					// System.out.println("Prime number is "+x);
				 }
			 });
	    Arrays.stream(arr).filter(AlternateNumber::checkPrime).forEach(System.out::print);
	    List<String> strings = Arrays.asList("apple banana apple", "banana", "cherry","cherry");
        Stream<Object> toArray = strings.stream().flatMap(x->Arrays.stream(x.split(" ")));
        toArray.collect(Collectors.groupingBy(x->x.toString(),Collectors.counting()))
        		.entrySet().stream().forEach(x->System.out.println(x.getKey()+" "+x.getValue()));       
    }
	private static boolean checkPrime(int x) {
		boolean isPrime = true;
		if (x <= 1) {
            return false;  // Prime numbers are greater than 1
        }
		isPrime = !IntStream.range(2, x).anyMatch(i->x%i==0);
        return isPrime;
	//	return !IntStream.range(2, x).anyMatch(i->x%i==0);
	}
}
