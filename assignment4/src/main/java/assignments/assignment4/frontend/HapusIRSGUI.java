package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class HapusIRSGUI {

    public HapusIRSGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        JLabel sambutan = new JLabel();
        sambutan.setText("Hapus IRS");
        sambutan.setHorizontalAlignment(JLabel.CENTER);
        sambutan.setFont(SistemAkademikGUI.fontTitle);

        // TODO: Implementasikan Hapus IRS
    }

    // Uncomment method di bawah jika diperlukan
    /*
    private MataKuliah getMataKuliah(String nama) {

        for (MataKuliah mataKuliah : daftarMataKuliah) {
            if (mataKuliah.getNama().equals(nama)){
                return mataKuliah;
            }
        }
        return null;
    }

    private Mahasiswa getMahasiswa(long npm) {

        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            if (mahasiswa.getNpm() == npm){
                return mahasiswa;
            }
        }
        return null;
    }
    */
}
