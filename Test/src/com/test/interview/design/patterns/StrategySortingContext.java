package com.test.interview.design.patterns;

public class StrategySortingContext {
	
	private SortingStrategy sortingStrategy;
	public StrategySortingContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }
    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }
    public void performSort(int[] array) {
        sortingStrategy.sort(array);
    }
}
