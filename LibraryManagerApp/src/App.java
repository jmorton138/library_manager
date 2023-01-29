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
