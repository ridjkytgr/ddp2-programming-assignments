# Tugas Pemrograman 2: Sistem Akademik Fasilkom

CSGE601021 Dasar-Dasar Pemrograman 2 @ Fakultas Ilmu Komputer Universitas Indonesia,
Semester Genap 2020/2021

Dokumen ini berisi deskripsi dan informasi umum yang dibutuhkan untuk menyelesaikan Tugas Pemrograman 2 mata kuliah DDP 2. 
Tugas Pemrograman ini didesain untuk
mengimplementasikan konsep Pemrograman Berorientasi Objek yang sederhana dengan memanfaatkan 5 buah class.

Tugas Pemrograman ini mencakup materi berikut:

- Materi yang dicakup Tugas Pemrograman 1
- *Classes*
- *Objects*
- Struktur data *array* dan *list*

## Daftar Isi

1. [Latar belakang dan deskripsi](#latar-belakang-dan-deskripsi)
2. [Persiapan](#persiapan)
3. [Menjalankan dan menguji program](#menjalankan-dan-menguji-program)
4. [Pengumpulan](#pengumpulan)
5. [Daftar pekerjaan](#daftar-pekerjaan)
   1. [Daftar pekerjaan wajib](#daftar-pekerjaan-wajib)
   2. [Daftar pekerjaan bonus (opsional)](#daftar-pekerjaan-bonus)
6. [Penilaian](#penilaian)


## Latar belakang dan deskripsi
Silakan membaca [dokumen soal][dokumen tp2]
## Persiapan

Silakan ikuti persiapan yang ada pada berkas [`README.md`][root-readme] di
*root* repositori ini.

> Template pengerjaan tugas ini disediakan di *path* 
`src\main\java\assignments\assignment2` 
## Menjalankan dan menguji program

> Catatan:<br> 
> - Ubah `gradlew.bat` dengan `./gradlew` dan `\` dengan `/` jika kamu
menggunakan Linux/Mac.
> - Tanda <kbd>></kbd> pada awal *command* tidak perlu ditulis. 
Digunakan sebagai pembeda antara *command* dan *output*-nya

Kamu bisa menjalankan beberapa *task* dengan Gradle melalui IDE atau
terminal/Command Prompt.
Jalankan *task* tersebut di root folder dari repository ini.

Untuk menjalankan program:

```bash
> gradlew.bat :assignment2:run --console plain
```

Untuk menguji program dengan *unit test* yang disediakan:

```bash
> gradlew.bat :assignment2:test
```

> Tips: kamu bisa memeriksa hasil tes dalam bentuk dokumen HTML. Lihat dokumen
> HTML tersebut di dalam folder `build\reports` yang ada di direktori ini.

Untuk melihat output program dengan *test case* input yang disediakan:

```bash
> gradlew.bat :assignment2:run --console plain --quiet < assignment2\testcases\in\in1.txt
> gradlew.bat :assignment2:run --console plain --quiet < assignment2\testcases\in\in2.txt
```

*Hint*: kamu juga bisa menggunakan `>` setelah penjalanan command diatas untuk menyimpan output ke dalam sebuah *file* (lampirkan juga nama file yang akan dijadikan tempat peletakan output).

Contoh:
```bash
> gradlew.bat :assignment2:run --console plain --quiet < assignment2\testcases\in\in1.txt > assignment2\testcases\out1.txt
```

Jika kamu tidak ingin menggunakan Gradle, kamu juga bisa melakukan kompilasi
dan menjalankan program dengan `javac` dan `java` seperti biasa. Masuk ke
direktori `src\main\java`, *compile* semua berkas `.java` kamu, dan jalankan
*main class*-nya.

```bash
> cd src\main\java
src\main\java> javac assignments\assignment2\*.java
src\main\java> java assignments.assignment2.SistemAkademik
```

## Pengumpulan
Simpan pekerjaan kamu, lalu lakukan `add`, `commit`, dan `push` dengan Git.
*Push* solusi kamu **sebelum 04 April 2020 pukul 23.55**. Disarankan untuk
*push* **sebelum pukul 22.00** untuk mengantisipasi antrean pada GitLab
Pipelines.

Jangan lupa bahwa ada pengumpulan secara terpisah di SCeLE untuk Class Diagram
dengan *deadline* yang sama. Untuk lebih detailnya, silakan lihat dokumen soal
dan SCeLE.

## Daftar pekerjaan

### Daftar pekerjaan wajib
- [ ] Buat sekurang-kurangnya 1 *commit* yang mengandung progres kamu dalam
      mengerjakan Tugas Pemrograman 2.
- [ ] *Push* *commit* kamu ke repositori Git *online* yang ada pada proyek
      GitLab kamu.
- [ ] Implementasikan *class* `Mahasiswa` dengan benar.
- [ ] Implementasikan *class* `MataKuliah` dengan benar.
- [ ] Implementasikan *class* `SistemAkademik` dengan benar.
- [ ] Demonstrasikan program kamu ke asdos kamu.

### Daftar pekerjaan bonus
<sup><sup><sub><sub>Akhirnya, ada bonus!</sub></sub></sup></sup>
- [ ] Buat Class Diagram sesuai dengan *code* yang kamu buat dan kumpulkan di SCeLE.

## Penilaian
- 50% Kebenaran Program (output sesuai dengan ekspektasi berdasarkan input)
- 40% Demonstrasi Program ke Asisten
- 10% Kerapian kode dan dokumentasi program
- 5% (BONUS) Diagram UML dari kelas SistemAkademik, Mahasiswa, dan MataKuliah

***Selamat Mengerjakan!***

[dokumen tp2]: https://docs.google.com/document/u/3/d/1TXBIFI0DgGfdhLYm-kuzXD3WBSaGAos4PG75_dxx_ZM/export?format=pdf&attachment=false
[root-readme]: ../README.md#memulai