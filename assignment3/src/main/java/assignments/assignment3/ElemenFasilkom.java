package assignments.assignment3;

abstract class ElemenFasilkom {

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

    public String getTipe() {
        return this.tipe;
    }

    public int getFriendship() {
        return this.friendship;
    }

    public int getNumOfTelahMenyapa() {
        return this.numOfTelahMenyapa;
    }

    public void updateFriendship(int newFriendship) {
        this.friendship += newFriendship;
        if (this.friendship < 0) {
            this.friendship = 0;
        } else if (this.friendship > 100) { // Jika total friendship yang baru lebih dari 100
            this.friendship = 100;
        }
    }

    public boolean validateMenyapa(ElemenFasilkom elemenFasilkom) {
        for (ElemenFasilkom arrayDisapa : telahMenyapa) {
            if (arrayDisapa != null && arrayDisapa.equals(elemenFasilkom)) {
                return false;
            }
        }
        return true;
    }

    public void menyapa(ElemenFasilkom elemenFasilkom) {
        if (this.validateMenyapa(elemenFasilkom)) {
            // Saling menambahkan satu sama lain pada array telahMenyapa
            this.telahMenyapa[numOfTelahMenyapa++] = elemenFasilkom;
            elemenFasilkom.telahMenyapa[elemenFasilkom.numOfTelahMenyapa++] = this;
            System.out.printf("%s menyapa dengan %s\n", this, elemenFasilkom);

            // Jika saling sapa menyapa antara dosen dengan mahasiswa
            if (this.getTipe().equals("Dosen") && elemenFasilkom.getTipe().equals("Mahasiswa")) {
                ((Dosen) this).dosenMenyapaMahasiswa((Mahasiswa) elemenFasilkom);
            } else if (this.getTipe().equals("Mahasiswa") && elemenFasilkom.getTipe().equals("Dosen")) {
                ((Dosen) elemenFasilkom).dosenMenyapaMahasiswa((Mahasiswa) this);
            }

            // Jika saling sapa menyapa antara elemenFasilkom dengan kantin
            else if (this.getTipe().equals("ElemenKantin")) {
                ((ElemenKantin) this).kantinMenyapa(elemenFasilkom);
            } else if (elemenFasilkom.getTipe().equals("ElemenKantin")) {
                ((ElemenKantin) elemenFasilkom).kantinMenyapa(this);
            }
        } else {
            System.out.printf("[DITOLAK] %s telah menyapa %s hari ini\n", this, elemenFasilkom);
        }
    }

    public void resetMenyapa() {
        ElemenFasilkom[] temp = new ElemenFasilkom[100];
        telahMenyapa = temp;
    }

    public void membeliMakanan(ElemenFasilkom penjual, String namaMakanan) {
        // Memeriksa apakah nama makanan ada di daftarMakanan
        if (((ElemenKantin) penjual).cekKetersediaanMakanan(namaMakanan)) {
            Makanan makanan = ((ElemenKantin) penjual).getMakanan(namaMakanan);
            System.out.printf("%s berhasil membeli %s seharga %d\n", this, namaMakanan, makanan.getHarga());
        } else {
            System.out.printf("[DITOLAK] %s tidak menjual %s\n", penjual, namaMakanan);
        }
    }

    public String toString() {
        return this.nama;
    }
}