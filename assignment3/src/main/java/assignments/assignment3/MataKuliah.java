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

    public Dosen getDosen() {
        return this.dosen;
    }

    public int getKapasitas() {
        return this.kapasitas;
    }

    public int getJumlahMahasiswa() {
        return this.jumlahMahasiswa;
    }

    public Mahasiswa[] getDaftarMahasiswa() {
        return this.daftarMahasiswa;
    }

    public boolean dosenIsExist() {
        if (this.dosen != null) {
            return true;
        } else {
            return false;
        }
    }

    void addMahasiswa(Mahasiswa mahasiswa) {
        daftarMahasiswa[jumlahMahasiswa++] = mahasiswa;
    }

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

    void addDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    void dropDosen() {
        this.dosen = null;
    }

    public String toString() {
        return this.nama;
    }
}