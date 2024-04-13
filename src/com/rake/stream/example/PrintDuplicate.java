package com.rake.stream.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrintDuplicate {
	public static void main(String[] args) {
		List<Integer> intList=Arrays.asList(1,2,2,6,3,4,5,6);
		Set<Integer> listMoreTimeOccureElement =intList.stream().filter(e->Collections.frequency(intList, e)>1).collect(Collectors.toSet());
		
		
		System.out.println(listMoreTimeOccureElement);
	}

}
