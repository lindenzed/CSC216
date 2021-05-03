/**
 *This program modifies the code given to us by Professor Glatz to include a class constant.
 *
 * @author Zach Giles
 *
 * @version 17Jan2020
 */
public class SlashFigure {
    
    /**
     * Creates a class constant to be used in the main method.
     */
    
    public static final int SIZE = 4;
    
    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("\\\\");
            }
            for (int j = 0; j < 2 * (SIZE - i) - 1; j++) {
                System.out.print("!!");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("//");
            }
            System.out.println();
        }
    }
}
