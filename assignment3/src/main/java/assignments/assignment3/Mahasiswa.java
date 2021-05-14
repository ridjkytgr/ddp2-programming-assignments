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

    public boolean validateAddMatkul() {
        return true;
    }

    public void addMatkul(MataKuliah mataKuliah) {
        daftarMataKuliah[numOfMataKuliah++] = mataKuliah;

    }

    public void dropMatkul(MataKuliah mataKuliah) {
        /* TODO: implementasikan kode Anda di sini */
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