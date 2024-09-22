package example1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example1 {

	public static void main(String[] args) {
		
		
		List<Integer> intList=Arrays.asList(1,2,3,4,5);
        intList.stream().map(e->e*e).collect(Collectors.toList()).forEach(System.out::println);
		
	}

}
