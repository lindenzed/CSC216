import java.awt.Color;
import java.awt.Graphics;
/**
 *Draws a face in two locations using a parameterized
 *static method.
 *
 * @author Zach Giles
 *
 * @version 24Jan2020
 */
public class Face2 {

    /**
     * Starts the program that draws two faces at given starting points.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(520, 180);
        Graphics g = panel.getGraphics();
        //draws five faces 100 pixels to the right of the previous face
        for (int i = 10; i <= 410; i = i + 100) {
            drawFace(g, i, 30);
        }
    }
    /**
     * Creates a static method that creates a face.
     * @param g Declares variables, computes position, and prints the face.
     * @param x starting horizontal position of face outline
     * @param y starting vertical position of face outline
     */
    public static void drawFace(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 100, 100); // face outline
        
        g.setColor(Color.BLUE);
        g.fillOval(x + 20, y + 30, 20, 20); // eyes
        g.fillOval(x + 60,y + 30,20,20);
        
        g.setColor(Color.RED); // mouth
        g.drawLine(x + 30, y + 70, x + 70, y + 70);
    }
}
