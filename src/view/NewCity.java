package view;

import agencia.Cidade;
import managerdb.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

public class NewCity {
    protected JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton cancelarButton;
    private JButton salvarButton;

    private Main db = new Main();

    public NewCity(JFrame f) {
        salvarButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String name =  textField1.getText();
                String state = textField2.getText();
                String country = textField3.getText();
                Cidade c = new Cidade(name, state, country);
                db.addCity(c);

                // add elemento crete to box of windo manager
                //cb.addItem(c.toString());

                // close this window
                f.setVisible(false);
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // close this window
                f.setVisible(false);
            }
        });
    };
}
