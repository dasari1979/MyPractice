package com.test.interview.design.patterns;

public class MergeSortStrategy implements SortingStrategy {

	@Override
	public void sort(int[] array) {
		System.out.println("Sorting using Merge Sort");
	}

}
