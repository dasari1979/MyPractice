package com.test.interview;


interface interface1{
	int m1();
}
interface interface2{
	int m1();
}

public class CheckInterface implements interface1,interface2{

	public static void main(String[] args) {
/*		interface1 one = new CheckInterface ();
		interface1 two = new CheckInterface ();
		one.m1();
		two.m1();*/
	}

	@Override
	public int m1() {
		System.out.println("Hello...");
		return 0;
	}

}
