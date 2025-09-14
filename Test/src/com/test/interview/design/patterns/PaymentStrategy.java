package com.test.interview.design.patterns;

import java.util.ArrayList;
import java.util.List;

public interface PaymentStrategy {
   public void pay(int amount);
}
class CreditCardStrategy implements PaymentStrategy{

	private String name;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CreditCardStrategy [name=" + name + ", cardNumber=" + cardNumber + ", cvv=" + cvv + ", dateOfExpiry="
				+ dateOfExpiry + "]";
	}

	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;
	
	/**
	 * @param name
	 * @param cardNumber
	 * @param cvv
	 * @param dateOfExpiry
	 */
	public CreditCardStrategy(String name, String cardNumber, String cvv, String dateOfExpiry) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.dateOfExpiry = dateOfExpiry;
	}

	@Override
	public void pay(int amount) {
		System.out.println("Payment using CreditCardStrategy");		
	}
	
}
class PaypalStrategy implements PaymentStrategy {
	private String emailId;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaypalStrategy [emailId=" + emailId + ", password=" + password + "]";
	}
	private String password;
	/**
	 * @param emailId
	 * @param password
	 */
	public PaypalStrategy(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}
	@Override
	public void pay(int amount) {
		System.out.println("Payment using PayalStrategy");
		
	}
	
}
class Item {
	private String upcCode;
	private int price;
	/**
	 * @param upcCode
	 * @param price
	 */
	public Item(String upcCode, int price) {
		super();
		this.upcCode = upcCode;
		this.price = price;
	}
	public String getUpcCode() {
		return upcCode;
	}

	public int getPrice() {
		return price;
	}
}
class ShoppingCart {
	//List of items
		List<Item> items;
		
		public ShoppingCart(){
			this.items=new ArrayList<Item>();
		}
		public void addItem(Item item){
			this.items.add(item);
		}
		
		public void removeItem(Item item){
			this.items.remove(item);
		}
		public int calculateTotal(){
			return items.stream().map(Item::getPrice).reduce(Integer::sum).get();
		}
		
		public void pay(PaymentStrategy paymentMethod){
			int amount = calculateTotal();
			System.out.println(amount);
			paymentMethod.pay(amount);
		}
}