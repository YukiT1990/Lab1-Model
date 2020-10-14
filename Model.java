package lab1;





/**
 * @author Yuki Tsukada
 */

public class Model {

    private String firstName;
    private String lastName;
    private int height;
    private double weight;
    private boolean canTravel;
    private boolean smokes;

    /**
     * The first constructor
     *  the no-arg constructor (default constructor)
     */
    public Model() {

    }

    /**
     * The second constructor
     * expect the first six fields to be passed in as parameters
     * @param firstName
     * @param lastName
     * @param height
     * @param weight
     * @param traveler
     * @param smoker
     */
    public Model(String firstName, String lastName, int height, double weight, boolean traveler, boolean smoker) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(height);
        setWeight(weight);
        setCanTravel(traveler);
        setSmokes(smoker);

    }

    /**
     * first name must be 3 to 20 characters long or else they won't be stored
     * @param firstName
     */
    public void setFirstName(String firstName) {
        if (firstName.length() >= 3 && firstName.length() <= 20) {
            this.firstName = firstName;
        } else {
            System.out.println("Invalid input: firstName must be 3-20 characters long");
        }

    }

    /**
     * last name must be 3 to 20 characters long or else they won't be stored
     * @param lastName
     */
    public void setLastName(String lastName) {
        if (lastName.length() >= 3 && lastName.length() <= 20) {
            this.lastName = lastName;
        } else {
            System.out.println("Invalid input: lastName must be 3-20 characters long");
        }

    }

    /**
     * height must be 24 to 84 inches or it won't be stored
     * @param height
     */
    public void setHeight(int height) {
        if (height >= 24 && height <= 84) {
            this.height = height;
        } else {
            System.out.println("Invalid input: height must be 24-84 inches");
        }
    }



    /**
     * Set the weight in pounds
     * weight must be 80 to 280 pounds or it won't be stored
     * @param weight pounds(lb)
     */

    public void setWeight(double weight) {
        if (weight >= 80 && weight <= 280) {
            this.weight = weight;
        } else {
            System.out.println("Invalid input: weight must be 80-280 pounds");
        }
    }

    /**
     * The third constructor
     * takes parameters for only the first name, last name, height in inches, and weight in pounds
     * this constructor will set canTravel to true and smokes to false
     * @param firstName
     * @param lastName
     * @param height
     * @param weight
     */
    public Model(String firstName, String lastName, int height, double weight) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(height);
        setWeight(weight);
        setCanTravel(true);
        setSmokes(false);

    }

    /**
     * setter for canTravel
     * @param canTravel
     */
    public void setCanTravel(boolean canTravel) {
        this.canTravel = canTravel;
    }

    /**
     * setter for smokes
     * @param smokes
     */
    public void setSmokes(boolean smokes) {
        this.smokes = smokes;
    }

    /**
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     *
     * @return canTravel
     */
    public boolean isCanTravel() {
        return canTravel;
    }

    /**
     *
     * @return smokes
     */
    public boolean isSmokes() {
        return smokes;
    }

    // magic numbers
    public static final int INCHES_PER_FOOT = 12;
    public static final double POUNDS_PER_KG = 2.2046;
    public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
    public static final int TALL_INCHES = 67;
    public static final double THIN_POUNDS = 140.0;
    public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
    public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
    public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;


    /**
     * Return the height in feet and inches
     * @return the height in feet and inches
     */
    public String getHeightInFeetAndInches() {
        int feet = height / INCHES_PER_FOOT;
        int inches = height % INCHES_PER_FOOT;
        String result = "";
        if (inches == 0) {
            result = String.format("%d feet", feet);
        } else if (inches == 1) {
            result = String.format("%d feet %d inch", feet, inches);
        } else {
            result = String.format("%d feet %d inches", feet, inches);
        }
        return result;
    }

    /**
     * convert weight from pounds to kg
     * @return
     */
    public long getWeightKg() {
        long kg = Math.round(weight / POUNDS_PER_KG);
        return kg;
    }

    /**
     * set weight from kilograms
     * @param kilograms
     */
    public void setWeight(long kilograms) {
        this.weight = (double) kilograms / POUNDS_PER_KG;
    }

    public void setHeight(int feet, int inches) {
        this.height = feet * INCHES_PER_FOOT + inches;
    }

    /**
     * Prints detail information about this Model
     */
    public void printDetails() {
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Height: " + getHeight() + " inches");
        System.out.println("Weight: " + (int) getWeight() + " pounds");
        if (canTravel == true) {
            System.out.println("Does travel");
        } else {
            System.out.println("Does not travel");
        }
        if (smokes == true) {
            System.out.println("Does smoke");
        } else {
            System.out.println("Does not smoke");
        }
    }

    /**
     * Calculates a model's per-hour pay rate and returns the amount
     * @return
     */
    public int calculatePayDollarsPerHour() {
        int payRate = BASE_RATE_DOLLARS_PER_HOUR;
        if (height >= TALL_INCHES && weight <= THIN_POUNDS) {
            payRate += TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        }
        if (canTravel == true) {
            payRate += TRAVEL_BONUS_DOLLARS_PER_HOUR;
        }
        if (smokes == true) {
            payRate -= SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
        }
        return payRate;
    }

    public void displayModelDetails() {
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Height: " + getHeightInFeetAndInches());
        String weightInOneDec = String.format("%.1f", getWeight());
        System.out.println("Weight: " + weightInOneDec + " pounds");
        if (canTravel == true) {
            System.out.println("Travels: yep");
        } else {
            System.out.println("Travels: nope");
        }
        if (smokes == true) {
            System.out.println("Smokes: yep");
        } else {
            System.out.println("Smokes: nope");
        }
        System.out.println("Hourly rate: $" + calculatePayDollarsPerHour());
    }

}
