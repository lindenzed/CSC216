import java.util.*;//imports Scanner class
/** This program declares the cost of eggs from a henhouse, and then
 * ask the user to input how many eggs they would like to purchase.
 * The program then prints an order summary with a total cost
 * for the order.
 *
 * @author Zach Giles
 *
 * @version 23Jan2020
 */
public class Eggs {
    /**
     * Assigns the cost of a dozen of eggs in dollars and cents of a dollar.
     */
    public static final double DOZEN_COST = 3.25;
    /**
     * Assigns the cost of a single egg.in cents of a dollar.
     */
    public static final double LOOSIE_COST = 0.45;
    /**
     * Declares how many eggs are in a dozen.
     */
    public static final int EGGS_IN_DOZEN = 12;
    /**
     * Starts the program.
     * @param args (not used)
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);//Creates object from Scanner class
        System.out.println("Enter the number of eggs you would like to purchase.\n"
                + "One dozen eggs cost $" + DOZEN_COST + " and single loose egg "
                        + "cost $" + LOOSIE_COST + ".");
        /**
         * Assigns EGGS to user input.
         */
        int eggs = console.nextInt();
        /**
         * Declares int dozens and assigns it to the number of dozens that can be derived from 
         * the total amount of eggs being purchased.
         */
        int dozens = eggs / EGGS_IN_DOZEN;
        /**
         * Declares int loosies that is found from the remaining 
         * eggs from the initial amount that are not included in the dozens.
         */
        int loosies = eggs % EGGS_IN_DOZEN;
        /**
         * Declares the int 'loosieCentsDialoge' so that the
         *  integer value of the price in cents can be displayed
         * as an integer, not a double with a decimal.
         * Used for making sentences where the word "cents" is 
         * spelled out. 
         */
        int loosieCentsDialogue  = (int) (LOOSIE_COST * 100);
        /**
         * Declares the int 'orderSum' that calculates the total cost of the order
         */
        double orderSum = (dozens * DOZEN_COST) + ( loosies * LOOSIE_COST);
        /**
         * Prints the order summary with order cost formatted to two decimal places.
         */
        System.out.printf("You ordered " + eggs + " eggs. That's " + dozens + " dozen at $"
                + DOZEN_COST + " per dozen" + " and " + loosies + " loose eggs at " 
                + loosieCentsDialogue + " cents each for a total of $%.2f.", orderSum);
    }
}
