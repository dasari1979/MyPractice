package com.test.interview;

class Parent{   
	  
	  // defining the method   
	  void msg() throws Exception {  
	    System.out.println("parent method");  
	    }    
	}    
	    
	public class TestExceptionChild extends Parent{    
	  
	  // overriding the method in child class  
	  // gives compile time error  
	  void msg() throws ArithmeticException {    
	    System.out.println("TestExceptionChild");    
	  }  
	  
	  public static void main(String args[]) {    
	   Parent p = new TestExceptionChild();    
	   try {
		p.msg();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}    
	  }    
	}
