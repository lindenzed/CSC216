import java.util.*;
/**
 *This program prompts the user for a number of students. It then prompts the
 *user to enter a average grade for each student. After each average grade is
 *entered the program then outputs the letter grade for that students
 *average before going on to the next student. This is done with
 *if/else if/else if/else if/else method nested inside a for loop.
 *
 * @author Zach Giles
 *
 * @version 28Jan2020
 */
public class CalculateGrade {

    /**
     * Defines lower boundary for "A" letter grade.
     */
    public static final double A_LOWER_BOUND = 90.0;
    /**
     * Defines lower boundary for "B" letter grade.
     */
    public static final double B_LOWER_BOUND = 80.0;
    /**
     * Defines lower boundary for "C" letter grade.
     */
    public static final double C_LOWER_BOUND = 70.0;
    /**
     * Defines lower boundary for "D" letter grade.
     */
    public static final double D_LOWER_BOUND = 60.0;
    /**
     * Starts the program.
     * @param args Command line arguments (not used). 
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("\nEnter number of students: ");
        int students = console.nextInt();
        for (int i = 1; i <= students; i++) {
            System.out.print("\nEnter average for student " + i + ": ");
            double studentAverage = console.nextDouble();
            System.out.println("Grade for student " + i + ": "
                    + calculateLetterGrade(studentAverage));
        }
    }
    /**
     * Determines the letter grade from an inputed average.
     * @param average students average.
     * @return letter grade.
     */
    public static String calculateLetterGrade (double average) {
        String stringAverage = "";
        if (average >= A_LOWER_BOUND) {
            stringAverage = "A";
        }
        else if (average < A_LOWER_BOUND && average >= B_LOWER_BOUND) {
            stringAverage = "B";
        }
        else if (average < B_LOWER_BOUND && average >= C_LOWER_BOUND) {
            stringAverage = "C";
        }
        else if (average < C_LOWER_BOUND && average >= D_LOWER_BOUND) {
            stringAverage = "D";
        }
        else {
            stringAverage = "F";
        }
        return stringAverage;
    }
}