
/**
 * This is for Homework 1.12.  I am having trouble figuring out how to 
 *get the program to only run each generated function once.  I split the 
 *repeating statements up, and the different parts of the song, but I have 
 *to call the repeating statements multiple times.
 *
 * @author Zach Giles
 *
 *
 * @version 11/Jan/2020
 */
public class FightSong {

    /**
     * Starts the program.
     * @param args (not used)
     */
    
    public static void main(String[] args) {
        intro();
        chorus();
        coda();
       
    }

    /** Creates a statement_1 method that encompasses the first
     * repeating unit of the FightSong.
     */

    public static void statement_1() {
        System.out.println("Go, team, go!");
        System.out.println("You can do it.");
    }
    
    /** Creates a statement_2 method that encompasses the second repeating
     * unit of the FightSong.
     */
    
    public static void statement_2() {
        System.out.println("You're the best,");
        System.out.println("In the West.");
    }
    
    /** Creates a method to make a empty line so I don't have to type
     * the System.out.println so many times.
     */
    
    public static void space() {
        System.out.println();
    }
    
    /** Creates the FightSong introduction using the statement_1 method.*/
    
    public static void intro() {
        statement_1();
        space();
        
    }
    
    /** Creates a stanza from statements_1 and statements_2 that is itself
     * repeated in the chorus.
     */
    public static void stanza() {
        statement_1();
        statement_2();
        statement_1();
        space();
    }
    
    /** Creates the chorus for the FightSong from the stanza method,
     * in which the stanza method is created from the statement_1
     * and statement_2 methods.
     */
    
    public static void chorus() {
        stanza();
        stanza();
    }
    
    /** Creates the FightSong coda using the statement_1 method.*/
    
    public static void coda() {
        statement_1();
    }
    
}