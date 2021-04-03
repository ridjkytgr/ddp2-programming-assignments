package assignments.assignment2;

public class MataKuliah {
    private String kode;
    private String nama;
    private int sks;
    private int kapasitas;
    private Mahasiswa[] daftarMahasiswa;

    public MataKuliah(String kode, String nama, int sks, int kapasitas){
        /* TODO: implementasikan kode Anda di sini */
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.kapasitas = kapasitas;
        this.daftarMahasiswa = new Mahasiswa[kapasitas];
    }

    public String getKode() {
        return kode;
    }

    public int getSks() {
        return sks;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public Mahasiswa[] getDaftarMahasiswa() {
        return daftarMahasiswa;
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            if (daftarMahasiswa[i] == null) {
                this.daftarMahasiswa[i] = mahasiswa;
                break;
            }
        }
    }
    public int calcJumlahMahasiswa() {
        int jumlahMahasiswa = 0;
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            if (daftarMahasiswa[i] != null) {
                jumlahMahasiswa++;
            }
        }
        return jumlahMahasiswa;
    }

    public void dropMahasiswa(Mahasiswa mahasiswa) {
        // Membuat array baru yang berisi daftar mahasiswa yang telah di-drop
        Mahasiswa[] daftarMahasiswaDrop = new Mahasiswa[kapasitas];
        int counter = 0;
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            if (daftarMahasiswa[i] != null && !daftarMahasiswa[i].equals(mahasiswa)) {
                daftarMahasiswaDrop[counter] = daftarMahasiswa[i];
                counter++;
            } else if (daftarMahasiswa[i] == null) {
                break;
            }
        }
        daftarMahasiswa = daftarMahasiswaDrop;
    }

    public String toString() {
        return nama;
    }
}
