package com.test.interview.practice.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo // implements Consumer<Integer>
{

	public static void main(String[] args) {

		Consumer<Integer> consumer = (t) -> System.out.println("Intger " + t);

		consumer.accept(10);

		List<Integer> list = Arrays.asList(1, 2, 3);
		list.stream().forEach(t -> System.out.println(t));

	}

}
