package view;

import javax.swing.*;

public class Runner {
    static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("App");
        frame.setContentPane(new MainFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void closeWindow () {
        this.frame.setVisible(false);
    }
}
