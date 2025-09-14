package com.test.interview;



interface Caliculator{
	
	//void switchon();
	//void sum(int a,int b);
	int subtract(int x,int y);
}


public class Caliculaterimpl{

/*	@Override
	public void switchon() {
		System.out.println();
		
	}*/
public static void main(String s[]) {
	
	/*Caliculator cal = () ->	System.out.println("Hello Functional Interface..");
	cal.switchon();*/
	
	/*Caliculator sum = (a,b) ->		System.out.println("Sum..."+(a+b));
	sum.sum(2, 3);*/
	
	/*Caliculator sub  = (x,y) -> x-y;
	System.out.println(sub.subtract(5, 2));*/
	
	Caliculator sub  = (x,y) -> {
		if(x<y) {
			throw new RuntimeException("Message.....");
		}else {
		return x - y;
		}
	
	};
	System.out.println(sub.subtract(6, 2));
}
}
