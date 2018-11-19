package view;

import javax.swing.*;

public class MainFrame extends JFrame {
    protected JPanel mainPanel;
    private JLabel quemVcÉLabel;
    private JButton button1;
    private JButton button2;

    public MainFrame() {
        setSize(500,500);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
    }
}
