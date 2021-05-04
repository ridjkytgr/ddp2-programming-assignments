package assignments.assignment3;

class Mahasiswa extends ElemenFasilkom {
    
    /* TODO: Silahkan menambahkan visibility pada setiap method dan variabel apabila diperlukan */

    MataKuliah[] daftarMataKuliah = new MataKuliah[10];
    
    long npm;

    String tanggalLahir;
    
    String jurusan;

    Mahasiswa(String nama, long npm) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void addMatkul(MataKuliah mataKuliah) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void dropMatkul(MataKuliah mataKuliah) {
        /* TODO: implementasikan kode Anda di sini */
    }

    String extractTanggalLahir(long npm) {
        /* TODO: implementasikan kode Anda di sini */
        return "";
    }

    String extractJurusan(long npm) {
        /* TODO: implementasikan kode Anda di sini */
        return "";
    }
}