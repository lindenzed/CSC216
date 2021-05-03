import java.util.Scanner;

/**
 *Creates a program that calculates a users income tax based
 *on their marital status and taxable income.
 *
 * @author Zach Giles
 *
 * @version 16Feb2020
 */
public class TaxCalculator {
    /**
     * Defines zero income boundary.
     */
    public static final int ZERO_INCOME = 0;
    /**
     * Defines $8000 income boundary in cents.
     */
    public static final int EIGHT_GRAND_INCOME_CENTS = 800000;
    /**
     * Defines $32000 income boundary in cents.
     */
    public static final int THIRTY_TWO_GRAND_INCOME_CENTS = 3200000;
    /**
     * Defines fixed tax in middle single tax bracket.
     */
    public static final int EIGHT_HUNDRED_TAX_BRACKET_CENTS = 80000;
    /**
     * Defines fixed tax in upper single tax bracket.
     */
    public static final int FORTY_FOUR_HUNDRED_TAX_BRACKET_CENTS = 440000;
    /**
     * Defines $16000 income boundary in cents.
     */
    public static final int SIXTEEN_GRAND_INCOME_CENTS = 1600000;
    /**
     * Defines $64000 income boundary in cents.
     */
    public static final int SIXTY_FOUR_GRAND_INCOME_CENTS = 6400000;
    /**
     * Defines fixed tax in middle married tax bracket.
     */
    public static final int SIXTEEN_HUNDRED_TAX_BRACKET_CENTS = 160000;
    /**
     * Defines fixed tax in upper married tax bracket.
     */
    public static final int EIGHTY_EIGHT_HUNDRED_TAX_BRACKET_CENTS = 880000;
    /**
     * Defines cents in dollar for conversions.
     */
    public static final int CENTS_IN_DOLLAR = 100;
    /**
     * Defines lower tax bracket tax rate.
     */
    public static final double TEN_PERCENT_TAX_BRACKET = 0.1;
    /**
     * Defines middle tax bracket tax rate.
     */
    public static final double FIFTEEN_PERCENT_TAX_BRACKET = 0.15;
    /**
     * Defines upper tax bracket tax rate.
     */
    public static final double TWENTY_FIVE_PERCENT_TAX_BRACKET = 0.25;
    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter your income in dollars with no cents: ");
        int income = console.nextInt();
        System.out.print("Please enter your marital status (Married/Single): ");
        String married = console.next();
        System.out.printf("Your income tax due is: $%.2f", tax(income * CENTS_IN_DOLLAR,
            getMaritalStatus(married)));
    }
    /**
     * Converts inputed marital status to boolean.
     * @param married Inputed marital status of user.
     * @return Married? T/F
     */
    public static boolean getMaritalStatus(String married) {
        boolean isMarried = false;
        if (married.equalsIgnoreCase("married")) {
            isMarried = true;
            return isMarried;
        }
        return isMarried;
    }
    /**
     * Calculates tax rate of user inputed marital status and income.
     * @param income User inputed income <i>converted to cents</i>.
     * @param isMarried True if user is married.
     * @return Calculated tax rate <i> in dollars </i>.
     */
    public static double tax(int income, boolean isMarried) {
        double tax = ZERO_INCOME;
        if (isMarried == false) {//single
            if (income >= ZERO_INCOME && income <= EIGHT_GRAND_INCOME_CENTS) {//lower bracket
                tax = TEN_PERCENT_TAX_BRACKET * income / CENTS_IN_DOLLAR;
                return tax;
            }
            else if (income > EIGHT_GRAND_INCOME_CENTS && income //middle bracket
                <= THIRTY_TWO_GRAND_INCOME_CENTS) {
                tax = ((income - EIGHT_GRAND_INCOME_CENTS) * FIFTEEN_PERCENT_TAX_BRACKET 
                        + EIGHT_HUNDRED_TAX_BRACKET_CENTS) / CENTS_IN_DOLLAR;
                return tax;
            }
            else {//upper bracket
                tax = ((income - THIRTY_TWO_GRAND_INCOME_CENTS) * TWENTY_FIVE_PERCENT_TAX_BRACKET 
                    + FORTY_FOUR_HUNDRED_TAX_BRACKET_CENTS) / CENTS_IN_DOLLAR;
                return tax;
            }
        }
        else {//married
            if (income >= ZERO_INCOME && income <= SIXTEEN_GRAND_INCOME_CENTS) {//lower bracket
                tax = TEN_PERCENT_TAX_BRACKET * income / CENTS_IN_DOLLAR;
                return tax;
            }
            else if (income > SIXTEEN_GRAND_INCOME_CENTS && income //middle bracket
                    <= SIXTY_FOUR_GRAND_INCOME_CENTS) {
                tax = ((income - SIXTEEN_GRAND_INCOME_CENTS) * FIFTEEN_PERCENT_TAX_BRACKET 
                        + SIXTEEN_HUNDRED_TAX_BRACKET_CENTS) / CENTS_IN_DOLLAR;
                return tax;
            }
            else {//upper bracket
                tax = ((income - SIXTY_FOUR_GRAND_INCOME_CENTS) * TWENTY_FIVE_PERCENT_TAX_BRACKET 
                        + EIGHTY_EIGHT_HUNDRED_TAX_BRACKET_CENTS) / CENTS_IN_DOLLAR;
                return tax;
            }
        }
    }
}
