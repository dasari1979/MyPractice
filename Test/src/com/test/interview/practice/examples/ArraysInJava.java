package com.test.interview.practice.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArraysInJava {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
        Vector<String> v = new Vector<>();
        v.add("hai");
        System.out.println(System.currentTimeMillis());
		System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().holdsLock(v));
        v.add("hello");
        System.out.println(System.currentTimeMillis());
        System.out.println(Thread.currentThread().holdsLock(v));
        System.out.println(v);
        List<String> list = new ArrayList<>();
        list.add("hai");
        System.out.println(System.currentTimeMillis());
        list.add("hello");
        System.out.println(System.currentTimeMillis());
        
        System.out.println(list);

		int dublicates[] = new int[10];
		int array[] = {5,6,8,3,5,6};
		int _array[] = new int[array.length];
		int i = 0;
		for(int ele : array) {
			
			boolean isdublicate = checkDublicate(ele,_array,i);
			if(!isdublicate)
			_array[i] = ele;
			if(isdublicate) {
				dublicates[i] = ele;
			}
			i++;
		}
        for(int ele : dublicates) {
        	if(ele != 0)
        	System.out.println(ele);
        }
	}

	private static boolean checkDublicate(int ele, int[] _array,int i) {
		boolean isAvailable = false;
		for(int _ele : _array) {
			if(ele == _ele) {
				isAvailable = true;
				break;
			}
		}		
		return isAvailable;
	}

}
