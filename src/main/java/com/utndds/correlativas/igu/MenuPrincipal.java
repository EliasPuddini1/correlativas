package com.utndds.correlativas.igu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal {
    private JLabel txtMenu;
    private JButton btnIInscrp;
    private JButton verDatosButton;
    private JPanel panel;


    public void SwingUI(){

        btnIInscrp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                IngresarInscripcion ingresarInscripcion = new IngresarInscripcion();
                ingresarInscripcion.visible();
            }
        });

    }

    public void visible() {
        JFrame frame = new JFrame("MenuPrincipal");
        frame.setContentPane(new MenuPrincipal().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MenuPrincipal");
        frame.setContentPane(new MenuPrincipal().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
