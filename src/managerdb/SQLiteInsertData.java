package managerdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    public void insertBeach(String name, String day, String startTime, String values, int address_id)  throws SQLException {
        String sql = "INSERT INTO events(name,day,hour,middle_values,address_id) VALUES(?,?,?,?,?)";

        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, day);
            pstmt.setString(3, startTime);
            pstmt.setString(4, values);
            pstmt.setInt(5, address_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertShow(String name, String day, String startTime, String bands, int address_id) throws SQLException {
        String sql = "INSERT INTO events(name,day,hour,bands,address_id) VALUES(?,?,?,?,?)";

        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, day);
            pstmt.setString(3, startTime);
            pstmt.setString(4, bands);
            pstmt.setInt(5, address_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPackage(String name, String dataStart, String dataEnd, double value, int agency_id) throws SQLException {

        String sql = "INSERT INTO packages(name,data_start,data_end,value,agency_id) VALUES(?,?,?,?,?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, dataStart);
        pstmt.setString(3, dataEnd);
        pstmt.setDouble(4, value);
        pstmt.setInt(5, agency_id);

        pstmt.executeUpdate();
    }

    public void insertPackageCity(int package_id, int city_id) throws SQLException {

        String sql = "INSERT INTO packs_cities(package_id,city_id) VALUES(?,?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);

        pstmt.setInt(1, package_id);
        pstmt.setInt(2, city_id);
        pstmt.executeUpdate();
    }

    public void insertPackageEvent(int package_id, int event_id) throws SQLException {
        String sql = "INSERT INTO packs_events(package_id,event_id) VALUES(?,?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);

        pstmt.setInt(1, package_id);
        pstmt.setInt(2, event_id);
        pstmt.executeUpdate();
    }
}