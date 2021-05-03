/**
 *This program calculates and outputs the energy cost and total cost in dollars
 *for a 75 watt incandescent and equivalent CFL and LED bulbs.  The costs are
 *computed from 0 to 1200 hours in increments of 50 hours using defined fixed
 * costs of power and materials.  I referenced the "Lighting Cost Analysis Overview"
 * web-page for the above description, and for the formatting of cost and hours.
 *
 * @author Zach Giles
 *
 * @version 23Jan2020
 */
public class CostAnalysis {
    /**
     * Class constant defining cost of kilowatt hour in cents.
     */
    public static final double CENTS_PER_KWH = 10.99;
    /**
     * Class constant defining wattage of incandescent bulb.
     */
    public static final int INCANDESCENT_WATTS = 75;
    /**
     * Class constant defining retail cost of incandescent bulb.
     */
    public static final double INCANDESCENT_COST = 1.05;
    /**
     * Class constant defining wattage of CFL bulb.
     */
    public static final int CFL_WATTS = 21;
    /**
     * Class constant defining retail cost of CFL bulb.
     */
    public static final double CFL_COST = 2.10;
    /**
     * Class constant defining wattage of LED bulb.
     */
    public static final int LED_WATTS = 11;
    /**
     * Class constant defining retail cost of LED bulb.
     */
    public static final double LED_COST = 3.85;
    /**
     * Class constant defining minimum hours for cost analysis.
     */
    public static final int MINIMUM_HOURS = 0;
    /**
     * Class constant defining maximum hours for cost analysis.
     */
    public static final int MAXIMUM_HOURS = 1200;
    /**
     * Class constant defining hour increment used in cost analysis.
     */
    public static final int HOUR_INCREMENT = 50;
    /**
     * Class constant stating how many cents are in a dollar.
     */
    public static final int CENTS_PER_DOLLAR = 100;
    /**
     * Class constant stating how many watts are in a kilowatt.
     */
    public static final int WATTS_PER_KW = 1000;
    /**
     * Creates the table showing the cost analysis.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        /*
         * System.out.print statements from here to the for loop are used to
         * create the table header.
         */
        System.out.println();
        System.out.printf("%52s\n","Energy and Total Cost Comparison (in dollars)");
        System.out.println();
        System.out.printf("%22s","Incandescent");
        System.out.printf("%14s", "CFL");
        System.out.printf("%18s\n", "LED");
        System.out.println("Hours    Energy   Total    Energy   Total    Energy   Total");
        System.out.println("-----    ------   -----    ------   -----    ------   -----");
        /* for each increment of hours the energy cost and total cost is calculated for
         * each bulb and then printed.
         */
        for (int i = MINIMUM_HOURS; i <= MAXIMUM_HOURS; i = i + HOUR_INCREMENT) {
            System.out.printf("%4d", i);
            bulbCost(INCANDESCENT_WATTS, INCANDESCENT_COST,i);
            bulbCost(CFL_WATTS, CFL_COST, i);
            bulbCost(LED_WATTS, LED_COST, i);
            System.out.println();
        }
    }
    /**
     * Prints the energy cost and total cost (energy cost plus retail price of bulb)
     * of a given bulb.
     * @param bulbWatts wattage of bulb being used.
     * @param bulbInitialCost retail cost of bulb being used.
     * @param hoursInUse hours the given bulb has been in use.
     */
    public static void bulbCost(int bulbWatts, double bulbInitialCost, int hoursInUse) {
        //calculates and prints energy cost for a given bulb
        System.out.printf("%9.2f", calculateEnergyCost(bulbWatts, hoursInUse, CENTS_PER_KWH));
        //calculates and prints total cost (energy cost plus retail price of bulb) for a given bulb
        System.out.printf("%9.2f", calculateEnergyCost(bulbWatts, hoursInUse, CENTS_PER_KWH)
                + bulbInitialCost);
    }
    /**
     * Calculates the energy cost <i>in dollars</i>
     * @param watts number of watts
     * @param hours number of hours
     * @param centsPerKWH cost of energy in cents per kilowatt-hour
     * @return energy cost in dollars
     */
    public static double calculateEnergyCost(int watts, int hours, double centsPerKWH) {
        double energyCost;
        energyCost = (watts * hours * centsPerKWH) / (WATTS_PER_KW * CENTS_PER_DOLLAR);
        return energyCost;
    }
}
