/**
 *This class creates a program that includes a method that takes an
 *integer parameter, that is assumed to be greater than or equal to 1.  It then prints numbers
 *from 1 to that integer on a single line with each number surrounded
 *by square brackets.
 *
 * @author Zach Giles
 *
 * @version 20Jan2020
 */
public class NumberWriter {

    /**
     * Starts the program.
     * @param args Command Line arguments (not used).
     */
    public static void main(String[] args) {
        int testCaseFifteen = 15;
        int testCaseFive = 5;
        printNumbers(testCaseFifteen);
        printNumbers(testCaseFive);
    }
    
    /**
     * Creates a method with a for loop that counts up to the number inputed into
     * the method.  It prints the numbers surround by brackets before counting
     * up to the next number.
     * @param x The number that you would like the method to count up to from 1.
     */
    public static void printNumbers(int x) {
        for (int count = 1 ; count <= x; count++) {
            System.out.print("[" + count + "] ");
        }//count
        System.out.println();
    }
}