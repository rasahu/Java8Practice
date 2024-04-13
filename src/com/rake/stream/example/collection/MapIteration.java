package com.rake.stream.example.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapIteration {
public static void main(String[] args) {
	Map<String, Integer> map = new HashMap<>();
	map.put("Alice", 25);
	map.put("Bob", 30);
	map.put("Charlie", 35);
	Map<String, Integer> tempMap = new TreeMap<>();
	// Iterate over the map using the forEach() method
			
			
			//map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
			
			map.entrySet().stream().forEach(entry -> tempMap.put(entry.getKey(), entry.getValue()));
			
			tempMap.entrySet().forEach(entry->System.out.println(entry));

}
}
