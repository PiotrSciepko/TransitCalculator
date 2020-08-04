package TransitCalculator;

import java.util.Arrays;

public class TransitCalculator {

    int numberOfDays;
    int numberOfExpectedRides;

    public TransitCalculator(int numberOfDays, int numberOfExpectedRides) {
        this.numberOfDays = numberOfDays;
        this.numberOfExpectedRides = numberOfExpectedRides;
    }

    double payPerRideFee = 2.75;
    double unlimited7Fee = 33.0;
    double unlimited30Fee = 127.0;

    public double unlimited7Price() {

        int numberOfU7;

        if (this.numberOfDays % 7 == 0) {
            numberOfU7 = numberOfDays / 7;
        } else {
            numberOfU7 = numberOfDays / 7 + 1;
        }
        return numberOfU7 * unlimited7Fee / numberOfExpectedRides;
    }

    public double[] getRidePrices() {

        double[] priceOptionsPerRide = new double[3];

        priceOptionsPerRide[0] = payPerRideFee * numberOfDays;
        priceOptionsPerRide[1] = unlimited7Price();
        priceOptionsPerRide[2] = unlimited30Fee;

        return priceOptionsPerRide;
    }

    public static void main(String[] args) {

        TransitCalculator t1 = new TransitCalculator(6, 14);
        System.out.println(Arrays.toString(t1.getRidePrices()));

    }
}
