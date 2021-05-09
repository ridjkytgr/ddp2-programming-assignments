package assignments.assignment3;

class ElemenKantin extends ElemenFasilkom {
    
    /* TODO: Silahkan menambahkan visibility pada setiap method dan variabel apabila diperlukan */

    private Makanan[] daftarMakanan = new Makanan[10];

    private int jumlahMakanan;

    public ElemenKantin(String nama) {
        /* TODO: implementasikan kode Anda di sini */
        super("ElemenKantin", nama);
    }

    public boolean validateMakanan (String nama) {
        for (int i = 0; i < 10; i++) {
            if (daftarMakanan[i] != null && daftarMakanan[i].equals(nama)) {
                return true;
            }
        }
        return false;
    }

    public void setMakanan(String nama, long harga) {
        /* TODO: implementasikan kode Anda di sini */
        if (validateMakanan(nama)) {
            System.out.printf("[DITOLAK] %s sudah pernah terdaftar", nama);
        }
        else {
            Makanan makanan = new Makanan(nama, harga);
            daftarMakanan[jumlahMakanan] = makanan;
            jumlahMakanan++;
            System.out.printf("%s telah mendaftarkan makanan %s dengan harga %d", this.getNama(), nama, harga);
        }
    }

    public Makanan getMakanan(String nama) {
        for (int i = 0; i < 10; i++) {
            if (daftarMakanan[i] != null && daftarMakanan[i].equals(nama)) {
                return daftarMakanan[i];
            }
        }
        return null;
    }

    public boolean cekKetersediaanMakanan (String namaMakanan) {
        for (int i = 0; i < 10; i++) {
            if (daftarMakanan[i] != null && daftarMakanan[i].equals(namaMakanan)) {
                return true;
            }
        }
        return false;
    }
}