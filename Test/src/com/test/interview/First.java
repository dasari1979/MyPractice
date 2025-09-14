package com.test.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class First {
	public static boolean isPrime(int number){
	    return !IntStream.rangeClosed(2, number/2).anyMatch(i -> number%i == 0);
	}
	public static int ctr = 0;
    public First() { ctr++; }
	public static void main(String[] args) {
		int c = 0;
		for(c=0;c<5;++c) {
			System.out.println();
			System.out.println(c);
		}
		System.out.println(c);
		
		int min1 = Arrays.stream(new int[]{})
				  .min()
				  .orElse(0);
		System.out.println("Minimum Value: "+min1);
		Employee e1 = new Employee(1,"dd",680);
		Employee e2 = new Employee(2,"ff",777);
		Map<Employee,Integer> empExe = new HashMap<>();
		empExe.put(e1 , 4);
		empExe.put(e2 , 5);
		System.out.println(empExe);
	    Set set = new TreeSet();
	    set.add(null);
	    set.add("abc");
	    
	    System.out.println(set);
		List<Object> _list = new ArrayList<Object>();
		_list.add(1);
		_list.add("Test");
		_list.add(6);
		
		First obj1 = new First();
		First obj2 = new First();
		First obj3 = new First();
        System.out.println("Number of objects created are "
                           + First.ctr);
        
		int a[] = {1,2,5,1,6,4,9,3,7};
		List<Integer> exists = new ArrayList<>();
		int n = 10;
		int primeArry[] =new int[n];
		for (int i = 1; i < n; i++) {
			primeArry[i] = i; 
			exists.add(i);
		}
		System.out.println(Arrays.stream(primeArry).filter(First::isPrime).sum());
		int _primeArry[] =new int[n];
		int j = 0;
		Arrays.stream(primeArry).forEach(x->{
			
			boolean primeNumber = !IntStream.rangeClosed(2, x/2).anyMatch(i->x%i == 0);

			if(primeNumber) {
				_primeArry[x] = x;
				System.out.println("Sum of Prime numbers "+ x);
			}
		});
		for (int i = 1; i < n; i++) {
		System.out.println("Prime numbers "+ _primeArry[i]);
		}
		System.out.println(Arrays.stream(_primeArry).reduce(0, Integer::sum));
	//	System.out.println(exists.stream().filter(First::isPrime).mapToInt(Integer::intValue).sum());//filter(First::isPrime);
		

		String str = "abcd%$efg*";
		
		List<String> list = Arrays.asList(str);
		//System.out.println("Hai: "+list);
		// create a REGEX String
        String REGEX = "[a-zA-Z]";
        Pattern p = Pattern.compile(REGEX);

            list.stream().forEach(line -> {
            	Matcher m=p.matcher(str);
            	String resultStr = "";
            	 while (m.find()) {
            		 resultStr = resultStr.concat(m.group());
            		 System.out.println();
            	 }
            	 Stream.of(resultStr)
                 .map(word->new StringBuilder(word).reverse())
                 .collect(Collectors.joining(" "));
            });
        List<Employee> emp = new ArrayList<>();                         
        emp.add(new Employee(1,"xx",56));
        emp.add(new Employee(2,"abc",57));
        emp.add(new Employee(3,"ff",56));
        
        Map<Integer, Employee> result  = emp.stream().collect(Collectors.toMap(Employee::getId,Employee->Employee));
 
        // create the string
        // in which you want to search
        String actualString = "code of Machine";
 
        // create pattern
        Pattern pattern1 = Pattern.compile(REGEX);
 
        // find the regular expression of pattern
        Matcher matcher1 = pattern1.matcher(str);
 
        while (matcher1.find()) {
//            System.out.println("Match 1: "
//                               + matcher1.group());
        }
		System.out.println(exists);

	      for (int i:a)
	      {
	    	  for (int k:a)
		      {
		        int sum = i+k;
		        if(sum == 6 && !exists.contains(i) && !exists.contains(k) && i!=k) {
		        	exists.add(i);
		        	exists.add(k);
		      //  System.out.println("{"+i+","+k+"}");
		        }
		      }
	      }
	      exists.stream().forEach(x->{
	    	  exists.stream().forEach(y->{
	    		  if(x+y == 6 && x<y) {
	    			  System.out.println("{"+x+","+y+"}");
	    		  }
	    		  }
	    	  );
	      });
	    	 
	      String s[] = {"java","hi","hi"};
	     System.out.println(Arrays.stream(s).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
	     
 }
}
class Employee{
	
	public Employee(int empId, String name, int salary) {
		id = empId;
		this.name = name;
		this.salary = salary;
	}
	private int id;
	private String name;
	private int salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}