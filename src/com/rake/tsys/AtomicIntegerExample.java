package com.rake.tsys;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    private static AtomicInteger count = new AtomicInteger();
	
	public static void main(String[] args) {
		List<Integer> intList=Arrays.asList(1,2,2,6,3,4,5,6);
	for (Integer i:intList) {
	
		System.out.println(count.addAndGet(2));
	}

	}

}
