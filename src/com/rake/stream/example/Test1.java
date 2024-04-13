package com.rake.stream.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test1 {
public static void main(String[] args) {
		
		List<Integer> intList=Arrays.asList(1,2,3,1,1,2,2,1,3,2,1);
		
		
		int[] original = {1,2,3,1,1,2,2,1,3,2,1};
		int[] reordered = new int[original.length];
		int shift = 1;

		for(int i=0; i<original.length;i++)
		     reordered[i] = original[(shift+i)%original.length];
		System.out.println(reordered[1]);
	}

}
