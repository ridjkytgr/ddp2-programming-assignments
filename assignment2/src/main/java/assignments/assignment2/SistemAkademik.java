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
        for (int i = 0; i < 100; i++) {
            if (daftarMahasiswa[i].getNpm() == npm) {
                return daftarMahasiswa[i];
            }
        }
        return null;
    }

    private MataKuliah getMataKuliah(String namaMataKuliah) {
        for (int i = 0; i < daftarMataKuliah.length; i++) {
            if (daftarMataKuliah[i].toString().equals(namaMataKuliah)) {
                return daftarMataKuliah[i];
            }
        }
        return null;
    }

    private void addMatkul() {
        System.out.println("\n--------------------------ADD MATKUL--------------------------\n");

        System.out.print("Masukkan NPM Mahasiswa yang akan melakukan ADD MATKUL : ");
        long npm = Long.parseLong(input.nextLine());
        Mahasiswa mahasiswa = getMahasiswa(npm);

        System.out.print("Banyaknya Matkul yang Ditambah: ");
        int banyakMatkul = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan nama matkul yang ditambah");

        for (int i = 0; i < banyakMatkul; i++) {
            System.out.print("Nama matakuliah " + i + 1 + " : ");
            String namaMataKuliah = input.nextLine();
            MataKuliah instanceMataKuliah = getMataKuliah(namaMataKuliah);
            if (mahasiswa.validateAddMatkul(instanceMataKuliah)) {
                // Menambahkan matkul untuk mahasiswa, dan menambahkan mahasiswa pada matkul yang bersangkutan.
                mahasiswa.addMatkul(instanceMataKuliah);
                instanceMataKuliah.addMahasiswa(mahasiswa);
            }
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

    private void ringkasanMahasiswa() {
        System.out.print("Masukkan npm mahasiswa yang akan ditunjukkan ringkasannya : ");
        long npm = Long.parseLong(input.nextLine());
        Mahasiswa mahasiswa = getMahasiswa(npm);

        System.out.println("\n--------------------------RINGKASAN--------------------------\n");
        System.out.println("Nama: " + mahasiswa);
        System.out.println("NPM: " + npm);
        System.out.println("Jurusan: " + mahasiswa.getJurusan());
        System.out.println("Daftar Mata Kuliah: ");

        int numOfMataKuliah = mahasiswa.getNumOfMataKuliah();
        int formatCounter = 1;

        // Handling jika mahasiswa belum mengambil mata kuliah sama sekali.
        if (numOfMataKuliah == 0) {
            System.out.println("Belum ada mata kuliah yang diambil");
        } else {
            MataKuliah[] mataKuliah = mahasiswa.getDaftarMataKuliah();
            for (int i = 0; i < numOfMataKuliah; i++) {
                System.out.println(formatCounter + ". " + mataKuliah[i]);
                formatCounter++;
            }
            System.out.println("Total SKS: " + mahasiswa.getTotalSKS());
            System.out.println("Hasil Pengecekan IRS:");
            mahasiswa.cekIRS();
        }
    }
    private void ringkasanMataKuliah(){
        System.out.print("Masukkan nama mata kuliah yang akan ditunjukkan ringkasannya : ");
        String namaMataKuliah = input.nextLine();
        MataKuliah mataKuliah = getMataKuliah(namaMataKuliah);
        int jumlahMahasiswa = mataKuliah.calcJumlahMahasiswa();

        System.out.println("\n--------------------------RINGKASAN--------------------------\n");
        System.out.println("Nama mata kuliah: " + mataKuliah);
        System.out.println("Kode: " + mataKuliah.getKode());
        System.out.println("SKS: " + mataKuliah.getSks());
        System.out.println("Jumlah mahasiswa: " + jumlahMahasiswa);
        System.out.println("Kapasitas: " + mataKuliah.getKapasitas());
        System.out.println("Daftar mahasiswa yang mengambil mata kuliah ini: ");

        if (jumlahMahasiswa == 0) {
            System.out.println("Belum ada mahasiswa yang mengambil mata kuliah ini.");
        } else {
            // Membuat variabel counter untuk formatting saat pencetakan.
            int counterMahasiswa = 1;
            Mahasiswa[] daftarMahasiswa = mataKuliah.getDaftarMahasiswa();
            for (int i = 0; i < jumlahMahasiswa; i++) {
                System.out.println(counterMahasiswa + ". " + daftarMahasiswa[i]);
                counterMahasiswa++;
            }
        }
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
            String kode = dataMatkul[0];
            String nama = dataMatkul[1];
            int sks = Integer.parseInt(dataMatkul[2]);
            int kapasitas = Integer.parseInt(dataMatkul[3]);

            // Membuat instance MataKuliah dan menambahkannya ke dalam array.
            MataKuliah mataKuliah = new MataKuliah(kode, nama, sks, kapasitas);
            daftarMataKuliah[i] = mataKuliah;
        }

        System.out.print("Banyaknya Mahasiswa di Fasilkom: ");
        int banyakMahasiswa = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan data mahasiswa");
        System.out.println("format: [Nama] [NPM]");

        for(int i=0; i<banyakMahasiswa; i++){
            String[] dataMahasiswa = input.nextLine().split(" ", 2);
            long npm = Long.parseLong(dataMahasiswa[1]);
            String nama = dataMahasiswa[0];

            // Membuat instance mahasiswa dan menyimpannya di dalam array
            Mahasiswa mahasiswa = new Mahasiswa(nama, npm);
            daftarMahasiswa[i] = mahasiswa;
        }

        daftarMenu();
        input.close();
    }

    public static void main(String[] args) {
        SistemAkademik program = new SistemAkademik();
        program.run();
    }


    
}
