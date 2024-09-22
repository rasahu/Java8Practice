package com.rake.stream.example.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MapIteration {
public static void main(String[] args) {
	Map<String, Integer> map = new HashMap<>();
	map.put("Alice", 25);
	map.put("Bob", 30);
	map.put("Charlie", 35);
	Map<String, Integer> tempMap = new TreeMap<>();
	// Iterate over the map using the forEach() method
			
			
			//map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
			
			/*
			 * map.entrySet().stream().forEach(entry -> tempMap.put(entry.getKey(),
			 * entry.getValue()));
			 * 
			 * tempMap.entrySet().forEach(entry->System.out.println(entry));
			 */
			
			Map<String, Integer> map1=	map.entrySet().stream().filter(entryset-> entryset.getKey().startsWith("A")).
			collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));
			
			map1.entrySet().forEach(entyy->System.out.println(entyy));
}
}
