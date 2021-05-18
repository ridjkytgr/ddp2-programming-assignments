package assignments.assignment3;

class Mahasiswa extends ElemenFasilkom {
    private MataKuliah[] daftarMataKuliah = new MataKuliah[10];

    private int numOfMataKuliah;

    private long npm;

    private String tanggalLahir;
    
    private String jurusan;

    Mahasiswa(String nama, long npm) {
        super("Mahasiswa", nama);
        this.npm = npm;
    }

    /**
     * Getter npm dari mahasiswa
     * @return long npm dari mahasiswa
     */
    public long getNpm() {
        return this.npm;
    }

    /**
     * Getter array daftar mata kuliah yang telah diambil oleh mahasiswa
     * @return array MataKuliah yang telah diambil oleh mahasiswa
     */
    public MataKuliah[] getDaftarMataKuliah() {
        return daftarMataKuliah;
    }

    /**
     * Memvalidasi mata kuliah yang akan ditambahkan ke dalam array daftarMataKuliah
     * @param mataKuliah yang akan divalidasi
     * @return boolean true jika memenuhi syarat, false jika sebaliknya
     */
    public boolean validateAddMatkul(MataKuliah mataKuliah) {
        for (MataKuliah matkul : daftarMataKuliah) {
            if (matkul != null && matkul.equals(mataKuliah)) {
                // Validasi pertama: Apakah matkul tersebut sudah pernah diambil sebelumnya
                System.out.printf("[DITOLAK] %s telah diambil sebelumnya\n", mataKuliah);
                return false;
            } else if (matkul == null) {
                break;
            }
        }
        if (mataKuliah.getJumlahMahasiswa() >= mataKuliah.getKapasitas()) {
             // Validasi kedua: Apakah matkul tersebut sudah penuh kapasitasnya
             System.out.printf("[DITOLAK] %s telah penuh kapasitasnya\n", mataKuliah);
             return false;
        }
        // Jika mataKuliah tidak mengalami kendala apapun
        return true;
    }

    /**
     * Menambahkan mata kuliah yang dipelajari oleh mahasiswa ke dalam array daftarMataKuliah
     * @param mataKuliah yang ingin ditambahkan ke dalam array daftarMataKuliah
     */
    public void addMatkul(MataKuliah mataKuliah) {
        if (validateAddMatkul(mataKuliah)) {
            daftarMataKuliah[numOfMataKuliah++] = mataKuliah;
            // Menambahkan mahasiswa tersebut ke dalam array daftarMahasiswa
            mataKuliah.addMahasiswa(this);
            System.out.printf("%s berhasil menambahkan mata kuliah %s\n", this, mataKuliah);
        }
    }

    /**
     * Memvalidasi mata kuliah yang akan ditambahkan ke dalam array daftarMataKuliah
     * @param mataKuliah yang akan divalidasi
     * @return boolean true jika memenuhi syarat, false jika sebaliknya
     */
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

    /**
     * Membuang/drop mata kuliah yang dipelajari oleh mahasiswa ke dalam array daftarMataKuliah
     * @param mataKuliah yang ingin dibuang-didrop ke dalam array daftarMataKuliah
     */
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
                } else if (matkul == null) {
                    break;
                }
            }
            // Memindahkan reference ke array baru
            daftarMataKuliah = temp;
            // Menghapus mahasiswa tersebut dari array daftarMahasiswa
            mataKuliah.dropMahasiswa(this);
            System.out.printf("%s berhasil drop mata kuliah %s\n", this, mataKuliah);
        }

    }

    /**
     * Mencari mata kuliah tertentu dari array daftarMataKuliah
     * @param nama String nama mata kuliah yang ingin dicari
     * @return MataKuliah yang dicari
     */
    public MataKuliah searchMataKuliah(String nama) {
        for (MataKuliah matkul : daftarMataKuliah) {
            if (matkul != null && matkul.equals(nama)) {
                return matkul;
            } else if (matkul == null) {
                break;
            }
        }
        return null;
    }

    /**
     * Mengekstrak tanggal lahir mahasiswa berdasarkan npm
     * @param npm mahasiswa yang ingin diekstrak tanggal lahirnya
     * @return String tanggal lahir dari mahasiswa
     */
    public String extractTanggalLahir(long npm) {
        String npmString = Long.toString(npm);
        return String.format("%d-%d-%d", Integer.parseInt(npmString.substring(4, 6)),
                Integer.parseInt(npmString.substring(6, 8)), Integer.parseInt(npmString.substring(8, 12)));
    }

    /**
     * Mengekstrak jurusan mahasiswa berdasarkan npm
     * @param npm mahasiswa yang ingin diekstrak jurusannya
     * @return String jurusan dari mahasiswa
     */
    public String extractJurusan(long npm) {
        String npmString = Long.toString(npm);
        if (npmString.substring(2, 4).equals("01")) {
            return "Ilmu Komputer";
        }
        return "Sistem Informasi";
    }
}