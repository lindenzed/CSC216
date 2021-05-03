
/**
 *INSERT PROJECT DESCRIPTION
 *
 * @author Zach Giles
 *
 * @version 22Jan2020
 */
public class Oops3 {
    public static  final double BUBBLE = 867.5309;

    /**
     * @param args
     */
    public static void main(String[] args) {
        double x = 10.01;
        int z = 5;
        printer(x,BUBBLE/108.4413625);
        printer(x,BUBBLE);
        System.out.println("The value from main is: " + BUBBLE);
        System.out.println("z = " + z);

    }

    public static void printer(double x, double y) {
        System.out.println("x = " + x + " and y = " + y);
    }
}
