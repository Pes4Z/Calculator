package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiFeld1 extends JFrame {

    private JLabel Operator1;

    private JTextField field1;
    private JTextField field2;

    private JButton enter;
    private JButton Addieren;
    private JButton Subtrahieren;
    private JButton Multiplizieren;
    private JButton Dividieren;
    private JButton hoch2;

    private String operator;

    //Gui für Hoch2 Rechnungen
    public GuiFeld1(String titel, String operator){
        this.operator = operator;

        setTitle(titel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        setSize(250, 400);
        setResizable(false);

        initComponents();

        add(field1);
        add(Operator1);
        add(enter);
        add(Addieren);
        add(Subtrahieren);
        add(Multiplizieren);
        add(Dividieren);
        add(hoch2);

        setLocationRelativeTo(null);
        setVisible(true);



    }

    //Öffnet das Fenster mit dem Operator für Addition
    private void FensterAddition() {
        if (this.operator.equals("+")) {
            setVisible(false);
            Main Addition = new Main("Rechner", "+");
            Addition.setVisible(true);
        }
    }

    //Öffnet das Fenster mit dem Operator für Subtraktion
    private void FensterSubtrahieren(){
        if (this.operator.equals("-")){
            setVisible(false);
            Main Subtraktion = new Main("Rechner", "-");
            Subtraktion.setVisible(true);
        }
    }

    //Öffnet das Fenster mit dem Operator für Multiplikation
    private void FensterMultiplizieren(){
        if (this.operator.equals("x")){
            setVisible(false);
            Main Multiplikation = new Main("Rechner", "x");
            Multiplikation.setVisible(true);
        }
    }

    //Öffnet das Fenster mit dem Operator für Division
    private void FensterDividieren(){
        if (this.operator.equals(":")){
            setVisible(false);
            Main Division = new Main("Rechner", ":");
            Division.setVisible(true);
        }
    }

    //Öffnet das Fenster für hoch2
    public void FensterHoch2(){
        if (this.operator.equals("²")){
            GuiFeld1 Hoch2 = new GuiFeld1("Rechner", "²");
            Hoch2.setVisible(false);

        }
    }

    //Initialisiert die Componenten des Rechners
    private void initComponents() {
        Operator1 = new JLabel(operator + "                            ");

        field1 = new JTextField(8);
        field2 = new JTextField(8);

        enter = new JButton("=");
        enter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Double zahl1 = Double.parseDouble(field1.getText());


                double ergebnis;

                if (operator.equals("²")){
                    ergebnis = zahl1 * zahl1;
                }
                else {
                    ergebnis = 666;
                }

                JOptionPane.showMessageDialog(null, "Ergebnis: "+ ergebnis, "Ergebnis", JOptionPane.INFORMATION_MESSAGE);

                field1.setText("");
                field2.setText("");
            }

        });

        //Funktion des + Buttons
        Addieren = new JButton("+");
        Addieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "+";
                FensterAddition();
            }
        });

        //Funktion des - Buttons
        Subtrahieren = new JButton("-");
        Subtrahieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "-";
                FensterSubtrahieren();
            }
        });

        //Funktion des x Buttons
        Multiplizieren = new JButton("x");
        Multiplizieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "x";
                FensterMultiplizieren();
            }
        });

        //Funktion des : Buttons
        Dividieren = new JButton(":");
        Dividieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = ":";
                FensterDividieren();
            }
        });

        //Funktion des ² Buttons
        hoch2 = new JButton("²");
        hoch2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "²";

            }
        });

    }
}
