public class FirstClassTicket extends Ticket {
    public FirstClassTicket(String passengerName, double baseFare) {
        super(passengerName, baseFare);
    }

    @Override
    public double calculateFare() {
        return getBaseFare() * 1.5; // 50% additional charge
    }
}
