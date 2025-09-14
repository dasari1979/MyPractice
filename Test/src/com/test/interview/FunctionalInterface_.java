package com.test.interview;

@FunctionalInterface
interface TestFunctionalInterface{
	
	public void test(String str,int i);
}

public class FunctionalInterface_ implements ExampleOfFunctionInterface{

	public static void main(String[] args) {
		TestFunctionalInterface d = (a,i) ->{
        System.out.println("Hello....");
		};
		d.test("hai",5);
	}

	@Override
	public void firstMethod() {
		System.out.println("Functional Interface...");
		
	}

}
@FunctionalInterface
interface ExampleOfFunctionInterface 
{
   public void firstMethod();
   default void secondMethod() 
   {
       System.out.println("It is a default method");
   }
}