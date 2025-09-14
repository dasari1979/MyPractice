package com.test.interview;

import java.util.Arrays;

public class ArrayClass {

	public static void main(String[] args) {
		int [] arr={1,1,2,2,3,4,0,0,0,-1,-2,-2};
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1;j++){
			   if(arr[j] > arr[j+1]){	   
			       int temp = arr[j];
		           	arr[j] = arr[j+1];
		            arr[j+1] = temp;			
			    }
			}
		}
		Arrays.stream(arr).forEach(x->System.out.print(x+" "));
	}

}
