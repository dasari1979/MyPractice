package com.test.interview.streamapi.coding.questions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntArrayLogics {

	public static void main(String[] args) throws ClassNotFoundException {

		// Read input from STDIN; write output to STDOUT.

		// ['java', 'python']

		List<String> _list = Arrays.asList("java", "python");

		_list.stream().map(x -> {

			String abc = x.substring(0, 1).toUpperCase() + x.substring(1);
			return abc;
		}).forEach(x -> System.out.print(x + " "));
		;
		System.out.println("");

		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// 1st argument, init value = 0
		int sum = Arrays.stream(numbers).reduce(5, (a, b) -> a + b);

		System.out.println("sum : " + sum); // 55

		for (int i = 'B' - 'A'; i <= 'd'; i++) {
			// System.out.println((int)i);
		}

		int arr[] = { 1, 2, 3, -4, -1, 4 };
		// int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
		//
		// int newArry[] = new int[arr.length];
		int ct = 0;
		// Output: arr[] = {1, -4, 2, -1, 3, 4}
		// for(int i =0;i<arr.length-1;i++){
		// arr[j],arr[j+2],arr[],arr[j+4],arr[j+6]
		for (int j = 0; j < arr.length; j++) {

			if (arr[j] < 0 && j % 2 == 0) {
				for (int k = ct; k < arr.length; k++) {
					if (arr[k] > 0) {
						moveElement(arr, j, k);
						ct = k;
						break;
					}
				}
			} else if (arr[j] > 0 && j % 2 == 1) {
				for (int k = ct + 1; k < arr.length; k++) {
					if (arr[k] < 0) {
						moveElement(arr, j, k);
						ct = k;
						break;
					}
				}
			}
		}
		// }
		Arrays.stream(arr).forEach(System.out::print);
		int[] array = { 6, 4, 3, 7, 2, 1, 9 };

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1; j++) {

				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		Arrays.stream(array).forEach(System.out::print);

		// int arr[] = {3, 2, 2, 3};

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {

				if (arr[j] > arr[j + 1]) {

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println("");
		int seq = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] != seq) {
				System.out.println("Missing is " + seq);
			}
			if (arr[i] == arr[i + 1]) {
				if (arr[i] != 3)
					System.out.println("Removeing is " + arr[i]);
			}
			seq++;
		}

		int c = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		Arrays.stream(arr).forEach(System.out::print);
		// int array[] = {1, 2, 0, 4, 3, 0, 5, 0};

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {

				if (arr[j] == 0) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		Arrays.stream(arr).forEach(System.out::print);

		// int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		// int arr[] = {1, 2, 3, 4, 5, 6, 7, 8,9,10};

		// int ct = 3;
		int l = 0;
		sortThreeEle(l, arr, ct);

		Arrays.stream(arr).forEach(System.out::print);

		// int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] == 0) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		// System.out.println(arr);

		System.out.println("");
		// arr[] = {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1};
		temp = 0;
		ct = 0;
		int k = 0;
		boolean isCon = false;
		int sortedArr[] = new int[arr.length - 1];
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				isCon = true;
			}
			if (isCon) {
				// System.out.println(arr[i]+" Index true "+temp+" to "+i+" "+arr[i+1]);
				ct++;
			}
			if (!isCon) {
				// System.out.println("Consecutive from "+temp+" to "+ct +" = "+ (ct -temp));
				int sub = ct - temp;
				if (sub != -1)
					sortedArr[k] = sub;
				// System.out.println(sub);
				temp = i;
				k++;
			} else if (arr.length - 2 == i) {
				// System.out.println("Consecutive from "+temp+" to "+ct+" = "+ (ct -temp));
				int sub = ct - temp;
				if (sub != -1)
					sortedArr[k] = sub;
				k++;
			}
			isCon = false;
		}
		Arrays.sort(sortedArr);
		// System.out.println(sortedArr[sortedArr.length - 1]);

		int[] arrayToSort = { 6, 4, 3, 7, 2, 1, 9 };
		for (int i = 0; i < arrayToSort.length - 1; i++) {
			for (int j = 0; j < arrayToSort.length - 1; j++) {
				if (arrayToSort[j] > arrayToSort[j + 1]) {
					temp = arrayToSort[j];
					arrayToSort[j] = arrayToSort[j + 1];
					arrayToSort[j + 1] = temp;
				}
			}
		}
		System.out.println("highest No :" + arrayToSort[arrayToSort.length - 2]);

		// arr[] = {12, 35, 1, 10, 34, 3};
		for (int y = 0; y < arr.length - 1; y++) {
			for (int z = 0; z < arr.length - 1; z++) {
				if (arr[z] > arr[z + 1]) {
					// Swap arr[j] and arr[j+1]
					temp = arr[z];
					arr[z] = arr[z + 1];
					arr[z + 1] = temp;
				}
			}
		}
		int[] secondHighest = Arrays.stream(arr).sorted().toArray();

		System.out.println("sfdf " + secondHighest[secondHighest.length - 2]);

		int[] _secondHighest = new int[arr.length];
		int aa = 0;
		if (arr[aa] < arr[arr.length - 1]) {
			System.out.println(arr[arr.length - 2]);
		} else
			System.out.println(arr[1]);

		// int array[] = {4, 3, 6, 2, 1, 1};
		int dublicatearray[] = new int[array.length];
		for (int j = 0; j <= array.length; j++) {
			boolean isAvailabel = checkAvailability(array, j);

			if (!isAvailabel && j > 0)
				System.out.println(j);
			dublicatearray = checkdublicate(array, dublicatearray);
			// System.out.println(dublicatearray);
		}
		IntStream.rangeClosed('A', 'd').forEach(i -> {
			// System.out.println(i -'A');
		});
		List<Integer> list = Arrays.asList(1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 6, 6, 6, 7, 7, 8);
		Map<Integer, Integer> map = list.stream().collect(Collectors.toMap(x -> x, x -> x, (x, y) -> y));
		// System.out.println(map);
		// System.out.println("ASCII value 1 corresponds to: " +'Z');
		// char c = '9';
		// Convert a character to its numeric value
		int numericValue = Character.getNumericValue(c); // 9
		// System.out.println("Numeric value of '9': " + numericValue);
	}

	private static void moveElement(int[] arr, int j, int ct) {
		int temp = arr[ct];
		for (; j < ct; ct--) {
			arr[ct] = arr[ct - 1];
		}
		arr[ct] = temp;
	}

	private static void sortThreeEle(int a, int[] arr, int ct) {
		int k = ct;
		if (arr.length < ct)
			k = arr.length;
		int next = a;
		for (int j = a; j < k - 1; j++) {
			next = j;
			if (j < k) {
				for (int i = a; i < k - 1; i++) {
					if (i < k) {
						if (arr[i] < arr[i + 1]) {
							int temp = arr[i];
							arr[i] = arr[i + 1];
							arr[i + 1] = temp;
						}
					}
				}
			}
		}

		if (a == arr.length || arr.length - k == 0)
			System.exit(0);
		// k = k+1;
		// sortThreeEle(next+2,arr,k);
		if (arr.length - k == 2) {
			k = k + 2;
			sortThreeEle(next + 2, arr, k);
		} else if (k <= arr.length) {
			k = k + 3;
			sortThreeEle(next + 2, arr, k);
		}
		// return 0;
	}

	private static int[] removeElement(int[] arrayToSort, int sortedArray) {
		for (int i : arrayToSort) {
			// if(sortedArray == i)
		}
		return arrayToSort;
	}

	private static int[] checkdublicate(int[] array, int[] dublicatearray) {
		int i = 0;
		int _dublicatearray[] = new int[array.length];
		for (int a : array) {
			for (int j : dublicatearray) {
				dublicatearray[i] = a;
			}
			i++;
		}
		int ct = 1;
		int j = 0;
		for (int a : array) {
			ct = 1;
			for (int b : dublicatearray) {
				if (a == b) {
					// System.out.println(a+": "+ct);
					if (ct == 2) {
						_dublicatearray[j] = a;
						j++;
					}
					ct++;
				}
			}
		}

		return _dublicatearray;
	}

	private static boolean checkAvailability(int[] array, int j) {
		for (int i : array) {
			if (i == j)
				return true;
		}
		return false;
	}

}
