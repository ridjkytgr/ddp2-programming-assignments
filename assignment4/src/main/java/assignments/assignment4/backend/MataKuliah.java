package assignments.assignment4.backend;

public class MataKuliah {
    private String kode;
    private String nama;
    private int sks;
    private int kapasitas;
    private int jumlahMahasiswa;
    private Mahasiswa[] daftarMahasiswa;

    public MataKuliah(String kode, String nama, int sks, int kapasitas){
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.kapasitas = kapasitas;
        this.jumlahMahasiswa = 0;
        this.daftarMahasiswa = new Mahasiswa[kapasitas];
    }

    public String getKode(){
        return this.kode;
    }

    public String getNama(){
        return this.nama;
    }
    
    public int getSKS(){
        return this.sks;
    }

    public int getKapasitas(){
        return this.kapasitas;
    }

    public int getJumlahMahasiswa(){
        return this.jumlahMahasiswa;
    }

    public Mahasiswa[] getDaftarMahasiswa(){
        return this.daftarMahasiswa;
    }

    public String toString() {
        return this.nama;
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        daftarMahasiswa[jumlahMahasiswa] = mahasiswa;
        this.jumlahMahasiswa += 1;
    }

    public void dropMahasiswa(Mahasiswa mahasiswa) {
        int indeksMahasiswa = cekIndeks(mahasiswa);
        for(int i=indeksMahasiswa; i<this.jumlahMahasiswa-1; i++){
            this.daftarMahasiswa[i] = this.daftarMahasiswa[i+1];
        }
        this.daftarMahasiswa[jumlahMahasiswa-1] = null;
        this.daftarMahasiswa[kapasitas-1] = null;
        this.jumlahMahasiswa -= 1;
    }

    private int cekIndeks(Mahasiswa mahasiswa){
        int indeks = 0;
        for(int i=0; i<this.kapasitas; i++){
            if(this.daftarMahasiswa[i].getNpm() == mahasiswa.getNpm()){
                indeks = i;
                break;
            }
        }
        return indeks;
    }
}
