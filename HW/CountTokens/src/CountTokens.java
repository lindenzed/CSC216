import java.io.*;
import java.util.*;
/**
 *Creates a program that counts the tokens in the given file hamlet.txt.
 *
 * @author Zach Giles
 *
 * @version 23Feb2020
 */
public class CountTokens {

    /**
     * Starts the program.
     * @param args Command line arguments (not used)
     * @throws FileNotFoundException if File does not exist
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("hamlet.txt"));
        int counter = 0;
        while (input.hasNext()) {
            input.next();
            counter++;
        }
        System.out.print("There are " + counter + " tokens in the file hamlet.txt");
    }
}
