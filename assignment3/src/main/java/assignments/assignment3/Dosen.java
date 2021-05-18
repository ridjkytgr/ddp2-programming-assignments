package assignments.assignment3;

class Dosen extends ElemenFasilkom {
    private MataKuliah mataKuliah;

    Dosen(String nama) {
        super("Dosen", nama);
    }

    /**
     * Menambahkan suatu mata kuliah yang diajarkan oleh dosen tersebut
     * @param mataKuliah yang akan diajarkan oleh dosen tersebut
     */
    public void mengajarMataKuliah(MataKuliah mataKuliah) {
        if (this.mataKuliah != null) {
            System.out.printf("[DITOLAK] %s sudah mengajar mata kuliah %s\n", this, this.mataKuliah);
        } else if (this.mataKuliah == null) {
            if (mataKuliah.dosenIsExist()) {
                System.out.printf("[DITOLAK] %s sudah memiliki dosen pengajar\n", mataKuliah);
            } else {
                System.out.printf("%s mengajar mata kuliah %s\n", this, mataKuliah);

                // Jadikan mataKuliah sebagai mata kuliah yang diajar oleh dosen tersebut
                this.mataKuliah = mataKuliah;

                // Tambahkan dosen yang mengajar ke dalam MataKuliah
                mataKuliah.addDosen(this);
            }
        }
    }

    /**
     * Membuang/menghapus mata kuliah yang diajar oleh dosen tersebut
     */
    public void dropMataKuliah() {
        if (this.mataKuliah != null) {
            System.out.printf("%s berhenti mengajar %s\n", this, this.mataKuliah);

            // Menghapus mataKuliah yang telah diajar oleh dosen
            this.mataKuliah.dropDosen();
            this.mataKuliah = null;
        } else {
            System.out.printf("[DITOLAK] %s sedang tidak mengajar mata kuliah apapun\n", this);
        }
    }

    /**
     * Menyapa khusus untuk antara dosen dengan mahasiswa
     * @param mahasiswa Mahasiswa yang ingin disapa oleh dosen
     */
    public void dosenMenyapaMahasiswa (Mahasiswa mahasiswa) {
        if (mataKuliah != null) {
            if (mataKuliah.equals(mahasiswa.searchMataKuliah(mataKuliah.toString()))) {
                this.updateFriendship(2);
                mahasiswa.updateFriendship(2);
            }
        }
    }
}