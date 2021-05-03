/**
 *In class exercise from Lecture 4 where we write 3 for loops to print 3 sequences.
 *The printed statement must be based on the control variable value.
 *
 * @author Zach Giles
 *
 * @version 17Jan2020
 */
public class Sequences {

    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        for (int i = 0; i <= 5; i++) {
            System.out.print(i * 5 + " ");
        }
        
        System.out.println("\n");
        
        for (int j = 0; j <= 4; j++) {
            System.out.print(8 - (j * 4) + " ");
        }
        
        System.out.println("\n");
        
        for (int k = 7; k >= 1; k--) {
            System.out.print(k * k + " ");
        }
    }
}
