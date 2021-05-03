import java.util.*;
import java.io.*;
/**
 *Reads a weather file from user input, processes the data line
 *by line, and the outputs the processed information into a PrintStream
 *object that is a text file.
 *
 * @author Zach Giles
 *
 * @version 29Feb2020
 */
public class WeatherReporter {
    /**
    * Defines the month beginning index for reformatting of date.
    */
    public static final int MONTH_BEGIN_INDEX = 4;
    /**
    * Defines the month ending index for reformatting of date.
    */
    public static final int MONTH_END_INDEX = 6;
    /**
    * Defines the day ending index for reformatting of date.
    */
    public static final int DAY_BEGIN_INDEX = MONTH_END_INDEX;
    /**
     * Defines the year ending index for reformatting of date.
     */
    public static final int YEAR_END_INDEX = MONTH_BEGIN_INDEX;
    /**
     * Starts the program
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        userInterface();
    }
    /**
     * Prompts the user for a file name to process.
     * Process the file line by line and reformats output
     * before saving it to a text file.
     */
    public static void userInterface() {
        Scanner console = new Scanner(System.in);
        Scanner fileScanner = getUserInput(console);
        processFile(fileScanner);
        fileScanner.close();
    }
    /**
     * Gets the input file from user input.
     * @param console user input for file to be processed
     * @return Scanner object with user inputed file
     */
    public static Scanner getUserInput(Scanner console) {
        Scanner fileScanner = null;
        while (fileScanner == null) {
            System.out.print("Enter file name: ");
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
     * Processes the file line by line.
     * @param fileScanner Scanner object containing user inputed file
     */
    public static void processFile(Scanner fileScanner) {
        PrintStream output = null;
        try {
            output = new PrintStream(new File("WeatherReporterOutput.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.print("Error writing to file!");
            System.exit(1);
        }
        fileScanner.nextLine();
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            processLine(line,output);
        }
    }
    /**
     * Processes each line with new formatting and indexing.
     * @param line each line of the user inputed file
     * @param output PrintStream object that stores newly formatted/indexed data
     */
    public static void processLine(String line, PrintStream output) {
        Scanner lineScanner = new Scanner(line);
        String date = lineScanner.next();
        String rain = "no";
        String snow = "no";
        lineScanner.next();
        double high = lineScanner.nextDouble();
        double low = lineScanner.nextDouble();
        String precip = lineScanner.next();
        if (precip.charAt(1) == '1') {
            rain = "yes";
        }
        if (precip.charAt(2) == '1') {
            snow = "yes";
        }
        output.printf(date.substring(MONTH_BEGIN_INDEX, MONTH_END_INDEX)
                + "/" + date.substring(DAY_BEGIN_INDEX) + "/" + date.substring(0,YEAR_END_INDEX)
                + " Low: %.1f High: %.1f Rain: " + rain + " Snow: " + snow, low, high);
        output.println();
        lineScanner.close();
    }
}
