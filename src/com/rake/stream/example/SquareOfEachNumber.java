package com.rake.stream.example;

import java.util.Arrays;
import java.util.List;

/**
 * Below operation done on stream
 * 1)square root of all element
 * 
 * 2)filter all list which element is greater than 10
 * 
 * 3)Average out the square root value greater than 10
 */
public class SquareOfEachNumber {
	public static void main(String[] args) {
		List<Integer> intList=Arrays.asList(1,2,3,4,5);
		
       Double doubleAverage=intList.stream().map(a->a*a).filter(e-> e>10).mapToInt(e->e).average().getAsDouble();
       
    System.out.println("doubleAverage "+doubleAverage);
		
		
	}
	


}
