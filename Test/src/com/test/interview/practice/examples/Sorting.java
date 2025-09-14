package com.test.interview.practice.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Sorting {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(1);
		list.add(8);
		
	//	Consumer<Integer> consumer = (t)->System.out.println(t);
	//	consumer.accept(3);
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		System.out.println();
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(1,50000,"Dasari"));
		employeeList.add(new Employee(2,10000,"Srinu"));
		employeeList.add(new Employee(3,90000,"Vaasu"));
		
/*		Collections.sort(employeeList, new CompareData(){

			@Override
			public int compare(Employee o1, Employee o2) {
				
				return (int) (o2.getSalary() - o1.getSalary());
			};
	     });*/
		
	///	Collections.sort(employeeList,(o1,o2)-> (int)(o2.getSalary() - o1.getSalary()));
	//	employeeList.stream().sorted((o1,o2)-> (int)(o1.getSalary() - o2.getSalary())).forEach(System.out::print);
		employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::print);
	//	System.out.println(employeeList);
		
		Map<Integer,String> map = new HashMap<>();
		map.put(2, "Hai");
		map.put(3, "Srinu");
		map.put(1, "Vaasu");
		map.put(6, "Dasari");
		map.put(9, "Boss");
		
		Map<Employee,Integer> employeeMap = new HashMap<>();
		
		employeeMap.put(new Employee(1,50000,"Dasari"),2);
		employeeMap.put(new Employee(2,10000,"Srinu"),4);
		employeeMap.put(new Employee(3,90000,"Vaasu"),1);
		
		map.entrySet().stream().sorted((Entry<Integer, String> o1, Entry<Integer, String> o2) -> o1.getValue().compareTo(o2.getValue())).forEach(System.out::println);
		System.out.println(employeeList);
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		System.out.println();
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByValue((Comparator.comparing(Integer::intValue)))).forEach(System.out::println);
 }
}
class CompareData implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return (int) (o2.getSalary() - o1.getSalary());
	}
	
}
