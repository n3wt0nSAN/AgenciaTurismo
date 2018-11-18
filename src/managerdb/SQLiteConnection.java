package managerdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
    /**
     * Connect to a sample database
     **/

    Connection conn = null;

    public Connection connect() {
        try {
            String url = "jdbc:sqlite:db/sampledb.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
            return conn;
        } catch (SQLException e) {
            // system error
            System.out.println(e.getMessage());
            return conn;
        }
    }

    public void close() {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
             }
    }
}
