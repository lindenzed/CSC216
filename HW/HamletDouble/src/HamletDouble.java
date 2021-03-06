import java.util.*;
import java.io.*;
/**
 *Takes the Hamlet.txt file from exercise 13 and makes it double spaced.
 *
 * @author Zach Giles
 *
 * @version 29Feb2020
 */
public class HamletDouble {

    /**
     * Starts the program.
     * @param args Command Line arguments (not used).
     */
    public static void main(String[] args) {
        doubleSpaceFile();
    }
    /**
     * Reads the file hamlet.txt line by line printing each line
     * to the file "HamletOutput.txt with a new line in between
     * each line.  Throws exception if either the read or write
     * files are not found.
     */
    public static void doubleSpaceFile() {
        Scanner readFile = null;
        PrintStream output = null;
        File hamlet = new File("hamlet.txt");
        File hamletDouble = new File("HamletOutput.txt");
        try {
            readFile = new Scanner(hamlet);
            output = new PrintStream(hamletDouble);
        }
        catch (FileNotFoundException e) {
            System.out.println("Error reading or writing to file! " + e);
            System.exit(1);
        }
        while (readFile.hasNextLine()) {
            if (readFile.hasNext()) {
                output.println(readFile.nextLine() + "\n");
            }
            else {
                readFile.nextLine();
                }
        }
        readFile.close();
        output.close();
    }
}