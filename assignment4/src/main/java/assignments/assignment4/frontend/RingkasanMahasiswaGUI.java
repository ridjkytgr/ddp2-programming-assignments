package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class RingkasanMahasiswaGUI {

    public RingkasanMahasiswaGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
        JPanel ringkasanMahasiswaGUI = new JPanel();
        // Menambahkan glue agar konten ada di tengah
        ringkasanMahasiswaGUI.add(Box.createVerticalGlue());

        ringkasanMahasiswaGUI.setLayout(new BoxLayout(ringkasanMahasiswaGUI, BoxLayout.Y_AXIS));
        ringkasanMahasiswaGUI.setBackground(new Color(0x03C1BF));

        // Membuat array yang menyimpan npm dari mahasiswa untuk ditampilkan pada dropdown
        Long[] arrayNpm = new Long[daftarMahasiswa.size()];

        // Mengisi array arrayNpm dengan NPM dari mahasiswa
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i) != null) {
                arrayNpm[i] = daftarMahasiswa.get(i).getNpm();
            } else if (daftarMahasiswa.get(i) == null) {
                break;
            }
        }

        // Melakukan sort terhadap arrayNpm
        Long[] arrayNpmSorted = sortNpm(arrayNpm);

        // Menambahkan gif
        ImageIcon pemandanganPict = new ImageIcon("assignment4/src/Sungai.gif");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        panel.add(new JLabel(pemandanganPict));
        panel.add(ringkasanMahasiswaGUI);
        frame.add(panel);


        // Menambahkan label judul
        JLabel newLabel = new JLabel();
        newLabel.setText("Ringkasan Mahasiswa");
        newLabel.setFont(SistemAkademikGUI.fontTitle);
        newLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ringkasanMahasiswaGUI.add(newLabel);
        ringkasanMahasiswaGUI.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan label Pilih NPM
        JLabel pilihNpmLabel = new JLabel();
        pilihNpmLabel.setText("Pilih NPM");
        pilihNpmLabel.setFont(SistemAkademikGUI.fontGeneral);
        pilihNpmLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ringkasanMahasiswaGUI.add(pilihNpmLabel);
        ringkasanMahasiswaGUI.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan dropdownNpm
        JComboBox<Long> dropdownNpm = new JComboBox<>(arrayNpmSorted);
        dropdownNpm.setMaximumSize(new Dimension(175, 0));
        dropdownNpm.setMaximumRowCount(8);
        ringkasanMahasiswaGUI.add(dropdownNpm);
        ringkasanMahasiswaGUI.add(Box.createRigidArea(new Dimension(0, 10)));

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
                Long npmSelected = (Long) dropdownNpm.getSelectedItem();

                // Jika terdapat dropdown yang masih kosong
                if (npmSelected == null) {
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh Field");
                } else {
                    // Membuka panel detail ringkasan mahasiswa
                    Mahasiswa mahasiswa = getMahasiswa(npmSelected, daftarMahasiswa);

                    // Menghapus panel
                    frame.getContentPane().removeAll();
                    frame.repaint();

                    new DetailRingkasanMahasiswaGUI(frame, mahasiswa, daftarMahasiswa, daftarMataKuliah);
                }
            }
        });
        ringkasanMahasiswaGUI.add(lihatButton);
        ringkasanMahasiswaGUI.add(Box.createRigidArea(new Dimension(0, 10)));

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
        ringkasanMahasiswaGUI.add(kembaliButton);


        // Menambahkan glue agar konten ada di tengah
        ringkasanMahasiswaGUI.add(Box.createVerticalGlue());

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

    private Mahasiswa getMahasiswa(long npm, ArrayList<Mahasiswa> daftarMahasiswa) {

        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            if (mahasiswa.getNpm() == npm){
                return mahasiswa;
            }
        }
        return null;
    }
}
