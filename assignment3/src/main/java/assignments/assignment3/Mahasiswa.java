package assignments.assignment3;

class Mahasiswa extends ElemenFasilkom {
    
    /* TODO: Silahkan menambahkan visibility pada setiap method dan variabel apabila diperlukan */

    private MataKuliah[] daftarMataKuliah = new MataKuliah[10];

    private int numOfMataKuliah;

    private long npm;

    private String tanggalLahir;
    
    private String jurusan;

    Mahasiswa(String nama, long npm) {
        /* TODO: implementasikan kode Anda di sini */
        super("Mahasiswa", nama);
        this.npm = npm;
    }

    public boolean validateAddMatkul(MataKuliah mataKuliah) {
        for (MataKuliah matkul : daftarMataKuliah) {
            if (matkul != null && matkul.equals(mataKuliah)) {
                // Validasi pertama: Apakah matkul tersebut sudah pernah diambil sebelumnya
                System.out.printf("[DITOLAK] %s telah diambil sebelumnya\n", mataKuliah);
                return false;
            } else if (matkul != null && mataKuliah.getKapasitas() == mataKuliah.getJumlahMahasiswa()) {
                // Validasi kedua: Apakah matkul tersebut sudah penuh kapasitasnya
                System.out.printf("[DITOLAK] %s telah penuh kapasitasnya\n", mataKuliah);
                return false;
            } else if (matkul == null) {
                break;
            }
        }
        // Jika mataKuliah tidak mengalami kendala apapun
        return true;
    }

    public void addMatkul(MataKuliah mataKuliah) {
        if (validateAddMatkul(mataKuliah)) {
            daftarMataKuliah[numOfMataKuliah++] = mataKuliah;
            System.out.printf("%s telah berhasil menambahkan mata kuliah %s", this.getNama(), mataKuliah);
        }
    }

    public boolean validateDropMatkul (MataKuliah mataKuliah) {
        for (MataKuliah matkul : daftarMataKuliah) {
            if (matkul != null && matkul.equals(mataKuliah)) {
                return true;
            } else if (matkul == null) {
                break;
            }
        }
        System.out.printf("[DITOLAK] %s belum pernah diambil\n", mataKuliah);
        return false;
    }

    public void dropMatkul(MataKuliah mataKuliah) {
        if (validateDropMatkul(mataKuliah)) {
            // Membuat array baru yang tidak berisi mataKuliah yang ingin di-drop
            MataKuliah[] temp = new MataKuliah[10];
            int counter = 0;
            for (MataKuliah matkul : daftarMataKuliah) {
                if (matkul != null && !matkul.equals(mataKuliah)) {
                    temp[counter] = matkul;
                    counter++;
                } else if (matkul != null && matkul.equals(mataKuliah)){
                    numOfMataKuliah--;
                }
            }
            // Memindahkan reference ke array baru
            daftarMataKuliah = temp;
        }
        System.out.printf("%s berhasil drop mata kuliah %s\n", this.getNama(), mataKuliah);
    }

    public String extractTanggalLahir(long npm) {
        String npmString = Long.toString(npm);
        return String.format("%s-%s-%s", npmString.substring(4, 6), npmString.substring(6, 8), npmString.substring(8, 12));
    }

    public String extractJurusan(long npm) {
        String npmString = Long.toString(npm);
        if (npmString.substring(2, 4) == "01") {
            return "Ilmu Komputer";
        }
        return "Sistem Informasi";
    }
}