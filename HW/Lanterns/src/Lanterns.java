/**
 *This is the "Lanterns" project where static methods are used to eliminate
 *redundancy and keep the main method clean and concise.
 *
 * @author Zach Giles
 *
 * @version 10Jan2020
 */
public class Lanterns {

    /**
     * Starts the program and creates the three lanterns with empty lines
     * between the lanterns.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        lantern_1();
        System.out.println();
        lantern_2();
        System.out.println();
        lantern_3();

    }
    /**
     * Creates a centered line of 5 stars for use in lantern creation.
     */
    
    public static void stars_5() {
        System.out.println("    *****    ");
    }
    
    /**
     * Creates a centered line of 9 stars for use in lantern creation.
     */
    
    public static void stars_9() {
        System.out.println("  *********  ");
    }
    
    /**
     * Creates a centered line of 13 stars for use in lantern creation.
     */
    
    public static void stars_13() {
        System.out.println("*************");
    }
    
    /**
     * Creates a centered image of "fire" for use in lantern creation.
     */
    
    public static void fire() {
        System.out.println("* | | | | | *");
    }
    
    /**
     * Creates the first lantern using the stars methods.
     */
    
    public static void lantern_1() {
        stars_5();
        stars_9();
        stars_13();
    }
    
    /**
     * Creates the second lantern using the stars_13, fire, and lantern_1 methods.
     */
    
    public static void lantern_2() {
        lantern_1();
        fire();
        stars_13();
        lantern_1();
    }
    
    /**
     * Creates the third lantern using the stars_5, fire, and lantern_1 methods.
     */
    
    public static void lantern_3() {
        lantern_1();
        stars_5();
        fire();
        fire();
        stars_5();
        stars_5();
    }
}
