import java.io.*;
import java.util.*;
/**
 *This program gets a file name from a user, and then scans the file line
 *by line counting tokens. For each line the total tokens are displayed,
 *and the length of the longest token is noted.
 *
 * @author Zach Giles
 *
 * @version 28Feb2020
 */
public class LineProcessing {

    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        userInterface();
    }
    /**
     * Gets input from user for data file name, scans the file, 
     * and then processes the file.
     */
    public static void userInterface() {
        Scanner console = new Scanner(System.in);
        Scanner fileScanner = getInputScanner(console);
        processFile(fileScanner);
        fileScanner.close();
        
    }
    /**
     * Gets the input file name. Remprompts until a valid file name is entered.
     * @param console User input for a file name.
     * @return An input scanner with the user inputed file.
     */
    public static Scanner getInputScanner(Scanner console) {
        Scanner fileScanner = null;
        while (fileScanner == null) {
            System.out.print("Input file name: ");
            String name = console.next();
            try {
                fileScanner = new Scanner(new File(name));
            }
            catch (FileNotFoundException e) {
                System.out.println("File: " + name + " not found. Please try again");
            }
        }
        return fileScanner;
    }
    /**
     * Counts the tokens in each line, and then outputs the total tokens
     * in each line, with a note for the length of the longest token.
     * @param fileScanner The input scanner that will be processed.
     */
    public static void processFile(Scanner fileScanner) {
        int countLine = 0;
        while (fileScanner.hasNextLine()) {
            int countToken = 0;
            int longestToken = 0;
            countLine++;
            String line = fileScanner.nextLine();
            Scanner stringScanner = new Scanner(line);
            while (stringScanner.hasNext()) {
                countToken++;
                String presentToken = stringScanner.next();
                if (presentToken.length() > longestToken) {
                    longestToken = presentToken.length();
                }
            }
            stringScanner.close();
            System.out.println("Line " + countLine + " has " + countToken
                    + " tokens (longest = " + longestToken + ")");
        }
    }
}
