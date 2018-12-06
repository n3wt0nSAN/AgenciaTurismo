package view;

import agencia.Agencia;
import managerdb.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class MainUser {
    protected JPanel mainPanel;
    protected JPanel panel;
    private JButton pesquisarPorAgenciaButton;
    private JButton pesquisarPorCidadeButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton comprarPacoteButton;
    private Main db = new Main();

    public MainUser(JFrame f) {

        comboBox1.setVisible(false);
        comboBox2.setVisible(false);
        comprarPacoteButton.setVisible(false);

        pesquisarPorAgenciaButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList agencies = db.getAllAgencies();
                comboBox1.addItem("-- Escolha uma Agência --");
                for (int i = 0; i < agencies.size(); i++) {
                    Agencia ag = (Agencia) agencies.get(i);
                    comboBox1.addItem(ag);
                }

                // Pesquisar atração onde agencia é o evento X
                comboBox2.addItem(" -- Escolha uma Atração -- ");
                ArrayList events = db.getAllEvents();
                for (int i = 0; i < events.size(); i++) {
                    comboBox2.addItem(events.get(i));
                }
                comprarPacoteButton.setVisible(true);

                comboBox1.setVisible(true);
                comboBox2.setVisible(true);
                f.pack();



            }
        });
        pesquisarPorCidadeButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                comboBox1.addItem(" -- Escolha uma cidade -- ");
                ArrayList cities = db.getAllCities();
                for (int i = 0; i < cities.size(); i++) {
                    comboBox1.addItem(cities.get(i));
                }

                comboBox1.setVisible(true);
                f.pack();

            }
        });
    }
}
