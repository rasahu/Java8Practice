package com.rake.stream.example;

import java.util.Arrays;
import java.util.List;

public class AverageOfAllElement {
	public static void main(String[] args) {
		List<Integer> intList=Arrays.asList(1,2,3,4);
		
		Double averageValue= intList.stream().mapToInt(a->a).average().getAsDouble();
		System.out.println("average value is : " +averageValue);

	}

}
