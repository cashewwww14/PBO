public class ParkingTicketMachine {
    private int balance;
    private int ticketPrice;
    private int totalTimePurchased;

    public ParkingTicketMachine(int pricePerHour) {
        ticketPrice = pricePerHour;
        balance = 0;
        totalTimePurchased = 0;
    }

    public void insertMoney(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Uang sebesar " + amount + " telah ditambahkan.");
        } else {
            System.out.println("Masukkan jumlah uang yang valid.");
        }
    }

    public void issueTicket() {
        if (balance >= ticketPrice) {
            int timeBought = balance / ticketPrice;
            totalTimePurchased += timeBought;
            balance = 0;
            System.out.println("Tiket dikeluarkan untuk " + timeBought + " jam.");
        } else {
            System.out.println("Saldo tidak mencukupi untuk membeli tiket.");
        }
    }

    public int getTimePurchased() {
        return totalTimePurchased;
    }
}
