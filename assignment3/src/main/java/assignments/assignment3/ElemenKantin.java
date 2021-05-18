package assignments.assignment3;

class ElemenKantin extends ElemenFasilkom {
    private Makanan[] daftarMakanan = new Makanan[10];

    private int jumlahMakanan;

    public ElemenKantin(String nama) {
        super("ElemenKantin", nama);
    }

    /**
     * Memvalidasi makanan tertentu pada daftarMakanan
     * @param nama String nama makanan yang ingin dicek keberadaannya pada daftarMakanan
     * @return boolean true jika makanan tersebut belum ada di daftarMakanan, false sebaliknya
     */
    public boolean validateMakanan(String nama) {
        // Jika makanan tersebut sudah ada
        for (Makanan makanan : daftarMakanan) {
            if (makanan != null && makanan.toString().equals(nama)) {
                System.out.printf("[DITOLAK] %s sudah pernah terdaftar\n", nama);
                return false;
            } else if (makanan == null) {
                break;
            }
        }
        // Jika makanan tersebut belum ada di daftar makanan
        return true;
    }

    /**
     * Menambahkan makanan pada daftarMakanan
     * @param nama String nama makanan yang ingin ditambahkan
     * @param harga long harga makanan yang ingin ditambahkan
     */
    public void setMakanan(String nama, long harga) {
        if (validateMakanan(nama)) {
            Makanan makanan = new Makanan(nama, harga);
            daftarMakanan[jumlahMakanan++] = makanan;
            System.out.printf("%s telah mendaftarkan makanan %s dengan harga %d\n", this, nama, harga);
        }
    }

    /**
     * Mencari makanan tertentu yang berada di dalam array daftarMakanan
     * @param nama String nama makanan yang ingin dicari
     * @return objek Makanan yang ingin dicari
     */
    public Makanan getMakanan(String nama) {
        for (Makanan makanan : daftarMakanan) {
            if (makanan != null && makanan.toString().equals(nama)) {
                return makanan;
            } else if (makanan == null) {
                break;
            }
        }
        return null;
    }

    /**
     * Memastikan keberadaan makanan tertentu di dalam array daftarMakanan
     * @param namaMakanan String namaMakanan yang ingin dipastikan keberadaannya
     * @return boolean true jika makanan tersebut ada di dalam array daftarMakanan, false jika sebaliknya
     */
    public boolean cekKetersediaanMakanan(String namaMakanan) {
        for (Makanan makanan : daftarMakanan) {
            if (makanan != null && makanan.toString().equals(namaMakanan)) {
                return true;
            } else if (makanan == null) {
                break;
            }
        }
        return false;
    }
}