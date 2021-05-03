import java.util.*;
/**
 *Creates a program that accepts an integer greater than zero
 *and then prints the reciprocal sums from 1 to n.
 *
 * @author Zach Giles
 *
 * @version 27Jan2020
 */
public class SumPrinter {

    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter an integer greater than 0.");
        int n = console.nextInt();
        System.out.println("The reciprocal sum of your entered value is: " + fractionSum(n));

    }
    /**
     * Creates a fraction sum String.
     * @param n how many fraction sums are added together
     * @return fraction sum text
     */
    public static String fractionSum(int n) {
        String fractions = "1";//post
        for (int i = 2; i <= n; i++) {
            fractions = fractions + " + (1/" + i + ")";//wires and additional post
        }
        return fractions;
    }
}
