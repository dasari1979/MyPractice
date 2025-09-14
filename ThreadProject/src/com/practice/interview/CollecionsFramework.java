package com.practice.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class CollecionsFramework {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
		Vector<Integer> v = new Vector<Integer>();
		System.out.println(v);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(4);
		System.out.println(list);
        LinkedList<Integer> lList = new LinkedList<Integer>();
        lList.add(6);
        lList.add(7);
        lList.add(8);
        
        System.out.println(lList.stream().distinct().sorted().skip(lList.size()-2).findFirst());
        
        LinkedList<Integer> countSecondHighest= new LinkedList<Integer>();
        countSecondHighest.add(6000);
        countSecondHighest.add(12000);
        countSecondHighest.add(7222);
       // countSecondHighest.add(9000);
        countSecondHighest.add(8000);
        countSecondHighest.add(94000);
        System.out.println(countSecondHighest.stream().filter(x -> x>8000).count());
	}

}
