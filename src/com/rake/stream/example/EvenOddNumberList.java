package com.rake.stream.example;
import java.util.Arrays;
import java.util.List;
public class EvenOddNumberList {
	
	public static void main(String[] args) {
		
		List<Integer> intList=Arrays.asList(1, 2, 1 ,2, 1 ,2, 3, 3, 4 ,4 ,1 ,2 ,5 ,6);
		System.out.println("Even Number :: ");
		//print even number list with unique value
		intList.stream().filter(e->e%2==0).distinct().toList().forEach(System.out::println);
		System.out.println("Odd Number :: ");
		intList.stream().filter(e->e%2!=0).distinct().toList().forEach(System.out::println);
		
	}

}
