import java.awt.*;
/**
 * 
 *This program creates a scalable animation of a zinger down the pipe.
 *Feel free to play around with the scale (which is the <b><i>HEIGHT</i></b>
 *class constant. The program was originally designed to run with a 
 *<b><i>HEIGHT</i></b> = 300, so please grade that one. I tested
 *200, 300, 400, 500, 600, and some prime numbers successfully. Values
 *less than 200 and greater than 600 create some scaling issues. I learned
 *the drawArc and setFont functions from the java.awt API.(docs.oracle.com/
 * javase/7/docs/api/java/awt/Graphics.html).
 *
 *
 * @author Zach Giles
 *
 * @version 12Feb2020
 */

public class Animation {
    /**
     * Creates the height of the drawing panel, and sets the scale for the entire drawing.
     */
    public static final int HEIGHT = 300;
    /**
     * Sets the width of the drawing panel.
     */
    public static final int WIDTH = 2 * HEIGHT;
    /**
     * Sets the sleep time for the animation.
     */
    public static final int SLEEP_TIME = 200;
    /**
     * Sets the initial "x" value used in drawing figures and background.
     */
    public static final int INITIAL_X = 0;
    /**
     * Sets the initial "y" value used in drawing the background.
     */
    public static final int INITIAL_Y = 0;
    /**
     * Sets the width for the upper green rectangle.
     */
    public static final int UPPER_GRASS_WIDTH = WIDTH;
    /**
     * Sets the height for the upper green rectangle.
     */
    public static final int UPPER_GRASS_HEIGHT = HEIGHT / 3;
    /**
     * Sets the "y" value for the white circle.
     */
    public static final int BASEBALL_Y = UPPER_GRASS_HEIGHT + HEIGHT / 10;
    /**
     * Sets the "y" value for the middle brown rectangle.
     */
    public static final int DIRT_Y = UPPER_GRASS_HEIGHT;
    /**
     * Sets the width for the middle brown rectangle.
     */
    public static final int DIRT_WIDTH = WIDTH;
    /**
     * Sets the height for the middle brown rectangle.
     */
    public static final int DIRT_HEIGHT = HEIGHT / 3 ;
    /**
     * Sets the width for the lower green rectangle.
     */
    public static final int LOWER_GRASS_WIDTH = UPPER_GRASS_WIDTH;
    /**
     * Sets the height for the lower green rectangle.
     */
    public static final int LOWER_GRASS_HEIGHT = HEIGHT - UPPER_GRASS_HEIGHT - DIRT_HEIGHT;
    /**
     * Sets the apex "y" point for the pentagon in the right middle of the animation.
     */
    public static final int HOME_PLATE_APEX_Y = UPPER_GRASS_HEIGHT
            + DIRT_HEIGHT / 2;
    /**
     * Sets the offset for drawing subsequent "y" points for the pentagon in the right middle.
     */
    public static final int HOME_PLATE_OFFSET_Y = (int) (20 * (HEIGHT / 300.0));
    /**
     * Sets the apex "x" point for the pentagon in the right middle of the animation.
     */
    public static final int HOME_PLATE_APEX_X = WIDTH - 2 * (WIDTH / 15);
    /**
     * Sets the offset for drawing subsequent "x" points for the pentagon in the right middle.
     */
    public static final int HOME_PLATE_OFFSET_X = WIDTH / 20;
    /**
     * Sets the "x" value for the white rectangle in the left middle of the animation.
     */
    public static final int PITCHERS_MOUND_X = WIDTH / 13;
    /**
     * Sets the "y" value for the white rectangle in the left middle. of the animation.
     */
    public static final int PITCHERS_MOUND_Y = UPPER_GRASS_HEIGHT
            + DIRT_HEIGHT / 5;
    /**
     * Sets the width for the white rectangle in the left middle of the animation.
     */
    public static final int PITCHERS_MOUND_WIDTH = WIDTH / 30;
    /**
     * Sets the height for the white rectangle in the left middle of the animation.
     */
    public static final int PITCHERS_MOUND_HEIGHT = HEIGHT / 5;
    /**
     * Sets the "x" value for the top line of text in the animation.
     */
    public static final int TEXT_X = (int) (WIDTH / 2.85);
    /**
     * Sets the offset value used to determine "x" values for succeeding lines of text.
     */
    public static final int TEXT_X_OFFSET = (WIDTH / 10);
    /**
     * Sets the "y" value for the top line of the text in the animation.
     */
    public static final int TEXT_Y = WIDTH / 20;
    /**
     * Sets the offset value used to determine "y" values for succeeding lines of text.
     */
    public static final int TEXT_Y_OFFSET = WIDTH / 30;
    /**
     * Sets the size of the red arcs.
     */
    public static final int ARC_SIZE = HEIGHT / 8;
    /**
     * Sets the size of the white circle.
     */
    public static final int BASEBALL_SIZE = ARC_SIZE;
    /**
     * Sets the number of updates used in the animation.
     */
    public static final int NUMBER_OF_UPDATES = 2 * (BASEBALL_SIZE - BASEBALL_SIZE / 4);
    /**
     * Sets delta "x" used for moving the figures in the animation.
     */
    public static final int DX = 10;
    /**
     * Sets the "y" value for the lower red arc in figure1.
     */
    public static final int LOWER_ARC_Y = BASEBALL_Y + (HEIGHT / 13);
    /**
     * Sets the "y" value for the upper red arc in figure).
     */
    public static final int UPPER_ARC_Y = BASEBALL_Y - (HEIGHT / 13);
    /**
     * Sets the "y" value for the left red arc in figure2.
     */
    public static final int LEFT_ARC_Y = BASEBALL_Y ;
    /**
     * Sets the "y" value for the right red arc in figure2.
     */
    public static final int RIGHT_ARC_Y = LEFT_ARC_Y;
    /**
     * Sets the final degree angle for the arcs.
     */
    public static final int ARC_END = 107;
    /**
     * Used by itself or with <b><i>NINETY_DEGREES</i></b> to set the beginning angle for the arcs.
     */
    public static final int ARC_BEGIN = 127;
    /**
     * Used by itself or with <b><i>ARC_BEGIN</i></b> to set the beginning angle for the arcs.
     */
    public static final int NINETY_DEGREES = 90;
    /**
     * Sets the font size to draw the "GO PACK!!!" String.
     */
    public static final int FONT_SIZE = (HEIGHT / 15);
    /**
     * Sets the difference in size between the "GO PACK!!!" String, and the title and name Strings.
     */
    public static final int TITLE_NAME_SIZE_DIFFERENCE = (HEIGHT / 60);
    /**
     * Starts the program, and runs the animation by cycling between an image
     * of a baseball with the threads on the top and bottom, and the threads on the
     * left and right.  Cycling these images while creating translational movement
     * along the x-axis creates an effect of the baseball spinning through the air.
     * @param args Command line arguments (not used).
     */
    public static void main (String[] args) {
        DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
        Graphics g = panel.getGraphics();
        int x = INITIAL_X;
        //draws the baseball with the threads on the top and bottom the initial time at "INITIAL_X" 
        //but then draws the subsequent figures "DX" pixels to the right of the succeeding
        //figure2 created in the nested loop.
        for (int i = 0; i < NUMBER_OF_UPDATES; i = i + 2) {
            drawBackground(g);//draws background (either new or over previous figure)
            drawFigure1(g, x + DX * i);//draws the baseball with the threads on the top and bottom
            panel.sleep(SLEEP_TIME);
            for (int j = i + 1; j > i; j--) {//
                drawBackground(g);//draws background over previous figure
                //draws the baseball with the threads on the left and right "DX" pixels
                //to the right of the previous figure.
                drawFigure2(g, x + DX * j);
                panel.sleep(SLEEP_TIME);
            }//j
        }//i
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("SansSerif", Font.BOLD, FONT_SIZE));
        g.drawString("STEEEEEEEERIKE!",HOME_PLATE_APEX_X - HEIGHT / 2, DIRT_HEIGHT
                + DIRT_Y + LOWER_GRASS_HEIGHT / 2);//It's Official
        System.out.println("\n*CLOSE the Drawing Panel to exit the program*");
    }
    /**
     * Draws the background for the figure that resembles an aerial view of the pitchers lane
     * on a baseball field. 
     * @param g A graphics object in the drawing panel.
     */
    public static void drawBackground(Graphics g) {
        Color brown = new Color(192,128,64);
        g.setColor(brown);
        g.fillRect(INITIAL_X, DIRT_Y, DIRT_WIDTH, DIRT_HEIGHT);//dirt
        Polygon homePlate = new Polygon();//creates home plate
        homePlate.addPoint(HOME_PLATE_APEX_X, HOME_PLATE_APEX_Y);
        homePlate.addPoint(HOME_PLATE_APEX_X + HOME_PLATE_OFFSET_X, HOME_PLATE_APEX_Y
                - HOME_PLATE_OFFSET_Y);
        homePlate.addPoint(HOME_PLATE_APEX_X + 2 * HOME_PLATE_OFFSET_X, HOME_PLATE_APEX_Y
                - HOME_PLATE_OFFSET_Y);
        homePlate.addPoint(HOME_PLATE_APEX_X + 2 * HOME_PLATE_OFFSET_X, HOME_PLATE_APEX_Y
                + HOME_PLATE_OFFSET_Y - HEIGHT / 150);
        homePlate.addPoint(HOME_PLATE_APEX_X + HOME_PLATE_OFFSET_X, HOME_PLATE_APEX_Y
                + HOME_PLATE_OFFSET_Y - HEIGHT / 150);
        g.setColor(Color.GREEN);
        g.fillRect(INITIAL_X, INITIAL_Y, UPPER_GRASS_WIDTH, UPPER_GRASS_HEIGHT);//upper grass
        g.fillRect(INITIAL_X, DIRT_HEIGHT + DIRT_Y, LOWER_GRASS_WIDTH,
                LOWER_GRASS_HEIGHT);//lower grass
        g.setColor(Color.WHITE);
        g.fillRect(PITCHERS_MOUND_X, PITCHERS_MOUND_Y, PITCHERS_MOUND_WIDTH,
                PITCHERS_MOUND_HEIGHT);//pitchers mound
        g.fillPolygon(homePlate);//fills home plate
        g.setColor(Color.RED);
        g.drawString("The Greatest Game Ever Played", TEXT_X, TEXT_Y);//picture title
        g.drawString("Zach Giles", TEXT_X + TEXT_X_OFFSET, TEXT_Y + TEXT_Y_OFFSET);//my name
        g.setFont(new Font("SansSerif", Font.BOLD, FONT_SIZE));
        g.drawString("GO PACK!!!",TEXT_X + (int) (TEXT_X_OFFSET / 1.5), TEXT_Y
                + 2 * TEXT_Y_OFFSET);//smells like team spirit
        g.setFont(new Font("SansSerif", Font.PLAIN, FONT_SIZE - TITLE_NAME_SIZE_DIFFERENCE));
    }
    /**
     * Creates a baseball with the threads on the top and bottom used in the animation.
     * @param g A graphics object in the drawing panel.
     * @param x The position along the x-axis.
     */
    public static void drawFigure1(Graphics g, int x) {
        g.setColor(Color.WHITE);
        g.fillOval(x, BASEBALL_Y, BASEBALL_SIZE, BASEBALL_SIZE);//baseball leather
        g.setColor(Color.RED);
        g.drawArc(x, LOWER_ARC_Y, ARC_SIZE, ARC_SIZE,
                (ARC_BEGIN - NINETY_DEGREES), ARC_END);//baseball lower threads
        g.drawArc(x, UPPER_ARC_Y, ARC_SIZE, ARC_SIZE,
                - (ARC_BEGIN - NINETY_DEGREES), - ARC_END);//baseball upper threads
        g.setColor(Color.BLACK);
        g.drawOval(x, BASEBALL_Y, BASEBALL_SIZE, BASEBALL_SIZE);//ball outline
    }
    /**
     * Creates a baseball with the threads on the left and right used in the animation.
     * @param g A graphics object in the drawing panel.
     * @param x The position along the x-axis.
     */
    public static void drawFigure2(Graphics g, int x) {
        g.setColor(Color.WHITE);
        g.fillOval(x, BASEBALL_Y, BASEBALL_SIZE, BASEBALL_SIZE);//baseball leather
        g.setColor(Color.RED);
        g.drawArc(x - (HEIGHT / 13), LEFT_ARC_Y, ARC_SIZE, ARC_SIZE,
                - (NINETY_DEGREES - (ARC_BEGIN - NINETY_DEGREES)), ARC_END);//baseball left threads
        g.drawArc(x + (HEIGHT / 13), RIGHT_ARC_Y, ARC_SIZE, ARC_SIZE,
                ARC_BEGIN, ARC_END);//baseball right threads
        g.setColor(Color.BLACK);
        g.drawOval(x, BASEBALL_Y, BASEBALL_SIZE, BASEBALL_SIZE);//ball outline
    }
}
