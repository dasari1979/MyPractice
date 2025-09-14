package com.test.interview.practice.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapFunction {

	public static void main(String[] args) {

		List<Customer> customerData = new ArrayList<>();
		/*customerData.add(new Customer(1, "Dasari", "dasari@gmail.com", Arrays.asList("5555555", "9999999")));
		customerData.add(new Customer(3, "SS", "ss@gmail.com", Arrays.asList("675433", "689766")));
		customerData.add(new Customer(5, "Vaasu", "vaasu@gmail.com", Arrays.asList("2345133", "045783")));
		customerData.add(new Customer(2, "Srinu", "srinu@gmail.com", Arrays.asList("567890", "0000000")));
		customerData.add(new Customer(7, "cnu", "cnu@gmail.com", Arrays.asList("0000000", "000000")));

		List<String> mails = customerData.stream().map(customer -> customer.getEmail()).sorted()
				.collect(Collectors.toList());
		System.out.println(mails);
		List<List<String>> phoneNumbersList = customerData.stream().map(customer->customer.getPhoneNumbers()).collect(Collectors.toList());
		System.out.println(phoneNumbersList);
		List<String> phoneNumbers = customerData.stream().flatMap(customer->customer.getPhoneNumbers().stream()).collect(Collectors.toList());
		System.out.println(phoneNumbers);*/
		
		List<Integer> sumList = Arrays.asList(1,2,6,8);
		
		Integer sum = sumList.stream().reduce(1,(a,b)->a+b);
		System.out.println(sum);
		
		Integer max = sumList.stream().reduce(Integer::max).get();
		System.out.println(max);
	}
	

}
