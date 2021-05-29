package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class DetailRingkasanMahasiswaGUI {
    public DetailRingkasanMahasiswaGUI(JFrame frame, Mahasiswa mahasiswa, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
        JPanel detailRingkasanMhsGUI = new JPanel();
        // Menambahkan glue agar konten ada di tengah
        detailRingkasanMhsGUI.add(Box.createVerticalGlue());

        detailRingkasanMhsGUI.setLayout(new BoxLayout(detailRingkasanMhsGUI, BoxLayout.Y_AXIS));
        detailRingkasanMhsGUI.setBackground(new Color(0xCD7841));

        // Menambahkan label judul
        JLabel newLabel = new JLabel();
        newLabel.setText("Detail Ringkasan Mahasiswa");
        newLabel.setFont(SistemAkademikGUI.fontTitle);
        newLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailRingkasanMhsGUI.add(newLabel);
        detailRingkasanMhsGUI.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menampung variabel label-label yang perlu ditampung
        String nama = mahasiswa.getNama();
        long npm = mahasiswa.getNpm();
        String jurusan = mahasiswa.extractJurusan(mahasiswa.getNpm());

        MataKuliah[] matkul = mahasiswa.getMataKuliah();
        int banyakMatkul = mahasiswa.getBanyakMatkul();

        int sks = mahasiswa.getTotalSKS();

        mahasiswa.cekIRS();
        String[] masalahIRS = mahasiswa.getMasalahIRS();
        int banyakMasalahIRS = mahasiswa.getBanyakMasalahIRS();


        // Menambahkan label-label yang akan ditampilkan
        addLabelGeneral(detailRingkasanMhsGUI, "Nama: " + nama);
        addLabelGeneral(detailRingkasanMhsGUI, "NPM: " + npm);
        addLabelGeneral(detailRingkasanMhsGUI, "Jurusan: " + jurusan);
        addLabelGeneral(detailRingkasanMhsGUI, "Daftar Mata Kuliah:");

        // Mencetak matkul-matkul yang diambil oleh mahasiswa
        for (int i = 0; i < banyakMatkul; i++) {
            JLabel masalahIRSLabel = new JLabel();
            masalahIRSLabel.setText(Integer.toString(i+1) + ". " + matkul[i]);
            masalahIRSLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
            masalahIRSLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            detailRingkasanMhsGUI.add(masalahIRSLabel);
            detailRingkasanMhsGUI.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        addLabelGeneral(detailRingkasanMhsGUI, "Total SKS: " + sks);
        addLabelGeneral(detailRingkasanMhsGUI, "Hasil Pengecekan IRS:");

        // Mencetak hasil pengecekan IRS
        if (banyakMasalahIRS == 0) {
            JLabel masalahIRSLabel = new JLabel();
            masalahIRSLabel.setText("IRS tidak bermasalah.");
            masalahIRSLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
            masalahIRSLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            detailRingkasanMhsGUI.add(masalahIRSLabel);
            detailRingkasanMhsGUI.add(Box.createRigidArea(new Dimension(0, 10)));
        } else {
            for (int i = 0; i < banyakMasalahIRS; i++) {
                JLabel masalahIRSLabel = new JLabel();
                masalahIRSLabel.setText(Integer.toString(i + 1) + ". " + masalahIRS[i]);
                masalahIRSLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
                masalahIRSLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                detailRingkasanMhsGUI.add(masalahIRSLabel);
                detailRingkasanMhsGUI.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }

        // Menambahkan button Selesai
        JButton kembaliButton = new JButton("Selesai");
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
        detailRingkasanMhsGUI.add(kembaliButton);

        // Menambahkan glue agar konten ada di tengah
        detailRingkasanMhsGUI.add(Box.createVerticalGlue());

        frame.add(detailRingkasanMhsGUI);
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

}
