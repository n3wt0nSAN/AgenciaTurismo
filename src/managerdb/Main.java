package managerdb;

import agencia.Agencia;
import agencia.Cidade;
import agencia.Endereco;
import agencia.Museu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class Main {

    static SQLiteConnection db = new SQLiteConnection();
    static Tables tb = new Tables();

    static Connection conn = db.connect();
    SQLiteGetData getData = new SQLiteGetData(conn);
    SQLiteInsertData insertData = new SQLiteInsertData(conn);

    /**
     * Create the default tables
     *
     * @param conn
     * @param sql
     */
    public static void createNewTable(Connection conn, String sql) {
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addCity(Cidade c) {
        try {
            insertData.insertCity(c.getNome(), c.getEstado(), c.getPais());
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public void addAddress(Endereco e, String s) {
        try {
            // get city_id
            int city_id = getData.getCity(s);
            insertData.insertAddress(e.getRua(), e.getBairro(), e.getCep(), e.getNumero(), city_id);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    public void addEvents(Museu m, String nome, String horaInicio, String data, String type, String historia, Endereco e) {
        try {
            // get address_id
            int address_id =  getAdressId(e);
            if (type == "Museu") {
                insertData.insertMuseum(m.getNome(), m.getData(), m.getHorario(), m.getHistoria(), address_id);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    private int getAdressId(Endereco e) {
        try {
            int id = getData.getAddressId(e.getCep());
            return id;

        } catch (SQLException e1) {
            e1.printStackTrace();
            return -1;
        }
    }

    public ArrayList getAllAgencies() {
        try {
            ArrayList <Agencia> agencies = getData.selectAllAgencies();
            return agencies;
        } catch (SQLException sqle ) {
            System.out.println(sqle.getCause());
            return null;
        }
    }

    public ArrayList getAllCities() {
        try {
            ArrayList cities = getData.selectAllCities();
             return cities;
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            return null;
        }
    }



//    public Cidade getCity(String c) {
//        try {
//            Cidade city = getData.selectCity(c);
//            return city;
//        } catch (SQLException sqle) {
//            System.out.println(sqle.getMessage());
//            return null;
//        }
//
//    }

    public static void main(String[] args) throws SQLException {
        if (conn != null){
            System.out.println("Create a Cidade table!");
            createNewTable(conn, tb.tCidades);

            System.out.println("Create a Endereco table!");
            createNewTable(conn, tb.tEnderecos);

            System.out.println("Create a Contato table!");
            createNewTable(conn, tb.tContatos);

            System.out.println("Create a Agencia table!");
            createNewTable(conn, tb.tAgencias);

            System.out.println("Create a Usuario table!");
            createNewTable(conn, tb.tUsuarios);

            System.out.println("Create a Pacote table!");
            createNewTable(conn, tb.tPacotes);

            System.out.println("Create a Atração table!");
            createNewTable(conn, tb.tAtracoes);

            System.out.println("Create a Pacote_Cidade table!");
            createNewTable(conn, tb.tPacotesCidades);


            try {
                SQLiteInsertData insertData = new SQLiteInsertData(conn);
                /**
                 * Cadastrar a primeira agência
                 */
                insertData.insertCity("Goiânia", "GO", "Brasil");
                insertData.insertAddress("Rua R-21", "Itaiaia", "74.690-300",
                        101, 1);
                insertData.insertContact("999.999.999", "agenciaturismo@contato.com");
                insertData.insertAgency("Agencia de Turismo UFG", "000.000.000",
                        1, 1);

                /**
                 * Cadastrar a segunda agência
                 */
                insertData.insertCity("Brasília", "DF", "Brasil");
                insertData.insertAddress("Rua Planalto", "Centro", "99.999-000",
                        202, 2);
                insertData.insertContact("888.888.888", "turismofacil@contato.com");
                insertData.insertAgency("Agencia de Turismo Viagem Facil", "111.111.111.111-11",
                        2, 2);

                /**
                 * Cadastrar a terceira agência
                 */
                insertData.insertCity("São Paulo", "SP", "Brasil");
                insertData.insertAddress("Av. Paulista", "Centro", "55.555-000",
                        202, 2);
                insertData.insertContact("777.777.777", "saopaulotur@contato.com");
                insertData.insertAgency("Agencia de Turismo São Paulo Tur", "222.222.222.222-22",
                        2, 2);

            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
            } finally {
                conn.close();
            }

        }
    }


    public ArrayList getAllEvents() {
        return null;
    }


}
