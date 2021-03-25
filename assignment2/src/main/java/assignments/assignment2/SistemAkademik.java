package assignments.assignment2;

import java.util.Scanner;

public class SistemAkademik {
    private static final int ADD_MATKUL = 1;
    private static final int DROP_MATKUL = 2;
    private static final int RINGKASAN_MAHASISWA = 3;
    private static final int RINGKASAN_MATAKULIAH = 4;
    private static final int KELUAR = 5;
    private static Mahasiswa[] daftarMahasiswa = new Mahasiswa[100];
    private static MataKuliah[] daftarMataKuliah = new MataKuliah[100];
    
    private Scanner input = new Scanner(System.in);

    private Mahasiswa getMahasiswa(long npm) {
        /* TODO: Implementasikan kode Anda di sini */
        return null;
    }

    private MataKuliah getMataKuliah(String namaMataKuliah) {
        /* TODO: Implementasikan kode Anda di sini */
        return null;
    }

    private void addMatkul(){
        System.out.println("\n--------------------------ADD MATKUL--------------------------\n");

        System.out.print("Masukkan NPM Mahasiswa yang akan melakukan ADD MATKUL : ");
        long npm = Long.parseLong(input.nextLine());

        /* TODO: Implementasikan kode Anda di sini 
        Jangan lupa lakukan validasi apabila banyaknya matkul yang diambil mahasiswa sudah 9*/

        System.out.print("Banyaknya Matkul yang Ditambah: ");
        int banyakMatkul = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan nama matkul yang ditambah");
        for(int i=0; i<banyakMatkul; i++){
            System.out.print("Nama matakuliah " + i+1 + " : ");
            String namaMataKuliah = input.nextLine();
            /* TODO: Implementasikan kode Anda di sini */
        }
        System.out.println("\nSilakan cek rekap untuk melihat hasil pengecekan IRS.\n");
    }

    private void dropMatkul(){
        System.out.println("\n--------------------------DROP MATKUL--------------------------\n");

        System.out.print("Masukkan NPM Mahasiswa yang akan melakukan DROP MATKUL : ");
        long npm = Long.parseLong(input.nextLine());

       /* TODO: Implementasikan kode Anda di sini 
        Jangan lupa lakukan validasi apabila mahasiswa belum mengambil mata kuliah*/

        System.out.print("Banyaknya Matkul yang Di-drop: ");
        int banyakMatkul = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan nama matkul yang di-drop:");
        for(int i=0; i<banyakMatkul; i++){
            System.out.print("Nama matakuliah " + i+1 + " : ");
            String namaMataKuliah = input.nextLine();
            /* TODO: Implementasikan kode Anda di sini */
        }
        System.out.println("\nSilakan cek rekap untuk melihat hasil pengecekan IRS.\n");
    }

    private void ringkasanMahasiswa(){
        System.out.print("Masukkan npm mahasiswa yang akan ditunjukkan ringkasannya : ");
        long npm = Long.parseLong(input.nextLine());

        // TODO: Isi sesuai format keluaran
        System.out.println("\n--------------------------RINGKASAN--------------------------\n");
        System.out.println("Nama: " + "");
        System.out.println("NPM: " + npm);
        System.out.println("Jurusan: " + "");
        System.out.println("Daftar Mata Kuliah: ");

        /* TODO: Cetak daftar mata kuliah 
        Handle kasus jika belum ada mata kuliah yang diambil*/

        System.out.println("Total SKS: " + "");
        
        System.out.println("Hasil Pengecekan IRS:");
        /* TODO: Cetak hasil cek IRS
        Handle kasus jika IRS tidak bermasalah */
    }

    private void ringkasanMataKuliah(){
        System.out.print("Masukkan nama mata kuliah yang akan ditunjukkan ringkasannya : ");
        String namaMataKuliah = input.nextLine();
        
        // TODO: Isi sesuai format keluaran
        System.out.println("\n--------------------------RINGKASAN--------------------------\n");
        System.out.println("Nama mata kuliah: " + "");
        System.out.println("Kode: " + "");
        System.out.println("SKS: " + "");
        System.out.println("Jumlah mahasiswa: " + "");
        System.out.println("Kapasitas: " + "");
        System.out.println("Daftar mahasiswa yang mengambil mata kuliah ini: ");
       /* TODO: Cetak hasil cek IRS
        Handle kasus jika tidak ada mahasiswa yang mengambil */
    }

    private void daftarMenu(){
        int pilihan = 0;
        boolean exit = false;
        while (!exit) {
            System.out.println("\n----------------------------MENU------------------------------\n");
            System.out.println("Silakan pilih menu:");
            System.out.println("1. Add Matkul");
            System.out.println("2. Drop Matkul");
            System.out.println("3. Ringkasan Mahasiswa");
            System.out.println("4. Ringkasan Mata Kuliah");
            System.out.println("5. Keluar");
            System.out.print("\nPilih: ");
            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
            System.out.println();
            if (pilihan == ADD_MATKUL) {
                addMatkul();
            } else if (pilihan == DROP_MATKUL) {
                dropMatkul();
            } else if (pilihan == RINGKASAN_MAHASISWA) {
                ringkasanMahasiswa();
            } else if (pilihan == RINGKASAN_MATAKULIAH) {
                ringkasanMataKuliah();
            } else if (pilihan == KELUAR) {
                System.out.println("Sampai jumpa!");
                exit = true;
            }
        }

    }


    private void run() {
        System.out.println("====================== Sistem Akademik =======================\n");
        System.out.println("Selamat datang di Sistem Akademik Fasilkom!");
        
        System.out.print("Banyaknya Matkul di Fasilkom: ");
        int banyakMatkul = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan matkul yang ditambah");
        System.out.println("format: [Kode Matkul] [Nama Matkul] [SKS] [Kapasitas]");

        for(int i=0; i<banyakMatkul; i++){
            String[] dataMatkul = input.nextLine().split(" ", 4);
            int sks = Integer.parseInt(dataMatkul[2]);
            int kapasitas = Integer.parseInt(dataMatkul[3]);
            /* TODO: Buat instance mata kuliah dan masukkan ke dalam Array */
        }

        System.out.print("Banyaknya Mahasiswa di Fasilkom: ");
        int banyakMahasiswa = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan data mahasiswa");
        System.out.println("format: [Nama] [NPM]");

        for(int i=0; i<banyakMahasiswa; i++){
            String[] dataMahasiswa = input.nextLine().split(" ", 2);
            long npm = Long.parseLong(dataMahasiswa[1]);
            /* TODO: Buat instance mata kuliah dan masukkan ke dalam Array */
        }

        daftarMenu();
        input.close();
    }

    public static void main(String[] args) {
        SistemAkademik program = new SistemAkademik();
        program.run();
    }


    
}
