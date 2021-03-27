package assignments.assignment2;

public class Mahasiswa {
    private MataKuliah[] mataKuliah = new MataKuliah[10];
    private String[] masalahIRS;
    private int totalSKS;
    private String nama;
    private String jurusan;
    private long npm;

    public Mahasiswa(String nama, long npm){
        this.nama = nama;
        this.npm = npm;

        String npmString = Long.toString(npm);
        if (npmString.substring(2,4).equals("01")) {
            this.jurusan = "Ilmu Komputer";
        } else if (npmString.substring(2,4).equals("02")) {
            this.jurusan = "Sistem Informasi";
        }
    }

    public int getTotalSKS() {
        return totalSKS;
    }

    public String[] getMasalahIRS() {
        return masalahIRS;
    }

    public String jurusan() {
        return jurusan;
    }

    public long getNpm() {
        return npm;
    }

    public void addMatkul(MataKuliah mataKuliah){
        /* TODO: implementasikan kode Anda di sini */
    }

    public void dropMatkul(MataKuliah mataKuliah){
        /* TODO: implementasikan kode Anda di sini */
    }

    /* TODO: SKIP, kerjain nanti aja */
    public void cekIRS(){
        int counterKode = 1;
        boolean statusSKS = true;
        /* TODO: implementasikan kode Anda di sini */
        for (int i = 0; i < mataKuliah.length; i++) {
            if (!mataKuliah[i].getKode().equals(this.jurusan)) {
                counterKode *= 0;
            }
        }
        if (this.getTotalSKS() > 24) {
            statusSKS = false;
        }
        if (counterKode == 1 && statusSKS) {
            System.out.println("IRS tidak bermasalah");
        }
    }

    public String toString() {
        return nama;
    }

}
