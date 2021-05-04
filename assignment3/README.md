# Tugas Pemrograman 3: Kehidupan Fasilkom

CSGE601021 Dasar-Dasar Pemrograman 2 @ Fakultas Ilmu Komputer Universitas Indonesia,
Semester Genap 2020/2021

Dokumen ini berisi deskripsi dan informasi umum yang dibutuhkan untuk menyelesaikan Tugas Pemrograman 3 mata kuliah DDP 2. 
Tugas Pemrograman ini didesain untuk
mengimplementasikan konsep Pemrograman Berorientasi Objek yang sederhana dengan memanfaatkan 7 buah class.

Tugas Pemrograman ini mencakup materi berikut:

- Materi yang dicakup Tugas Pemrograman 1 dan 2
- *Inheritance*
- *Abstract Classes*

## Daftar Isi

1. [Latar belakang dan deskripsi](#latar-belakang-dan-deskripsi)
2. [Persiapan](#persiapan)
3. [Menjalankan dan menguji program](#menjalankan-dan-menguji-program)
4. [Pengumpulan](#pengumpulan)
5. [Daftar pekerjaan](#daftar-pekerjaan)
   1. [Daftar pekerjaan wajib](#daftar-pekerjaan-wajib)
6. [Penilaian](#penilaian)


## Latar belakang dan deskripsi
Silakan membaca [dokumen soal][dokumen tp3]
## Persiapan

Silakan ikuti persiapan yang ada pada berkas [`README.md`][root-readme] di
*root* repositori ini.

> Template pengerjaan tugas ini disediakan di *path* 
`src\main\java\assignments\assignment3` 
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
> gradlew.bat :assignment3:run --console plain
```

Untuk tugas pemrograman 3 ini, tidak disediakan *unit test*. Hal ini 
digantikan dengan penggunaan *test case* yang disediakan pada folder 
<kbd>assignment3/testcases</kbd>

Untuk melihat output program dengan *test case* input yang disediakan:

```bash
> gradlew.bat :assignment3:run --console plain --quiet < assignment3\testcases\in\in1.txt
> gradlew.bat :assignment3:run --console plain --quiet < assignment3\testcases\in\in2.txt
```

*Hint*: kamu juga bisa menggunakan `>` setelah penjalanan command diatas untuk menyimpan output ke dalam sebuah *file* (lampirkan juga nama file yang akan dijadikan tempat peletakan output).

Contoh:
```bash
> gradlew.bat :assignment3:run --console plain --quiet < assignment3\testcases\in\in1.txt > assignment3\testcases\out1.txt
```

Jika kamu tidak ingin menggunakan Gradle, kamu juga bisa melakukan kompilasi
dan menjalankan program dengan `javac` dan `java` seperti biasa. Masuk ke
direktori `src\main\java`, *compile* semua berkas `.java` kamu, dan jalankan
*main class*-nya.

```bash
> cd src\main\java
src\main\java> javac assignments\assignment3\*.java
src\main\java> java assignments.assignment3.Main
```

## Pengumpulan
Simpan pekerjaan kamu, lalu lakukan `add`, `commit`, dan `push` dengan Git.
*Push* solusi kamu **sebelum 18 Mei 2021 pukul 23.55**. Disarankan untuk
*push* **sebelum pukul 22.00** untuk mengantisipasi antrean pada GitLab
Pipelines.


## Daftar pekerjaan

### Daftar pekerjaan wajib
- [ ] Buat sekurang-kurangnya 1 *commit* yang mengandung progres kamu dalam
      mengerjakan Tugas Pemrograman 3.
- [ ] *Push* *commit* kamu ke repositori Git *online* yang ada pada proyek
      GitLab kamu.
- [ ] Implementasikan *class* `Dosen` dengan benar.
- [ ] Implementasikan *class* `ElemenFasilkom` dengan benar.
- [ ] Implementasikan *class* `ElemenKantin` dengan benar.
- [ ] Implementasikan *class* `Mahasiswa` dengan benar.
- [ ] Implementasikan *class* `Main` dengan benar.
- [ ] Implementasikan *class* `Makanan` dengan benar.
- [ ] Implementasikan *class* `MataKuliah` dengan benar.
- [ ] Demonstrasikan program kamu ke asdos kamu.

## Penilaian
- 50% Kebenaran Program (output sesuai dengan ekspektasi berdasarkan input)
- 40% Demonstrasi Program ke Asisten
- 10% Kerapian kode dan dokumentasi program

***Selamat Mengerjakan!***

[dokumen tp3]: https://docs.google.com/document/d/15TqHsWyRtdkEaURI4A-kW90Ms0M4q6l1W6bkbgFv1VA/export?format=pdf&attachment=false
[root-readme]: ../README.md#memulai