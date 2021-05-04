package assignments.assignment3;

abstract class ElemenFasilkom {
    
    /* TODO: Silahkan menambahkan visibility pada setiap method dan variabel apabila diperlukan */

    String tipe;
    
    String nama;

    int friendship;

    ElemenFasilkom[] telahMenyapa = new ElemenFasilkom[100];

    void menyapa(ElemenFasilkom elemenFasilkom) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void resetMenyapa() {
        /* TODO: implementasikan kode Anda di sini */
    }

    void membeliMakanan(ElemenFasilkom pembeli, ElemenFasilkom penjual, String namaMakanan) {
        /* TODO: implementasikan kode Anda di sini */
    }

    String toString() {
        /* TODO: implementasikan kode Anda di sini */
        return "";
    }
}