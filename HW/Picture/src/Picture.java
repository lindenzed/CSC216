import java.awt.*;
/**
 * Draws a series of baseballs. Uses a for loop to rotate
 * the baseball while adding translational motion along
 * the x-axis.  Uses <i>panel.sleep</i> and 
 * <i>panel.clear</i> to create a small animation before
 * completing the assignment of drawing a picture to the
 * drawing panel. Final picture is a series of baseballs
 * similar to the series of faces made in Faces2.  The 
 * baseballs are drown down the pitchers alley, surrounded 
 * by grass.  I also included a pitchers mound and home plate.
 * Shapes drawn include <i>oval, rectangle, polygon</i>.  Colors
 * include <i><b>WHITE, GREEN, BROWN, RED, BLACK</b></i>.
 * The baseball threads are made using <i>drawArc</i> which
 * I learned to use from the java.awt API (docs.oracle.com/
 * javase/7/docs/api/java/awt/Graphics.html.
 *
 * @author Zach Giles
 *
 * @version 25Jan2020
 */
public class Picture {
    /**
     * Starts the program.  Runs animation then completes assignment.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(600, 300);
        Color brown = new Color(192,128,64);
        panel.setBackground(brown);//dirt
        Graphics g = panel.getGraphics();
        Polygon homePlate = new Polygon();//creates home plate
        homePlate.addPoint(520,145);
        homePlate.addPoint(550, 125);
        homePlate.addPoint(580,125);
        homePlate.addPoint(580, 165);
        homePlate.addPoint(550, 165);
        for (int i = 0; i <= 4 ; i = i + 2 ) {//animation
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, 600, 100);//upper grass
            g.fillRect(0, 190, 600, 110);//lower grass
            g.setColor(Color.WHITE);
            g.fillRect(40, 115, 20, 60);//pitchers mound
            g.fillPolygon(homePlate);//fills home plate
            g.fillOval(i * 100, 95, 100, 100);//baseball leather
            g.setColor(Color.RED);
            g.drawArc(i * 100, 155, 100,100,36,107);//baseball lower threads
            g.drawArc(i * 100,35, 100, 100,-36, -107);//baseball upper threads
            panel.sleep(600);
            panel.clear();
            //baseball moves left and rotates 90 degrees
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, 600, 100);//upper grass
            g.fillRect(0, 190, 600, 110);//lower grass
            g.setColor(Color.WHITE);
            g.fillRect(40, 115, 20, 60);//pitchers mound
            g.fillPolygon(homePlate);//fills home plate
            g.fillOval((i + 1) * 100, 95, 100, 100);//baseball leather
            g.setColor(Color.RED);
            g.drawArc((-60 + (i + 1) * 100),95,100,100,-54,105);//baseball left threads
            g.drawArc((60 + (i + 1) * 100), 95, 100, 100, 127, 108);//baseball right threads
            panel.sleep(600);
            panel.clear();
            //sets up for baseball movement and rotation 90 degrees again
        }
        /*
         * Up until now I realize the assignment is to print two graphics
         * with two colors, and I have done an animation.  I end the program
         * with the actual assignment parameters.  I have printed three shapes
         * (oval/rectangle/polygon) using 5 colors (green, brown, white, black, and red).
         * As cited in the Class JavaDoc I learned to use the drawArc from the API.*/
         
        g.setColor(Color.WHITE);
        g.fillRect(40, 115, 20, 60);//pitchers mound
        g.fillPolygon(homePlate);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 600, 100);//upper grass
        g.fillRect(0, 190, 600, 110);//lower grass
        g.setColor(Color.RED);
        g.drawString("The Greatest Game Ever Played", 210, 30);//picture title
        g.drawString("Zach Giles", 270, 50);//my name
        g.drawString("GO PACK!!!",270, 70);//smells like team spirit
        for (int i = 0; i  <= 4 ; i = i + 2 ) {
            g.setColor(Color.BLACK);
            g.drawOval(i * 100, 95, 100, 100);//draws outline of baseball
            g.setColor(Color.RED);
            g.drawArc(i * 100, 155, 100,100,36,107);//draws lower threads
            g.drawArc(i * 100,35, 100, 100,-36, -107);//draws upper threads
            g.setColor(Color.BLACK);
            g.drawOval((i + 1) * 100, 95, 100, 100);//draws outline of baseball
            g.setColor(Color.RED);
            g.drawArc((-60 + (i + 1) * 100),95,100,100,-54,107);//draws left threads
            g.drawArc((60 + (i + 1) * 100), 95, 100, 100, 126, 107);//draws right threads
        }
    }
}


