package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class TambahMataKuliahGUI{

    public TambahMataKuliahGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
        JPanel tambahMataKuliahGUIPanel = new JPanel();
        // Menambahkan glue agar konten ada di tengah
        tambahMataKuliahGUIPanel.add(Box.createVerticalGlue());

        tambahMataKuliahGUIPanel.setLayout(new BoxLayout(tambahMataKuliahGUIPanel, BoxLayout.Y_AXIS));
        tambahMataKuliahGUIPanel.setBackground(new Color(0xCD7841));

        // Menambahkan label judul
        JLabel newLabel = new JLabel();
        newLabel.setText("Tambah Mata Kuliah");
        newLabel.setFont(SistemAkademikGUI.fontTitle);
        newLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahMataKuliahGUIPanel.add(newLabel);
        tambahMataKuliahGUIPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Menambahkan label dan field
        addLabelGeneral(tambahMataKuliahGUIPanel, "Kode Mata Kuliah:");
        JTextField kodeMatkulField = new JTextField("", 30);
        kodeMatkulField.setMaximumSize(new Dimension(250, 0));
        tambahMataKuliahGUIPanel.add(kodeMatkulField);
        tambahMataKuliahGUIPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        addLabelGeneral(tambahMataKuliahGUIPanel, "Nama Mata Kuliah:");
        JTextField namaMatkulField = new JTextField("", 30);
        namaMatkulField.setMaximumSize(new Dimension(250, 0));
        tambahMataKuliahGUIPanel.add(namaMatkulField);
        tambahMataKuliahGUIPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        addLabelGeneral(tambahMataKuliahGUIPanel, "SKS:");
        JTextField sksField = new JTextField("", 30);
        sksField.setMaximumSize(new Dimension(250, 0));
        tambahMataKuliahGUIPanel.add(sksField);
        tambahMataKuliahGUIPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        addLabelGeneral(tambahMataKuliahGUIPanel, "Kapasitas:");
        JTextField kapasitasField = new JTextField("", 30);
        kapasitasField.setMaximumSize(new Dimension(250, 0));
        tambahMataKuliahGUIPanel.add(kapasitasField);
        tambahMataKuliahGUIPanel.add(Box.createRigidArea(new Dimension(0, 10)));

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
                String kodeMatkul = kodeMatkulField.getText();
                String namaMatkul = namaMatkulField.getText();
                String sksString = sksField.getText();
                String kapasitasString = kapasitasField.getText();
                boolean flagNamaMatkulSama = false;

                // Mengecek keterisian field
                if (kodeMatkul.equals("") || namaMatkul.equals("") || sksString.equals("") || kapasitasString.equals("")) {
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh Field");

                    // Mengosongkan field
                    kodeMatkulField.setText("");
                    namaMatkulField.setText("");
                    sksField.setText("");
                    kapasitasField.setText("");
                } else {
                    int sks = Integer.parseInt(sksString);
                    int kapasitas = Integer.parseInt(kapasitasString);

                    // Mengecek apakah ada nama mata kuliah yang sama
                    for (MataKuliah mataKuliah : daftarMataKuliah) {
                        if (mataKuliah != null && mataKuliah.toString().equals(namaMatkul)) {
                            JOptionPane.showMessageDialog(frame, String.format("Mata Kuliah %s sudah pernah ditambahkan sebelumnya", namaMatkul));

                            // Mengosongkan field
                            kodeMatkulField.setText("");
                            namaMatkulField.setText("");
                            sksField.setText("");
                            kapasitasField.setText("");

                            flagNamaMatkulSama = true;
                        } else if (mataKuliah == null) {
                            break;
                        }
                    }

                    // Jika tidak ada nama mata kuliah yang sama
                    if (!flagNamaMatkulSama) {
                        // Membuat instance matakuliah dan memasukannya ke dalam ArrayList
                        MataKuliah matkul = new MataKuliah(kodeMatkul, namaMatkul, sks, kapasitas);
                        daftarMataKuliah.add(matkul);

                        // Menampilkan message
                        JOptionPane.showMessageDialog(frame, String.format("Mata Kuliah %s berhasil ditambahkan", namaMatkul));

                        // Mengosongkan field
                        kodeMatkulField.setText("");
                        namaMatkulField.setText("");
                        sksField.setText("");
                        kapasitasField.setText("");
                    }
                }
            }
        });
        tambahMataKuliahGUIPanel.add(tambahkanButton);
        tambahMataKuliahGUIPanel.add(Box.createRigidArea(new Dimension(0, 10)));

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
        tambahMataKuliahGUIPanel.add(kembaliButton);



        // Menambahkan glue agar konten ada di tengah
        tambahMataKuliahGUIPanel.add(Box.createVerticalGlue());

        frame.add(tambahMataKuliahGUIPanel);
        frame.setVisible(true);
    }

    public void addLabelGeneral(JPanel panel, String text) {
        JLabel newLabel = new JLabel();
        newLabel.setText(text);
        newLabel.setFont(SistemAkademikGUI.fontGeneral);
        newLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(newLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
    }
}
