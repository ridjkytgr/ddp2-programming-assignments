package assignments.assignment3;

abstract class ElemenFasilkom {
    
    /* TODO: Silahkan menambahkan visibility pada setiap method dan variabel apabila diperlukan */

    private String tipe;
    
    private String nama;

    private int friendship;

    private ElemenFasilkom[] telahMenyapa = new ElemenFasilkom[100];

    private int numOfTelahMenyapa;

    public ElemenFasilkom(String tipe, String nama) {
        this.tipe = tipe;
        this.nama = nama;
    }

    public String getNama() {
        return this.nama;
    }

    public boolean validateMenyapa(ElemenFasilkom elemenFasilkom) {
        for (int i = 0; i < numOfTelahMenyapa; i++) {
            if (telahMenyapa[i] != null && telahMenyapa[i].equals(elemenFasilkom)) {
                return true;
            }
        }
        return false;
    }

    public void menyapa(ElemenFasilkom elemenFasilkom) {
        /* TODO: implementasikan kode Anda di sini */
        if (this.validateMenyapa(elemenFasilkom)) {
            // Saling menambahkan satu sama lain pada array telahMenyapa
            this.telahMenyapa[numOfTelahMenyapa++] = elemenFasilkom;
            elemenFasilkom.telahMenyapa[elemenFasilkom.numOfTelahMenyapa++] = this;
            System.out.printf("%s menyapa dengan %s", this, elemenFasilkom);
        } else {
            System.out.printf("[DITOLAK] %s telah menyapa %s hari ini", this, elemenFasilkom);
        }
    }

    public void resetMenyapa() {
        /* TODO: implementasikan kode Anda di sini */
        for (int i = 0; i < numOfTelahMenyapa; i++) {
            telahMenyapa[i] = null;
            numOfTelahMenyapa = 0;
        }
    }

    public void membeliMakanan(ElemenFasilkom pembeli, ElemenFasilkom penjual, String namaMakanan) {
        /* TODO: implementasikan kode Anda di sini */

        // Memeriksa apakah nama makanan ada di daftarMakanan
        if (((ElemenKantin) penjual).cekKetersediaanMakanan(namaMakanan)) {
            Makanan makanan = ((ElemenKantin) penjual).getMakanan(namaMakanan);
            System.out.printf("%s berhasil membeli %s seharga %d", pembeli, namaMakanan, makanan.getHarga());
        } else {
            System.out.printf("[DITOLAK] %s tidak menjual %s", penjual, namaMakanan);
        }
    }

    public String toString() {
        return this.nama;
    }
}