package managerdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteInsertData {
    private Connection conn;

    public SQLiteInsertData(Connection conn){
        this.conn = conn;
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param cnpj
     * @param address_id
     * @param contact_id
     */

    public void insertAgency(String name, String cnpj, Integer address_id, Integer contact_id) throws SQLException {
        String sql = "INSERT INTO agencies(name,cnpj,address_id,contact_id) VALUES(?,?,?,?)";

        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, cnpj);
        pstmt.setInt(3, address_id);
        pstmt.setInt(4, contact_id);
        pstmt.executeUpdate();
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param street
     * @param neighborhood
     * @param cep
     * @param number
     * @param city_id Integer foreign key
     */
    public void insertAddress(String street, String neighborhood, String cep, Integer number, Integer city_id) throws SQLException {
        String sql;

        if (number != null) {
            sql = "INSERT INTO addresses(street,neighborhood,cep,number,city_id) VALUES(?,?,?,?,?)";
        } else {
            sql = "INSERT INTO addresses(street,neighborhood,cep,city_id) VALUES(?,?,?,?)";
            number = 000;
        }

        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, street);
        pstmt.setString(2, neighborhood);
        pstmt.setString(3, cep);
        pstmt.setInt(4, number);
        pstmt.setInt(5, city_id);
        pstmt.executeUpdate();
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param phone String
     * @param email String
     */
    public void insertContact(String phone, String email) throws SQLException {
        String sql = "INSERT INTO contacts(phone,email) VALUES(?,?)";

        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, phone);
        pstmt.setString(2, email);
        pstmt.executeUpdate();
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param name String not null
     * @param state String not null
     * @param country String not null
     */

    public void insertCity(String name, String state, String country) throws SQLException {
        String sql = "INSERT INTO cities(name,state,country) VALUES(?,?,?)";
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, state);
            pstmt.setString(3, country);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertMuseum(String name, String day, String startTime, String history, int address_id) throws SQLException {
        String sql = "INSERT INTO events(name,day,hour,history,address_id) VALUES(?,?,?,?,?)";

        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, day);
            pstmt.setString(3, startTime);
            pstmt.setString(4, history);
            pstmt.setInt(5, address_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
//} else if (type == "Praia") {
//        sql = "INSERT INTO events(name,day,hour,min_age,band,address_id) VALUES(?,?,?,?,?,?)";
//        } else {
//        sql = "INSERT INTO events(name,day,hour,danger,middle_value,address_id) VALUES(?,?,?,?,?,?)";
//        }