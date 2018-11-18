package managerdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLiteGetData {
    private Connection conn;

    public SQLiteGetData(Connection conn) {
        this.conn = conn;
    }

    /**
     * Get
     *
     * @param name
     */
    public Data getCity(String name) throws SQLException {
        String sql = "SELECT city_id, name, state, country "
                + "FROM cities WHERE name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the value
            pstmt.setString(1, name);
            ResultSet rs  = pstmt.executeQuery();

            Data d = new Data(rs.getInt("city_id"), rs.getString("name"),
                    rs.getString("state"), rs.getString("state"));

            return d;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
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
     * @param street
     * @param number
     * @param cep
     */
    public Data getAddress(String street, Integer number, String cep) throws SQLException {
        String sql = "SELECT address_id, street, neighborhood, cep, number, city_id "
                + "FROM addresses WHERE street = ? AND cep = ? AND number = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the value
            pstmt.setString(1, street);
            pstmt.setString(2, cep);
            pstmt.setInt(3,number);
            ResultSet rs  = pstmt.executeQuery();

            Data d = new Data(rs.getInt("address_id"), rs.getString("street"),
                    rs.getString("neighborhood"), rs.getString("cep"), rs.getInt("city_id"));

            return d;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
