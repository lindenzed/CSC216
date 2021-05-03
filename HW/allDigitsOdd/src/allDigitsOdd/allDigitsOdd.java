package allDigitsOdd;

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
        System.out.print(allDigitsOdd(13572));
    }
    public static boolean allDigitsOdd(int number) {
        boolean result = false;
        number = 0;
        int digit = number % 10;
        while (digit != 0 && digit % 2 != 0) {
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
