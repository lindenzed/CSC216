import java.util.*;
/**
 *Creates a program that prompts the user to enter three integers.
 *It then determines if the three integers are "all the same", 
 *"all different", or "neither" using a if/else if/else statement.
 *
 * @author Zach Giles
 *
 * @version 27Jan2020
 */
public class SameIntegers {

    /**
     * Starts the program
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter three integers separated by spaces: ");
        int x = console.nextInt();
        int y = console.nextInt();
        int z = console.nextInt();
        if (x == y && y == z) {//check for all equal
            System.out.println("all the same");
        }
        else if (x != y && x != z && y != z) {//check for all different
            System.out.println("all different");
        }
        else {//returns neither if not same and not different
            System.out.println("neither");
        }
    }
}