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

        JPanel panel = new JPanel();
        panel.setSize(400, 400);
        panel.setLayout(null);
        panel.setBackground(new Color(0, 251, 246));

        Statement statement = this.conn.createStatement();
        String getCategoriesQuery = "select * from category";
        ResultSet resultSet = statement.executeQuery(getCategoriesQuery);
        Integer y_coord = 50;
        while (resultSet.next()) {
            String category = resultSet.getString("name");
            System.out.println(category);
            Button categoryBtn = new Button(category);
            categoryBtn.setBounds(100, y_coord, 250, 50);
            y_coord += 80;
            categoryBtn.addActionListener(btnAction -> {
                System.out.println(categoryBtn.getText());
            });
            panel.add(categoryBtn);

        }
        this.add(panel);
    }

}
