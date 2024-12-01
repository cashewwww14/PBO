public class Kendaraan {
    private String merk;
    private String model;
    private int tahunProduksi;
    private boolean tersedia;

    public Kendaraan(String merk, String model, int tahunProduksi) {
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
        this.tersedia = true;
    }

    public String getDetail() {
        return "Merk: " + merk + ", Model: " + model + ", Tahun Produksi: " + tahunProduksi +
               ", Status: " + (tersedia ? "Tersedia" : "Tidak Tersedia");
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}
