/**
 * Methods in class calculate area for various shapes.
 * 
 * @author Zach Giles
 * @version 20JAN2020
 */
public class MyAreaCalculations {

    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println(triangleArea(8, 5.2, 7.1));// EXPECTED OUTPUT:
                                                      // 18.151176098258745
        System.out.println(triangleArea(3.0, 4.0, 5));// EXPECTED OUTPUT: 6.0
        System.out.println(cylinderSurfaceArea(3.0, 4.5)); // EXPECTED OUTPUT:
                                                           // 141.3716694115407
        System.out.println(cylinderSurfaceArea(5, 5)); // EXPECTED OUTPUT:
                                                       // 314.1592653589793
    }

    /**
     * Returns the area of a triangle with given side lengths
     * 
     * @param sideA   first side of triangle
     * @param sideB   second side of triangle
     * @param sideC   third side of triangle
     * @return        area of a triangle with the given sides
     */
    public static double triangleArea(double sideA, double sideB, double sideC) {
        double s = (sideA + sideB + sideC)/2;
        double area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        return area;
    }

    /**
     * Returns the surface area of a cylinder with the given radius and height
     * 
     * @param radius   radius of cylinder
     * @param height   height of cylinder
     * @return         surface area of cylinder with radius and height
     */
    public static double cylinderSurfaceArea(double radius, double height) {
        final double PI_TIMES_TWO = 2 * Math.PI;
        double surfaceArea = PI_TIMES_TWO * (Math.pow(radius, 2)+radius * height);
        return surfaceArea;
    }
}
