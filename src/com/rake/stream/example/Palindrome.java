package com.rake.stream.example;

import java.util.stream.IntStream;

/**This program uses the IntStream.range() method to generate a stream of integers from 0 to half the length of the string. 
 * The allMatch() method is then used to check if all of the characters in the string are equal to their corresponding characters
 * in the reverse of the string. If all of the characters are equal, 
 * then the string is a palindrome and the program returns true. Otherwise, the program returns false
 * 
 */
public class Palindrome {
    public static boolean isPalindrome(String str) {
        return IntStream.range(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));
    }

    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(isPalindrome(str)); // true

        str = "madam";
        System.out.println(isPalindrome(str)); // true

        str = "hello";
        System.out.println(isPalindrome(str)); // false
    }
}