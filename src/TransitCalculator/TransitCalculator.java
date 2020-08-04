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

        priceOptionsPerRide[0] = payPerRideFee * numberOfExpectedRides;
        priceOptionsPerRide[1] = unlimited7Price();
        priceOptionsPerRide[2] = unlimited30Fee / numberOfExpectedRides;

        return priceOptionsPerRide;
    }

    public String getBestFare() {

        double[] priceOptionsPerRide = getRidePrices();
        double minFare = priceOptionsPerRide[0];
        int minIndex = 0;
        for(int i = 1;  i < priceOptionsPerRide.length; i++) {
            if (priceOptionsPerRide[i] < minFare) {
                minFare = priceOptionsPerRide[i];
                minIndex = i;
            }
        }
        if (minIndex == 0) {
            return "You should get the Pay-per-ride option at " + minFare + " per ride.";
        } else if (minIndex == 1) {
            return "You should get the 7-day Unlimited option at " + minFare + " per ride.";
        } else {
            return "You should get the 30-day Unlimited option at " + minFare + " per ride.";
        }
    }

    public static void main(String[] args) {

        TransitCalculator t1 = new TransitCalculator(22, 3);
        System.out.println(Arrays.toString(t1.getRidePrices()));
        System.out.println(t1.getBestFare());

    }
}
