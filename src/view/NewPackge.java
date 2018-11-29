package view;

import managerdb.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewPackge {
    protected JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField5;
    private JButton cancelarButton;
    private JButton salvarButton;
    //protected JComboBox comboBox1;
    private JButton novaCidadeButton;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JSpinner spinner5;
    private JSpinner spinner6;
    private JButton adicionarCidadeButton;
    private JButton cadastrarCidadeButton;
    private JButton adicionarAtraçãoButton;
    private JButton cadastrarAtraçãoButton;

    private Main db = new Main();

    protected static JFrame frame;
    protected ArrayList cities = new ArrayList();


    public NewPackge() {

//        comboBox1.addItem(" -- Escolha uma cidade -- ");
//        ArrayList cities = db.getAllCities();
//        for (int i = 0; i < cities.size(); i++) {
//            comboBox1.addItem(cities.get(i));
//        }

        cadastrarCidadeButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                frame = new JFrame("Cidade");
                frame.setContentPane(new NewCity(frame).mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        adicionarCidadeButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("Add Cidade");
                frame.setContentPane(new AddCity(frame, cities).mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        adicionarAtraçãoButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("Add Atração");
                frame.setContentPane(new AddAtracao(frame, cities).mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        cadastrarAtraçãoButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("Criar Atração");
                frame.setContentPane(new NewAtracao(frame).mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
