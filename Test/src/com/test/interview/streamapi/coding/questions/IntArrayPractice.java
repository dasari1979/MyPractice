package com.test.interview.streamapi.coding.questions;

import java.util.Arrays;
import java.util.Comparator;

public class IntArrayPractice {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 4, 3 };
		int start = 0;
		int end = arr.length - 1;
		while (arr[start] < arr[end]) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		int length = arr.length - 1;
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
		for (int i = 0; i < (arr.length - 1) / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[length];
			arr[length] = temp;
			length--;
		}
		System.out.println("");
		System.out.println("Using for loop: ");
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));

		int array[] = { 1, 2, 0, 4, 3, 0, 5, 0 };
		for (int j = 0; j < array.length - 1; j++) {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] == 0 && array[i + 1] != 0) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}
		Arrays.stream(array).forEach(x -> System.out.print(x + " "));
		System.out.println("");
		int n = 1234;
		int sum = 0;
		while (n > 0) {
			sum = caliculateDigits(n);
			if (sum > 9) {
				caliculateDigits(sum);
				n = sum;
			} else
				break;
		}
		System.out.println(sum);
		int arrSort[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
		Integer[] arrays = Arrays.stream(arrSort).boxed().toArray(Integer[]::new);
		Arrays.sort(arrays, Comparator.reverseOrder());
		for (int i = 0; i < arrSort.length - 1; i++) {
			if (arrSort[i] > arrSort[i + 1]) {
				int temp = arrSort[i];
				arrSort[i] = arrSort[i + 1];
				arrSort[i + 1] = temp;
			}
		}
		Arrays.stream(arrSort).forEach(x -> System.out.print(x + " "));
	}

	private static int caliculateDigits(int n) {
		int sum = 0;
		while (n > 0) {

			sum = sum + n % 10;
			System.out.print(sum + " ");
			n = n / 10;
		}
		return sum;
	}

}
