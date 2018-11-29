package view;

import managerdb.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class AddAtracao {
    private JComboBox comboBox1;
    private JButton cancelarButton;
    private JButton adicionarButton;
    protected JPanel mainPanel;
    private Object obj;

    private Main db = new Main();

    public AddAtracao(JFrame f, ArrayList list) {
        comboBox1.addItem(" -- Escolha uma Atração -- ");
        ArrayList events = db.getAllEvents();
//        for (int i = 0; i < events.size(); i++) {
//            comboBox1.addItem(events.get(i));
//        }

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    obj = e.getItem();
                }
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
                f.setVisible(false);
            }
        });

        adicionarButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(String.valueOf(obj));
                System.out.println(list);
                f.setVisible(false);
            }
        });
    }
}
