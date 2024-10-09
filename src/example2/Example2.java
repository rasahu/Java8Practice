package example2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import example1.EmployeeRecord;

/*
Given four integers sx,sy,tx,and ty,return

true if it is possible to convert the point(sx,sy)to the point(tx,ty)through some operations,or false otherwise.

The allowed operation on some point(x,y)is to convert it to either(x,x+y)or(x+y,y).*/

public class Example2 {

public static void main(String[] args) {
	List<EmployeeRecord> empList=Arrays.asList(new EmployeeRecord(3, "bhuv"),new EmployeeRecord(6, "stavik"),
			new EmployeeRecord(5, "rakesh"),new EmployeeRecord(1, "zebra"));
	
	empList.stream().sorted(Comparator.comparingInt(EmployeeRecord::getId).
			thenComparing(Comparator.comparing(EmployeeRecord::getFirstName))).toList().
	         forEach(System.out::println);;
}
}
