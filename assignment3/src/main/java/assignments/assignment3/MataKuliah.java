package assignments.assignment3;

class MataKuliah {
    private int kapasitas;

    public int jumlahMahasiswa;

    private Dosen dosen;

    private String nama;

    private Mahasiswa[] daftarMahasiswa;

    MataKuliah(String nama, int kapasitas) {
        this.nama = nama;
        this.kapasitas = kapasitas;
        this.daftarMahasiswa = new Mahasiswa[kapasitas];
    }

    /**
     * Getter dosen yang mengajar mata kuliah tersebut
     * @return Dosen pengajar mata kuliah tersebut
     */
    public Dosen getDosen() {
        return this.dosen;
    }

    /**
     * Getter kapasitas dari mata kuliah tersebut
     * @return integer kapasitas dari mata kuliah
     */
    public int getKapasitas() {
        return this.kapasitas;
    }

    /**
     * Getter jumlah mahasiswa yang sedang mengambil mata kuliah tersebut
     * @return integer jumlah mahasiswa yang sedang mengambil mata kuliah tersebut
     */
    public int getJumlahMahasiswa() {
        return this.jumlahMahasiswa;
    }

    /**
     * Getter array Mahasiswa[] yang berisi daftar mahasiswa-mahasiswa yang mengambil mata kuliah tersebut
     * @return array Mahasiswa[] yang berisi daftar mahasiswa-mahasiswa yang mengambil mata kuliah tersebut
     */
    public Mahasiswa[] getDaftarMahasiswa() {
        return this.daftarMahasiswa;
    }

    /**
     * Getter status keberadaan dosen yang mengajar mata kuliah tersebut
     * @return boolean true jika terdapat dosen pengajar, false jika tidak
     */
    public boolean dosenIsExist() {
        if (this.dosen != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Menambahkan mahasiswa tertentu ke dalam array daftarMahasiswa
     * @param mahasiswa yang akan dimasukkan ke dalam array
     */
    void addMahasiswa(Mahasiswa mahasiswa) {
        daftarMahasiswa[jumlahMahasiswa++] = mahasiswa;
    }

    /**
     * Mengeluarkan/membuang mahasiswa tertentu dari array daftarMahasiswa
     * @param mahasiswa yang akan dibuang dari array
     */
    void dropMahasiswa(Mahasiswa mahasiswa) {
        // Membuat array baru yang tidak berisi mahasiswa yang ingin di-drop
        Mahasiswa[] temp = new Mahasiswa[kapasitas];
        int counter = 0;
        for (Mahasiswa mahasiswaArray : daftarMahasiswa) {
            if (mahasiswaArray != null && !(mahasiswaArray.equals(mahasiswa))) {
                temp[counter++] = mahasiswaArray;
            } else if (mahasiswaArray != null && mahasiswaArray.equals(mahasiswa)){
                jumlahMahasiswa--;
            } else if (mahasiswaArray == null) {
                break;
            }
        }
        // Memindahkan reference ke array baru
        daftarMahasiswa = temp;
    }

    /**
     * Menambahkan dosen yang mengajar mata kuliah tersebut
     * @param dosen object Dosen yang mengajar mata kuliah tersebut
     */
    void addDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    /**
     * Menghapus dosen yang mengajar mata kuliah tersebut
     */
    void dropDosen() {
        this.dosen = null;
    }

    /**
     * Representasi string dari class MataKuliah
     * @return String nama dari mata kuliah tersebut
     */
    public String toString() {
        return this.nama;
    }
}