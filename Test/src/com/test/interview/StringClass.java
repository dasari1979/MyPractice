package com.test.interview;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StringClass {

	public static void main(String[] args) {
		String s1 = "Dasari";
		String s2 = "Srinivas";
        String joinString = String.join(s1,"Shireesha", s2);
        
        System.out.println(joinString);
        StringJoiner joiner = new StringJoiner(",");
        joiner.add("Hai");
        joiner.add("World");
        
       // System.out.println(joiner.toString());
        List<String> liststr = Arrays.asList("abc", "pqr", "xyz"); //List of String array  
        String str = liststr.stream().collect(Collectors.joining("::"));
        System.out.println(str);
        
        String s="hello";    
        System.out.println(s.substring(0,4)); //returns he  as a substring
        
        String ss1=new String("hello");    
        String ss2="hello";  
        String ss3 = ss1.intern();
        System.out.println(ss2);//Sachin    
        
        System.out.println(ss1 == ss2);
        System.out.println(ss3 == ss2);
        System.out.println(ss3 == ss1);
        
        
        String strArray[] = {"abc","pqrs","sql"};
        
        List<String> list = Arrays.asList(strArray);
      //  list.stream().collect(Collector.)
	}

}
