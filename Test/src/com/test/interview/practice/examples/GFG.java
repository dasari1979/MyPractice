package com.test.interview.practice.examples;

import java.util.PriorityQueue;

public class GFG {

	public static void main(String[] args) {
        PriorityQueue<Person> queue
        = new PriorityQueue<>(new AgeComparator());

    // Create some Person objects
    Person person1 = new Person("Sushmita", 25);
    Person person2 = new Person("Alekya", 30);
    Person person3 = new Person("Geetha", 20);

    // Add Person objects to the PriorityQueue
    queue.offer(person1);
    queue.offer(person2);
    queue.offer(person3);

    // Poll elements from the PriorityQueue and print
    // their details
    while (!queue.isEmpty()) 
    {
        Person person = queue.poll();
        System.out.println("Name: " + person.getName()
                           + ", Age: "
                           + person.getAge());
    }
	}

}
