import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;

public class HomePage extends NewPage {
    Button categoryButton;
    Button addCategory;
    Button booksButton;
    Button authorsButton;
    Button issueBookButton;
    Button returnBookButton;
    JPanel navPanel;
    Connection conn;

    HomePage(Connection conn) {
        this.conn = conn;
        navPanel = new JPanel();
        navPanel.setLayout(null);
        addCategory = new Button("Add Category");

        addCategory.addActionListener(addCategoryClick -> {
            CategoryPage categoryPage = new CategoryPage(conn);
            categoryPage.setVisible(true);

        });

        booksButton = new Button("Books");
        booksButton.addActionListener(booksClick -> {
            ViewBooksPage viewBooksPage = new ViewBooksPage(this.conn);
            try {
                viewBooksPage.viewBooks();

            } catch (SQLException throwables) {
                System.out.println(throwables.getLocalizedMessage());
            }
        });
        authorsButton = new Button("Authors");

        issueBookButton = new Button("Issue Book");

        returnBookButton = new Button("Return Book");

        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(10);
        navPanel.setLayout(layout);
        navPanel.add(addCategory);
        navPanel.add(booksButton);
        navPanel.add(authorsButton);
        navPanel.add(issueBookButton);
        navPanel.add(returnBookButton);
        this.centerPanel.add(navPanel);

    }
}
