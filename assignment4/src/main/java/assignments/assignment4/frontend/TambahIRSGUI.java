package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class TambahIRSGUI {

    public TambahIRSGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
        JPanel tambahIRSGUI = new JPanel();
        // Menambahkan glue agar konten ada di tengah
        tambahIRSGUI.add(Box.createVerticalGlue());

        tambahIRSGUI.setLayout(new BoxLayout(tambahIRSGUI, BoxLayout.Y_AXIS));
        tambahIRSGUI.setBackground(new Color(0x03C1BF));

        // Membuat array yang menyimpan npm dari mahasiswa untuk ditampilkan pada dropdown
        Long[] arrayNpm = new Long[daftarMahasiswa.size()];
        String[] arrayNamaMatkul = new String[daftarMataKuliah.size()];

        // Mengisi array arrayNpm dengan NPM dari mahasiswa
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i) != null) {
                arrayNpm[i] = daftarMahasiswa.get(i).getNpm();
            } else if (daftarMahasiswa.get(i) == null) {
                break;
            }
        }

        // Mengisi array arrayNamaMatkul dengan nama mata kuliah dari setiap mata kuliah
        for (int i = 0; i < daftarMataKuliah.size(); i++) {
            if (daftarMataKuliah.get(i) != null) {
                arrayNamaMatkul[i] = daftarMataKuliah.get(i).getNama();
            } else if (daftarMataKuliah.get(i) == null) {
                break;
            }
        }

        // Melakukan sorting terhadap array npm dan nama mata kuliah
        Long[] arrayNpmSorted = sortNpm(arrayNpm);
        String[] arrayNamaMatkulSorted = sortNamaMatkul(arrayNamaMatkul);

        // Menambahkan label judul
        JLabel newLabel = new JLabel();
        newLabel.setText("Tambah IRS");
        newLabel.setFont(SistemAkademikGUI.fontTitle);
        newLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahIRSGUI.add(newLabel);
        tambahIRSGUI.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan label dan dropdown pilih NPM
        addLabelGeneral(tambahIRSGUI, "Pilih NPM");
        JComboBox<Long> dropdownNpm = new JComboBox<>(arrayNpmSorted);
        dropdownNpm.setMaximumSize(new Dimension(175, 0));
        dropdownNpm.setMaximumRowCount(8);
        tambahIRSGUI.add(dropdownNpm);
        tambahIRSGUI.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan label dan dropdown pilih nama matkul
        addLabelGeneral(tambahIRSGUI, "Pilih Nama Matkul");
        JComboBox dropdownNamaMatkul = new JComboBox(arrayNamaMatkulSorted);
        dropdownNamaMatkul.setMaximumSize(new Dimension(175, 0));
        dropdownNamaMatkul.setMaximumRowCount(8);
        tambahIRSGUI.add(dropdownNamaMatkul);
        tambahIRSGUI.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan button Tambahkan
        JButton tambahkanButton = new JButton("Tambahkan");
        tambahkanButton.setFocusable(false);
        tambahkanButton.setFont(SistemAkademikGUI.fontGeneral);
        tambahkanButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahkanButton.setForeground(new Color(0xFFFFFF));
        tambahkanButton.setBackground(new Color(0x0549B0));
        tambahkanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengambil nilai dari dropdown
                Long npmSelected = (Long) dropdownNpm.getSelectedItem();
                String namaMatkulSelected = (String) dropdownNamaMatkul.getSelectedItem();

                // Jika terdapat dropdown yang masih kosong
                if (npmSelected == null || namaMatkulSelected == null) {
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh Field");
                } else {
                    // Mencari object dari data yang ada di dropdown
                    Mahasiswa mahasiswa = getMahasiswa(npmSelected, daftarMahasiswa);
                    MataKuliah matkul = getMataKuliah(namaMatkulSelected, daftarMataKuliah);

                    // Menampilkan message dialog berdasarkan hasil validasi matkul
                    String message = mahasiswa.addMatkul(matkul);
                    JOptionPane.showMessageDialog(frame, message);

                }
            }
        });
        tambahIRSGUI.add(tambahkanButton);
        tambahIRSGUI.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan button Kembali
        JButton kembaliButton = new JButton("Kembali");
        kembaliButton.setFocusable(false);
        kembaliButton.setFont(SistemAkademikGUI.fontGeneral);
        kembaliButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        kembaliButton.setForeground(new Color(0xFFFFFF));
        kembaliButton.setBackground(new Color(0x059846));
        kembaliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menghapus panel
                frame.getContentPane().removeAll();
                frame.repaint();

                // Pindah ke panel homeGUI
                new HomeGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });
        tambahIRSGUI.add(kembaliButton);

        // Menambahkan gif
        ImageIcon pemandanganPict = new ImageIcon("assignment4/src/Pemandangan.gif");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        panel.add(new JLabel(pemandanganPict));
        panel.add(tambahIRSGUI);
        frame.add(panel);

        // Menambahkan glue agar konten ada di tengah
        tambahIRSGUI.add(Box.createVerticalGlue());

        frame.setVisible(true);
    }

    private void addLabelGeneral(JPanel panel, String text) {
        JLabel newLabel = new JLabel();
        newLabel.setText(text);
        newLabel.setFont(SistemAkademikGUI.fontGeneral);
        newLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(newLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
    }

    private Long[] sortNpm(Long[] arrayNpm) {
        for (int i = 0; i < arrayNpm.length; i++) {
            for (int j = i + 1; j < arrayNpm.length; j++) {
                if (arrayNpm[i] > arrayNpm[j]) {
                    // Melakukan swap
                    Long tempMin = arrayNpm[j];
                    arrayNpm[j] = arrayNpm[i];
                    arrayNpm[i] = tempMin;
                }
            }
        }
        return arrayNpm;
    }

    private String[] sortNamaMatkul(String[] namaMatkul) {
        for (int i = 0; i < namaMatkul.length; i++) {
            for (int j = i + 1; j < namaMatkul.length; j++) {
                if (namaMatkul[i].compareTo(namaMatkul[j]) > 0) {
                    // Melakukan swap
                    String tempMin = namaMatkul[j];
                    namaMatkul[j] = namaMatkul[i];
                    namaMatkul[i] = tempMin;
                }
            }
        }
        return namaMatkul;
    }

    private MataKuliah getMataKuliah(String nama, ArrayList<MataKuliah> daftarMataKuliah) {

        for (MataKuliah mataKuliah : daftarMataKuliah) {
            if (mataKuliah.getNama().equals(nama)){
                return mataKuliah;
            }
        }
        return null;
    }

    private Mahasiswa getMahasiswa(long npm, ArrayList<Mahasiswa> daftarMahasiswa) {

        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            if (mahasiswa.getNpm() == npm){
                return mahasiswa;
            }
        }
        return null;
    }

}
