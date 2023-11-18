package Tourism.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static final String PROJECT_TITLE = "Turizm Acente Sistemi";
    public static final String DB_URL = "jdbc:mysql://localhost/turizm";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";

    private Connection connect = null;

    public Connection connectDB() {
        try {
            this.connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.connect;
    }

    public static Connection getInstance() {
        DBConnector db = new DBConnector();
        return db.connectDB();
    }
}
