import java.util.*;
/**
 *Continuously prompts the user to enter integers until the a sentinel
 *value is entered.  At that point the average of the non-sentinel integers
 *is calculated and returned as a number.  Any negative integer is a
 *sentinel.
 *
 * @author Zach Giles
 *
 * @version 13Feb2020
 */
public class PrintAverage {

    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        userInterface();
    }
    /**
     * Collects user input of positive integers. Calculates and prints average of positive integers
     * inputed.  Negative values are sentinels. Error handling for non-integer
     * values. If no positive values are entered, no average is printed.
     */
    public static void userInterface() {
        Scanner console = new Scanner(System.in);
        int sum = 0;
        int number = 0;
        int counter = 0;
        System.out.print("Type an integer (negative number to quit): ");
        while (!console.hasNextInt()) {
            console.next();
            System.out.print("Not an integer, try again: ");
        }
        number = console.nextInt();
        while ( number > 0) {
            sum += number;
            counter ++;
            System.out.print("Type an integer (negative number to quit): ");
            while (!console.hasNextInt()) {
                console.next();
                System.out.print("Not an integer, try again: ");
            }
            number = console.nextInt();
        }
        if (counter > 0) {
            System.out.println("Average is " + (double) sum / counter);
        }
    }
}
