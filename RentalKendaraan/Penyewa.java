public class Penyewa {
    private String nama;
    private Kendaraan kendaraanDisewa;

    public Penyewa(String nama, Kendaraan kendaraanDisewa) {
        this.nama = nama;
        this.kendaraanDisewa = kendaraanDisewa;
    }

    public String getDetail() {
        return "Nama Penyewa: " + nama + "\n" + kendaraanDisewa.getDetail();
    }
}
