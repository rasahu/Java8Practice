package com.rake.stream.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxAndMin {
public static void main(String[] args) {
	List<Integer> intList=Arrays.asList(1,2,3,4,44);
	
	//first way
	Integer a=  intList.stream().mapToInt(e->e).max().getAsInt();
	System.out.println(a);
	//second way
	
	Integer b=   intList.stream().max(Comparator.comparing(Integer::valueOf)).get();
	
	
	System.out.println(b);
	
	Integer min=   intList.stream().min(Comparator.comparing(Integer::valueOf)).get();
	
	System.out.println(min);
}
}
