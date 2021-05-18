package assignments.assignment3;

class Dosen extends ElemenFasilkom {
    private MataKuliah mataKuliah;

    Dosen(String nama) {
        super("Dosen", nama);
    }

    public void mengajarMataKuliah(MataKuliah mataKuliah) {
        if (this.mataKuliah != null) {
            System.out.printf("[DITOLAK] %s sudah mengajar mata kuliah %s\n", this.getNama(), this.mataKuliah);
        } else if (this.mataKuliah == null) {
            System.out.printf("%s mengajar mata kuliah %s\n", this.getNama(), mataKuliah);

            // Jadikan mataKuliah sebagai mata kuliah yang diajar oleh dosen tersebut
            this.mataKuliah = mataKuliah;

            // Tambahkan dosen yang mengajar ke dalam MataKuliah
            mataKuliah.addDosen(this);
        } else if (mataKuliah.dosenIsExist()) {
            System.out.printf("[DITOLAK] %s sudah memiliki dosen pengajar\n", mataKuliah);
        }
    }

    public void dropMataKuliah() {
        if (this.mataKuliah != null) {
            System.out.printf("%s berhenti mengajar %s\n", this.getNama(), this.mataKuliah);

            // Menghapus mataKuliah yang telah diajar oleh dosen
            this.mataKuliah.dropDosen();
            this.mataKuliah = null;
        } else {
            System.out.printf("[DITOLAK] %s sedang tidak mengajar mata kuliah apapun\n", this.getNama());
        }
    }

    public void dosenMenyapaMahasiswa (Mahasiswa mahasiswa) {
        if (mataKuliah != null) {
            // Jika dosen mengajarkan matkul yang sama dengan yang dipelajari mahasiswa
            if (mataKuliah.equals(mahasiswa.searchMataKuliah(mataKuliah.toString()))) {
                // Menambahkan friendship dosen dan mahasiswa
                this.updateFriendship(2);
                mahasiswa.updateFriendship(2);
            }
        }
    }
}