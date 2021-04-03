package assignments.assignment2;

public class Mahasiswa {
    private MataKuliah[] daftarMataKuliah = new MataKuliah[10];
    private String[] masalahIRS;
    private int totalSKS;
    private String nama;
    private String jurusan;
    private long npm;
    private int numOfMataKuliah;

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

    public String getJurusan() {
        return jurusan;
    }

    public MataKuliah[] getDaftarMataKuliah() {
        return daftarMataKuliah;
    }

    public long getNpm() {
        return npm;
    }

    /**
     * Method untuk menghitung dan mengembalikan banyak mataKuliah yang telah diambil oleh mahasiswa.
     * @return integer banyaknya mataKuliah yang telah diambil.
     */
    public int getNumOfMataKuliah() {
        numOfMataKuliah = 0;
        for (int i = 0; i < 10; i++) {
            if (daftarMataKuliah[i] != null) {
                numOfMataKuliah++;
            }
        }
        return numOfMataKuliah;
    }

    /**
     * Method untuk melakukan validasi sebelum menambahkan mata kuliah ke dalam array sesuai dengan prioritas validasi.
     * @param mataKuliah object dengan class MataKuliah yang akan divalidasi.
     * @return boolean yang bernilai true jika lolos validasi dan false jika sebaliknya.
     */
    public boolean validateAddMatkul(MataKuliah mataKuliah) {
        for (int i = 0; i < 10; i++) {
            // Pengecekan apakah mataKuliah telah diambil sebelumnya dan memastikan mataKuliah tersebut belum penuh.
            if (daftarMataKuliah[i] != null && daftarMataKuliah[i].equals(mataKuliah)) {
                System.out.println("[DITOLAK] " + daftarMataKuliah[i] + " telah diambil sebelumnya");
                return false;
            } else if (mataKuliah.getKapasitas() == mataKuliah.calcJumlahMahasiswa()) {
                System.out.println("[DITOLAK] " + mataKuliah + " telah penuh kapasitasnya");
                return false;
            }
        }
            if (numOfMataKuliah < 10) {
                return true;
            } else {
                System.out.println("[DITOLAK] Maksimal mata kuliah yang diambil hanya 10.");
                return false;
            }
        }

    public void addMatkul(MataKuliah mataKuliah) {
        for (int i = 0; i < 10; i++) {
            if (daftarMataKuliah[i] == null) {
                daftarMataKuliah[i] = mataKuliah;
                this.totalSKS += daftarMataKuliah[i].getSks();
                this.numOfMataKuliah++;
                break;
            }
        }
    }

    /**
     * Method untuk melakukan validasi sebelum mengurangi mata kuliah dari dalam array sesuai dengan prioritas validasi.
     * @param mataKuliah object dengan class MataKuliah yang akan divalidasi.
     * @return boolean yang bernilai true jika lolos validasi dan false jika sebaliknya.
     */
    public boolean validateDropMatkul (MataKuliah mataKuliah) {
        // Membuat variabel boolean sebagai penanda jika telah menemukan mataKuliah yang sama.
        boolean foundFlag = false;
        for (int i = 0; i < 10; i++) {
            if (daftarMataKuliah[i] != null && daftarMataKuliah[i].equals(mataKuliah)) {
                foundFlag = true;
            }
        }
        return foundFlag;
    }

    public void dropMatkul(MataKuliah mataKuliah){
        // Membuat array baru yang berisi mataKuliah setelah di-drop.
        MataKuliah[] temp = new MataKuliah[10];
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            if (daftarMataKuliah[i] != null && !daftarMataKuliah[i].equals(mataKuliah)) {
                temp[counter] = daftarMataKuliah[i];
                counter++;
            } else if (daftarMataKuliah[i] != null && daftarMataKuliah[i].equals(mataKuliah)){
                this.totalSKS -= daftarMataKuliah[i].getSks();
            }
        }
        daftarMataKuliah = temp;
    }

    /**
     * Method untuk mengubah nama jurusan menjadi bentuk singkatannya.
     * @return String yang berisi singkatan dari jurusan mahasiswa tersebut.
     */
    public String getEncodeJurusan() {
        String singkatan;
        if (jurusan.equals("Ilmu Komputer")) {
            singkatan = "IK";
        } else {
            singkatan = "SI";
        }
        return singkatan;
    }

    public void cekIRS(){
        int numOfMasalahIRS = 0;
        // flagKode dan statusSKS untuk memastikan IRS mahasiswa tidak bermasalah (agar bisa dicetak string-nya)
        boolean flagKode = true;
        boolean statusSKS = true;

        if (totalSKS > 24) {
            statusSKS = false;
            masalahIRS[numOfMasalahIRS] = "SKS yang Anda ambil lebih dari 24";
            numOfMasalahIRS++;
        }

        // Melakukan pengecekan jurusan mahasiswa dengan kode mataKuliah
        for (int i = 0; i < 10; i++) {
            if (daftarMataKuliah[i] != null && !daftarMataKuliah[i].getKode().equals(getEncodeJurusan())) {
                if (!daftarMataKuliah[i].getKode().equals("CS")) {
                    flagKode = false;
                    masalahIRS[numOfMasalahIRS] = "Mata Kuliah " + daftarMataKuliah[i] + " tidak dapat diambil jurusan " + getEncodeJurusan();
                    numOfMasalahIRS++;
                }
            }
        }

        // Melakukan pengecekan IRS secara keseluruhan
        if (flagKode && statusSKS) {
            System.out.println("IRS tidak bermasalah.");
        } else {
            int counterPrint = 1;
            for (int i = 0; i < numOfMasalahIRS; i++) {
                System.out.println(counterPrint + ". " + masalahIRS[i]);
                counterPrint++;
            }
        }
    }

    public String toString() {
        return nama;
    }

}
