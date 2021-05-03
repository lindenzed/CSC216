import java.util.*;
/**
 *Prompts the user for how many times they want to play the
 *game, and then plays the game that many times. The game
 *is a coin toss where the coin is continually tossed until either
 *three heads, or three tails are flipped in a row.
 *
 * @author Zach Giles
 *
 * @version 21Feb2020
 */
public class HeadsTails {

    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int numberOfGames = 0;
        Scanner console = new Scanner(System.in);
        System.out.print("How many games would you like to play? ");
        while(!console.hasNextInt()) {
            console.next();
            System.out.print("Invalid input, please enter an integer: ");
        }
        numberOfGames = console.nextInt();
        for (int i = 0; i < numberOfGames; i++) {
            System.out.println();
            threeHeads();
        }
    }
    /**
     * Flips a coin until three heads in a row are flipped.
     */
    public static void threeHeads() {
        int flipCounter = 0;
        int headsCount = 0;
        Random rand = new Random();
        do {
            int flip = rand.nextInt(2);
            flipCounter++;
            if (flip == 0) {
                System.out.print("H ");
                headsCount++;
                flip = rand.nextInt(2);
                flipCounter++;
                if (flip == 0) {
                    System.out.print("H ");
                    headsCount++;
                    flip = rand.nextInt(2);
                    flipCounter++;
                    if (flip == 0) {
                        System.out.print("H \n");
                        headsCount++;
                    }
                    else {
                        System.out.print("T ");
                        headsCount = 0;
                    }
                }
                else {
                    System.out.print("T ");
                    headsCount = 0;
                }
            }
            else {
                System.out.print("T ");
                headsCount = 0;
            }
        } while (headsCount < 3);
        System.out.println("Three heads in a row after " + flipCounter + " flips!");
        headsCount = 0;
        flipCounter = 0;
    }
}

