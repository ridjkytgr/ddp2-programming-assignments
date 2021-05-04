package assignments.assignment3;

import java.util.Scanner;

public class Main {

    /* TODO: Silahkan menambahkan visibility pada setiap method dan variabel apabila diperlukan */

    ElemenFasilkom[] daftarElemenFasilkom = new ElemenFasilkom[100];

    MataKuliah[] daftarMataKuliah = new MataKuliah[100];

    int totalMataKuliah = 0;

    int totalElemenFasilkom = 0; 

    void addMahasiswa(String nama, long npm) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void addDosen(String nama) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void addElemenKantin(String nama) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void menyapa(String objek1, String objek2) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void addMakanan(String objek, String namaMakanan, long harga) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void membeliMakanan(String objek1, String objek2, String namaMakanan) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void createMatkul(String nama, int kapasitas) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void addMatkul(String objek, String namaMataKuliah) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void dropMatkul(String objek, String namaMataKuliah) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void mengajarMatkul(String objek, String namaMataKuliah) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void berhentiMengajar(String objek) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void ringkasanMahasiswa(String objek) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void ringkasanMataKuliah(String namaMataKuliah) {
        /* TODO: implementasikan kode Anda di sini */
    }

    void nextDay() {
        /* TODO: implementasikan kode Anda di sini */
    }

    void friendshipRanking() {
        /* TODO: implementasikan kode Anda di sini */
    }

    void programEnd() {
        /* TODO: implementasikan kode Anda di sini */
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (true) {
            String in = input.nextLine();
            if (in.split(" ")[0].equals("ADD_MAHASISWA")) {
                addMahasiswa(in.split(" ")[1], Long.parseLong(in.split(" ")[2]));
            } else if (in.split(" ")[0].equals("ADD_DOSEN")) {
                addDosen(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("ADD_ELEMEN_KANTIN")) {
                addElemenKantin(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("MENYAPA")) {
                menyapa(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("ADD_MAKANAN")) {
                addMakanan(in.split(" ")[1], in.split(" ")[2], Long.parseLong(in.split(" ")[3]));
            } else if (in.split(" ")[0].equals("MEMBELI_MAKANAN")) {
                membeliMakanan(in.split(" ")[1], in.split(" ")[2], in.split(" ")[3]);
            } else if (in.split(" ")[0].equals("CREATE_MATKUL")) {
                createMatkul(in.split(" ")[1], Integer.parseInt(in.split(" ")[2]));
            } else if (in.split(" ")[0].equals("ADD_MATKUL")) {
                addMatkul(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("DROP_MATKUL")) {
                dropMatkul(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("MENGAJAR_MATKUL")) {
                mengajarMatkul(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("BERHENTI_MENGAJAR")) {
                berhentiMengajar(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("RINGKASAN_MAHASISWA")) {
                ringkasanMahasiswa(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("RINGKASAN_MATKUL")) {
                ringkasanMataKuliah(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("NEXT_DAY")) {
                nextDay();
            } else if (in.split(" ")[0].equals("PROGRAM_END")) {
                programEnd();
                break;
            }
        }
    }
}