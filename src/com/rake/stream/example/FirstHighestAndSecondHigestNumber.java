package com.rake.stream.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FirstHighestAndSecondHigestNumber {

	public static void main(String[] args) {
		List<Integer> intList=Arrays.asList(51,21,13,49,5,76575,342,12,689,689);
		List<Integer> intList1= intList.stream().distinct().sorted(Comparator.reverseOrder()).toList()
				.subList(0,2);
		intList1.forEach(t->System.out.println(t));	
	}

}
