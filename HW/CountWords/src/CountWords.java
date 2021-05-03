import java.util.*;
/**
 *This program prompts the user to enter a phrase, and then
 *counts the words in that phrase. A statement informing the
 *user how many word were entered is then printed to the screen.
 *
 * @author Zach Giles
 *
 * @version 10Feb2020
 */
public class CountWords {

    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter a phrase to count words: ");
        String phrase = console.nextLine();
        System.out.printf("Your phrase has %d words.", wordCount(phrase));

    }
    /**
     * Counts the "words" by counting first counting the characters that are succeeded by
     * whitespace. The method then checks to see if the last index has a character
     * in it to count the final word (since you can test the index succeeding the final index.)
     * @param phrase A statement containing words to be counted.
     * @return Number of words.
     */
    public static int wordCount (String phrase) {
        int length = phrase.length();
        int wordCounter = 0;
        for (int i = 0; i <= length - 1; i++) {
            if (i < length - 1 && phrase.charAt(i) != ' ' && phrase.charAt(i + 1) == ' ') {
                wordCounter++;
            }
            if (i == length - 1 && phrase.charAt(i) != ' ') {
                wordCounter++;
            }
        }
        return wordCounter;
    }
}
