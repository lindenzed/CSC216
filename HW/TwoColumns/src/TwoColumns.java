import java.util.*;
import java.io.*;
/**
 *Reads a text file containing two columns of floats and then 
 *outputs the average of each column.
 *
 * @author Zach Giles
 *
 * @version 28Feb2020
 */
public class TwoColumns {

    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        userInterface();
}
    /**
     * Gets user input for file name, and then processes the file
     * to find the average of the two float columns.
     */
    public static void userInterface() {
        Scanner console = new Scanner(System.in);
        Scanner fileScanner = getUserInput(console);
        processFile(fileScanner);
        fileScanner.close();
    }
    /**
     * Gets the input file from user input.  Re-prompts if file not found.
     * @param console User input for file name.
     * @return Scanner object of user input.
     */
    public static Scanner getUserInput(Scanner console) {
        Scanner fileScanner = null;
        while (fileScanner == null) {
            System.out.print("Input file name: ");
            try {
                fileScanner = new Scanner(new File(console.next()));
            }
            catch (FileNotFoundException e) {
                System.out.print("File not found. ");
            }
        }
        return fileScanner;
    }
    /**
     * Processes the file to find column averages.
     * @param fileScanner File that is processed.
     */
    public static void processFile(Scanner fileScanner) {
        double columnOne = 0.0;
        double columnTwo = 0.0;
        int count = 0;
        while (fileScanner.hasNextDouble()) {
            columnOne += fileScanner.nextDouble();
            columnTwo += fileScanner.nextDouble();
            count++;
        }
        System.out.print(columnOne/count + "\t" + columnTwo/count);
    }
}
