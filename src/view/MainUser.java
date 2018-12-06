package view;

import agencia.Agencia;
import agencia.Atracao;
import agencia.Endereco;
import agencia.Pacote;
import managerdb.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainUser {
    protected JPanel mainPanel;
    protected JPanel panel;
    private JButton pesquisarPorAgenciaButton;
    private JButton pesquisarPorCidadeButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton comprarPacoteButton;
    private JLabel nomeLabel;
    private JLabel periodoLabel;
    private JLabel precoLabel;
    private JComboBox atracaoBox;
    private JLabel nome;
    private JLabel periodo;
    private JLabel preco;
    private JLabel atracoes;
    private JLabel nomeAtracao;
    private JLabel atracaoData;
    private JLabel atracaoHorario;
    private JLabel atracaoEndereco;
    private JLabel labelAtData;
    private JLabel labelAtHorario;
    private JLabel labelAtEndereco;
    private Main db = new Main();

    Object agency;
    Object pack;
    Object event;

    public MainUser(JFrame f) {

        comboBox1.setVisible(false);
        comboBox1.addItem("-- Escolha uma Agência --");
        comboBox2.setVisible(false);
        comboBox2.addItem("-- Escolha um Pacote --");

        atracaoBox.addItem("-- Veja as Atrações --");

        comprarPacoteButton.setVisible(false);


        // pacote infos
        nome.setVisible(false);
        periodo.setVisible(false);
        preco.setVisible(false);
        atracoes.setVisible(false);
        atracaoBox.setVisible(false);
        nomeLabel.setVisible(false);
        periodoLabel.setVisible(false);
        precoLabel.setVisible(false);

        // atracao infos
        atracaoData.setVisible(false);
        atracaoHorario.setVisible(false);
        atracaoEndereco.setVisible(false);

        labelAtData.setVisible(false);
        labelAtHorario.setVisible(false);
        labelAtEndereco.setVisible(false);

        pesquisarPorAgenciaButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList agencies = db.getAllAgencies();
                for (int i = 0; i < agencies.size(); i++) {
                    Agencia ag = (Agencia) agencies.get(i);
                    comboBox1.addItem(ag);
                }

                comboBox1.setVisible(true);
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

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    // Selecionei um ciade, e acidionar no pacote
                    agency = e.getItem();

                    if (String.valueOf(agency) != "-- Escolha uma Agência --") {
                        System.out.println(agency);
                        // Pesquisar atração onde agencia é o evento X
                        ArrayList events = db.getAllPackagesFromAgency(String.valueOf(agency));
                        for (int i = 0; i < events.size(); i++) {
                            comboBox2.addItem(events.get(i));
                        }

                        comprarPacoteButton.setVisible(true);
                        comboBox2.setVisible(true);
                        f.pack();
                    } else {
                        comprarPacoteButton.setVisible(false);
                        comboBox2.setVisible(false);
                        f.pack();
                    }
                }
            }

        });

        comboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    // Selecionei um ciade, e acidionar no pacote
                    pack = e.getItem();

                    if (String.valueOf(pack) != "-- Escolha um Pacote --") {
                        System.out.println(pack);
                        // buscar informações do pacote
                        Pacote p = db.getPackage(String.valueOf(pack), String.valueOf(agency));


                        nomeLabel.setText(p.getName());
                        periodoLabel.setText(p.getDataIni() + " até " + p.getDataFim());
                        precoLabel.setText(String.valueOf(p.getPreco()));

                        // Adicionar as atrações do pacote
                        ArrayList<Atracao> events = p.getAtracoes();
                        for(int i=0; i < events.size(); i++){
                            Atracao at = events.get(i);
                            atracaoBox.addItem(at.getNome());
                        }

                        // colocar visivil infos do pacote
                        nome.setVisible(true);
                        periodo.setVisible(true);
                        preco.setVisible(true);
                        atracoes.setVisible(true);
                        atracaoBox.setVisible(true);
                        nomeLabel.setVisible(true);
                        periodoLabel.setVisible(true);
                        precoLabel.setVisible(true);
                        f.pack();

                    } else {
                        nome.setVisible(false);
                        periodo.setVisible(false);
                        preco.setVisible(false);
                        atracoes.setVisible(false);
                        atracaoBox.setVisible(false);
                        nomeLabel.setVisible(false);
                        periodoLabel.setVisible(false);
                        precoLabel.setVisible(false);

                        f.pack();
                    }
                }
            }
        });

        atracaoBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    // Selecionei um ciade, e acidionar no pacote
                    event = e.getItem();

                    if (String.valueOf(event) != "-- Veja as Atrações --") {
                        System.out.println(event);
                        // buscar informações do pacote
                        Atracao at = db.getEvent(String.valueOf(event));
                        System.out.println(at);

                        labelAtData.setText(at.getData());
                        labelAtHorario.setText(at.getHorario());
                        Endereco endereco = at.getEndereco();
                        System.out.println(endereco);
                        labelAtEndereco.setText(endereco.toString());

                        atracaoData.setVisible(true);
                        atracaoHorario.setVisible(true);
                        atracaoEndereco.setVisible(true);

                        labelAtData.setVisible(true);
                        labelAtHorario.setVisible(true);
                        labelAtEndereco.setVisible(true);
                        f.pack();

                    } else {
                        nomeAtracao.setVisible(false);
                        f.pack();
                    }
                }
            }
        });
    }
}
