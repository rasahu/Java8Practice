package com.rake.tsys;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExtractIntApprearSameTime {
		public static void main(String[] args) {
		List<Integer> intList=Arrays.asList(1,2,2,6,3,3,3,4,5,6);	
		Set<Integer> intList1=intList.stream().filter(e->e==Collections.frequency(intList, e))
				                              .collect(Collectors.toSet());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println(intList1);
		
	}

}
