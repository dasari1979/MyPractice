package com.test.interview.functional.intface;

@FunctionalInterface
public interface FunctionalIntExample {
	
	void add();
    default void sub() {
	}
}

class FunctionalIntExampleImpl implements FunctionalIntExample{

	@Override
	public void add() {
		System.out.println("Hai Userdefined Functional Interface...");		
	}
}