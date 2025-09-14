package com.test.interview.design.patterns;

public class Singleton {
private static Singleton singlton;

private Singleton() {}

public Singleton getInstance() {
	
	if(singlton == null) {
		singlton = new Singleton();
	}
	
	return singlton;
}

}
