package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    protected JPanel mainPanel;
    private JLabel quemVcÉLabel;
    private JButton viajanteButton;
    private JButton agenteButton;

    static JFrame frame;

    public MainFrame() {
        agenteButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("Login na Agência");
                frame.setContentPane(new LoginAgency().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

                Runner r = new Runner();
                r.closeWindow();
            }
        });
        viajanteButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("Painel do Usuário");
                frame.setContentPane(new MainUser(frame).mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);


                Runner r = new Runner();
                r.closeWindow();
            }
        });
    }


    public void closeWindow () {
        this.frame.setVisible(false);
    }
}
