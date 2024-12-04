import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Ticket> reservations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Sistem Reservasi Tiket Pesawat =====");
        System.out.print("Masukkan harga dasar untuk tiket: ");
        double baseFare = scanner.nextDouble();

        int choice;

        do {
            System.out.println("\n===== Menu Utama =====");
            System.out.println("1. Beli Tiket");
            System.out.println("2. Lihat Reservasi");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan Anda (1/2/3): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    buyTicket(scanner, baseFare);
                    break;
                case 2:
                    viewReservations(baseFare);
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem kami. Selamat tinggal!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void buyTicket(Scanner scanner, double baseFare) {
        scanner.nextLine();

        System.out.println("\n===== Pembelian Tiket =====");
        System.out.println("Pilih kelas penerbangan:");
        System.out.println("1. Economy");
        System.out.println("   Fasilitas: Bagasi 20kg, Makanan ringan");
        System.out.println("   Harga Akhir: $" + new EconomyTicket("", baseFare).calculateFare());
        System.out.println("2. Business");
        System.out.println("   Fasilitas: Bagasi 30kg, Makanan lengkap, Kursi lebih luas");
        System.out.println("   Harga Akhir: $" + new BusinessTicket("", baseFare).calculateFare());
        System.out.println("3. First Class");
        System.out.println("   Fasilitas: Bagasi 40kg, Makanan premium, Kursi mewah, Layanan khusus");
        System.out.println("   Harga Akhir: $" + new FirstClassTicket("", baseFare).calculateFare());
        System.out.print("Masukkan pilihan Anda (1/2/3): ");
        int classChoice = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Masukkan nama penumpang: ");
        String passengerName = scanner.nextLine();

        Ticket ticket;

        switch (classChoice) {
            case 1:
                ticket = new EconomyTicket(passengerName, baseFare);
                break;
            case 2:
                ticket = new BusinessTicket(passengerName, baseFare);
                break;
            case 3:
                ticket = new FirstClassTicket(passengerName, baseFare);
                break;
            default:
                System.out.println("Pilihan tidak valid. Tiket Economy akan dipilih secara default.");
                ticket = new EconomyTicket(passengerName, baseFare);
        }

        reservations.add(ticket);
        System.out.println("Tiket berhasil dipesan untuk " + passengerName + " dengan tarif akhir: $" + ticket.calculateFare());
    }

    private static void viewReservations(double baseFare) {
        System.out.println("\n===== Daftar Reservasi =====");
        if (reservations.isEmpty()) {
            System.out.println("Belum ada tiket yang dipesan.");
            return;
        }

        System.out.println("+-----------------------+------------------+------------+--------------------+------------+");
        System.out.println("| Nama Pembeli          | Kelas Penerbangan | Harga Awal | Diskon/Tambahan    | Harga Akhir|");
        System.out.println("+-----------------------+------------------+------------+--------------------+------------+");

        for (Ticket ticket : reservations) {
            double finalFare = ticket.calculateFare();
            double adjustment = finalFare - baseFare;
            String adjustmentString = adjustment < 0 ? String.format("-$%.2f", Math.abs(adjustment)) 
                                                     : String.format("+$%.2f", adjustment);

            System.out.printf("| %-21s | %-16s | $%-10.2f | %-18s | $%-10.2f |\n",
                    ticket.getPassengerName(),
                    ticket.getClass().getSimpleName().replace("Ticket", ""),
                    baseFare,
                    adjustmentString,
                    finalFare);
        }

        System.out.println("+-----------------------+------------------+------------+--------------------+------------+");
    }
}
