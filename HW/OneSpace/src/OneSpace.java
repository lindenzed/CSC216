import java.util.*;
import java.io.*;
/**
 *Prompts user for the name of an input file, and then an output file.
 *Scans the input file line by line, and then prints each token on each line
 *to a new line in the output file with one space in between tokens.
 *
 * @author Zach Giles
 *
 * @version 01Mar2020
 */
public class OneSpace {

    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        userInterface();
    }
    /**
     * Gets the input file name, output file name, and then creates the
     * desired output file by scanning the input file.
     */
    public static void userInterface() {
        Scanner console = new Scanner(System.in);
        Scanner userInputFile = getInput(console);
        PrintStream userOutputFile = getOutput(console);
        collapseSpaces(userInputFile, userOutputFile);
        userInputFile.close();
        userOutputFile.close();
    }
    /**
     * Gets the name of the input file. Closes program if file not found.
     * @param console User input for input file name.
     * @return input file
     */
    public static Scanner getInput(Scanner console) {
        Scanner userInputFile = null;
        while (userInputFile == null) {
            System.out.print("Enter the input file you want to read: ");
            try {
                userInputFile = new Scanner(new File(console.next()));
            }
            catch (FileNotFoundException e) {
                System.out.print("File not found! Exiting program! ");
                System.exit(1);
            }
        }
        return userInputFile;
        }
    /**
     * Gets the output file name. Closes program if unable to write to file.
     * @param console User input for the output file name.
     * @return output file
     */
    public static PrintStream getOutput(Scanner console) {
        PrintStream userOutputFile = null;
        while (userOutputFile == null) {
            System.out.print("Enter the filename of for the output: ");
            try {
                userOutputFile = new PrintStream(new File(console.next()));
            }
            catch (FileNotFoundException e) {
                System.out.print("File not avaialbe to be written to! Exiting program!");
                System.exit(1);
            }
        }
        return userOutputFile;
    }
    /**
     * Scans the input file line by line, and then prints each token on each line to a line
     * in the output file.
     * @param userInputFile input file name
     * @param userOutputFile output file name
     */
    public static void collapseSpaces(Scanner userInputFile, PrintStream userOutputFile) {
        while (userInputFile.hasNextLine()) {
            String line = userInputFile.nextLine();
            Scanner lineScanner = new Scanner(line);
            while (lineScanner.hasNext()) {
                userOutputFile.print(lineScanner.next() + " ");
            }
            lineScanner.close();
            userOutputFile.println();
        }
    }
}
