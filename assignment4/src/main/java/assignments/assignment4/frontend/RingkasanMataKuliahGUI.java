package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class RingkasanMataKuliahGUI {

    public RingkasanMataKuliahGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
        JPanel ringkasanMataKuliahGUI = new JPanel();
        // Menambahkan glue agar konten ada di tengah
        ringkasanMataKuliahGUI.add(Box.createVerticalGlue());

        ringkasanMataKuliahGUI.setLayout(new BoxLayout(ringkasanMataKuliahGUI, BoxLayout.Y_AXIS));
        ringkasanMataKuliahGUI.setBackground(new Color(0x00DB88));

        // Membuat array yang menyimpan nama mata kuliah untuk ditampilkan pada dropdown
        String[] arrayNamaMatkul = new String[daftarMataKuliah.size()];

        // Mengisi array arrayNamaMatkul dengan nama mata kuliah dari setiap mata kuliah
        for (int i = 0; i < daftarMataKuliah.size(); i++) {
            if (daftarMataKuliah.get(i) != null) {
                arrayNamaMatkul[i] = daftarMataKuliah.get(i).getNama();
            } else if (daftarMataKuliah.get(i) == null) {
                break;
            }
        }

        // Melakukan sort terhadap arrayNpm
        String[] arrayNamaMatkulSorted = sortNamaMatkul(arrayNamaMatkul);

        // Menambahkan label judul
        JLabel newLabel = new JLabel();
        newLabel.setText("Ringkasan Mata Kuliah");
        newLabel.setFont(SistemAkademikGUI.fontTitle);
        newLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ringkasanMataKuliahGUI.add(newLabel);
        ringkasanMataKuliahGUI.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan label Pilih NPM
        JLabel pilihNamaMatkulLabel = new JLabel();
        pilihNamaMatkulLabel.setText("Pilih Nama Matkul");
        pilihNamaMatkulLabel.setFont(SistemAkademikGUI.fontGeneral);
        pilihNamaMatkulLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ringkasanMataKuliahGUI.add(pilihNamaMatkulLabel);
        ringkasanMataKuliahGUI.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan dropdownMataKuliah
        JComboBox dropdownMataKuliah = new JComboBox(arrayNamaMatkulSorted);
        dropdownMataKuliah.setMaximumSize(new Dimension(175, 0));
        dropdownMataKuliah.setMaximumRowCount(8);
        ringkasanMataKuliahGUI.add(dropdownMataKuliah);
        ringkasanMataKuliahGUI.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan button Lihat
        JButton lihatButton = new JButton("lihat");
        lihatButton.setFocusable(false);
        lihatButton.setFont(SistemAkademikGUI.fontGeneral);
        lihatButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        lihatButton.setForeground(new Color(0xFFFFFF));
        lihatButton.setBackground(new Color(0x0549B0));
        lihatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengambil nilai dari dropdown
                String namaMatkul =  (String) dropdownMataKuliah.getSelectedItem();

                // Jika terdapat dropdown yang masih kosong
                if (namaMatkul == null) {
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh Field");
                } else {
                    // Membuka panel detail ringkasan mata kuliah
                    MataKuliah mataKuliah = getMataKuliah(namaMatkul, daftarMataKuliah);

                    // Menghapus panel
                    frame.getContentPane().removeAll();
                    frame.repaint();

                    new DetailRingkasanMataKuliahGUI(frame, mataKuliah, daftarMahasiswa, daftarMataKuliah);
                }
            }
        });
        ringkasanMataKuliahGUI.add(lihatButton);
        ringkasanMataKuliahGUI.add(Box.createRigidArea(new Dimension(0, 10)));

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
        ringkasanMataKuliahGUI.add(kembaliButton);


        // Menambahkan glue agar konten ada di tengah
        ringkasanMataKuliahGUI.add(Box.createVerticalGlue());

        frame.add(ringkasanMataKuliahGUI);
        frame.setVisible(true);
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

    private MataKuliah getMataKuliah(String nama, ArrayList<MataKuliah> daftarMataKuliah) {

        for (MataKuliah mataKuliah : daftarMataKuliah) {
            if (mataKuliah.getNama().equals(nama)){
                return mataKuliah;
            }
        }
        return null;
    }

}
