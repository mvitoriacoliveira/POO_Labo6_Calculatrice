package calculator;
import calculator.Operation.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JButton {

    public JButton (String name){

    }
    private JTextField jNumber = new JTextField("0");
    //operations
    Addition add = new Addition();
    Substraction sub = new Substraction();
    Multiplication mult = new Multiplication();
    Divide div = new Divide();
    Inverse inv = new Inverse();
    Squared squ = new Squared();
    SquareRoot sqrt = new SquareRoot();
    UnaryOp unop = new UnaryOp();

    // buttons
    // Boutons
    javax.swing.JButton addButton = new javax.swing.JButton();
    javax.swing.JButton subButton = new javax.swing.JButton();
    javax.swing.JButton mulButton = new javax.swing.JButton();
    javax.swing.JButton divButton = new javax.swing.JButton();
    javax.swing.JButton sqaButton = new javax.swing.JButton();
    javax.swing.JButton sqrtButton = new javax.swing.JButton();
    javax.swing.JButton unOpButton = new javax.swing.JButton();

    javax.swing.JButton[] digitButtons = new javax.swing.JButton[10];

    public JButton() {
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add.execute(3, 4);
            }
        });

        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sub.execute(5, 2);
            }
        });

        mulButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mult.execute(6, 7);
            }
        });

        divButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                div.execute(8, 2);
            }
        });

        sqaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                squ.execute(9);
            }
        });

        sqrtButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sqrt.execute(16);
            }
        });

        unOpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                unop.execute(10);
            }
        });


        // Bouton 1-9
        for (int i = 1; i < 10; i++) {
            final int digit = i;
            digitButtons[i] = new javax.swing.JButton(String.valueOf(i));
            digitButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jNumber.setText(jNumber.getText() + digit);
                }
            });
        }

        // Bouton 0
        digitButtons[0] = new javax.swing.JButton("0");
        digitButtons[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jNumber.setText(jNumber.getText() + "0");
            }
        });
    }
}
