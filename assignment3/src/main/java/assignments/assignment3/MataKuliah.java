package assignments.assignment3;

class MataKuliah {
    private String nama;
    
    private int kapasitas;

    private Dosen dosen;

    private Mahasiswa[] daftarMahasiswa;

    MataKuliah(String nama, int kapasitas) {
        /* TODO: implementasikan kode Anda di sini */
        this.nama = nama;
        this.kapasitas = kapasitas;
    }

    public Dosen getDosen() {
        return this.dosen;
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