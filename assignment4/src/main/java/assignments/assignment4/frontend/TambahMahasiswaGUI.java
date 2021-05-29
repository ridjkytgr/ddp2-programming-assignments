package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class TambahMahasiswaGUI {

    public TambahMahasiswaGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah) {
        JPanel tambahMahasiswaGUIPanel = new JPanel();
        // Menambahkan glue agar konten ada di tengah
        tambahMahasiswaGUIPanel.add(Box.createVerticalGlue());

        tambahMahasiswaGUIPanel.setLayout(new BoxLayout(tambahMahasiswaGUIPanel, BoxLayout.Y_AXIS));
        tambahMahasiswaGUIPanel.setBackground(new Color(0xCD7841));

        // Menambahkan label Tambah Mahasiswa
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Tambah Mahasiswa");
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahMahasiswaGUIPanel.add(titleLabel);
        tambahMahasiswaGUIPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan label Nama:
        JLabel namaLabel = new JLabel();
        namaLabel.setText("Nama:");
        namaLabel.setFont(SistemAkademikGUI.fontGeneral);
        namaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahMahasiswaGUIPanel.add(namaLabel);
        tambahMahasiswaGUIPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan text field untuk Nama:
        JTextField namaField = new JTextField("", 30);
        namaField.setMaximumSize(new Dimension(250, 0));
        tambahMahasiswaGUIPanel.add(namaField);
        tambahMahasiswaGUIPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan label Nama:
        JLabel npmLabel = new JLabel();
        npmLabel.setText("NPM:");
        npmLabel.setFont(SistemAkademikGUI.fontGeneral);
        npmLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahMahasiswaGUIPanel.add(npmLabel);
        tambahMahasiswaGUIPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan text field untuk NPM:
        JTextField npmField = new JTextField("", 30);
        npmField.setMaximumSize(new Dimension(250, 0));
        tambahMahasiswaGUIPanel.add(npmField);
        tambahMahasiswaGUIPanel.add(Box.createRigidArea(new Dimension(0, 10)));

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
                // Mengambil nama dan npm pada textField
                String nama = namaField.getText();
                String npmString = npmField.getText();
                boolean flagNpmSama = false;

                // Mengecek keterisian field
                if (nama.equals("") || npmString.equals("")) {
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh Field");

                    // Mengosongkan field
                    namaField.setText("");
                    npmField.setText("");
                } else {
                    long npm = Long.parseLong(npmString);
                    // Mengecek apakah ada npm yang sama
                    for (Mahasiswa mahasiswa : daftarMahasiswa) {
                        if (mahasiswa != null && mahasiswa.getNpm() == npm) {
                            JOptionPane.showMessageDialog(frame, String.format("NPM %d sudah pernah ditambahkan sebelumnya", npm));

                            // Mengosongkan field
                            namaField.setText("");
                            npmField.setText("");
                            flagNpmSama = true;
                        } else if (mahasiswa == null) {
                            break;
                        }
                    }

                    // Jika tidak ada npm yang sama
                    if (!flagNpmSama) {
                        // Membuat instance mahasiswa dan memasukannya ke dalam ArrayList
                        Mahasiswa mhs = new Mahasiswa(nama, npm);
                        daftarMahasiswa.add(mhs);

                        // Menampilkan message
                        JOptionPane.showMessageDialog(frame, String.format("Mahasiswa %d-%s berhasil ditambahkan", npm, nama));

                        // Mengosongkan field
                        namaField.setText("");
                        npmField.setText("");
                    }
                }
            }
        });
        tambahMahasiswaGUIPanel.add(tambahkanButton);
        tambahMahasiswaGUIPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan button kembali
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
        tambahMahasiswaGUIPanel.add(kembaliButton);

        // Menambahkan glue agar konten ada di tengah
        tambahMahasiswaGUIPanel.add(Box.createVerticalGlue());

        frame.add(tambahMahasiswaGUIPanel);
        frame.setVisible(true);
    }

}
