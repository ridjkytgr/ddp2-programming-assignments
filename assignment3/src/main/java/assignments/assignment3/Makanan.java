package assignments.assignment3;

class Makanan {
    private String nama;

    private long harga;

    public Makanan(String nama, long harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public long getHarga() {
        return this.harga;
    }

    public String toString() {
        return this.nama;
    }
}