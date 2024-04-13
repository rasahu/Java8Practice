package com.rake.stream.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Syn {
public static void main(String[] args) {
	String s="rakeshra";
	
	char[] ch = new char[s.length()];
	
	List<char[]> a=Arrays.asList(ch);
	
	Optional<char[]> b=a.stream().filter(e->Collections.frequency(a,e)>1).findFirst();
	
	System.out.println(b);
}
}
