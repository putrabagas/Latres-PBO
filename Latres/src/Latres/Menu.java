/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Latres;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Putra Bagas
 */
public class Menu extends JFrame {

    JLabel ltitle;
    JButton input, tampil, exit;

    public void Menu() {

        setTitle("GUI MAHASISWA");

        ltitle = new JLabel("MENU");
        input = new JButton("Input Data Mahasiswa");
        tampil = new JButton("Tampilkan Seluruh Data");
        exit = new JButton("Exit");

        setLayout(null);
        add(ltitle);
        add(input);
        add(tampil);
        add(exit);
        
        ltitle.setBounds(180, 30, 50, 30);
        input.setBounds(100, 80, 200, 30);
        tampil.setBounds(100, 120, 200, 30);
//        hapus.setBounds(100, 160, 200, 30);
//        edit.setBounds(100, 200, 200, 30);
        exit.setBounds(100, 240, 200, 30);
        
        setSize(400, 350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        input.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                new InputDataKontak();
            }
        });
        
        tampil.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                new LihatDataKontak();
            }
        });
        
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

    }

}
