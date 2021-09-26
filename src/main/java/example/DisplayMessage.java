package example;

import javax.swing.*;
import java.awt.*;

public class DisplayMessage extends JFrame {
    private JPanel panel;
    private JLabel labelOne;
    private JLabel labelTwo;

    public DisplayMessage(){

        setLayout(new FlowLayout());
        panel.add(labelOne);
        panel.add(labelTwo);
        add(panel);
        validate();

    }

    public static void main(String[] args) {
        DisplayMessage gui = new DisplayMessage();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.pack();
        gui.setTitle("Showing example UI");
    }
}
