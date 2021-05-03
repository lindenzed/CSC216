import java.util.*;//imports Scanner class
/**
 * This program takes an inputed value and converts it to denominations of currency.
 * The denominations are 20s 10s 5s and 1s. 
 *
 * @author Zach Giles
 *
 * @version 14Jan2020
 */
public class Dollars {
    /**
     * Class constant that states the value of a 20 dollar bill.
     */
    public static final int TWENTY_DOLLARS = 20;
    /**
     * Class constant that states the value of a 10 dollar bill.
     */
    public static final int TEN_DOLLARS = 10;
    /**
     * Class constant that states the value of a 5 dollar bill.
     */
    public static final int FIVE_DOLLARS = 5;
    /**
     * Class constant that states the value of a 1 dollar bill.
     */
    public static final int ONE_DOLLAR = 1;
    /**
     * Starts the program.
     * @param args (not used)
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter a whole dollar amount of money you would like change for"
                + "in 20s, 10s, 5s, and 1s");
        /**
         * Creates int deposit Fixed to maintain value for use in final print.
         */
        int depositFixed = console.nextInt();
        /**
         * Creates int deposit to use for algebra manipulations.
         */
        int deposit = depositFixed;
        /**
         * Creates int twenties to discover how many twenties can be derived.
         */
        int twenties = deposit / TWENTY_DOLLARS;
        /**
         * Credits the twenties from the deposit.
         */
        deposit = deposit - (twenties * TWENTY_DOLLARS);
        /**
         * Creates int tens to discover how many tens can be derived.
         */
        int tens = deposit / TEN_DOLLARS;
        /**
         * Credits the tens from the deposit.
         */
        deposit = deposit - (tens * TEN_DOLLARS);
        /**
         * Creates int fives to discover how many fives can be derived.
         */
        int fives = deposit / FIVE_DOLLARS;
        /**
         * Credits the fives from the deposit.
         */
        deposit = deposit - (fives * FIVE_DOLLARS);
        /**
         * Creates int ones to discover assign remaining amount to singles.
         */
        int ones = deposit;
        /**
         * Credits the ones from the deposit.
         */
        deposit = deposit - (ones * deposit);
        System.out.println("$" + depositFixed + " converts to:  " + twenties + " 20s, " + tens
                + " 10s, " + fives + " 5s, and " + ones + " 1s.");
    }
}

