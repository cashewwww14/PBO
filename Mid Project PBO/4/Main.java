import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodOrder order = new FoodOrder();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1. Tambah Menu Item");
            System.out.println("2. Hapus Menu Item");
            System.out.println("3. Tampilkan Order");
            System.out.println("4. Bayar");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Membersihkan buffer

            switch (option) {
                case 1:
                    System.out.print("Nama item: ");
                    String name = scanner.nextLine();
                    System.out.print("Harga item: ");
                    double price = scanner.nextDouble();
                    MenuItem newItem = new MenuItem(name, price);
                    order.addMenuItem(newItem);
                    System.out.println("Item ditambahkan.");
                    break;
                case 2:
                    System.out.print("Nama item yang akan dihapus: ");
                    String itemName = scanner.nextLine();
                    MenuItem toRemove = null;
                    for (MenuItem item : order.menuItems) {
                        if (item.getName().equalsIgnoreCase(itemName)) {
                            toRemove = item;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        order.menuItems.remove(toRemove);
                        System.out.println("Item dihapus.");
                    } else {
                        System.out.println("Item tidak ditemukan.");
                    }
                    break;
                case 3:
                    order.displayOrder();
                    break;
                case 4:
                    ArrayList<Integer> selectedItems = new ArrayList<>();
                    ArrayList<Integer> quantities = new ArrayList<>();
                    System.out.print("Masukkan jumlah jenis menu yang ingin dibayar: ");
                    int count = scanner.nextInt();

                    for (int i = 0; i < count; i++) {
                        System.out.print("Masukkan nomor menu: ");
                        int itemNumber = scanner.nextInt();
                        System.out.print("Masukkan jumlah pesanan untuk menu tersebut: ");
                        int quantity = scanner.nextInt();
                        selectedItems.add(itemNumber);
                        quantities.add(quantity);
                    }

                    double totalPrice = order.calculateTotalPrice(selectedItems, quantities);
                    System.out.println("Total Harga: $" + totalPrice);

                    double payment = 0;
                    while (payment < totalPrice) {
                        System.out.print("Masukkan nominal uang: ");
                        double currentPayment = scanner.nextDouble();
                        payment += currentPayment;

                        if (payment < totalPrice) {
                            double deficit = totalPrice - payment;
                            System.out.println("Saldo tidak cukup. Kurang: $" + deficit);
                        }
                    }

                    if (payment == totalPrice) {
                        System.out.println("Pembayaran berhasil. Nominal Anda pas.");
                    } else {
                        double change = payment - totalPrice;
                        System.out.println("Pembayaran berhasil. Kembalian: $" + change);
                    }
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
        scanner.close();
    }
}
