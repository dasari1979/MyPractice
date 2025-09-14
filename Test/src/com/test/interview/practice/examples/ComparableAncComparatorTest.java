package com.test.interview.practice.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComparableAncComparatorTest {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, 50000, "Dasari"));
		employeeList.add(new Employee(2, 10000, "Vaasu"));
		employeeList.add(new Employee(3, 90000, "Srinu"));
		employeeList.add(new Employee(3, 90000, "Abc"));

		Collections.sort(employeeList);
		// System.out.println(employeeList);

		List<Customer> customerList = new ArrayList<>();
		customerList.add(new Customer(5, "hai", "hai"));
		customerList.add(new Customer(8, "ccc", "ccc"));
		customerList.add(new Customer(7, "xxx", "xxx"));
		customerList.add(new Customer(3, "bb", "bbbb"));
		
/*		Comparator<Customer> sorting = (o1, o2) ->{
			return o1.getId() - o2.getId();
		};*/
		Comparator<Customer> com = new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				return o1.getId() - o2.getId();
			}

		};
		
	       Collections.sort(customerList,new Comparator<Customer>(){

			@Override
			public int compare(Customer o1, Customer o2) {
				// TODO Auto-generated method stub
				return o1.getId() - o1.getId();
			}

	       });

		Collections.sort(customerList, com);
		System.out.println(customerList);
		
		Collections.sort(employeeList, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		System.out.println(employeeList);
		
		Collections.sort(customerList, (o1, o2) -> o1.getId() - o2.getId());
		System.out.println(customerList);
		
		
		Collections.sort(employeeList,(obj1,obj2)-> obj1.getName().compareTo(obj2.getName()));
        List<String> names = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(x->x.getValue() > 1).forEach(x->System.out.println(x+" "));
	}

}
