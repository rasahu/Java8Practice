package com.rake.stream.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrintDuplicate {
	public static void main(String[] args) {
		List<Integer> intList=Arrays.asList(1,2,2,6,3,4,5,6);
		
		List<String> stringList=Arrays.asList("ram","shyam","ghar","home","hello");
		Set<Integer> listMoreTimeOccureElement =intList.stream().
				filter(e->Collections.frequency(intList, e)>1).collect(Collectors.toSet());
		
		System.out.println(intList.stream().max(Comparator.comparing(Integer::valueOf)).get());
		System.out.println(stringList.stream().max(Comparator.comparing(String::valueOf)).get());
		//System.out.println(listMoreTimeOccureElement);
	}

}
