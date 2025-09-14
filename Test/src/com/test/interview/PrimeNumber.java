package com.test.interview;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PrimeNumber {

	public static void main(String[] args) {
		  System.out.println(IntStream.rangeClosed(2, 15 / 2).count() +" Is Prime No : " + isPrimeByJava8(15));
			 int a[] = {2,6,5,8,7,9,10,13,15};
			 Arrays.stream(a).forEach(x->{    
				 if(!IntStream.rangeClosed(2, x/2).anyMatch(i->x%i==0)) {
					 System.out.println("Prime number is "+x);
				 }
			 });
				System.out.println("Count:  "+Arrays.stream(a).filter(PrimeNumber::prime).count());
		 }
		 private static boolean isPrimeByJava8(int n) {
		  if (n == 0 || n == 1) {
		   return false;
		  }
		  if (n == 2) {
		   return true;
		  }
		  boolean isPrime = IntStream.rangeClosed(2, n / 2).noneMatch(x -> n % x == 0);
		  return isPrime;
		 }
		 private static boolean prime(int a) {
			 return !IntStream.rangeClosed(2, a/2).anyMatch(x -> a%x == 0);
		 }

}
