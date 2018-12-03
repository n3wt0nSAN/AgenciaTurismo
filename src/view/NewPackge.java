package view;

import agencia.Agencia;
import agencia.Atracao;
import agencia.Cidade;
import agencia.Pacote;
import managerdb.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewPackge {
    protected JPanel mainPanel;
    private JTextField name;
    private JButton cancelarButton;
    private JButton salvarButton;
    //protected JComboBox comboBox1;
    private JButton novaCidadeButton;
    private JSpinner diaInicio;
    private JSpinner mesInicio;
    private JSpinner anoInicio;
    private JSpinner diaFim;
    private JSpinner mesFim;
    private JSpinner anoFim;
    private JButton adicionarCidadeButton;
    private JButton cadastrarCidadeButton;
    private JButton adicionarAtraçãoButton;
    private JButton cadastrarAtraçãoButton;
    private JTextField preco;

    private Main db = new Main();

    protected static JFrame frame;
    protected ArrayList cities = new ArrayList();
    protected ArrayList events = new ArrayList();


    public NewPackge(JFrame f, Object ag) {

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
                frame.setContentPane(new AddAtracao(frame, events).mainPanel);
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
        salvarButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                int diaInicioValue = (int) diaInicio.getValue();
                int mesInicioValue = (int) mesInicio.getValue();
                int anoInicioValue = (int) anoInicio.getValue();
                String dataInicio = diaInicioValue + "/" + mesInicioValue + "/" + anoInicioValue;

                int diaFimValue = (int) diaFim.getValue();
                int mesFimValue = (int) mesFim.getValue();
                int anoFimValue = (int) anoFim.getValue();
                String dataFim = diaFimValue + "/" + mesFimValue + "/" + anoFimValue;

                double pc = Double.parseDouble(preco.getText());

                Agencia agencia = db.getAgency(String.valueOf(ag));
                Pacote p = new Pacote(name.getText(), dataInicio, dataFim, pc, agencia);
                for(int i=0; i < cities.size(); i++){
                    Cidade c = db.getCity(String.valueOf(cities.get(i)));
                    p.setCidade(c);
                }

                for(int j=0; j < events.size(); j++) {
                    Atracao a = db.getEvent(String.valueOf(events.get(j)));
                    p.setAtracao(a);
                }

                // Salvar o pacote
                db.addPackage(p);
                f.setVisible(false);
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.setVisible(false);
            }
        });
    }
}
