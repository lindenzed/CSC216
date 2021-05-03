/**
 *This project computes the position final position using a kinematic equation.
 *The initial conditions are declared as doubles and assumes SI units.
 *
 * @author Zach Giles
 *
 * @version 15Jan2020
 */

public class Position {

    /**
     * Starts the program.
     * @param args (not used).
     */
    public static void main(String[] args) {
        
        /**
         * Declares double initialPosition and assigns a value of 12.0 m.
         */
        
        double initialPosition = 12.0;
        
        /**
         * Declares double initialVelocity and assigns a value of 3.5 m/s.
         */
        
        double initialVelocity = 3.5;
        
        /**
         * Declares double acceleration and assigns a value of 4.3 m/(s^2).
         */
        
        double acceleration = 4.3;
        
        /**
         * Declares double time and assigns a value of 5.0 s.
         */
        
        double time = 5.0;
        
        /**
         * Derives the translational displacement obtained from the velocity of the body in meters.
         */
        
        double displacementFromVelocity = initialVelocity * time;
        
        /**
         * Derives the translational displacement obtained from the acceleration of 
         *the body in meters.
         */
        
        double displacementFromAcceleration = ((double) 1 / 2) * (acceleration * Math.pow(time,2));
        
        /**
         * Computes the final position by adding the translational displacement obtained from the
         * velocity and acceleration to the initial position.  Result is in meters.
         */
        
        double finalPosition = initialPosition + displacementFromVelocity 
                + displacementFromAcceleration;
        
        System.out.println("s = " + finalPosition + " m");

    }

}
