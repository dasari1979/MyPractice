package com.practice.interview;

public class Generics {

	public static void main(String[] args) {
		Container<String> obj = new Container<String>();
		obj.value = "Hello";
		obj.show();
		obj.setValue("Dasari");
		obj.getValue();
	}

}

class Container<T>
{
T value;

public T getValue() {
	System.out.println("get "+value);
	return value;
}

public void setValue(T value) {
	this.value = value;
}

public void show()
{
	System.out.println("Value "+value);
}

}