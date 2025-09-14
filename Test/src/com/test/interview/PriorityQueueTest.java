package com.test.interview;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Integer> numbers = new PriorityQueue<>();
        
		numbers.add(4);
        numbers.add(2);
        numbers.add(6);
        numbers.add(1);
        System.out.println("PriorityQueue: " + numbers.poll());
        numbers.stream().map(x->x.toString()).forEach(x->System.out.print(x+" "));
/*      PriorityQueue<String> tasks=new PriorityQueue<>(Comparator.reverseOrder());
      tasks.add("task1");
      tasks.add("task4");
      tasks.add("task5");
      tasks.add("task3");
      tasks.add("task2");
      System.out.println("*****************************************");
      tasks.stream().map(x->x.toString()).forEach(x->System.out.print(x+" "));*/
	}

}
