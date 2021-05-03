import java.util.*;
/**
 *The program prints a radom number from 0-1000 until
 *a number above 900 is printed.
 *
 * @author Zach Giles
 *
 * @version 21Feb2020
 */
public class PrintRandom {
    /**
     * Defines the maximum number for the random number generator.
     */
    public static final int MAXIMUM_NUMBER = 1000;
    /**
     * Defines the minimum number for the random number generator.
     */
    public static final int MINIMUM_NUMBER = 900;
    /**
     * Starts the program..
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNumber;
        do {
            int random = rand.nextInt(MAXIMUM_NUMBER + 1);
            randomNumber = random;
            System.out.println("Random number: " + randomNumber);
        } while (randomNumber <= MINIMUM_NUMBER);
    }
}
