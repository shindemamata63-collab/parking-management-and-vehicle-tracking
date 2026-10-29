
public class ParkingManagement {

    static double calculateBaseFee(int hours) {
        return hours * 20.0;
    }

    static double calculateVehicleSurcharge(
            String vehicleType, double baseFee) {

        double rate = 0;

        if (vehicleType.equalsIgnoreCase("car")) {
            rate = 0.20;
        } else if (vehicleType.equalsIgnoreCase("bike")) {
            rate = 0.10;
        } else if (vehicleType.equalsIgnoreCase("van")) {
            rate = 0.30;
        }

        return baseFee + (baseFee * rate);
    }

    static double calculateTrackingFee(boolean trackingEnabled) {
        if (trackingEnabled) {
            return 50.0;
        }
        return 0.0;
    }

    static double totalParkingBill(
            int hours, String vehicleType,
            boolean trackingEnabled) {

        double baseFee = calculateBaseFee(hours);

        double vehicleAmount =
                calculateVehicleSurcharge(vehicleType, baseFee);

        double trackingFee =
                calculateTrackingFee(trackingEnabled);

        return vehicleAmount + trackingFee;
    }

    static double calculateFinalParkingFee(
            int hours, String vehicleType,
            boolean trackingEnabled) {

        double total = totalParkingBill(
                hours, vehicleType, trackingEnabled);

        if (hours >= 5) {
            total = total - (total * 0.10);
        }

        return total;
    }

    public static void main(String[] args) {

        int hours = 5;
        String vehicleType = "car";
        boolean trackingEnabled = true;

        double baseFee = calculateBaseFee(hours);
        double vehicleAmount =
                calculateVehicleSurcharge(vehicleType, baseFee);
        double surcharge = vehicleAmount - baseFee;
        double trackingFee =
                calculateTrackingFee(trackingEnabled);
        double total = totalParkingBill(
                hours, vehicleType, trackingEnabled);
        double discount = hours >= 5 ? total * 0.10 : 0;
        double finalFee = calculateFinalParkingFee(
                hours, vehicleType, trackingEnabled);

        System.out.printf("Base fee = %.2f%n", baseFee);
        System.out.printf("Surcharge = %.2f%n", surcharge);
        System.out.printf("Tracking fee = %.2f%n", trackingFee);
        System.out.printf("Total before discount = %.2f%n", total);
        System.out.printf("Discount = %.2f%n", discount);
        System.out.printf("Final payable fee = %.2f%n", finalFee);
    }
}

