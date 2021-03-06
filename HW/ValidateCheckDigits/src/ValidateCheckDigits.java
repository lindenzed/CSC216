import java.util.*;
import java.io.*;
/**
 *Prompts user for a text file containing six digit account numbers.
 *Validates account numbers using the algorithem of the remainder when
 *divided by ten of the sum of the first five account numbers must be
 *the sixth number in the account. Prints the valid numbers to a PrintStream
 *output file that is "VALID_TEXT_FILE_NAME_ENTERED_BY_USER". Prints 
 *a message to the console stating whether or not each account is valid or not.
 *
 * @author Zach Giles
 *
 * @version 01Mar2020
 */
public class ValidateCheckDigits {
    /**
     * First five digits used in account validation.
     */
    public static final int ACCOUNT_FIRST_FIVE_DIGITS = 5;
    /**
     * Magnitude divider used to find single digits in account numbers.
     */
    public static final int MAGNITUDE_DIVIDER = 10;

    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        userInterface();
    }
    /**
     * Creates console scanner for user interface the Scanner,
     * and PrintStream used in validation.
     */
    public static void userInterface() {
        Scanner console = new Scanner(System.in);
        File fileName = null;
        Scanner fileScanner = null;
        while (fileScanner == null) {
            try {
                fileName = getUserInput(console);
                fileScanner = new Scanner(fileName);
            }
            catch (FileNotFoundException e) {
                System.out.print("File not found! ");
            }
        }
        processFile(fileName, fileScanner, console);
        fileScanner.close();
    }
    /**
     * Pulls possible accounts from user.
     * @param console User inputed text file.
     * @return Scanner object with user inputed file of possible accounts.
     */
    public static File getUserInput(Scanner console) {
        System.out.print("Enter file with possible account numbers: ");
        File fileName = new File(console.next());
        return fileName;
    }
    /**
     * Checks to see if output file exits, and creates output file. Validates
     * the account numbers in the input file and prints valid accounts to
     * the output file. Prints validation status of each account to console.
     * @param fileName Name of input file.
     * @param fileScanner Input file scanner object.
     * @param console User input for file overwrite if output file already exists.
     */
    public static void processFile(File fileName, Scanner fileScanner, Scanner console) {
        String validFiles = "VALID_" + fileName.getName();
        File valid = new File(validFiles);
        PrintStream output = null;
        try {
            if (!valid.exists()) {
                output = new PrintStream(valid);
            }
            else {
                System.out.print("File already exists!  Do you want to overwrite? ");
                String reply = console.next();
                if (reply.equals("y") || reply.equals("Y")) {
                    output = new PrintStream(valid);
                }
                else {
                    System.exit(1);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.print("Can't write to file! Check Read Only?");
            System.exit(1);
        }
        while (fileScanner.hasNextInt()) {
            int counter = 1;
            int sum = 0;
            int account = fileScanner.nextInt();
            while (counter <= ACCOUNT_FIRST_FIVE_DIGITS) {
                sum += account / Math.pow(MAGNITUDE_DIVIDER, counter);
                counter++;
            }
            if (sum % 10 == account % 10) {
                System.out.println(account + " is valid.");
                output.println(account);
            }
            else {
                System.out.println(account + " is NOT valid.");
            }
        }
        output.close();
    }

}
