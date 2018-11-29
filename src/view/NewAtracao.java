package view;

import agencia.*;
import managerdb.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class NewAtracao {
    private JTextField textField1;
    private JTextField textBairro;
    private JTextField horario;
    private JButton cancelarButton;
    private JButton salvarButton;
    private JComboBox comboBox1;
    private JTextField ruaAv;
    private JSpinner numero;
    private JTextField textCep;
    private JSpinner dDia;
    private JSpinner dMes;
    private JSpinner dAno;
    protected JPanel mainPanel;
    private JComboBox comboBox2;
    private JTextField textHistoria;
    private JTextField textBandas;
    private JTextField textPrecos;

    protected static JFrame frame;
    protected static String history;

    private Main db = new Main();
    private Object obj;

    public NewAtracao(JFrame f) {
        comboBox1.addItem(" -- Escolha uma cidade -- ");
        ArrayList cities = db.getAllCities();
        for (int i = 0; i < cities.size(); i++) {
            comboBox1.addItem(cities.get(i));
        }

        comboBox2.addItem(" -- Escolha uma tipo de atração -- ");
        comboBox2.addItem("Museu");
        comboBox2.addItem("Show");
        comboBox2.addItem("Praia");

//        textHistoria.setVisible(false);
//        textPrecos.setVisible(false);
//        textBandas.setVisible(false);

        salvarButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String name =  textField1.getText();
                String horas = horario.getText();
                int dia = (int) dDia.getValue();
                int mes = (int) dMes.getValue();
                int ano = (int) dAno.getValue();

                // parametro para enderço
                String rua = ruaAv.getText();
                int num = (int) numero.getValue();
                String bairro = textBairro.getText();
                String cep = textCep.getText();

                // get cidade pelo nome usando Object obj

                Endereco end = new Endereco(rua, num, cep, bairro);
                db.addAddress(end, String.valueOf(obj));

                String data = dia + "/" + mes + "/" + ano;

                if (String.valueOf(obj) == "Museu") {
                    Museu m = new Museu(name, data, horas, textHistoria.getText(), end);
                    db.saveEvent((Atracao) m, );
                } else if (String.valueOf(obj) == "Praia") {
                    Praia p = new Praia(name, data, horas, textPrecos.getText(), end);
                    db.saveEvent((Atracao) p);
                } else {
                    Show s = new Show(name, data, horas, textBandas.getText(), end);
                    db.saveEvent((Atracao) s);
                }


                f.setVisible(false);
            }
        });

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    // Selecionei um ciade, e acidionar no pacote
                    obj = e.getItem();
                }
            }
        });

        comboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    // Criar nova janela para informções extras do tipo
                    obj = e.getItem();
                    System.out.println(obj);
                    if (String.valueOf(obj) == "Museu") {
                        // Ativa somente o textHistoria
                        textHistoria.setVisible(true);
                        textPrecos.setVisible(false);
                        textBandas.setVisible(false);
                    } else if (String.valueOf(obj) == "Praia") {
                        textPrecos.setVisible(true);
                        textBandas.setVisible(false);
                        textHistoria.setVisible(false);
                    } else {
                        textBandas.setVisible(true);
                        textPrecos.setVisible(false);
                        textHistoria.setVisible(false);
                    }
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
    }
}
