import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;
import javax.swing.border.EmptyBorder;

public class ViewBooksPage extends NewPage {
    Connection connection;
    String category;

    ViewBooksPage(Connection connection, String category) {
        this.connection = connection;
        this.category = category;
        this.setVisible(true);
        this.setTitle(String.format("%s Books", category));
    }

    public void viewBooks() throws SQLException {
        Statement statement = connection.createStatement();
        String getBooksQuery = String.format(
                "select * from book left join category on book.category_id=category.id where category.name='%s'",
                category);
        ResultSet resultSet = statement.executeQuery(getBooksQuery);
        JPanel buttonPanel = new JPanel();
        while (resultSet.next()) {
            JPanel bookCard = new JPanel();

            JLabel idLabel = new JLabel("ID");
            idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel bookID = new JLabel(String.valueOf(resultSet.getString("id")));
            bookID.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel titleLabel = new JLabel("Title");
            titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel title = new JLabel(String.valueOf(resultSet.getString("title")));
            title.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel authorLabel = new JLabel("author");
            authorLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel author = new JLabel(String.valueOf(resultSet.getString("author")));
            author.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            bookCard.add(idLabel);
            bookCard.add(bookID);
            bookCard.add(titleLabel);
            bookCard.add(title);
            bookCard.add(authorLabel);
            bookCard.add(author);

            bookCard.setSize(1000, 400);
            bookCard.setBackground(new Color(166, 209, 230));
            bookCard.setBorder(new EmptyBorder(20, 50, 50, 50));

            GridLayout cardLayout = new GridLayout(0, 2);
            cardLayout.setHgap(5);
            cardLayout.setVgap(10);
            bookCard.setLayout(cardLayout);

            buttonPanel.add(bookCard);

        }
        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(10);
        buttonPanel.setLayout(layout);
        this.centerPanel.add(buttonPanel);
    }

}
