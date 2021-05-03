import java.util.*;
/**
 *This program pompts the user to enter an integer and then
 *determines if all of the digits in the integer are odd. The program
 *then prints a message to the screen letting the user know 
 *whether all of the digits are odd or not.
 *
 * @author Zach Giles
 *
 * @version 14Feb2020
 */
public class AllDigitsOdd {
    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        int userNumber = console.nextInt();
        if (userNumber == 0 || allDigitsOdd(userNumber) == false) {
            System.out.print("\n All digits in (" + userNumber + ") are NOT odd");
        }
        else {
            System.out.print("\n All digits in (" + userNumber + ") are odd");
        }
    }
    /**
     * Test to see whether all digits in a given number are odd.
     * @param number Number in which digits are checked.
     * @return Whether or not all digits are odd.
     */
    public static boolean allDigitsOdd(int number) {
        boolean result = false;
        int digit = number % 10;
        while (digit % 2 != 0) {
            number = number / 10;
            digit = number % 10;
        }
        if (number == 0) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }
}
