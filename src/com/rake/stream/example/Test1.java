package com.rake.stream.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Test1 extends Thread {
    /*
     * public static void main(String[] args) {
     *
     * List<Integer> intList=Arrays.asList(1,2,3,1,1,2,2,1,3,2,1);
     *
     *
     * int[] original = {1,2,3,1,1,2,2,1,3,2,1}; int[] reordered = new
     * int[original.length]; int shift = 1;
     *
     * for(int i=0; i<original.length;i++) reordered[i] =
     * original[(shift+i)%original.length]; System.out.println(reordered[1]); }
     */

    public static boolean isPalindrome(String args) {

        return IntStream.range(0, args.length()).allMatch(i -> args.charAt(i) == args.charAt(args.length() - i + 1));

    }

    public static void main(String[] args) {
        
        
    }
}
