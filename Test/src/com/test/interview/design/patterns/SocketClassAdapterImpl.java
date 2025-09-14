package com.test.interview.design.patterns;

public class SocketClassAdapterImpl extends Socket implements SocketAdapter {

	@Override
	public Volt get120Volt() {
		return getVolts();
	}

	@Override
	public Volt get12Volt() {
		Volt v = getVolts();
		return convertToVolt(v, 10);
	}

	@Override
	public Volt get3Volt() {
		Volt v = getVolts();
		return convertToVolt(v, 40);
	}

	private Volt convertToVolt(Volt v, int volt) {
		return new Volt(v.getVolts() / volt);
	}
}
