import java.util.ArrayList;
import java.util.Scanner;

public class RentalKendaraan {
    private ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
    private ArrayList<Penyewa> daftarPenyewa = new ArrayList<>();

    public void tambahKendaraan(Kendaraan kendaraan) {
        daftarKendaraan.add(kendaraan);
    }

    public void tambahPenyewa(Penyewa penyewa) {
        daftarPenyewa.add(penyewa);
    }

    public void tampilkanKendaraan() {
        System.out.println("Daftar Kendaraan yang Tersedia:");
        int nomor = 1;
        for (Kendaraan kendaraan : daftarKendaraan) {
            System.out.println(nomor + ". " + kendaraan.getDetail());
            nomor++;
        }
    }

    public void tampilkanPenyewa() {
        System.out.println("Daftar Penyewa dan Kendaraan yang Disewa:");
        int nomor = 1;
        for (Penyewa penyewa : daftarPenyewa) {
            System.out.println(nomor + ". " + penyewa.getDetail().replace(", Status: Tidak Tersedia", ""));
            nomor++;
        }
    }

    public static void main(String[] args) {
        RentalKendaraan rental = new RentalKendaraan();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistem Rental Kendaraan ===");

        while (true) {
            System.out.println("\nPilih opsi:");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Tambah Penyewa");
            System.out.println("3. Tampilkan Kendaraan");
            System.out.println("4. Tampilkan Penyewa");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline

            if (pilihan == 1) {
                System.out.print("Masukkan tipe kendaraan (Mobil/Motor/Sepeda): ");
                String tipe = scanner.nextLine();
                System.out.print("Masukkan merk: ");
                String merk = scanner.nextLine();
                System.out.print("Masukkan model: ");
                String model = scanner.nextLine();
                System.out.print("Masukkan tahun produksi: ");
                int tahun = scanner.nextInt();
                scanner.nextLine();

                if (tipe.equalsIgnoreCase("Mobil")) {
                    System.out.print("Masukkan jumlah roda: ");
                    int roda = scanner.nextInt();
                    scanner.nextLine();
                    rental.tambahKendaraan(new Mobil(merk, model, tahun, roda));
                } else if (tipe.equalsIgnoreCase("Motor")) {
                    System.out.print("Masukkan jumlah roda: ");
                    int roda = scanner.nextInt();
                    scanner.nextLine();
                    rental.tambahKendaraan(new Motor(merk, model, tahun, roda));
                } else if (tipe.equalsIgnoreCase("Sepeda")) {
                    System.out.print("Masukkan jenis sepeda: ");
                    String jenis = scanner.nextLine();
                    rental.tambahKendaraan(new Sepeda(merk, model, tahun, jenis));
                } else {
                    System.out.println("Tipe kendaraan tidak dikenal!");
                }
            } else if (pilihan == 2) {
                System.out.print("Masukkan nama penyewa: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan nomor kendaraan (1 - " + rental.daftarKendaraan.size() + "): ");
                int nomor = scanner.nextInt() - 1;
                scanner.nextLine();

                if (nomor >= 0 && nomor < rental.daftarKendaraan.size()) {
                    Kendaraan kendaraanDipilih = rental.daftarKendaraan.get(nomor);
                    if (kendaraanDipilih.isTersedia()) {
                        Penyewa penyewa = new Penyewa(nama, kendaraanDipilih);
                        rental.tambahPenyewa(penyewa);
                        kendaraanDipilih.setTersedia(false);
                        System.out.println("Kendaraan berhasil disewa!");
                    } else {
                        System.out.println("Kendaraan yang dipilih tidak tersedia. Silakan pilih kendaraan lain.");
                    }
                } else {
                    System.out.println("Nomor kendaraan tidak valid!");
                }
            } else if (pilihan == 3) {
                rental.tampilkanKendaraan();
            } else if (pilihan == 4) {
                rental.tampilkanPenyewa();
            } else if (pilihan == 5) {
                System.out.println("Terima kasih telah menggunakan sistem rental!");
                break;
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }

        scanner.close();
    }
}
