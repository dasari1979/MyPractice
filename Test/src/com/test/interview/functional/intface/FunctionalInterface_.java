package com.test.interview.functional.intface;
import java.lang.FunctionalInterface;


@FunctionalInterface
public interface FunctionalInterface_ //extends FunInterface
{
abstract int mul();
default void xyz() {	
}
static void abc() {
	
}
}

interface i1{
	int add();	
}

interface i2 extends i1
{
int add();	
}

class IntImpl implements FunctionalInterface_{

	@Override
	public int mul() {
		// TODO Auto-generated method stub
		return 5;
	}
}

class MainClass{
	
	public static void main(String s[]) {
		IntImpl intImpl = new IntImpl();
		intImpl.mul();
	}
}
@FunctionalInterface
interface InterfaceA {
    void methodA();
}
@FunctionalInterface
interface InterfaceB {
    void methodB();
}
@FunctionalInterface
interface CombinedInterface //extends InterfaceA//, InterfaceB 
{
    void combinedMethod();
}