import java.util.*;
/**
Creates a program that calculates the daily calories needed for people who 
engage in light exercise 1-3 times per a week.  The program uses height,
weight, gender, and age to perform the calculation.

@author Zach Giles

@version 09FEB2020
*/
public class CalorieCalculator {
    /**
    Class constant that defines the "Light Activity" factor.
    */
    public static final double LIGHT_ACTIVITY_FACTOR = 1.375;
    /**
    Class constant that defines the "Male BMR" constant.
    */
    public static final int MALE_BMR_CONSTANT = 66;
    /**
    Class constant that defines the "Female BMR" constant.
    */
    public static final int FEMALE_BMR_CONSTANT = 655;
    /**
    Class constant that defines the "Male Weight" coefficient.
    */
    public static final double MALE_WEIGHT_COEFFICIENT = 6.23;
    /**
    Class constant that defines the "Female Weight" coefficient.
    */
    public static final double FEMALE_WEIGHT_COEFFICIENT = 4.35;
    /**
    Class constant that defines the "Male Height" coefficient.
    */
    public static final double MALE_HEIGHT_COEFFICIENT = 12.7;
    /**
    Class constant that defines the "Female Height" coefficient.
    */
    public static final double FEMALE_HEIGHT_COEFFICIENT = 4.7;
    /**
    Class constant that defines the "Male Age" coefficient.
    */
    public static final double MALE_AGE_COEFFICIENT = 6.8;
    /**
    Class constant that defines the "Female Age" coefficient.
    */
    public static final double FEMALE_AGE_COEFFICIENT = 4.7;
    /**
    Prompts the user for gender, weight in lbs, height in inches, and age in years.
    @param args Command line arguments (not used).
    */
    public static void main(String[] args) {
        String userGender;
        double userWeight;
        int userHeight;
        int userAge;
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter your gender (m/f): ");
        userGender = console.next();
        System.out.print("Please enter your weight in pounds: ");
        userWeight = console.nextDouble();
        System.out.print("Please enter your height in inches: ");
        userHeight = console.nextInt();
        System.out.print("Please enter your age in years: ");
        userAge = console.nextInt();
        System.out.println("Your daily calorie requirment is: " + calculateCalories(userGender,
                userWeight, userHeight, userAge));
    }
    /**
    Calculates the calories needed for a given gender, weight, height, and age
    for an individual that engage in exercise 1-3 times per a week.
    @param gender The gender of the individual.
    @param weight The weight of the individual in lbs.
    @param height The height of the individual in inches.
    @param age The age of the individual in years.
    @return calories The needed calories for the individual.
    @throw Throws illegal argument exception if any of the numerical values are less
        than or equal to zero, or if the gender is not "m", "f", "M", or "F".
    */
    public static double calculateCalories(String gender,
            double weight, int height, int age) {
        double calories;
        gender = gender.toLowerCase();
        if (gender.charAt(0) != 'f' && gender.charAt(0) != 'm' || gender.length() > 1) {
            throw new IllegalArgumentException("gender must be \"M\",\"m\", \"F\", or \"f\".");
        }
        if (weight <= 0 ) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than 0");
        }
        if (gender.charAt(0) == 'f') {
            calories = LIGHT_ACTIVITY_FACTOR * (FEMALE_BMR_CONSTANT
                   + (FEMALE_WEIGHT_COEFFICIENT * weight)
                   + (FEMALE_HEIGHT_COEFFICIENT * height)
                   - (FEMALE_AGE_COEFFICIENT * age));
        }
        else {
            calories = LIGHT_ACTIVITY_FACTOR * (MALE_BMR_CONSTANT
                    + (MALE_WEIGHT_COEFFICIENT * weight)
                    + (MALE_HEIGHT_COEFFICIENT * height)
                    - (MALE_AGE_COEFFICIENT * age));
        }
        return calories;
    }
}

/*
Women: 
Daily Calorie Requirement for Light Activity = 1.375 * BMR (Basal Metabolic Rate)
BMR = 655 + ( 4.35 x weight in pounds ) + ( 4.7 x height in inches ) - ( 4.7 x age in years )

Men: 
Daily Calorie Requirement for Light Activity = 1.375 * BMR (Basal Metabolic Rate)
BMR = 66 + ( 6.23 x weight in pounds ) + ( 12.7 x height in inches ) - ( 6.8 x age in year )


Based on http://www.bmi-calculator.net/bmr-calculator/harris-benedict-equation/ 
*/