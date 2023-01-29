import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        DatabaseConnection dbConnection = new DatabaseConnection("library_db");
        Connection connection = dbConnection.getConnection();
        // LoginForm loginPage = new LoginForm();
        HomePage home = new HomePage(connection);
        home.setVisible(true);
    }

}

// set up DB X
// decide structure/tables
// connect DB X
// Entrypoint and object structure
// Set up controller patern
// Style
// add referenced library to readme
