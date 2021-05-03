/**
 * Tests CostAnalysis program
 * @author Suzanne Balik
 */
public class CostAnalysisTest {

    /**
     * Tests calculateEnergyCost method
     * @param args command line arguments
     */
    public static void main(String[] args) {
        double cost = CostAnalysis.calculateEnergyCost(65, 23, 8.9);
        System.out.println("Expected: 0.133055 Actual: " + cost);
    }
}
