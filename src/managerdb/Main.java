package managerdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class Main {

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

    public static void main(String[] args) throws SQLException {
        SQLiteConnection db = new SQLiteConnection();
        Tables tb = new Tables();

        Connection conn = db.connect();
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

            SQLiteInsertData insertData = new SQLiteInsertData(conn);
            //SQLiteGetData getData = new SQLiteGetData(conn);

            /**
             * Cadastrar a primeira agência
             */
            insertData.insertCity("Goiânia", "GO", "Brasil");
            insertData.insertAddress("Rua R-21", "Itaiaia", "74.690-300",
                    101, 1);
            insertData.insertContact("999.999.999", "agenciaturismo@contato.com");
            insertData.insertAgency("Agencia de Turismo UFG", "000.000.000.000-00",
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
        }
    }
}
