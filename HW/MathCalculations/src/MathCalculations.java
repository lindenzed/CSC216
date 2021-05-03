/**
 *This Class has two methods that find the "max" and "min" values of three numbers
 *that are entered as parameters to each method.  The "min" method accepts three
 *integers, and the "max" method accepts three doubles.  It then outputs the "min" 
 *and "max" of the entered values that are specified in the program.  The "min" method
 *has an int return value and the "max" method has a double return value.
 *
 * @author Zach Giles
 *
 * @version 20Jan2020
 */
public class MathCalculations {

    /**
     * Starts the program.
     * @param args Command Line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("The minimum of " + 5 + ", " + 7 + ", and " + 3 
            + " is " + findMin(5,7,3) + ".");
        System.out.println("The maxiumum of " + -5.1 + ", " + 32.5 + ", and " 
            + 56.8 + " is " + findMax(-5.1,32.5,56.8) + ".");
        System.out.println("The maxiumum of " + 20 + ", " + 25 + ", and " 
            + 15 + " is " + findMax(20,25,15) + ".");
    }
    
    /**
     * Finds the minimum value in a set of three parameters.
     * @param x first number to compare.
     * @param y second number to compare.
     * @param z third number to compare.
     * @return The smallest value of the parameters.
     */
    public static int findMin(int x, int y, int z) {
        int minResult = Math.min(Math.min(x,y),z);
        return minResult;
    }
    
    /**
     * Finds the maximum value in a set of three parameters.
     * @param x first number to compare.
     * @param y second number to compare.
     * @param z third number to compare.
     * @return The largest value of the parameters.
     */
    public static double findMax(double x, double y, double z) {
        double maxResult = Math.max(Math.max(x, y), z);
        return maxResult;
    }
}

