/**
 This program turns pseudocode and a class constant to print an assigned pattern.
 *
 * @author Zach Giles
 *
 * @version 17Jan2020
 */
public class Pattern {
    
    /**
     * Creates a class constant to be used in the main method.
     */
    
    public static final int LINES = 5;
    
    /**
     * Starts the program.
     * @param Command line arguments (not used).
     */
    public static void main(String[] args) {
        for (int i = 1; i <= LINES; i++) {
            for (int j = LINES - i; j >= 1; j--) {
                System.out.print(".");
            }
            System.out.print(i);
            for (int k = i - 1; k >0; k--) {
                System.out.print(".");
            }
            System.out.println();
        }
    }
}
