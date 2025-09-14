package com.test.interview.practice.examples;

import java.util.Arrays;
import java.util.List;

public class SupplierDemo //implements Supplier<String> 
{

	public static void main(String[] args) {
	//	System.out.println(new SupplierDemo().get());
		
	//	Supplier<String> supplier = ()->"Hi all";
	//	System.out.println(supplier.get());
		
		List<String> list = Arrays.asList();
		System.out.println(list.stream().findAny().orElseGet(()->"Hi all"));
	}

}
