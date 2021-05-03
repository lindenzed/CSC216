import java.util.*;//imports Scanner class
/**
 *Creates a class that prompts a user for an input string, and then outputs
 *a string of the input int the form of Pig Latin.  A method must be used
 *to do the conversion as stipulated in the assignment. 
 *
 * @author Zach Giles
 *
 * @version 22Jan2020
 */
public class PigLatin {

    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);//Creates an object from Scanner class
        System.out.print("Please enter a word: ");//prompts user for word
        String userWord = console.next();//stores user input
        //passes user input into pigLatinWord() method to create Pig Latin version outputs return.
        System.out.println("Your word in Pig Latin is: " +pigLatinWord(userWord));
    }
    
    /**
     * Creates a method that takes a single word and converts the word to Pig Latin.
     * @param word the word that will be converted to Pig Latin
     * @return the word in Pig Latin
     */
    public static String pigLatinWord(String word) {
        //creates the Pig Latin suffix from the first letter in the word
        String pigLatinSuffix = word.charAt(0) + "ay";
      //creates the Pig Latin base from the original word without the first letter
        String pigLatinBase = word.substring(1, word.length());
        //creates the Pig Latin form of the original parameter by adding the base to the suffix
        String wordPigLatin = pigLatinBase + pigLatinSuffix;
        return wordPigLatin;//returns the original parameter in Pig Latin
    }
}
