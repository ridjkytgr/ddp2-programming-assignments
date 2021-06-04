package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class HapusIRSGUI {

    public HapusIRSGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
        JPanel hapusIRSGUI = new JPanel();
        // Menambahkan glue agar konten ada di tengah
        hapusIRSGUI.add(Box.createVerticalGlue());

        hapusIRSGUI.setLayout(new BoxLayout(hapusIRSGUI, BoxLayout.Y_AXIS));
        hapusIRSGUI.setBackground(new Color(0x03C1BF));

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

        // Menambahkan gif
        ImageIcon pemandanganPict = new ImageIcon("assignment4/src/Pemandangan.gif");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        panel.add(new JLabel(pemandanganPict));
        panel.add(hapusIRSGUI);
        frame.add(panel);


        // Menambahkan label judul
        JLabel newLabel = new JLabel();
        newLabel.setText("Hapus IRS");
        newLabel.setFont(SistemAkademikGUI.fontTitle);
        newLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        hapusIRSGUI.add(newLabel);
        hapusIRSGUI.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan label dan dropdown pilih NPM
        addLabelGeneral(hapusIRSGUI, "Pilih NPM");
        JComboBox<Long> dropdownNpm = new JComboBox<>(arrayNpmSorted);
        dropdownNpm.setMaximumSize(new Dimension(175, 0));
        dropdownNpm.setMaximumRowCount(8);
        hapusIRSGUI.add(dropdownNpm);
        hapusIRSGUI.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan label dan dropdown pilih nama matkul
        addLabelGeneral(hapusIRSGUI, "Pilih Nama Matkul");
        JComboBox dropdownNamaMatkul = new JComboBox(arrayNamaMatkulSorted);
        dropdownNamaMatkul.setMaximumSize(new Dimension(175, 0));
        dropdownNamaMatkul.setMaximumRowCount(8);
        hapusIRSGUI.add(dropdownNamaMatkul);
        hapusIRSGUI.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan button Hapus
        JButton hapusButton = new JButton("Hapus");
        hapusButton.setFocusable(false);
        hapusButton.setFont(SistemAkademikGUI.fontGeneral);
        hapusButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        hapusButton.setForeground(new Color(0xFFFFFF));
        hapusButton.setBackground(new Color(0x0549B0));
        hapusButton.addActionListener(new ActionListener() {
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
                    String message = mahasiswa.dropMatkul(matkul);
                    JOptionPane.showMessageDialog(frame, message);

                }
            }
        });
        hapusIRSGUI.add(hapusButton);
        hapusIRSGUI.add(Box.createRigidArea(new Dimension(0, 10)));

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
        hapusIRSGUI.add(kembaliButton);


        // Menambahkan glue agar konten ada di tengah
        hapusIRSGUI.add(Box.createVerticalGlue());
        frame.setVisible(true);

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
                if (namaMatkul[i].compareToIgnoreCase(namaMatkul[j]) > 0) {
                    // Melakukan swap
                    String tempMin = namaMatkul[j];
                    namaMatkul[j] = namaMatkul[i];
                    namaMatkul[i] = tempMin;
                }
            }
        }
        return namaMatkul;
    }

    private void addLabelGeneral(JPanel panel, String text) {
        JLabel newLabel = new JLabel();
        newLabel.setText(text);
        newLabel.setFont(SistemAkademikGUI.fontGeneral);
        newLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(newLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
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
