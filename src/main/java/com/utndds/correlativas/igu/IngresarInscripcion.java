package com.utndds.correlativas.igu;

import javax.swing.*;

public class IngresarInscripcion {
    private JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    private JTextField textField4;


    public void visible(){
        JFrame frame = new JFrame("IngresarInscripcion");
        frame.setContentPane(new IngresarInscripcion().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("IngresarInscripcion");
        frame.setContentPane(new IngresarInscripcion().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
