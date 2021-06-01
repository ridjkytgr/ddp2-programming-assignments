package assignments.assignment4.backend;

public class Mahasiswa {
    private MataKuliah[] mataKuliah = new MataKuliah[10];
    private String[] masalahIRS;
    private int banyakMatkul = 0;
    private int totalSKS;
    private int banyakMasalahIRS;
    private String nama;
    private String jurusan;
    private long npm;

    public Mahasiswa(String nama, long npm){
        this.nama = nama;
        this.npm = npm;
        this.jurusan = extractJurusan(npm);
    }

    public String getNama() {
        return this.nama;
    }

    public long getNpm(){
        return this.npm;
    }

    public MataKuliah[] getMataKuliah(){
        return this.mataKuliah;
    }

    public int getBanyakMatkul(){
        return this.banyakMatkul;
    }

    public int getTotalSKS(){
        return this.totalSKS;
    }


    public String getJurusan(){
        return this.jurusan;
    }

    public int getBanyakMasalahIRS(){
        return this.banyakMasalahIRS;
    }

    public String[] getMasalahIRS(){
        return this.masalahIRS;
    }

    private int cekMatkulAda(MataKuliah mataKuliah){
        for(int i=0; i<banyakMatkul; i++){
            if(this.mataKuliah[i].toString().equals(mataKuliah.toString())){
                return i;
            }
        }
        return -1;
    }
    
    public String addMatkul(MataKuliah mataKuliah){
        if (cekMatkulAda(mataKuliah) != -1) {
            return("[DITOLAK] " + mataKuliah + " telah diambil sebelumnya.");
        }
        if (mataKuliah.getJumlahMahasiswa() == mataKuliah.getKapasitas()){
            return("[DITOLAK] " + mataKuliah + " telah penuh kapasitasnya.");
        }

        if(this.banyakMatkul == 10){
            return("[DITOLAK] Maksimal mata kuliah yang diambil hanya 10.");
        }
        mataKuliah.addMahasiswa(this);
        this.mataKuliah[this.banyakMatkul] = mataKuliah;
        this.banyakMatkul++;
        this.totalSKS += mataKuliah.getSKS();
        return("[BERHASIL] Silakan cek rekap untuk melihat hasil pengecekan IRS.");
    }

    public String dropMatkul(MataKuliah mataKuliah){
        int indexMatkul = cekMatkulAda(mataKuliah);

        if (banyakMatkul == 0){
            return("[DITOLAK] Belum ada mata kuliah yang diambil.");
        }
        
        if (indexMatkul== -1) {
            return("[DITOLAK] " + mataKuliah.toString() + " belum pernah diambil.");
        }

        this.totalSKS -= this.mataKuliah[indexMatkul].getSKS();
        this.mataKuliah[indexMatkul] = null;
        mataKuliah.dropMahasiswa(this);

        for(int i=indexMatkul; i<banyakMatkul-1; i++){
            this.mataKuliah[i] = this.mataKuliah[i+1];
        }
        this.mataKuliah[9] = null;
        this.mataKuliah[banyakMatkul-1] = null;

        this.banyakMatkul--;
        return("[BERHASIL] Silakan cek rekap untuk melihat hasil pengecekan IRS.");
    }


    public String extractJurusan(long npm) {
        long kodeJurusan = (npm / 10000000000L) % 100;
        if (kodeJurusan == 1) {
            return "Ilmu Komputer";
        } else if (kodeJurusan == 2) {
            return "Sistem Informasi";
        } 
        return "";
        
    }
    

    private void cekJurusanMatkul(MataKuliah mataKuliah){
        String kodeJurusan;
        if (this.extractJurusan(this.npm).equals("Ilmu Komputer")){
            kodeJurusan = "IK";
        } else{
            kodeJurusan = "SI";
        }

        if (!(mataKuliah.getKode().equals(kodeJurusan) || mataKuliah.getKode().equals("CS"))){
            this.masalahIRS[banyakMasalahIRS] = "Mata Kuliah " + mataKuliah + " tidak dapat diambil jurusan " + kodeJurusan;
            this.banyakMasalahIRS++;
        }
    }

    public void cekIRS(){
        this.masalahIRS = new String[20];
        banyakMasalahIRS = 0;
        if (this.totalSKS > 24){
            this.masalahIRS[banyakMasalahIRS] = "SKS yang diambil lebih dari 24";
            this.banyakMasalahIRS++;
        }

        for(int i=0; i<banyakMatkul; i++){
            cekJurusanMatkul(this.mataKuliah[i]);
        }

    }

}