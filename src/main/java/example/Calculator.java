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
    private JButton btn0;
    private JButton buttonDot;
    private JButton buttonEquals;
    private JPanel panel;

    public String operation = null;
    public String operand1 = null;
    public String operand2 = null;

    public Calculator() {
        btn1.addActionListener(e -> updateOutput("1"));
        btn2.addActionListener(e -> updateOutput("2"));
        btn3.addActionListener(e -> updateOutput("3"));
        btn4.addActionListener(e -> updateOutput("4"));
        btn5.addActionListener(e -> updateOutput("5"));
        btn6.addActionListener(e -> updateOutput("6"));
        btn7.addActionListener(e -> updateOutput("7"));
        btn8.addActionListener(e -> updateOutput("8"));
        btn9.addActionListener(e -> updateOutput("9"));
        btn0.addActionListener(e -> updateOutput("0"));
        buttonPlus.addActionListener(e -> handleOperationClick("add"));
        buttonMinus.addActionListener(e -> handleOperationClick("sub"));
        buttonDiv.addActionListener(e -> handleOperationClick("div"));
        buttonMul.addActionListener(e -> handleOperationClick("mul"));
        buttonEquals.addActionListener(e -> handleOperation());

    }

    /**
     * handle click on operator like + - * /
     * take existing numbers from output area as input values
     *
     * @param operator the operator string
     */
    private void handleOperationClick(String operator) {
        operation = operator;
        operand1 = textOutput.getText();
        textOutput.setText("");
        System.out.println("->"+operator);
    }

    /**
     * handles onclick for = button
     */
    private void handleOperation() {
        operand2 = textOutput.getText();
        switch (operation) {
            case "add":
                addNumbers(operand1, operand2);
                break;
            case "sub":
                break;
            case "mul":
                break;
            case "div":
                break;
            default:
                System.out.println(operation == "add");
                break;
        }

        System.out.println("op1 is ->" + operand1);
        System.out.println("operation is ->" + operation);
        System.out.println("op2 is ->" + operand2);
    }

    private void addNumbers(String operand1, String operand2) {
        if (operand1.contains(".") || operand2.contains(".")) {
            float op1 = Float.parseFloat(operand1);
            float op2 = Float.parseFloat(operand2);
            float out = op1 + op2;
            show_and_swap(operand2, String.valueOf(out));
        } else if (!operand1.contains(".") && !operand2.contains(".")) {
            int op1 = Integer.parseInt(operand1);
            int op2 = Integer.parseInt(operand2);
            int out = op1 + op2;
            show_and_swap(operand2, String.valueOf(out));
        } else{
            textOutput.setText("ERROR");
            // log result for
            System.out.println(operand1);
            System.out.println("+");
            System.out.println(operand2);
        }
    }

    private void show_and_swap(String operand2, String s) {
        textOutput.setText(s);
        this.operand1 = operand2;
        this.operand2 = s;
    }

    //todo add function to subtract
    //todo add function to divide
    //todo add function to multiply
    //todo add function to mod
    //todo add function to pos_neg
    //todo add function to clear
    //todo add function to . click

    private void updateOutput(String s) {
        String oldText = textOutput.getText();
        textOutput.setText(oldText + s);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.validate();
        frame.setVisible(true);
    }
}
