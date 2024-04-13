package com.rake.stream.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintNumberStartwith2 {
	
	public static void main(String[] args) {
		
		List<Integer> intList=Arrays.asList(21,12,33,24,25);
		
		List<Integer> stringList= intList.stream().map(e->String.valueOf(e)).
				filter(e->e.startsWith("2")).map(Integer::valueOf).toList();
		
		
		System.out.println(stringList);
	}

}
