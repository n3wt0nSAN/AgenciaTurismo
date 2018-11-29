package view;

import managerdb.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAgency {
    protected JPanel mainPanel;
    private JButton criarButton;
    private JButton alterarButton;
    private JButton excluirButton;
    private JButton aquivarButton;
    private JList list1;
    private JTable table1;
    private JLabel about;

    static JFrame frame;

    public MainAgency(Object ag) {

        about.setText(String.valueOf(ag));

        criarButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("Pacote");
                frame.setContentPane(new NewPackge().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
