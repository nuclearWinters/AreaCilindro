/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.areacilindro;

/**
 *
 * @author armandorueda
 */
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Font;


public class AreaCilindro {

    public static void main(String[] args) {
        new AreaCilindro();
    }

    public AreaCilindro() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());

            JTextField field1 = new JTextField(10);
            JTextField field2 = new JTextField(10);
            JTextField field3 = new JTextField(10);
            TextPrompt placeholder = new TextPrompt("Radio", field1);
            placeholder.changeAlpha(0.75f);
            placeholder.changeStyle(Font.ITALIC);
            TextPrompt placeholder2 = new TextPrompt("Altura", field2);
            placeholder2.changeAlpha(0.75f);
            placeholder2.changeStyle(Font.ITALIC);

            DocumentListener dl = new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateFieldState();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateFieldState();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateFieldState();
                }

                protected void updateFieldState() {
                    try {
                        String radio = field1.getText();
                        double radioNumber = Double.parseDouble(radio);
                        String altura = field2.getText();
                        double alturaNumber = Double.parseDouble(altura);
                        double total = (radioNumber * radioNumber * 3.1416 * alturaNumber);
                        field3.setText(Double.toString(total));
                    } catch (Exception e) {
                        field3.setText("Escribe solo números");
                    }
                }
            };

            field1.getDocument().addDocumentListener(dl);
            field2.getDocument().addDocumentListener(dl);
            field3.setEditable(false);

            add(field1);
            add(field2);
            add(field3);
        }

    }

}

