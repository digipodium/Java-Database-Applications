package example;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    private JTextField textOutput;
    private JButton buttonAC;
    private JButton buttonDiv;
    private JButton buttonPosNeg;
    private JButton buttonMod;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton buttonMul;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton buttonMinus;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton buttonPlus;
    private JButton button0;
    private JButton buttonDot;
    private JButton buttonEquals;
    private JPanel panel;

    public Calculator() {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300,200));
        frame.pack();
        frame.validate();
        frame.setVisible(true);
    }
}
