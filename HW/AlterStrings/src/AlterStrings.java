import java.util.*; //imports Scanner class.
/**
 *Uses a object of the Scanner class to retrieve input from the terminal in the form
 *of a first and last name.  It then prints out the name in reverse (i.e. Last, First).
 *Full Javadoc, and required submit through Github.
 *
 * @author Zach Giles
 *
 * @version 21Jan2020
 */
public class AlterStrings {
    /**
     * Starts the program.
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        System.out.print("Please enter your first and last name: ");
        String firstName = console.next();
        String lastName = console.next();
        String reverseName = lastName + ", " + firstName;
        System.out.println("Your name in reverse order is " + reverseName + ".");
    }
}
