package com.test.interview;

import java.util.LinkedHashMap;
import java.util.Map;

public class Java8Features {

	
	public void m1() {
		
		System.out.println("m1......");
	}
	
/*	(){
		
	}*/
	
	public static void main(String[] args) {
		
		
		Map<String,String> map = new LinkedHashMap<>();
		map.put("srinu", "vasu");
		map.put("dasari", "sri");
		
	    String value =	map.entrySet().stream().filter(x->x.getKey().equalsIgnoreCase("srinu")).findAny().get().getValue();
		
	    System.out.println(value);
	    
		//Capee --> aCeep

        String str = "Capee";
        
        String s[] = str.split("");

        System.out.println(s[1]+s[0]+s[3]+s[4]+s[2]);
	}

}

interface MyfunctionalInterface{
	
	void m1();
	void m5();
	
	default void m2()
	{
		System.out.println("Default method m2");
	}
	default void m3()
	{
		System.out.println("Default method m3");
	}
	
	static void m4()
	{
		System.out.println("Default method m4");
	}
}