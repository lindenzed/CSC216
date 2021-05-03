import java.util.*;
/**
 *The program determines the admission status (Admit, Defer, Deny), for a student.
 *The parameters that determine the admission status depend on which school the
 *student is applying to. Only questions relevant to the students choice of school
 *are asked. Error handling is done two-fold to allow for white box testing, and to
 *quit the program with a message upon invalid input. Error handling is not done to deal with 
 *improper type input (i.e. int/double). The admission status is printed to the screen
 *after all input has been acquired and verified to be valid.  I referenced the project
 *outline for the text contained in the program header.
 *
 * @author Zach Giles
 *
 * @version 22Feb2020
 */
public class Admissions {
    /**
     * Defines the minimum SAT score.
     */
    public static final int MIN_SAT_SCORE = 200;
    /**
     * Defines the maximum SAT score.
     */
    public static final int MAX_SAT_SCORE = 800;
    /**
     * Defines the minimum SAT essay score.
     */
    public static final int MIN_WRITING_SCORE = 2;
    /**
     * Defines the maximum SAT essay score.
     */
    public static final int MAX_WRITING_SCORE = 8;
    /**
     * Defines the lower boundary for the Math SAT for the engineering school.
     */
    public static final int E_MATH_SAT_CUT = 500;
    /**
     * Defines the lower boundary for the Reading/Writing SAT for the engineering school.
     */
    public static final int E_READING_SAT_CUT = 400;
    /**
     * Defines the lower GPA boundary for the engineering school.
     */
    public static final double E_GPA_CUT = 3.8;
    /**
     * Defines the lower boundary for the Math SAT engineering school Admit status.
     */
    public static final int E_MATH_SAT_SKATE = 700;
    /**
     * Defines the lower boundary for the Reading/Writing SAT engineering school Admit status.
     */
    public static final int E_READING_SAT_SKATE = 600;
    /**
     * Defines the lower boundary for the Reading/Writing SAT for the journalism school.
     */
    public static final int J_READING_SAT_CUT = 400;
    /**
     * Defines the lower boundary for the SAT essay score for the journalism school.
     */
    public static final int J_WRITING_CUT = 6;
    /**
     * Defines the lower GPA boundary for the journalism school.
     */
    public static final double J_GPA_CUT = 3.0;
    /**
     * Defines the lower boundary for the Reading/Writing SAT journalism school Admit status.
     */
    public static final int J_READING_SAT_SKATE = 600;
    /**
     * Defines the lower boundary for the SAT essay score journalism school Admit status.
     */
    public static final int J_WRITING_SKATE = 7;
    /**
     * Defines the lower GPA boundary for the school of fine arts.
     */
    public static final double F_GPA_CUT = 2.8;
    /**
     * Defines the number of alumni family members needed to promote Defer status to Admit.
     */
    public static final int ALUMNI_PROMOTE = 2;
    /**
     * Starts the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("           Welcome to the College Admission Program!\n"
                + "When prompted, please enter the applicant's name, and the school\n"
                + "to which he/she is applying - E (Engineering), J (Journalism),\n"
                + "or F (Fine Arts). Depending on the school, you will be prompted\n"
                + "to enter SAT scores (Math, Reading/Writing, Essay), high school\n"
                + "GPA (weighted/unweighted), or a Portfolio rating - E (Excellent),\n"
                + "G (Good), F (Fair), P (Poor). You will also be prompted to enter\n"
                + "the number of alumni family members.  The applicant's admission\n"
                + "status of Admit, Defer, or Deny will then be displayed\n");
        System.out.print("\nApplicant Name: ");
        String applicant = console.nextLine();
        System.out.print("E (Engineering), J (Journalism), or F (Fine Arts): ");
        String getSchool = console.next();
        char school = getSchool.charAt(0);
        if (school == 'e' || school == 'E') {
            int mathSAT = getMathSAT(console);
            int readingWritingSAT = getReadingSAT(console);
            double gpa = getGPAWeighted(console);
            int numberOfAlumni = getNumberOfAlumni(console);
            System.out.print("\nAdmission Status: "
                    + getEngineeringAdmissionStatus(mathSAT, readingWritingSAT,
                            gpa, numberOfAlumni) + "\n");
        }
        else if (school == 'j' || school == 'J') {
            int readingWritingSAT = getReadingSAT(console);
            int essayWritingSAT = getEssayWritingSAT(console);
            double gpa = getGPAUnweighted(console);
            int numberOfAlumni = getNumberOfAlumni(console);
            System.out.print("\nAdmission Status: "
                    + getJournalismAdmissionStatus(readingWritingSAT, essayWritingSAT,
                            gpa, numberOfAlumni) + "\n");
        }
        else if (school == 'f' || school == 'F') {
            char portfolioRating = getPortfolioRating(console);
            double gpa = getGPAUnweighted(console);
            int numberOfAlumni = getNumberOfAlumni(console);
            System.out.print("\nAdmission Status: "
                    + getFineArtsAdmissionStatus(portfolioRating, gpa, 
                            numberOfAlumni));
        }
        else {
            System.out.print("Invalid School");
            System.exit(1);
        }
        
        
    }

    /**
     * Determines and returns the engineering school admission status (Deny, Defer, Admit).
     * @param mathSAT Applicants Math SAT score
     * @param readingWritingSAT Applicants Reading/Writing SAT score
     * @param gpa Applicants Weighted GPA
     * @param numberOfAlumni Number of family member alumni related to applicant
     * @return Admission status
     * @throws IllegalArgumentException for invalid Math SAT score
     * @throws IllegalArgumentException for invalid Reading/Writing SAT score
     * @throws IllegalArgumentException for invalid GPA
     * @throws IllegalArgumentException for invalid number of alumni relatives
     */
    public static String getEngineeringAdmissionStatus(int mathSAT, int readingWritingSAT,
            double gpa, int numberOfAlumni) {
        String status = "";
        if (mathSAT < MIN_SAT_SCORE || mathSAT > MAX_SAT_SCORE) {
            throw new IllegalArgumentException("Invalid SAT score");
        }
        if (readingWritingSAT < MIN_SAT_SCORE || readingWritingSAT > MAX_SAT_SCORE) {
            throw new IllegalArgumentException("Invalid SAT score");
        }
        if (gpa < 0) {
            throw new IllegalArgumentException("Invalid GPA");
        }
        if (numberOfAlumni < 0) {
            throw new IllegalArgumentException("Invalid number of alumni");
        }
        if (mathSAT < E_MATH_SAT_CUT || readingWritingSAT < E_READING_SAT_CUT
                || gpa < E_GPA_CUT) {
            status = "Deny";
        }
        else if (mathSAT >= E_MATH_SAT_SKATE && readingWritingSAT >= E_READING_SAT_SKATE) {
            status = "Admit";
        }
        else if (numberOfAlumni >= ALUMNI_PROMOTE) {
            status = "Admit";
        }
        else {
            status = "Defer";
        }
        return status;
    }
  
    /**
     * Determines and returns the journalism school admission status (Deny, Defer, Admit).
     * @param readingWritingSAT Applicants Reading/Writing SAT score
     * @param essayWritingSAT Applicants SAT essay score
     * @param gpa Applicants Unweighted GPA
     * @param numberOfAlumni Number of family member alumni related to applicant.
     * @return Admission status
     * @throws IllegalArgumentException for invalid Reading/Writing SAT score
     * @throws IllegalArgumentException for invalid SAT essay score
     * @throws IllegalArgumentException for invalid GPA
     * @throws IllegalArgumentException for invalid number of alumni relatives
     */
    public static String getJournalismAdmissionStatus(int readingWritingSAT, int essayWritingSAT,
            double gpa, int numberOfAlumni) {
        String status = "";
        if (readingWritingSAT < MIN_SAT_SCORE || readingWritingSAT > MAX_SAT_SCORE) {
            throw new IllegalArgumentException("Invalid SAT score");
        }
        if (essayWritingSAT < MIN_WRITING_SCORE || essayWritingSAT > MAX_WRITING_SCORE) {
            throw new IllegalArgumentException("Invalid SAT essay score");
        }
        if (gpa < 0) {
            throw new IllegalArgumentException("Invalid GPA");
        }
        if (numberOfAlumni < 0) {
            throw new IllegalArgumentException("Invalid number of alumni");
        }
        if (readingWritingSAT < J_READING_SAT_CUT || essayWritingSAT < J_WRITING_CUT
                || gpa < J_GPA_CUT) {
            status = "Deny";
        }
        else if (readingWritingSAT >= J_READING_SAT_SKATE &&
                essayWritingSAT >= J_WRITING_SKATE) {
            status = "Admit";
        }
        else if (numberOfAlumni >= ALUMNI_PROMOTE) {
            status = "Admit";
        }
        else {
            status = "Defer";
        }
        return status;
    }
    
    /**
     * Determines and returns the fine arts school admission status (Deny, Defer, Admit).
     * @param portfolioRating Applicants portfolio rating
     * @param gpa Applicants Unweighted GPA
     * @param numberOfAlumni Number of family member alumni related to applicant.
     * @return Admission status
     * @throws IllegalArgumentException for invalid portfolio rating
     * @throws IllegalArgumentException for invalid GPA
     * @throws IllegalArgumentException for invalid number of alumni relatives
     */
    public static String getFineArtsAdmissionStatus(char portfolioRating, double gpa, 
            int numberOfAlumni) {
        String status = "";
        if (portfolioRating != 'E' && portfolioRating != 'e' && portfolioRating != 'G'
                && portfolioRating != 'g' && portfolioRating != 'F' && portfolioRating != 'f'
                && portfolioRating != 'P' && portfolioRating != 'p') {
            throw new IllegalArgumentException("Invalid portfolio rating");
        }
        if (gpa < 0) {
            throw new IllegalArgumentException("Invalid GPA");
        }
        if (numberOfAlumni < 0) {
            throw new IllegalArgumentException("Invalid number of alumni");
        }
        if (portfolioRating == 'p' || portfolioRating == 'P' || portfolioRating == 'f' ||
                portfolioRating == 'F' || gpa < F_GPA_CUT) {
            status = "Deny";
        }
        else if (portfolioRating == 'e' || portfolioRating == 'E') {
            status = "Admit";
        }
        else if (numberOfAlumni >= ALUMNI_PROMOTE) {
            status = "Admit";
        }
        else {
            status = "Defer";
        }
        return status;
    }
    
    
    /**
     * Gets the portfolio rating from user input for an applicant of the Fine Arts School.
     * @param console User input
     * @return Portfolio rating
     */
    public static char getPortfolioRating(Scanner console) {
        System.out.print("Portfolio rating (E (Exellent), G (Good), F (Fair), "
                + "or P (Poor)): ");
        String getChar = console.next();
        if (getChar.length() > 1) {
            System.out.print("Invalid portfolio rating");
            System.exit(1);
        }//ensures only one letter is entered so an input of, say, "Every" wouldn't return a portfolio rating of 'E'
        char portfolioRating = getChar.charAt(0);
        if (portfolioRating != 'E' && portfolioRating != 'e' && portfolioRating != 'G'
                && portfolioRating != 'g' && portfolioRating != 'F' && portfolioRating != 'f'
                && portfolioRating != 'P' && portfolioRating != 'p') {
            System.out.print("Invalid portfolio rating");
            System.exit(1);
        }
        return portfolioRating;
    }
    /**
     * Gets the SAT essay score for an applicant of the Journalism School.
     * @param console User input
     * @return SAT essay score
     */
    public static int getEssayWritingSAT(Scanner console) {
        System.out.print("SAT Essay Writing score (2-8): ");
        int essayWritingSAT = console.nextInt();
        if (essayWritingSAT < MIN_WRITING_SCORE || essayWritingSAT > MAX_WRITING_SCORE) {
            System.out.print("Invalid SAT essay score");
            System.exit(1);
        }
        return essayWritingSAT;
    }
    /**
     * Gets the number of alumni related to the applicant.
     * @param console User input
     * @return Number of family members that are alumni related to the applicant
     */
    public static int getNumberOfAlumni(Scanner console) {
        System.out.print("Number of alumni family members: ");
        int numberOfAlumni = console.nextInt();
        if (numberOfAlumni < 0) {
            System.out.print("Invalid number of alumni");
            System.exit(1);
        }
        return numberOfAlumni;
    }
    /**
     * Gets the applicant's unweighted GPA.
     * @param console User input
     * @return Applicant's unweighted GPA
     */
    public static double getGPAUnweighted(Scanner console) {
        System.out.print("Unweighted high school GPA: ");
        double gpa = console.nextDouble();
        if (gpa < 0) {
            System.out.print("Invalid GPA");
            System.exit(1);
        }
        return gpa;
    }
    /**
     * Gets the applicant's weighted GPA.
     * @param console User input
     * @return Applicant's weighted GPA
     */
    public static double getGPAWeighted(Scanner console) {
        System.out.print("Weighted high school GPA: ");
        double gpa = console.nextDouble();
        if (gpa < 0) {
            System.out.print("Invalid GPA");
            System.exit(1);
        }
        return gpa;
    }
    /**
     * Gets the applicant's Reading/Writing SAT score.
     * @param console User input
     * @return Applicant's Reading/Writing SAT score
     */
    public static int getReadingSAT(Scanner console) {
        System.out.print("Reading/Writing SAT Score (200-800): ");
        int readingWritingSAT = console.nextInt();
        if (readingWritingSAT < MIN_SAT_SCORE || readingWritingSAT > MAX_SAT_SCORE) {
            System.out.print("Invalid SAT score");
            System.exit(1);
        }
        return readingWritingSAT;
    }
    /**
     * Gets the applicant's Math SAT score.
     * @param console User input
     * @return Applicant's Math SAT score.
     */
    public static int getMathSAT (Scanner console) {
        System.out.print("Math SAT Score (200-800): ");
        int mathSAT = console.nextInt();
        if (mathSAT < MIN_SAT_SCORE || mathSAT > MAX_SAT_SCORE) {
            System.out.print("Invalid SAT score");
            System.exit(1);
        }
        return mathSAT;
    }
}




