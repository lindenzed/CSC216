import java.util.*;
/**
 *This program prompts the user to enter three side lengths
 *of a triangle. An internal method is then called to determine
 *if the triangle is an equilateral, isosceles, or scalene. The results
 *is then printed to the screnn.
 *
 * @author Zach Giles
 *
 * @version 29Jan2020
 */
public class Triangle {

    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter three lengths of lines to determine if \n"
                + "a triagnel is formed, and if so what type: ");
        int sideA = console.nextInt();
        int sideB = console.nextInt();
        int sideC = console.nextInt();
        System.out.println(getTriangleType(sideA, sideB, sideC));
    }
    /**
     * Method that determines triangle type if valid side lengths are entered.
     * @param a one of three side lengths
     * @param b two of three side lengths
     * @param c three of three side lengths
     * @return triangle type if valid lengths, error if invalid
     */
    public static String getTriangleType(int a, int b, int c) {
        String triangleString = "";
        if (a >= b + c || b >= a + c || c >= a + b) {
            triangleString = "invalid";
        }
        else if (a == b || a == c || b == c) {
            if ( a == b && b == c) {
                triangleString = "equilateral";
            }
            else {
                triangleString = "isosceles";
            }
        }
        else {
            triangleString = "scalene";
        }
        return triangleString;
    }
}
