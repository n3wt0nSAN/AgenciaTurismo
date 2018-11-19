package view;

import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new MainFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
