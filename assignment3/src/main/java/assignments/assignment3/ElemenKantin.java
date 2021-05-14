package assignments.assignment3;

class ElemenKantin extends ElemenFasilkom {
    private Makanan[] daftarMakanan = new Makanan[10];

    private int jumlahMakanan;

    public ElemenKantin(String nama) {
        super("ElemenKantin", nama);
    }

    public boolean validateMakanan (String nama) {
        for (Makanan makanan : daftarMakanan) {
            if (makanan != null && makanan.equals(nama)) {
                System.out.printf("[DITOLAK] %s sudah pernah terdaftar\n", nama);
                return false;
            } else if (makanan == null) {
                break;
            }
        }
        // Jika makanan tersebut belum ada di daftar makanan
        return true;
    }

    public void setMakanan(String nama, long harga) {
        if (validateMakanan(nama)) {
            Makanan makanan = new Makanan(nama, harga);
            daftarMakanan[jumlahMakanan] = makanan;
            jumlahMakanan++;
            System.out.printf("%s telah mendaftarkan makanan %s dengan harga %d", this.getNama(), nama, harga);
        }
    }

    public Makanan getMakanan(String nama) {
        for (Makanan makanan : daftarMakanan) {
            if (makanan != null && makanan.equals(nama)) {
                return makanan;
            } else if (makanan == null) {
                break;
            }
        }
        return null;
    }

    public boolean cekKetersediaanMakanan (String namaMakanan) {
        for (Makanan makanan : daftarMakanan) {
            if (makanan != null && makanan.equals(namaMakanan)) {
                return true;
            }
        }
        return false;
    }
}