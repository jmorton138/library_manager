import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;

public class HomePage extends NewPage {
    Button categoryButton;
    Connection conn;

    HomePage(Connection conn) {
        this.conn = conn;
        categoryButton = new Button("Category");
        categoryButton.setBounds(400, 200, 300, 40);
        categoryButton.addActionListener(categoryClick -> {
            ViewCategoriesPage viewCategoriesPage = new ViewCategoriesPage(conn);
            try {
                viewCategoriesPage.viewCategories();
            } catch (SQLException throwables) {
                String string;
            }
        });
        this.add(categoryButton);

    }
}
