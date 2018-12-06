package managerdb;

import agencia.*;

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
            sqle.printStackTrace();
        }
    }

    public void addAddress(Endereco e) {
        try {
            // get city_id
            Cidade c = e.getCidade();
            int city_id = getData.getCity(c.getNome());
            insertData.insertAddress(e.getRua(), e.getBairro(), e.getCep(), e.getNumero(), city_id);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    public void addPackage(Pacote p) {
        try {
            // get agency_id
            Agencia ag = p.getAgencia();
            int agency_id =  getData.selectAgencyId(ag.getNome());

            // get cities_ids
            ArrayList<Cidade> cities = p.getCidades();
            ArrayList<Integer> cities_ids = new ArrayList<>();

            for(int i=0; i < cities.size(); i++){
                Cidade c = cities.get(i);
                int id = getData.selectCityId(c.getNome());
                cities_ids.add(id);
            }

            // get events_ids
            ArrayList<Atracao> events = p.getAtracoes();
            ArrayList<Integer> events_ids = new ArrayList<>();

            for(int j=0; j < events.size(); j++){
                Atracao at = events.get(j);
                int id = getData.selectEventId(at.getNome());
                events_ids.add(id);
            }

            // TODO: Criar função pra salvar objeto

            insertData.insertPackage(p.getNome(), p.getDataIni(), p.getDataFim(), p.getPreco(), agency_id);


            int package_id = getData.selectPackageId(p.getNome());
            // Create insertPackageCity()
            for(int n=0; n < cities_ids.size(); n++){
                insertData.insertPackageCity(package_id, cities_ids.get(n));
            }

            // Create insertPackageEvent()
            for(int m=0; m < events_ids.size(); m++){
                insertData.insertPackageEvent(package_id, events_ids.get(m));
            }

            System.out.println("PACOTE SALVO COM SUCESSO!");

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }


    }


    private int getAddressId(Endereco e) {
        try {
            int id = getData.selectAddressId(e.getCep());
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
            sqle.printStackTrace();
            return null;
        }
    }

    public ArrayList getAllCities() {
        try {
            ArrayList cities = getData.selectAllCities();
             return cities;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
    }

    public ArrayList getAllEvents() {
        try {
            ArrayList atracoes = getData.selectAllEvents();
            return atracoes;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
    }

    public ArrayList getAllPackagesFromAgency(String name) {
        try {
            ArrayList agencies = getData.selectAllPackagesFromAgency(name);
            return agencies;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return null;
    }


    public Cidade getCity(String name) {
        try {
           Cidade c = getData.selectCityByName(name);
           return c;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public Agencia getAgency(String name) {
        try {
            Agencia a = getData.selectAgencyByName(name);
            return a;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return null;
    }


    public Atracao getEvent(String name) {
        try {
            Atracao a = getData.selectEventByName(name);
            return a;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public Pacote getPackage(String name, String agency) {
        try {
            Agencia a = getData.selectAgencyByName(agency);
            Pacote p = getData.selectPackageByName(name, a);
            return p;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public void saveMuseum(Museu m) {
        try {
            // get address_id
            Endereco e = m.getEndereco();
            int address_id =  getAddressId(e);
            if (address_id != -1) {
                insertData.insertMuseum(m.getNome(), m.getData(), m.getHorario(), m.getHistoria(), address_id);
            }
        } catch (SQLException e1) {
            System.out.println(e1.getMessage());
            e1.printStackTrace();
        }

    }

    public void savePraia(Praia p) {
        try {
            // get address_id
            Endereco e = p.getEndereco();
            int address_id =  getAddressId(e);
            if (address_id != -1) {
                insertData.insertBeach(p.getNome(), p.getData(), p.getHorario(), p.getPrecos(), address_id);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void saveShow(Show s) {
        try {
            // get address_id
            Endereco e = s.getEndereco();
            int address_id =  getAddressId(e);
            if (address_id != -1) {
                insertData.insertShow(s.getNome(), s.getData(), s.getHorario(), s.getBandas(), address_id);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
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

            System.out.println("Create a Pacote_Atracao table!");
            createNewTable(conn, tb.tPacotesAtracoes);

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
}
