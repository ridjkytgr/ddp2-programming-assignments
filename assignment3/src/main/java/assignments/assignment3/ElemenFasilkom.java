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

    /**
     * Getter tipe dari elemen fasilkom
     * @return String tipe dari elemen fasilkom
     */
    public String getTipe() {
        return this.tipe;
    }

    /**
     * Getter nilai friendship dari elemen fasilkom
     * @return integer nilai friendship
     */
    public int getFriendship() {
        return this.friendship;
    }

    /**
     * Getter banyak orang yang telah disapa oleh suatu elemen fasilkom
     * @return integer banyak orang yang telah disapa
     */
    public int getNumOfTelahMenyapa() {
        return this.numOfTelahMenyapa;
    }

    /**
     * Mengubah nilai friendship dari elemen fasilkom
     * @param newFriendship nilai friendship baru yang akan ditambahkan/dikurangkan terhadap friendship yang lama
     */
    public void updateFriendship(int newFriendship) {
        this.friendship += newFriendship;
        if (this.friendship < 0) {
            this.friendship = 0;
        } else if (this.friendship > 100) { // Jika total friendship yang baru lebih dari 100
            this.friendship = 100;
        }
    }

    /**
     * Memvalidasi elemen fasilkom yang akan disapa
     * @param elemenFasilkom elemen fasilkom yang akan disapa
     * @return boolean true jika elemen fasilkom lolos validasi, false jika sebaliknya
     */
    public boolean validateMenyapa(ElemenFasilkom elemenFasilkom) {
        for (ElemenFasilkom arrayDisapa : telahMenyapa) {
            if (arrayDisapa != null && arrayDisapa.equals(elemenFasilkom)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Menyapa elemen fasilkom
     * @param elemenFasilkom yang akan disapa
     */
    public void menyapa(ElemenFasilkom elemenFasilkom) {
        if (validateMenyapa(elemenFasilkom)) {
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
        } else {
            System.out.printf("[DITOLAK] %s telah menyapa %s hari ini\n", this, elemenFasilkom);
        }
    }

    /**
     * Me-reset array telahMenyapa dan menjadikan setiap elemen array tersebut menjadi null
     */
    public void resetMenyapa() {
        ElemenFasilkom[] temp = new ElemenFasilkom[100];
        telahMenyapa = temp;
        numOfTelahMenyapa = 0;
    }

    /**
     * Membeli makanan yang dijual oleh elemen kantin
     * @param penjual penjual yang menjual makanan tersebut (merupakan ElemenKantin)
     * @param namaMakanan yang akan dibeli oleh pembeli
     */
    public void membeliMakanan(ElemenFasilkom penjual, String namaMakanan) {
        if (((ElemenKantin) penjual).cekKetersediaanMakanan(namaMakanan)) {
            Makanan makanan = ((ElemenKantin) penjual).getMakanan(namaMakanan);
            System.out.printf("%s berhasil membeli %s seharga %d\n", this, namaMakanan, makanan.getHarga());

            this.updateFriendship(1);
            penjual.updateFriendship(1);
        } else {
            System.out.printf("[DITOLAK] %s tidak menjual %s\n", penjual, namaMakanan);
        }
    }

    /**
     * Representasi string dari kelas ElemenFasilkom
     * @return nama dari kelas tersebut
     */
    public String toString() {
        return this.nama;
    }
}