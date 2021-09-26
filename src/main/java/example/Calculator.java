package example;

import javax.swing.*;

public class Calculator {
    private JTextField textOutput;
    private JButton ACButton;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton xButton;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton button7;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton button11;
    private JButton a0Button;
    private JButton button6;
    private JButton button8;
    private JPanel panel;

    public Calculator() {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.validate();
        frame.setVisible(true);
    }
}
