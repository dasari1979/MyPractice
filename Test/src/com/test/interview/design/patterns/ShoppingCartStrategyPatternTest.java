package com.test.interview.design.patterns;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class ShoppingCartStrategyPatternTest {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		ZonedDateTime zonedDateTime = ZonedDateTime.now();

/*		System.out.println("Date: " + date);
		System.out.println("Time: " + time);
		System.out.println("DateTime: " + dateTime);
		System.out.println("ZonedDateTime: " + zonedDateTime);*/
		
		callAmethod();
		
		ShoppingCart cart = new ShoppingCart();
		
		Item item1 = new Item("1234",10);
		Item item2 = new Item("5678",40);
		
		cart.addItem(item1);
		cart.addItem(item2);
		
		//pay by paypal
		cart.pay(new PaypalStrategy("myemail@example.com", "mypwd"));
		
		//pay by credit card
		cart.pay(new CreditCardStrategy("Pankaj Kumar", "1234567890123456", "786", "12/15"));

	}

	private static int callAmethod() {
		try { 
	           
            // open files
            System.out.println("Open files");
           
            // do some processing
            int a = 45;
            int b = 0;
            if (a > 0)
            	return a;
            // dividing by 0 to get an exception
            int div = a / b;
           
            System.out.println("After dividing a and b ans is " + div);
        }
 
        catch (ArithmeticException ae) {
            System.out.println("exception caught");
 
            // display exception details
            System.out.println(ae);
        }
 
        finally {
        //    System.out.println("Inside finally block");
 
            // close the files irrespective of any exception
            System.out.println("Close files");
        }
		return 0;
		
	}

}
