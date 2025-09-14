package com.test.photon.interview;

import java.util.Arrays;
import java.util.OptionalInt;

public class ArrayClass {

	public static void main(String[] args) {

		int arr[] = { 3, 4, 10, 7, 8, 1 };

		OptionalInt second = Arrays.stream(arr).sorted().skip(arr.length - 2).findFirst();

		System.out.println(second.getAsInt());

	}

}
