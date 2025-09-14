package com.test.interview.streamapi.coding.questions;

import java.util.Arrays;
import java.util.List;

public class Second {

	public void sum(int a1, int b1) {
		a1 = a1 + 10;
		b1 = b1 + 10;

		System.out.println(a1 + " " + b1);
	}

	public void sum(Integer a, Integer b) {

		a = a + 10;
		b = b + 10;
		System.out.println(a + " " + b);
	}

	public static void main(String[] args) {

		new Second().sum(2, 3);
		new Second().sum(5, 6);
		int target = -2;
		int arr[] = { 0, -1, 2, -3, 1 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] != arr[j] && arr[i] > arr[j]) {
					int newTarget = arr[i] + arr[j];
					if (newTarget == target)
						System.out.println("Pair (" + arr[i] + "," + arr[j] + ")");
				}
			}
		}
		List<Integer> list = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		list.stream().sorted((a, b) -> a.compareTo(b)).forEach(x -> System.out.print(x + " "));
		Integer value = list.stream().sorted((a, b) -> b.compareTo(a)).skip(1).findFirst().get();
		System.out.println("");
		System.out.println(value);
	}

}
