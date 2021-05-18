package assignments.assignment3;

import java.util.Scanner;

public class Main {
    private static ElemenFasilkom[] daftarElemenFasilkom = new ElemenFasilkom[100];

    private static MataKuliah[] daftarMataKuliah = new MataKuliah[100];

    private static int totalMataKuliah = 0;

    private static int totalElemenFasilkom = 0;

    /**
     * Getter elemen fasilkom berdasarkan nama dari elemen fasilkom
     * @param nama elemen fasilkom yang akan dicari
     * @return objek ElemenFasilkom yang dicari
     */
    private static ElemenFasilkom getElemenFasilkom(String nama) {
        for (ElemenFasilkom elemenFasilkom : daftarElemenFasilkom) {
            if (elemenFasilkom != null && elemenFasilkom.toString().equals(nama)) {
                return elemenFasilkom;
            } else if (elemenFasilkom == null) {
                break;
            }
        }
        return null;
    }

    /**
     * Getter mata kuliah berdasarkan nama dari mata kuliah
     * @param nama mata kuliahy yang akan dicari
     * @return objek MataKuliah yang dicari
     */
    private static MataKuliah getMataKuliah(String nama) {
        for (MataKuliah matkul : daftarMataKuliah) {
            if (matkul != null && matkul.toString().equals(nama)) {
                return matkul;
            } else if (matkul == null) {
                break;
            }
        }
        return null;
    }

    /**
     * Menambahkan instance mahasiswa baru
     * @param nama nama dari mahasiswa
     * @param npm npm dari mahasiswa
     */
    private static void addMahasiswa(String nama, long npm) {
        Mahasiswa mahasiswa = new Mahasiswa(nama, npm);
        daftarElemenFasilkom[totalElemenFasilkom++] = mahasiswa;
        System.out.printf("%s berhasil ditambahkan\n", mahasiswa);
    }

    /**
     * Menambahkan instance dosen baru
     * @param nama nama dari dosen
     */
    private static void addDosen(String nama) {
        Dosen dosen = new Dosen(nama);
        daftarElemenFasilkom[totalElemenFasilkom++] = dosen;
        System.out.printf("%s berhasil ditambahkan\n", dosen);
    }

    /**
     * Menambahkan instance elemen kantin baru
     * @param nama nama dari elemen kantin
     */
    private static void addElemenKantin(String nama) {
        ElemenKantin elemenKantin = new ElemenKantin(nama);
        daftarElemenFasilkom[totalElemenFasilkom++] = elemenKantin;
        System.out.printf("%s berhasil ditambahkan\n", elemenKantin);
    }

    /**
     * Menyapa antara elemen fasilkom
     * @param objek1 objek yang akan saling menyapa
     * @param objek2 objek yang akan saling menyapa
     */
    private static void menyapa(String objek1, String objek2) {
        if (objek1.equals(objek2)) {
            System.out.printf("[DITOLAK] Objek yang sama tidak bisa saling menyapa\n");
        } else {
            getElemenFasilkom(objek1).menyapa(getElemenFasilkom(objek2));
        }
    }

    /**
     * Menambahkan makanan yang dilakukan oleh elemen kantin
     * @param objek objek ElemenKantin yang akan menambahkan makanan tersebut
     * @param namaMakanan nama makanan yang akan ditambahkan
     * @param harga harga dari makanan yang akan ditambahkan
     */
    private static void addMakanan(String objek, String namaMakanan, long harga) {
        // Memeriksa apakah objek tersebut merupakan ElemenKantin atau bukan
        if (getElemenFasilkom(objek).getTipe().equals("ElemenKantin")) {
            ((ElemenKantin) getElemenFasilkom(objek)).setMakanan(namaMakanan, harga);
        } else {
            System.out.printf("[DITOLAK] %s bukan merupakan elemen kantin\n", objek);
        }
    }

    /**
     * Membeli makanan yang dilakukan antara elemen kantin dengan elemen fasilkom
     * @param objek1 elemen fasilkom yang merupakan pembeli
     * @param objek2 elemen kantin yang merupakan penjual
     * @param namaMakanan
     */
    private static void membeliMakanan(String objek1, String objek2, String namaMakanan) {
        // objek1Pacil sebagai pembeli dan objek2Pacil sebagai penjual
        ElemenFasilkom objek1Pacil = getElemenFasilkom(objek1);
        ElemenFasilkom objek2Pacil = getElemenFasilkom(objek2);
        if (objek2Pacil.getTipe().equals("ElemenKantin")) {
            if (objek1Pacil.equals(objek2Pacil)) {
                System.out.println("[DITOLAK] Elemen kantin tidak bisa membeli makanan sendiri");
            } else {
                objek1Pacil.membeliMakanan(objek2Pacil, namaMakanan);
            }
        } else {
            System.out.println("[DITOLAK] Hanya elemen kantin yang dapat menjual makanan");
        }
    }

    /**
     * Membuat matkul baru
     * @param nama nama dari mata kuliah baru yang akan dibuat
     * @param kapasitas kapasitas dari mata kuliah yang akan dibuat
     */
    private static void createMatkul(String nama, int kapasitas) {
        MataKuliah matkul = new MataKuliah(nama, kapasitas);
        daftarMataKuliah[totalMataKuliah++] = matkul;
        System.out.printf("%s berhasil ditambahkan dengan kapasitas %d\n", nama, kapasitas);
    }

    /**
     * Menambahkan matkul yang dilakukan oleh mahasiswa
     * @param objek ElemenFasilkom yang berupa Mahasiswa
     * @param namaMataKuliah nama mata kuliah yang akan ditambahkan
     */
    private static void addMatkul(String objek, String namaMataKuliah) {
        if (getElemenFasilkom(objek).getTipe().equals("Mahasiswa")) {
            ((Mahasiswa) getElemenFasilkom(objek)).addMatkul(getMataKuliah(namaMataKuliah));
        } else {
            System.out.println("[DITOLAK] Hanya mahasiswa yang dapat menambahkan matkul");
        }
    }

    /**
     * Melakukan drop matkul yang dilakukan oleh mahasiswa
     * @param objek ElemenFasilkom yang berupa Mahasiswa
     * @param namaMataKuliah nama mata kuliah yang akan ditambahkan
     */
    private static void dropMatkul(String objek, String namaMataKuliah) {
        if (getElemenFasilkom(objek).getTipe().equals("Mahasiswa")) {
            ((Mahasiswa) getElemenFasilkom(objek)).dropMatkul(getMataKuliah(namaMataKuliah));
        } else {
            System.out.println("[DITOLAK] Hanya mahasiswa yang dapat drop matkul");
        }
    }

    /**
     * Menambahkan matkul yang diajarkan oleh dosen
     * @param objek ElemenFasilkom berupa dosen
     * @param namaMataKuliah nama mata kuliah yang akan diajarkan
     */
    private static void mengajarMatkul(String objek, String namaMataKuliah) {
        if (getElemenFasilkom(objek).getTipe().equals("Dosen")) {
            ((Dosen) getElemenFasilkom(objek)).mengajarMataKuliah(getMataKuliah(namaMataKuliah));
        } else {
            System.out.println("[DITOLAK] Hanya dosen yang dapat mengajar matkul");
        }
    }

    /**
     * Membuang/drop mata kuliah yang diajar oleh dosen
     * @param objek ElemenFasilkom berupa dosen
     */
    private static void berhentiMengajar(String objek) {
        if (getElemenFasilkom(objek) instanceof Dosen) {
            ((Dosen) getElemenFasilkom(objek)).dropMataKuliah();
        } else {
            System.out.println("[DITOLAK] Hanya dosen yang dapat berhenti mengajar");
        }
    }

    /**
     * Mencetak informasi umum dari mahasiswa
     * @param objek Mahasiswa yang ingin dicetak informasinya
     */
    private static void ringkasanMahasiswa(String objek) {
        ElemenFasilkom elemenFasilkom = getElemenFasilkom(objek);
        // Jika elemenFasilkom merupakan mahasiswa
        if (getElemenFasilkom(objek).getTipe().equals("Mahasiswa")) {
            // Melakukan downcasting agar bisa menggunakan method di dalam Mahasiswa.java
            Mahasiswa mahasiswa = (Mahasiswa) elemenFasilkom;
            long npmMahasiswa = mahasiswa.getNpm();
            MataKuliah[] daftarMatkul = mahasiswa.getDaftarMataKuliah();

            System.out.printf(
                            "Nama: %s\n" +
                            "Tanggal lahir: %s\n" +
                            "Jurusan: %s\n", mahasiswa, mahasiswa.extractTanggalLahir(npmMahasiswa),
                    mahasiswa.extractJurusan(npmMahasiswa));
            System.out.println("Daftar Mata Kuliah:");
            // Jika mahasiswa tersebut sudah mengambil suatu mata kuliah
            if (daftarMatkul[0] != null) {
                int counterPrint = 1;
                for (MataKuliah matkul : daftarMatkul) {
                    if (matkul != null) {
                        System.out.println(counterPrint + ". " + matkul);
                        counterPrint++;
                    }
                }
            } else { // Jika mahasiswa tersebut belum mengambil mata kuliah sama sekali.
                System.out.println("Belum ada mata kuliah yang diambil");
            }
        } else { // Jika elemenFasilkom bukanlah mahasiswa
            System.out.printf("[DITOLAK] %s bukan merupakan seorang mahasiswa\n", elemenFasilkom);
        }
    }

    /**
     * Mencetak informasi umum dari mata kuliah
     * @param namaMataKuliah nama mata kuliah yang ingin dicetak informasinya
     */
    private static void ringkasanMataKuliah(String namaMataKuliah) {
        String pesanDosen;
        MataKuliah matkul = getMataKuliah(namaMataKuliah);

        // Pengecekan ada/tidaknya dosen pengajar
        if (matkul.getDosen() == null) {
            pesanDosen = "Belum ada";
        } else {
            pesanDosen = matkul.getDosen().toString();
        }

        System.out.printf(
                "Nama mata kuliah: %s\n" +
                "Jumlah mahasiswa: %s\n" +
                "Kapasitas: %d\n" +
                "Dosen pengajar: %s\n", matkul, matkul.getJumlahMahasiswa(), matkul.getKapasitas(), pesanDosen);
        System.out.println("Daftar mahasiswa yang mengambil mata kuliah ini:");

        if (matkul.getJumlahMahasiswa() != 0) {
            int counterPrint = 1;
            for (Mahasiswa mahasiswa : matkul.getDaftarMahasiswa()) {
                if (mahasiswa != null) {
                    System.out.println(counterPrint++ + ". " + mahasiswa.toString());
                }
            }
        } else {
            System.out.println("Belum ada mahasiswa yang mengambil mata kuliah ini");
        }

    }

    /**
     * Melakukan reset terhadap array telahMenyapa dan merangkum nilai friendship dari masing-masing elemenFasilkom
     */
    private static void nextDay() {
        // Menghitung friendship points dari masing-masing elemen fasilkom
        for (ElemenFasilkom elemenFasilkom : daftarElemenFasilkom) {
            if (elemenFasilkom != null && elemenFasilkom.getNumOfTelahMenyapa() >= Math.round(((totalElemenFasilkom - 1) / 2.0))) {
                elemenFasilkom.updateFriendship(10);
            } else if (elemenFasilkom != null && elemenFasilkom.getNumOfTelahMenyapa() < Math.round(((totalElemenFasilkom - 1) / 2.0))) {
                elemenFasilkom.updateFriendship(-5);
            }
        }

        System.out.println("Hari telah berakhir dan nilai friendship telah diupdate");
        friendshipRanking();

        // Reset array telahMenyapa
        for (ElemenFasilkom elemenFasilkom : daftarElemenFasilkom) {
            if (elemenFasilkom != null) {
                elemenFasilkom.resetMenyapa();
            } else if (elemenFasilkom == null) {
                break;
            }
        }
    }

    /**
     * Melakukan perhitungan dan pengurutan nilai friendship dari masing-masing elemenFasilkom
     */
    private static void friendshipRanking() {
        // Membuat variabel temp yang merupakan deep copy dari daftarElemenFasilkom
        ElemenFasilkom[] tempRank = daftarElemenFasilkom.clone();

        // Menerapkan algoritma bubble sort
        for (int i = 0; i < totalElemenFasilkom; i++) {
            for (int j = i + 1; j < totalElemenFasilkom; j++) {
                if (tempRank[i].getFriendship() < tempRank[j].getFriendship()) {
                    // Melakukan swap
                    ElemenFasilkom tempMax = tempRank[j];
                    tempRank[j] = tempRank[i];
                    tempRank[i] = tempMax;
                } else if (tempRank[i].getFriendship() == tempRank[j].getFriendship()) { // Jika friendship sama
                    if (tempRank[i].toString().compareToIgnoreCase(tempRank[j].toString()) > 0) { // Urutkan berdasarkan alfabet
                        // Melakukan swap
                        ElemenFasilkom tempMin = tempRank[j];
                        tempRank[j] = tempRank[i];
                        tempRank[i] = tempMin;
                    }
                }
            }
        }

        // Mencetak array yang telah di-sort
        int counterPrint = 1;
        for (ElemenFasilkom arraySorted : tempRank) {
            if (arraySorted != null) {
                System.out.println(String.format("%d. %s(%d)", counterPrint, arraySorted, arraySorted.getFriendship()));
                counterPrint++;
            }
        }
    }

    /**
     * Mengakhiri program
     */
    private static void programEnd() {
        System.out.println("Program telah berakhir. Berikut nilai terakhir dari friendship pada Fasilkom :");
        friendshipRanking();

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