import java.util.*;
/**
 *Prompts the user to enter a password, and then validates that password
 *with the guidelines of at least two digits, at least two uppercase letters,
 *and at least two lowercase letter.
 *
 * @author Zach Giles
 *
 * @version 07Feb2020
 */
public class ValidatePassword {
    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter your password, which must contain at least two \n"
                + "uppercase letters, at least two lowercase letters, and at least two digits: ");
        String userPW = console.next();
        System.out.println(validatePW(userPW));
    }
    /**
     * Validates the password by running test on every character of user input.
     * @param userPW password entered by user.
     * @return whether the password passes validation or fails validation
     */
    public static String validatePW(String userPW) {
        int digitCount = 0;
        int upperCount = 0;
        int lowerCount = 0;
        String pass = "Your password (" + userPW + ") is valid.";
        String failGeneral = "Your password (" + userPW + ") is invalid because:\n";
        String failDigits = "- fewer than two digits\n";
        String failUpper = "- fewer than two uppercase letters\n";
        String failLower = "- fewer than two lowercase letters\n";
        String failConcat;
        for (int i = 0; i < userPW.length(); i++) {
            char userChar = userPW.charAt(i);
            if (Character.isDigit(userChar)) {
                digitCount++;
            }
            if (Character.isUpperCase(userChar)) {
                upperCount++;
            }
            if (Character.isLowerCase(userChar)) {
                lowerCount++;
            }
        }
        if (digitCount < 2 || upperCount < 2 || lowerCount < 2) {
            failConcat = failGeneral;
            if(digitCount < 2) {
                failConcat = failConcat + failDigits;
            }
            if (upperCount < 2) {
                failConcat = failConcat + failUpper;
            }
            if (lowerCount < 2) {
                failConcat = failConcat + failLower;
            }
            return failConcat;
        }
        else {
            return pass;
        }
    }
}
