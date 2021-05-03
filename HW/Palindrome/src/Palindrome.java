import java.util.*;

/**
 * Determines if a user entered String is a palindrome, which means the String
 * is the same forward and reverse. The determination is case-insensitive.
 * Spaces and punctuation must match for palindromes.
 * 
 * @author Dr. Sarah Heckman
 * @author Dr. Jessica Young Schmidt
 * @author Michelle Glatz
 * @author Zach Giles
 * 
 * @version 10FEB2020
 */
public class Palindrome {

    /**
     * Starts program.
     * 
     * @param args array of command line arguments (not used).
     */
    public static void main(String[] args) {
        printPalindrome("abba");// palindrome
        printPalindrome("racecar");// palindrome
        printPalindrome("Madam");// palindrome
        printPalindrome("!!!Hannah!!!");// palindrome
        printPalindrome("! ! ! Hannah ! ! !");// palindrome
        printPalindrome("Dot saw I was tod");// palindrome
        printPalindrome("Step on no pets");// palindrome
        printPalindrome("Step on no pets!"); // NOT
        printPalindrome("dog"); // NOT
        printPalindrome("Java"); // NOT
        printPalindrome("abca"); // NOT
        System.out.println("\n*****Read from User*****");
        readConsole();
    }

    /**
     * Reads user's console input and prints the results
     */
    public static void readConsole() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String text = in.nextLine();
        printPalindrome(text);
    }

    /**
     * Prints whether text is a palindrome
     * @param text String to check whether it is a palindrome
     */
    public static void printPalindrome(String text) {
        System.out.print("\nisPalindrome: \t");
        //create a String that is the reverse of text  
        String reverse = "";
        //Creates a reversed String.
        for (int i = 0; i < text.length(); i++) {
            reverse = text.charAt(i) + reverse;
        }
        // if text equals reversed text (remember to ignore case) then print:
        if (reverse.toLowerCase().equals(text.toLowerCase())) {
            System.out.println("\"" + text + "\" is a palindrome");
        }
        else {
        // otherwise print:
            System.out.println("\"" + text + "\" is NOT a palindrome");
        }
    }
}
