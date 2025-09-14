package com.test.interview.design.patterns;

public class StreategyPatternClient {

	public static void main(String[] arg) {
		
		StrategySortingContext sortingContext = new StrategySortingContext(new BubbleSortStrategy());
		int[] array1 = {5, 2, 9, 1, 5};
        sortingContext.performSort(array1); // Output: Sorting using Bubble Sort
        
     // Change strategy to MergeSortStrategy
        sortingContext.setSortingStrategy(new MergeSortStrategy());
        int[] array2 = {8, 3, 7, 4, 2};
        sortingContext.performSort(array2); // Output: Sorting using Merge Sort
        
        // Change strategy to QuickSortStrategy
        sortingContext.setSortingStrategy(new QuickSortStrategy());
        int[] array3 = {8, 3, 7, 4, 2};
        sortingContext.performSort(array3); // Output: Sorting using Quick Sort
	}
}
