package com.rake.stream.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SumOfAllElemnent {
	public static void main(String[] args) {
		
		List<Integer> intList=Arrays.asList(1,2,3,4,5);
		
		//Sum of all
		Optional<Integer> sumOfAll=intList.stream().reduce((a,b)->a+b);
		System.out.println("Multiplication of All :: "+ sumOfAll.get());

		//multiplication of all
		Optional<Integer> muliplicationOfAll=intList.stream().reduce((a,b)->a*b);
		System.out.println("Multiplication of All :: "+ muliplicationOfAll.get());

		//multiplication of all
		Optional<Integer> averageOfAll=intList.stream().reduce((a,b)->(a+b)/2);
		System.out.println("averageOfAll of All :: "+ averageOfAll.get());
	}

}
