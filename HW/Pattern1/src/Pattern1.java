import java.util.*;
import java.awt.*;
/**
 *INSERT PROJECT DESCRIPTION
 *
 * @author Zach Giles
 *
 * @version 12Feb2020
 */
public class Pattern1 {
    /**
     * Sets the width (and height) of the square and circles.
     */
    public static final int WIDTH = 50;
    /**
     * Creates a variable to be used for finding a inversed color.
     */
    public static final int COLOR_NEGATION = 255;
    /**
     * Sets the minimum row/column boundary.
     */
    public static final int MIN_RC = 1;
    /**
     * Sets the maximum row/column boundary.
     */
    public static final int MAX_RC = 10;
    /**
     * Sets the minimum RGB color boundary.
     */
    public static final int MIN_RGB = 0;
    /**
     * Sets the maximum RGB color boundary.
     */
    //kept different from COLOR_NEGATION in case you want to constrain
    //user color selection
    public static final int MAX_RGB = 255;

    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int rows = getRows();
        int columns = getColumns();
        int red = getRed();
        int green = getGreen();
        int blue = getBlue();
//        DrawingPanel panel = new DrawingPanel(500, 500);
        DrawingPanel panel = new DrawingPanel(columns * WIDTH, rows * WIDTH);
        Graphics g = panel.getGraphics();
        Color color = new Color(red, green, blue);
        Color invertedColor = new Color((COLOR_NEGATION - red), (COLOR_NEGATION - green),
                (COLOR_NEGATION - blue));
        for (int i = 0; i < rows * WIDTH; i = i + WIDTH) {
            for (int j = 0; j < columns * WIDTH; j = j + WIDTH) {
                drawSquare(g, j, i, WIDTH, color);
                drawCircle(g, j, i, WIDTH, invertedColor);
            }//j
        }//i
        System.out.println("\n*CLOSE the Drawing Panel to exit the program*");
    }
    /**
     * Helper method used to request user input for number of rows.
     * Constrains value if necessary.
     * @return Number of rows.
     */
    public static int getRows() {
        Scanner console = new Scanner(System.in);
        System.out.print("Number of rows (1-10): ");
        int rows = console.nextInt();
        rows = Math.max(rows, MIN_RC);
        rows = Math.min(rows, MAX_RC);
        return rows;
    }
    /**
     * Helper method used to request user input for number of columns.
     * Constrains value if necessary.
     * @return Number of columns.
     */
    public static int getColumns() {
        Scanner console = new Scanner(System.in);
        System.out.print("Number of columns (1-10): ");
        int columns = console.nextInt();
        columns = Math.max(columns, MIN_RC);
        columns = Math.min(columns, MAX_RC);
        return columns;
    }
    /**
     * Helper method used to request user input for red color value.
     * Constrains value if necessary.
     * @return Red RGB value.
     */
    public static int getRed() {
        Scanner console = new Scanner(System.in);
        System.out.print("Red value (0-255): ");
        int red = console.nextInt();
        red = Math.max(red, MIN_RGB);
        red = Math.min(red, MAX_RGB);
        return red; 
    }
    /**
     * Helper method used to request user input for green color value.
     * Constrains value if necessary.
     * @return Green RGB value.
     */
    public static int getGreen() {
        Scanner console = new Scanner(System.in);
        System.out.print("Green value (0-255): ");
        int green = console.nextInt();
        green = Math.max(green, MIN_RGB);
        green = Math.min(green, MAX_RGB);
        return green; 
    }
    /**
     * Helper method used to request user input for blue color value.
     * Constrains value if necessary.
     * @return Blue RGB value.
     */
    public static int getBlue() {
        Scanner console = new Scanner(System.in);
        System.out.print("Blue value (0-255): ");
        int blue = console.nextInt();
        blue = Math.max(blue, MIN_RGB);
        blue = Math.min(blue, MAX_RGB);
        return blue;
    }
    /**
     * Draws a square that is filled in with a color.
     * @param g Graphics panel used to create a square.
     * @param x "x" coordinate of top left corner of square.
     * @param y "y" coordinate of top left corner of square.
     * @param width Width (and height) of the square.
     * @param color Color of the circle.
     */
    public static void drawSquare (Graphics g, int x, int y, int width, Color color) {
        g.setColor(color);
        g.fillRect(x, y, width, width);
    }
    /**
     * Draws a circle that is filled in with a color.
     * @param g Graphics panel used to create a circle.
     * @param x "x" coordinate of top left corner of square that circle is drawn in.
     * @param y "y" coordinate of top left corner of square that circle is drawn in.
     * @param width Width (and height) of the circle.
     * @param color Color of the circle.
     */
    public static void drawCircle (Graphics g, int x, int y, int width, Color color) {
        g.setColor(color);
        g.fillOval(x, y, width, width);
    }
}
