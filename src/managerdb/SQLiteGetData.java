package managerdb;

import agencia.Agencia;
import agencia.Cidade;
import agencia.Endereco;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;


public class SQLiteGetData {
    private Connection conn;

    public SQLiteGetData(Connection conn) {
        this.conn = conn;
    }

    /**
     * Get city_id by the name
     *
     * @param name
     */
    public int getCity(String name) throws SQLException {
        String sql = "SELECT city_id, name, state, country "
                + "FROM cities WHERE name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the value
            pstmt.setString(1, name);
            ResultSet rs  = pstmt.executeQuery();

            Cidade c = new Cidade(rs.getString("name"),
                    rs.getString("state"), rs.getString("state"));

            return rs.getInt("city_id");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    /**
     * Get contact from number
     *
     * @param number String
     */
    public Data getContact(String number) throws SQLException {
        String sql = "SELECT contact_id, phone, email "
                + "FROM contacts WHERE phone = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the value
            pstmt.setString(1, number);
            ResultSet rs  = pstmt.executeQuery();

            Data d = new Data(rs.getInt("contact_id"), rs.getString("phone"),
                    rs.getString("email"));

            return d;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Get contact from number
     *
     * @param id
     */
    public Endereco getAddress(int id) throws SQLException {
        String sql = "SELECT street, neighborhood, cep, number, city_id "
                + "FROM addresses WHERE address_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the value
            pstmt.setInt(1, id);
            ResultSet rs  = pstmt.executeQuery();

            Cidade c = getCity(rs.getInt("city_id"));
            Endereco e = new Endereco(rs.getString("street"), rs.getInt("number"),
                    rs.getString("neighborhood"), rs.getString("cep"), c);

            return e;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int getAddressId(String cep) throws SQLException {
        String sql = "SELECT address_id"
                + "FROM addresses WHERE cep = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the value
            pstmt.setString(1, cep);
            ResultSet rs  = pstmt.executeQuery();

            return rs.getInt("address_id");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }

    public Cidade getCity(int id) throws SQLException {
        String sql = "SELECT * FROM cities WHERE city_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the value
            pstmt.setInt(1, id);
            ResultSet rs  = pstmt.executeQuery();

            Cidade c = new Cidade(rs.getString("name"), rs.getString("state"),
                    rs.getString("country"));

            return c;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Get all agencies from db
     *
     */
    public ArrayList selectAllAgencies() throws SQLException {
        try (Statement stmt  = conn.createStatement()) {
            String sql = "SELECT * FROM agencies";
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList <Agencia> lists  = new ArrayList<Agencia>();
            Agencia ag;
            while (rs.next()) {
                Endereco e = getAddress(rs.getInt("address_id"));
                ag = new Agencia(rs.getString("name"), rs.getString("cnpj"), e);
                lists.add(ag);
            }

            return lists;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList selectAllCities() throws SQLException{
        try (Statement stmt  = conn.createStatement()) {
            String sql = "SELECT * FROM cities";
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList <Cidade> lists  = new ArrayList<Cidade>();
            Cidade c;
            while (rs.next()) {
                c = new Cidade(rs.getString("name"), rs.getString("state"), rs.getString("country"));
                lists.add(c);
            }

            return lists;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
