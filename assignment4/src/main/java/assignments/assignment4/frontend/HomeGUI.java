package assignments.assignment4.frontend;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class HomeGUI {
    
    public HomeGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
        JPanel homeGUIPanel = new JPanel();
        // Menambahkan glue agar konten ada di tengah
        homeGUIPanel.add(Box.createVerticalGlue());

        homeGUIPanel.setLayout(new BoxLayout(homeGUIPanel, BoxLayout.Y_AXIS));
        homeGUIPanel.setBackground(new Color(0x03C1BF));

        // Menambahkan label untuk homeGUI
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Selamat datang di Sistem Akademik");
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeGUIPanel.add(titleLabel);
        homeGUIPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Meng-import gif
        ImageIcon ngopiPict = new ImageIcon("assignment4/src/Ngopi.gif");

        // Menambahkan button-button yang diperlukan
        addButton(frame, daftarMahasiswa, daftarMataKuliah, homeGUIPanel,"Tambah Mahasiswa");
        addButton(frame, daftarMahasiswa, daftarMataKuliah, homeGUIPanel,"Tambah Mata Kuliah");
        addButton(frame, daftarMahasiswa, daftarMataKuliah, homeGUIPanel,"Tambah IRS");
        addButton(frame, daftarMahasiswa, daftarMataKuliah, homeGUIPanel,"Hapus IRS");
        addButton(frame, daftarMahasiswa, daftarMataKuliah, homeGUIPanel,"Lihat Ringkasan Mahasiswa");
        addButton(frame, daftarMahasiswa, daftarMataKuliah, homeGUIPanel,"Lihat Ringkasan Mata Kuliah");

        // Menempelkan gif
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        panel.add(homeGUIPanel);
        panel.add(new JLabel(ngopiPict));
        frame.add(panel);

        // Menambahkan glue agar konten tampil di tengah
        homeGUIPanel.add(Box.createVerticalGlue());

        frame.setVisible(true);
    }

    private void addButton(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah, JPanel panel, String text) {
        JButton newButton = new JButton(text);
        newButton.setFocusable(false);
        newButton.setFont(SistemAkademikGUI.fontGeneral);
        newButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newButton.setForeground(new Color(0xFFFFFF));
        newButton.setBackground(new Color(0x0549B0));
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text.equals("Tambah Mahasiswa")) {
                    // Menghapus panel
                    frame.getContentPane().removeAll();
                    frame.repaint();

                    // Pindah ke panel tambahMahasiswa
                    new TambahMahasiswaGUI(frame, daftarMahasiswa, daftarMataKuliah);
                } else if (text.equals("Tambah Mata Kuliah")) {
                    // Menghapus panel
                    frame.getContentPane().removeAll();
                    frame.repaint();

                    // Pindah ke panel tambahMataKuliah
                    new TambahMataKuliahGUI(frame, daftarMahasiswa, daftarMataKuliah);
                } else if (text.equals("Tambah IRS")) {
                    // Menghapus panel
                    frame.getContentPane().removeAll();
                    frame.repaint();

                    // Pindah ke panel tambahIRS
                    new TambahIRSGUI(frame, daftarMahasiswa, daftarMataKuliah);
                } else if (text.equals("Hapus IRS")) {
                    // Menghapus panel
                    frame.getContentPane().removeAll();
                    frame.repaint();

                    // Pindah ke panel hapusIRS
                    new HapusIRSGUI(frame, daftarMahasiswa, daftarMataKuliah);
                } else if (text.equals("Lihat Ringkasan Mahasiswa")) {
                    // Menghapus panel
                    frame.getContentPane().removeAll();
                    frame.repaint();

                    // Pindah ke panel hapusIRS
                    new RingkasanMahasiswaGUI(frame, daftarMahasiswa, daftarMataKuliah);
                } else if (text.equals("Lihat Ringkasan Mata Kuliah")) {
                    // Menghapus panel
                    frame.getContentPane().removeAll();
                    frame.repaint();

                    // Pindah ke panel hapusIRS
                    new RingkasanMataKuliahGUI(frame, daftarMahasiswa, daftarMataKuliah);
                }
            }
        });
        panel.add(newButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
    }
}