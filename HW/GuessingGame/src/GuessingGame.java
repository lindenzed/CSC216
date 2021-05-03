import java.util.*;
/**
 *This program is a game where a random number from
 *1- <b><i>MAXIMUM_BOUNDARY</i></b> is generated and then prompts the user to guess the number.
 *The user is continually asked for guesses until the correct
 *number is chosen (the correct number is the sentinel). The program
 *handles errors for incorrect input (guess out of range/non integer).
 *If valid, but incorrect, guess is made
 *the program provides a hint (greater than answer or less than answer).
 *
 * @author Zach Giles
 *
 * @version 14Feb2020
 */
public class GuessingGame {
    /**
     * The Maximum boundary used for the guessing game.
     */
    public static final int MAXIMUM_BOUNDARY = 50;
    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Random rand = new Random();
        //creates a random game answer inclusive of the maximum boundary
        int answer = rand.nextInt(MAXIMUM_BOUNDARY + 1);
//        int answer = 5;
        while (answer == 0) {//if randomly assigns to 0 reassigns until != 0.
            answer = rand.nextInt(MAXIMUM_BOUNDARY + 1);
        }
        System.out.println("Welcome to the Guessing Game.");
        System.out.println("Try to guess the secret number between"
                + "1 and " + MAXIMUM_BOUNDARY + " (inclusive).");
        collectGuess(answer);//passes randomly generated answer into function
        System.out.print("\nYou win! you guessed the secret number: " + answer);
    }
    /**
     * The method collects guesses from the user until the correct answer is guessed.
     * If the user does not enter an integer a message is displayed to handle the
     * incorrect input. If the user enters an integer out of the boundary conditions
     * a message is displayed to handle the incorrect input. If the guess is greater
     * than the answer a message is displayed indicating so. If the guess is less than
     * the answer a message is displayed indicating so. The method exits when the
     * answer is correctly guessed.
     * @param secretNumber The answer/sentinel to the guessing game.
     */
    public static void collectGuess(int secretNumber) {
        Scanner console = new Scanner(System.in);
        int guess = 0;
        System.out.print("\nYour guess? ");
        while (!console.hasNextInt()) {
            console.next();
            System.out.print("Not an integer, guess again: ");
        }
        guess = console.nextInt();
        while (guess <= 0 || guess > MAXIMUM_BOUNDARY) {
            System.out.print("Out of range, guess again: ");
            while (!console.hasNextInt()) {
                console.next();
                System.out.print("Not an integer, guess again: ");
            }
            guess = console.nextInt();
        }
        while (guess != secretNumber) {
            if (guess < secretNumber) {
                System.out.println(guess + " is smaller than the secret number.");
            }
            else {
                System.out.println(guess + " is larger than the secret number.");
            }
            System.out.print("\nYour guess? ");
            while (!console.hasNextInt()) {
                console.next();
                System.out.print("Not an integer, guess again: ");
            }
            guess = console.nextInt();
            while (guess <= 0 || guess > MAXIMUM_BOUNDARY) {
                System.out.print("Out of range, guess again: ");
                while (!console.hasNextInt()) {
                    console.next();
                    System.out.print("Not an integer, guess again: ");
                }
                guess = console.nextInt();
            }
        }
    }
}
