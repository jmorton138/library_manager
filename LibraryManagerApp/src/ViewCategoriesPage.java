import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;
import javax.swing.border.EmptyBorder;

public class ViewCategoriesPage extends NewPage {
    Connection conn;
    JPanel categoriesList;

    ViewCategoriesPage(Connection conn) {
        this.conn = conn;
        this.setVisible(true);
        this.setTitle("View Categories");
    }

    public void viewCategories() throws SQLException {

        JPanel buttonPanel = new JPanel();
        Statement statement = this.conn.createStatement();
        String getCategoriesQuery = "select * from category";
        ResultSet resultSet = statement.executeQuery(getCategoriesQuery);
        while (resultSet.next()) {
            String category = resultSet.getString("name");
            Button categoryBtn = new Button(category);
            categoryBtn.addActionListener(btnAction -> {
                System.out.println(categoryBtn.getText());
            });
            buttonPanel.add(categoryBtn);
        }
        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(10);
        buttonPanel.setLayout(layout);
        this.centerPanel.add(buttonPanel);
    }

}
