public class Ticket {
    private String passengerName;
    private double baseFare;

    public Ticket(String passengerName, double baseFare) {
        this.passengerName = passengerName;
        this.baseFare = baseFare;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public double calculateFare() {
        return baseFare; // Default fare
    }

    @Override
    public String toString() {
        return "Passenger: " + passengerName + ", Fare: $" + calculateFare();
    }
}
