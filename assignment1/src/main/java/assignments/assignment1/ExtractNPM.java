package assignments.assignment1;

import java.util.Scanner;

public class ExtractNPM {
    /*
    You can add other method do help you solve
    this problem

    Some method you probably need like
    - Method to get tahun masuk or else
    - Method to help you do the validation
    - and so on
    */

    public static boolean validate(long npm) {
        // Mengubah NPM menjadi String
        String npmString = Long.toString(npm);

        // Variabel counter akan ditambahkan jika syarat validasi terpenuhi
        int counter = 0;

        // Melakukan pengecekan panjang dari NPM
        if (npmString.length() == 14) {
            counter += 1;
            // Dilakukan di dalam if agar dipastikan terlebih dahulu npm tersebut ada 14 angka
            if (kodeNpmVal(npmString)) { // Pengecekan kode NPM
                counter += 1;
            } if (jurusanVal(npmString)) { // Pengecekan kode jurusan
                counter += 1;
            } if (umurVal(npmString)) { // Pengecekan umur
                counter += 1;
            }
        }
        // Melakukan pengecekan validasi dengan menghitung nilai counter
        if (counter == 4) {
            return true;
        } else {
            return false;
        }
    }

    public static String extract(long npm) {
        String npmString = Long.toString(npm);
        String tahunMasuk = "20" + npmString.substring(0, 2);
        String jurusan = jurusanExt(npmString);
        String tanggalLahir = tanggalLahirExt(npmString);

        return "Tahun masuk: " + tahunMasuk + "\n" + "Jurusan: " + jurusan + "\n" + "Tanggal Lahir: " + tanggalLahir;
    }
    // Membuat method untuk mengecek kode jurusan (proses validasi)
    public static boolean jurusanVal(String npmString) {
        String kodeJurusan = npmString.substring(2, 4);
        if (kodeJurusan.equals("01") || kodeJurusan.equals("02") || kodeJurusan.equals("03") || kodeJurusan.equals("11") || kodeJurusan.equals("12"))
            return true;
        else return false;
    }

    // Membuat method untuk menghitung umur dari mahasiswa (proses validasi)
    public static boolean umurVal(String npm) {
        // Mengambil informasi tahun masuk dan tahun lahir dari npm
        String tahunMasuk = "20" + npm.substring(0, 2);
        String tahunLahir = npm.substring(8, 12);
        int tahunMasukInt = Integer.parseInt(tahunMasuk);
        int tahunLahirInt = Integer.parseInt(tahunLahir);

        // Melakukan pengecekan umur (harus >= 15)
        if ((tahunMasukInt - tahunLahirInt) >= 15) {
            return true;
        } else {
            return false;
        }
    }
    // Membuat method untuk melakukan pengecekan kode NPM (proses validasi)
    public static boolean kodeNpmVal(String npm) {
        // Counter untuk menambahkan hasil penjumlahan
        int counter1 = 0;
        int counter2 = 0;
        // Melakukan pengembilan 13 digit pertama dari NPM
        String validator = npm.substring(0, 13);
        int kodeNpm = Integer.parseInt(String.valueOf(npm.charAt(13)));
        // Melakukan penjumlahan pasangan digit
        for (int i = 0; i <= 5; i++) {
            // Mengembil 2 digit yang berpasangan
            int validator1 = Integer.parseInt(String.valueOf(validator.charAt(i)));
            int validator2 = Integer.parseInt(String.valueOf(validator.charAt(12 - i)));

            // Melakukan penjumlahan 2 digit tersebut
            counter1 += validator1 * validator2;
        }
        // Menambahkan counter dengan digit NPM terakhir
        counter1 += Integer.parseInt(String.valueOf(validator.charAt(6)));

        // Loop untuk menjumlahkan digit-digit NPM setelah melakukan penjumlahan pasangan digit
        while (counter1 >= 10) {
            while (counter1 > 0) {
                counter2 += counter1 % 10;
                counter1 /= 10;
            }
            counter1 = counter2;
        }

        // Mengecek apakah hasil penjumlahan digit-digit tersebut == Kode NPM
        if (counter1 == kodeNpm) {
            return true;
        } else {
            return false;
        }
    }
    // Membuat method untuk melakukan assignment kode jurusan ke dalam nama jurusan
    public static String jurusanExt (String npm) {
        String kodeJurusan = npm.substring(2,4);
        String jurusan = "";
        if (kodeJurusan.equals("01")) {
            jurusan += "Ilmu Komputer";
        } else if (kodeJurusan.equals("02")) {
            jurusan += "Sistem Informasi";
        } else if (kodeJurusan.equals("03")) {
            jurusan += "Teknologi Informasi";
        } else if (kodeJurusan.equals("11")) {
            jurusan += "Teknik Telekomunikasi";
        } else if (kodeJurusan.equals("12")) {
            jurusan += "Teknik Elektro";
        }
        return jurusan;
    }
    // Membuat method untuk melakukan perubahan format tanggal lahir
    public static String tanggalLahirExt (String npm) {
        String tanggalLahir = "";
        tanggalLahir += npm.substring(4,6) + "-" + npm.substring(6,8) + "-" + npm.substring(8, 12);
        return tanggalLahir;
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        boolean exitFlag = false;
        while (!exitFlag) {
            long npm = input.nextLong();
            if (npm < 0) {
                exitFlag = true;
                break;
            }

            // TODO: Check validate and extract NPM
            if (!validate(npm)) {
                System.out.println("NPM tidak valid");
            } else {
                System.out.println(extract(npm));
            }
        }
        input.close();
    }
}
