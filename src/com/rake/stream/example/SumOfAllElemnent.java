package com.rake.stream.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SumOfAllElemnent {
	public static void main(String[] args) {
		
		List<Integer> intList=Arrays.asList(1,2,3,4);
		
		Optional<Integer> as=intList.stream().reduce((a,b)->a+b);
		
		System.out.println(as.get());
	}

}
