package com.test.interview.streamapi.coding.questions;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Test;

public class CounterTest {

	public static Counter counter;

	@BeforeClass
	public static void beforeClass() {
		counter = new Counter();
	}

	public static void test() {

	}

	@Test
	public void testGetItemNameSuccess() throws Exception {

		CounterTest test = null;
		test.test();
		String expectedName = "computer";
		Method method = Counter.class.getDeclaredMethod("getItemName", String.class);
		method.setAccessible(true);
		String actualName = (String) method.invoke(counter, "computer");
		assertEquals(expectedName, actualName);
	}
}
