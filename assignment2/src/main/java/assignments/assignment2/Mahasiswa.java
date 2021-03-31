package assignments.assignment2;

public class Mahasiswa {
    private MataKuliah[] daftarMataKuliah = new MataKuliah[10];
    private String[] masalahIRS;
    private int totalSKS;
    private String nama;
    private String jurusan;
    private long npm;

    public Mahasiswa(String nama, long npm){
        this.nama = nama;
        this.npm = npm;
        this.masalahIRS = new String[20];

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

    public String getJurusan() {
        return jurusan;
    }

    public MataKuliah[] getDaftarMataKuliah() {
        return daftarMataKuliah;
    }

    public long getNpm() {
        return npm;
    }

    public boolean validateAddMatkul(MataKuliah mataKuliah) {
        // Melakukan pengecekan jumlah mata kuliah yang telah diambil
        int numOfMataKuliah = 0;

        for (int i = 0; i < 10; i++) {
            if (daftarMataKuliah[i] != null) {
                numOfMataKuliah++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (daftarMataKuliah[i].equals(mataKuliah)) {
                System.out.println("[DITOLAK] " + daftarMataKuliah[i].toString() + "telah diambil sebelumnya");
            } else if (daftarMataKuliah[i].getKapasitas() == daftarMataKuliah[i].calcJumlahMahasiswa()) {
                System.out.println("[DITOLAK] " + daftarMataKuliah[i].toString() + "telah penuh kapasitasnya");
            } else if (numOfMataKuliah == 10) {
                System.out.println("[DITOLAK] Maksimal mata kuliah yang diambil hanya 10");
            } else {
                numOfMataKuliah += 1;
                return true;
            }
        }
        return false;
    }

    public void addMatkul(MataKuliah mataKuliah) {
        /* TODO: implementasikan kode Anda di sini */
        if (validateAddMatkul(mataKuliah)) {
            for (int i = 0; i < 10; i++) {
                if (daftarMataKuliah[i] != null) {
                    daftarMataKuliah[i] = mataKuliah;
                    break;
                }
            }
        }
    }

    public void dropMatkul(MataKuliah mataKuliah){
        /* TODO: implementasikan kode Anda di sini */
        for (int i = 0; i < 10; i++) {
            if (daftarMataKuliah[i].equals(mataKuliah)) {
                daftarMataKuliah[i] = null;
            }
        }
    }

    /* TODO: SKIP, kerjain nanti aja */
    public void cekIRS(){
        boolean counterKode = true;
        boolean statusSKS = true;
        /* TODO: implementasikan kode Anda di sini */
        for (int i = 0; i < 10; i++) {
            if (!daftarMataKuliah[i].getKode().equals(this.jurusan) && !daftarMataKuliah[i].getKode().equals("CS")) {
                counterKode = false;
            } else {
            }
        }
        if (totalSKS > 24) {
            statusSKS = false;
        }
        if (counterKode == true && statusSKS) {
            System.out.println("IRS tidak bermasalah");
        }
    }

    public String toString() {
        return nama;
    }

}
