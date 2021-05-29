# Tugas Pemrograman 4: GUI Sistem Akademik

CSGE601021 Dasar-Dasar Pemrograman 2 @ Fakultas Ilmu Komputer Universitas Indonesia,
Semester Genap 2020/2021

Dokumen ini berisi deskripsi dan informasi umum yang dibutuhkan untuk menyelesaikan Tugas Pemrograman 4 mata kuliah DDP 2. 
Tugas Pemrograman ini didesain untuk
mengimplementasikan konsep *Graphical User Interface* (GUI) dan beberapa algoritma dasar dalam pemrograman.

Tugas Pemrograman ini mencakup materi berikut:

- Materi yang dicakup Tugas Pemrograman 1, 2, dan 3
- *Graphical User Interface* menggunakan Java Swing

## Daftar Isi

1. [Latar belakang dan deskripsi](#latar-belakang-dan-deskripsi)
2. [Persiapan](#persiapan)
3. [Menjalankan dan menguji program](#menjalankan-dan-menguji-program)
4. [Pengumpulan](#pengumpulan)
5. [Daftar pekerjaan](#daftar-pekerjaan)
   1. [Daftar pekerjaan wajib](#daftar-pekerjaan-wajib)
6. [Penilaian](#penilaian)


## Latar belakang dan deskripsi
Silakan membaca [dokumen soal][dokumen tp4]
## Persiapan

Silakan ikuti persiapan yang ada pada berkas [`README.md`][root-readme] di
*root* repositori ini.

> Template pengerjaan tugas ini disediakan di *path* 
`src\main\java\assignments\assignment4` 
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
> gradlew.bat :assignment4:run --console plain
```

Untuk tugas pemrograman 4 ini, **tidak disediakan *unit test* dan *testcases* seperti tugas pemrograman sebelumnya**. Diharapkan Anda dapat mencoba langsung program Anda sesuai dengan ketentuan yang telah diberikan pada dokumen soal.

Jika kamu tidak ingin menggunakan Gradle, kamu juga bisa melakukan kompilasi
dan menjalankan program dengan `javac` dan `java` seperti biasa. Masuk ke
direktori `src\main\java`, *compile* semua berkas `.java` kamu, dan jalankan
*main class*-nya.

```bash
> cd src\main\java
src\main\java> javac assignments\assignment4\*.java
src\main\java> java assignments.assignment4.frontend.SistemAkademik
```

## Pengumpulan
Simpan pekerjaan kamu, lalu lakukan `add`, `commit`, dan `push` dengan Git.
*Push* solusi kamu **sebelum 04 Juni 2021 pukul 23.55**. Disarankan untuk
*push* **sebelum pukul 22.00** untuk mengantisipasi antrean pada GitLab
Pipelines.


## Daftar pekerjaan

### Daftar pekerjaan wajib
- [ ] Buat sekurang-kurangnya 1 *commit* yang mengandung progres kamu dalam
      mengerjakan Tugas Pemrograman 4.
- [ ] *Push* *commit* kamu ke repositori Git *online* yang ada pada proyek
      GitLab kamu.
- [ ] Implementasikan algoritma *sorting* dengan benar.
- [ ] Implementasikan *class* `DetailRingkasanMahasiswaGUI` dengan benar.
- [ ] Implementasikan *class* `DetailRingkasanMataKuliahGUI` dengan benar.
- [ ] Implementasikan *class* `HapusIRSGUI` dengan benar.
- [ ] Implementasikan *class* `HomeGUI` dengan benar.
- [ ] Implementasikan *class* `RingkasanMahasiswaGUI` dengan benar.
- [ ] Implementasikan *class* `RingkasanMataKuliahGUI` dengan benar.
- [ ] Implementasikan *class* `SistemAkademikGUI` dengan benar.
- [ ] Implementasikan *class* `TambahIRSGUI` dengan benar.
- [ ] Implementasikan *class* `TambahMahasiswaGUI` dengan benar.
- [ ] Implementasikan *class* `TambahMataKuliahGUI` dengan benar.
- [ ] Demonstrasikan program kamu ke asdos kamu.

## Penilaian
- **40%** `Kesesuaian Flow GUI dengan penjelasan soal`
- **10%** `Implementasi Algoritma Sorting`
- **10%** `Estetika GUI`
- **40%** `Demonstrasi Program ke Asisten`

***Selamat Mengerjakan!***

[dokumen tp4]: https://docs.google.com/document/d/1A__YjbR722mk2Pnn329wAq7jzv0F2PgJXp6WtzXYeBg/export?format=pdf&attachment=false
[root-readme]: ../README.md#memulai
