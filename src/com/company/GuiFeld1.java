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

    //Creates the Gui for square number calculations
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

    //Opens the window with the operator for addition
    private void FensterAddition() {
        if (this.operator.equals("+")) {
            setVisible(false);
            Main Addition = new Main("Rechner", "+");
            Addition.setVisible(true);
        }
    }

    //// Opens the window with the operator for subtraction
    private void FensterSubtrahieren(){
        if (this.operator.equals("-")){
            setVisible(false);
            Main Subtraktion = new Main("Rechner", "-");
            Subtraktion.setVisible(true);
        }
    }

    //Opens the window with the operator for multiplication
    private void FensterMultiplizieren(){
        if (this.operator.equals("x")){
            setVisible(false);
            Main Multiplikation = new Main("Rechner", "x");
            Multiplikation.setVisible(true);
        }
    }

    //Opens the window with the operator for division
    private void FensterDividieren(){
        if (this.operator.equals(":")){
            setVisible(false);
            Main Division = new Main("Rechner", ":");
            Division.setVisible(true);
        }
    }

    //Opens the window for square number calculations
    public void FensterHoch2(){
        if (this.operator.equals("²")){
            GuiFeld1 Hoch2 = new GuiFeld1("Rechner", "²");
            Hoch2.setVisible(false);

        }
    }

    //Initializes the components of the calculator
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

        //Function of the plus button
        Addieren = new JButton("+");
        Addieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "+";
                FensterAddition();
            }
        });

        //Function of the minus button
        Subtrahieren = new JButton("-");
        Subtrahieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "-";
                FensterSubtrahieren();
            }
        });

        //Function of the multiply button
        Multiplizieren = new JButton("x");
        Multiplizieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "x";
                FensterMultiplizieren();
            }
        });

        //Function of the divide button
        Dividieren = new JButton(":");
        Dividieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = ":";
                FensterDividieren();
            }
        });

        //Function of the square button
        hoch2 = new JButton("²");
        hoch2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "²";

            }
        });

    }
}
