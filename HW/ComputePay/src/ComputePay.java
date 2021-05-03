/**
 *Computes employees pay based on hours worked, and hourly salary.
 *The program then computes taxes owed at a given tax rate.
 *
 *@author Reges and Stepp
 * @author Zach Giles
 *
 * @version 15Jan2020
 */
public class ComputePay {

    /**
     * Starts the program.
     * 
     * @param args (not used)
     */
    
    public static void main(String[] args) {
        
        /**
         * Declares and assigns int hourWorked to expression 
         * of hours recorded.
         */
        
        int hoursWorked = 4 + 5 + 8 + 4;
        
        /**
         * Declares and assigns double hourlySalary to salary given in problem.
         */
        
        double hourlySalary = 8.75;
        
        /**
         * Declares and assigns double totalPay to expression containing
         * the total hours worked multiplied by the hourly salary.
         */
        
        double totalPay = hoursWorked * hourlySalary;
        
        /**
         * Declares and assigns double tax rate to the tax rate given in the problem.
         */
        
        double taxRate = 0.2;
        
        /**
         * Declares and assigns double taxes to an expression of the total pay and tax
         * rate to calculate taxes paid.
         */
        
        double taxes = totalPay * taxRate;
        
        System.out.println("My total hours worked:\n" + hoursWorked
                + "\nMy hourly salary:\n" + "$" + hourlySalary + "\nMy total pay:\n"
                + "$" + totalPay + "\nMy taxes owed:\n" + "$" + taxes);
    }
}
