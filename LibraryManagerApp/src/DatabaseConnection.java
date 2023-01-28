import java.awt.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DatabaseConnection {
    String name;
    Connection connection;

    DatabaseConnection(String name) throws Exception {
        // gets the required driver
        Class.forName("com.mysql.jdbc.Driver");
        // creates connection with sql
        this.name = name;
        String db_username = "root";
        String db_password = "password";
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + name, db_username, db_password);
    }

    public Connection getConnection() {
        return this.connection;
    }

}
