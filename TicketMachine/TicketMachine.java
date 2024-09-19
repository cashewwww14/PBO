public class TicketMachine {
    private int price;
    private int balance;
    private int total;

    public TicketMachine(int ticketPrice) {
        price = ticketPrice;
        balance = 0;
        total = 0;
    }

    public int getHarga() {
        return price;
    }

    public int getSaldo() {
        return balance;
    }

    public void masukkanUang(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Masukkan jumlah yang valid.");
        }
    }

    public void printTiket() {
        if (balance >= price) {
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            total += price;
            balance -= price;
        } else {
            int kurang = price - balance;
            System.out.println("Saldo tidak cukup. Tambahkan " + kurang + " cents.");
        }
    }

    public int kembalian() {
        int refundAmount = balance;
        balance = 0;
        System.out.println("Mengembalikan saldo: " + refundAmount + " cents.");
        return refundAmount;
    }

    public int getTotal() {
        return total;
    }
}
