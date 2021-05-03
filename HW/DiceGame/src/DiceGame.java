import java.util.*;
/**
 *Prompts the user to enter a target sum.  Two "dice" which are really
 *random number generators with possibilities of 1-6 are rolled until
 *the sum of the two random number generators equal the target sum.
 *
 * @author Zach Giles
 *
 * @version 22Feb2020
 */
public class DiceGame {
    /**
     * Maximum sum for a double dice roll.
     */
    public static final int MAX_TWO_DICE_SUM = 12;
    /**
     * Minimum sum for a double dice roll.
     */
    public static final int MIN_TWO_DICE_SUM = 2;
    /**
     * Minimum face value of a single die.
     */
    public static final int MIN_DICE_FACE = 1;
    /**
     * Maximum face value of a single die.
     */
    public static final int MAX_DICE_FACE = 6;
    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        diceSum(console);
    }
    /**
     * Ensures the user enters an integer
     * @param console user input
     * @return user inputed integer
     */
    public static int getInt(Scanner console) {
        while(!console.hasNextInt()) {
            //ASSERT: User did not enter an integer.
            console.next();
            System.out.print("Invalid input, please enter an integer between 2 and 12: ");
        }
        //ASSERT: User entered an integer.
        return console.nextInt();
    }
/**
 * Ensures the inputed integer is within the proper range for the sum of two dice faces.
 * Once verified the desired sum inputed is passed into the diceRoll function.
 * @param console user input
 */
    public static void diceSum(Scanner console) {
        int desiredSum = 0;
        System.out.print("Desired Dice Sum: ");
        desiredSum = getInt(console);
        while (desiredSum > MAX_TWO_DICE_SUM || desiredSum < MIN_TWO_DICE_SUM) {
            //ASSERT: The integer the user entered is not > 2 or < 12
            System.out.print("Invalid input, please enter an integer between 2 and 12: ");
            desiredSum = getInt(console);
        }
        //ASSERT: User has entered an integer that is > 2 and < 12
        rollDice(desiredSum);
    }
    /**
     * Rolls two dice until the user inputed sum is acquired. Each roll is
     * printed on a new line, and the number or rolls needed to get to 
     * the desired sum is printed to the screen.
     * @param desiredSum the target sum for the double dice roll.
     */
    public static void rollDice(int desiredSum) {
        int sum;
        int counter = 0;
        do {
            Random rand = new Random();
            int roll1 = rand.nextInt(MAX_DICE_FACE) + MIN_DICE_FACE;
            int roll2 = rand.nextInt(MAX_DICE_FACE) + MIN_DICE_FACE;
            //Point A: roll1 and roll2 are < 7 and > 0 (ALWAYS)
            sum = roll1 + roll2;
            //Point B: sum is not equal to user inputed sum (SOMETIMES)
            System.out.println(roll1 + " and " + roll2 + " = " + sum);
            counter++;
            //Point C: counter is > 1 (ALWAYS)
        } while (sum != desiredSum);
       //Point D sum is equal to user inputed sum.
        System.out.print("It took " + counter + " tries to get your desired sum");
    }
}
