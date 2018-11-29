package view;

import agencia.Cidade;
import agencia.Pacote;
import managerdb.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class AddCity {
    private JComboBox comboBox1;
    private JButton cancelarButton;
    private JButton adicionarButton;

    protected JPanel mainPanel;

    private Object obj;

    private Main db = new Main();

    public AddCity(JFrame f, ArrayList list) {
        comboBox1.addItem(" -- Escolha uma cidade -- ");
        ArrayList cities = db.getAllCities();
        for (int i = 0; i < cities.size(); i++) {
            comboBox1.addItem(cities.get(i));
        }

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    // Selecionei um ciade, e acidionar no pacote
                    obj = e.getItem();
                }
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
                //Cidade c = db.getCity(String.valueOf(obj));
                //p.setCidade(c);
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
                f.setVisible(false);
            }
        });
    }
}
