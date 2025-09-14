package com.test.interview.design.patterns;

public class AdapterPatternTest {

	public static void main(String[] args) {
		
		SocketAdapter sockAdapter = new SocketClassAdapterImpl();
		
		Volt v3 = sockAdapter.get3Volt();
		Volt v12 = sockAdapter.get12Volt();
		Volt v120 = sockAdapter.get120Volt();
		System.out.println("Converting to 3 Volts: "+v3.getVolts());
		System.out.println("Converting to 12 Volts: "+v12.getVolts());
		System.out.println("Converting to 120 Volts: "+v120.getVolts());
	}

}
