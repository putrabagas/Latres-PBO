/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Latres;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.*;

/**
 *
 * @author Putra Bagas
 * 
 */
class InputDataKontak extends JFrame {
    JLabel ltitle,lnama,lnomor;
    JTextField txnama,txnomor;
    JButton btnsimpan, btnkembali;
    Statement statement;
    String nama, nomor;
    
    public InputDataKontak() {
        setTitle("INPUT DATA MAHASISWA");
        ltitle = new JLabel("Input Data Mahasiswa");
        lnama = new JLabel("Nama   : ");
        lnomor = new JLabel("Nomor :");
        
        txnama = new JTextField("");
        txnomor = new JTextField("");
        
        btnsimpan = new JButton("Simpan");
        btnkembali = new JButton("Kembali");
        
        setLayout(null);
        add(ltitle);
        add(lnama);
        add(lnomor);
        
        add(txnama);
        add(txnomor);
        
        add(btnsimpan);
        add(btnkembali);
        
        ltitle.setBounds(150, 50, 150, 30);
        lnama.setBounds(150, 90, 50, 20);
        lnomor.setBounds(150, 130, 50, 20);
        txnama.setBounds(200, 90, 120, 20);
        txnomor.setBounds(200, 130, 120, 20);
        btnsimpan.setBounds(150, 230, 90, 20);
        btnkembali.setBounds(250, 230, 90, 20);

        setSize(500,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        btnsimpan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    nama = txnama.getText();
                    nomor = txnomor.getText();
                    
                    Data data = new Data(nama, nomor);
                    
                    KoneksiDB koneksi = new KoneksiDB();
                    try {
                        statement = koneksi.getKoneksi().createStatement();
                        statement.executeUpdate("INSERT INTO kontak VALUES('"
                                + data.getNama() + "','" + data.getNomor() + "')");
                        JOptionPane.showMessageDialog(rootPane, "Data Tersimpan");
                    } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(InputDataKontak.class.getName()).log(Level.SEVERE, null, ex);
                    }catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(InputDataKontak.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "TIPE DATA SALAH");
                } catch (Error ext) {
                    JOptionPane.showMessageDialog(rootPane, "SALAH");

                }
                
            }
        });
        
        btnkembali.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Menu();
            }
        });

    }
    
}
