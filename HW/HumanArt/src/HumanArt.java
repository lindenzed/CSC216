/**
 *This program prints an ASCII art image that I made on my own.  The image is an awkward guy 
 *with curly hair and bucked teeth.  He reminds me of myself as a child before braces.
 *This is for the HumanArt, Project 1, for CSC116. I tried to limit redundancy and empty
 *spaces by using <i>printf</i> statements.  In doing this I created parameter methods
 *that returned a <i>String</i> so I could make shorter/neater <i>printf</i> statements.
 *I made <i>for</i> loops for repeating segments, even if there
 *were only two lines so I could add a <i>SCALE</i>
 *constant where you could easily change the height of the figure.
 *
 * @author Zach Giles
 *
 * @version 23Jan2020
 */
public class HumanArt {
    /**
     * Creates a scalable height.  Used in for loops of body construction
     * (not used in for loops of String construction).  Must be a whole positive number.
     */
    public static final int SCALE = 2;
    /**
     * Creates the unit of <b>hair</b> building block.
     */
    public static final String HAIR = "&&&";
    /**
     * Creates the unit of <b>upper body</b> building block.
     */
    public static final String UPPER_BODY = "--";
    /**
     * Creates the unit of <b>lower body</b> building block.
     */
    public static final String LOWER_BODY = "!!!";
    /**
     * Creates the <b>torso</b> building block.
     */
    public static final String TORSO_BLOCK = "|!!!!!!|";
    /**
     * Creates the <b>left hand</b>.
     */
    public static final  String LEFT_HAND = "((((";
    /**
     * Creates the <b>right hand</b>.
     */
    public static final String RIGHT_HAND = "))))";
    /**
     * Builds the ASCII human art by building the head, torso, and then legs.
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        head();//hair, face, neck
        torso();//torso, arms, hands
        legs();//legs, feet
    }
    /**
     * Creates a <i>String</i> of hair with the hair block. Used in <i>printf</i> statements.
     * @param x how many units of hair needed. One unit is <b>&&&</b>.
     * @return hair to build artwork.
     */
    public static String hair(int x) {
        String hairLength = "";
        for (int i = 1; i <= x; i++) {
            hairLength = hairLength + HAIR;//adds one unit of HAIR
        }//i
        return hairLength;
    }
    /**
     * Creates a <i>String</i> of upper body characters using the upper body building block.
     * Used in <i>printf</i> statements.
     * @param x how many units of upper body needed. One unit is <b>--</b>.
     * @return upper body to build artwork.
     */
    public static String upperBody(int x) {
        String upperBodyLength = "";
        for (int i = 1; i <= x; i++) {
            upperBodyLength = upperBodyLength + UPPER_BODY;//adds one unit of UPPER_BODY
        }//i
        return upperBodyLength;
    }
    /**
     * Creates a <i>String</i> of lower body characters using the lower body building block.
     * Used in <i>printf</i> statements.
     * @param x how many units of lower body needed. One unit is <b>!!!</b>.
     * @return lower body to build artwork.
     */
    public static String lowerBody(int x) {
        String lowerBodyLength = "";
        for (int i = 1; i <= x; i++) {
            lowerBodyLength = lowerBodyLength + LOWER_BODY;//adds one unit of LOWER_BODY
        }//i
        return lowerBodyLength;
    }
    /**
     * Creates the head of the artwork.
     */
    public static void head() {
        System.out.printf("%12s\n", hair(1));//hairstyle line 1
        System.out.printf("%14s\n", hair(2));//hairstyle line 2
        System.out.printf("%15s\n","/" + upperBody(3) + "\\");//forehead
        System.out.printf("%16s\n","/" + hair(1) + upperBody(1) + hair(1) + "\\");//eyebrows
        System.out.printf("%18s\n", "{|" + upperBody(1) + "@" + upperBody(2) + "@"
                + upperBody(1) + "|}");//eyes
        System.out.printf("%17s\n", "|" + upperBody(2) + "^^" + upperBody(2) + "|");//nose
        System.out.printf("%17s\n","|__________|");//mouth
        System.out.printf("%16s\n","\\#|_||_|#/");//sizable incisors
        System.out.printf("%15s\n","\\######/");//bottom teeth
        System.out.printf("%14s\n", upperBody(3));//chin
        for (int i = 1; i <= 2 * SCALE; i++) {
            System.out.printf("%13s\n",upperBody(2));//prints lines of repeating neck
        }//i
    }
    /**
     * Creates the shoulders, arms, hands, and torso of the artwork.
     */
    public static void torso() {
        for (int i = 1; i <= 2 * SCALE; i++) {
            System.out.print(upperBody(11) + "\n");//prints lines of 22 -'s for shoulders
        }//i
        for (int j = 1; j <= 5 * SCALE; j++) {
            System.out.printf("%18s\n", upperBody(2) + "   " + TORSO_BLOCK + "   "
                    + upperBody(2));//prints lines of repeating units of arms and torso
        }//j
        System.out.printf("%18s\n",LEFT_HAND + "   " + TORSO_BLOCK + "   " + RIGHT_HAND);//hands
    }
    /**
     * Creates a the legs and feet.
     */
    public static void legs() {
        for (int i = 1; i <= 5 * SCALE; i++) {
            System.out.printf("%15s\n", lowerBody(1) + "  " + lowerBody(1));//prints lines of legs
        }//i
        System.out.printf("%15s\n","/ |  | \\");//ankles
        System.out.printf("%16s\n","/__|  |__\\");//feet
    }
}
