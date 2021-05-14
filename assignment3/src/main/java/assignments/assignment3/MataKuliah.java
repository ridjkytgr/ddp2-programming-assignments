package assignments.assignment3;

class MataKuliah {
    private int kapasitas;

    public int jumlahMahasiswa;

    private Dosen dosen;

    private String nama;

    private Mahasiswa[] daftarMahasiswa;

    MataKuliah(String nama, int kapasitas) {
        /* TODO: implementasikan kode Anda di sini */
        this.nama = nama;
        this.kapasitas = kapasitas;
    }

    public Dosen getDosen() {
        return this.dosen;
    }

    public int getKapasitas() {
        return this.kapasitas;
    }

    public int getJumlahMahasiswa() {
        return this.jumlahMahasiswa;
    }

    public boolean dosenIsExist() {
        if (this.dosen != null) {
            return true;
        } else {
            return false;
        }
    }

    void addMahasiswa(Mahasiswa mahasiswa) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void dropMahasiswa(Mahasiswa mahasiswa) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void addDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    void dropDosen() {
        this.dosen = null;
    }

    public String toString() {
        /* TODO: implementasikan kode Anda di sini */
        return this.nama;
    }
}