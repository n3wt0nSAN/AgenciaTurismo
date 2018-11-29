package view;

import agencia.Agencia;
import managerdb.Main;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginAgency extends JFrame {
    protected JPanel mainPanel;
     String agency;

    private JLabel quemVcÉLabel;
    private JComboBox comboBox1;
    private JButton entrarButton;

    private Object obj;

    private Main db = new Main();
    static JFrame frame;


    public LoginAgency() {

        ArrayList agencies = db.getAllAgencies();
        comboBox1.addItem("-- Escolha uma Agência --");
        for (int i = 0; i < agencies.size(); i++) {
            Agencia ag = (Agencia) agencies.get(i);
            comboBox1.addItem(ag);
        }

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                     obj = e.getItem();
                }
            }
        });

        entrarButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame mf = new MainFrame();
                mf.closeWindow();

                frame = new JFrame("Gerenciamento da Agencia");
                frame.setContentPane(new MainAgency(obj).mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
    }
}
