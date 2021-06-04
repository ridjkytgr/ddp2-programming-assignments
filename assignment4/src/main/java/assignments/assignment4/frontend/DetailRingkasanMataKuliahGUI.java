package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class DetailRingkasanMataKuliahGUI {
    public DetailRingkasanMataKuliahGUI(JFrame frame, MataKuliah mataKuliah, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
        JPanel detailRingkasanMatkulGUI = new JPanel();
        // Menambahkan glue agar konten ada di tengah
        detailRingkasanMatkulGUI.add(Box.createVerticalGlue());

        detailRingkasanMatkulGUI.setLayout(new BoxLayout(detailRingkasanMatkulGUI, BoxLayout.Y_AXIS));
        detailRingkasanMatkulGUI.setBackground(new Color(0x00DB88));

        // Menambahkan label judul
        JLabel newLabel = new JLabel();
        newLabel.setText("Detail Ringkasan Mata Kuliah");
        newLabel.setFont(SistemAkademikGUI.fontTitle);
        newLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailRingkasanMatkulGUI.add(newLabel);
        detailRingkasanMatkulGUI.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menampung variabel label-label yang perlu ditampung
        String nama = mataKuliah.getNama();
        String kode = mataKuliah.getKode();
        int sks = mataKuliah.getSKS();
        int jumlahMahasiswa = mataKuliah.getJumlahMahasiswa();
        int kapasitas = mataKuliah.getKapasitas();
        Mahasiswa[] daftarMahasiswaMatkul = mataKuliah.getDaftarMahasiswa();

        // Menambahkan label-label yang akan ditampilkan
        addLabelGeneral(detailRingkasanMatkulGUI, "Nama mata kuliah: " + nama);
        addLabelGeneral(detailRingkasanMatkulGUI, "Kode: " + kode);
        addLabelGeneral(detailRingkasanMatkulGUI, "SKS: " + sks);
        addLabelGeneral(detailRingkasanMatkulGUI, "Jumlah mahasiswa: " + jumlahMahasiswa);
        addLabelGeneral(detailRingkasanMatkulGUI, "Kapasitas: " + kapasitas);
        addLabelGeneral(detailRingkasanMatkulGUI, "Daftar Mahasiswa:");

        // Mencetak daftar mahasiswa yang mengambil matkul yang bersangkutan
        if (jumlahMahasiswa == 0) {
            JLabel daftarMahasiswaLabel = new JLabel();
            daftarMahasiswaLabel.setText("Belum ada mahasiswa yang mengambil mata kuliah ini.");
            daftarMahasiswaLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
            daftarMahasiswaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            detailRingkasanMatkulGUI.add(daftarMahasiswaLabel);
            detailRingkasanMatkulGUI.add(Box.createRigidArea(new Dimension(0, 10)));
        } else {
            for (int i = 0; i < jumlahMahasiswa; i++) {
                JLabel daftarMahasiswaLabel = new JLabel();
                daftarMahasiswaLabel.setText(Integer.toString(i + 1) + ". " + daftarMahasiswaMatkul[i].getNama());
                daftarMahasiswaLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
                daftarMahasiswaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                detailRingkasanMatkulGUI.add(daftarMahasiswaLabel);
                detailRingkasanMatkulGUI.add(Box.createRigidArea(new Dimension(0, 10)));
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
        detailRingkasanMatkulGUI.add(kembaliButton);

        // Menambahkan scroller
        JScrollPane scrollPane = new JScrollPane(detailRingkasanMatkulGUI);
        frame.add(scrollPane);

        // Menambahkan glue agar konten ada di tengah
        detailRingkasanMatkulGUI.add(Box.createVerticalGlue());

        frame.add(detailRingkasanMatkulGUI);
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

