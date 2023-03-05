import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;
import javax.swing.border.EmptyBorder;

public class CategoryPage extends NewPage {
    Connection conn;
    JPanel categoriesList;
    JPanel formPanel;
    Button addCategoryBtn;
    Button deleteCategoryBtn;
    Button editCategoryBtn;

    public CategoryPage(Connection conn) {
        this.conn = conn;
        this.setTitle("Category");
        createForm();
        try {
            viewCategories();
        } catch (SQLException throwables) {
            System.out.println(throwables.getLocalizedMessage());
        }
    }

    public void createForm() {
        formPanel = new JPanel();
        addCategoryBtn = new Button("Add");
        deleteCategoryBtn = new Button("Delete");
        editCategoryBtn = new Button("Edit");

        JLabel categoryLabel = new JLabel("Enter Category");
        categoryLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        JTextField categoryVal = new JTextField();
        categoryVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel categoryStatusLabel = new JLabel("Status");
        categoryStatusLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        String statuslist[] = { "Active", "Inactive" };

        JComboBox categoryStatusVal = new JComboBox<>(statuslist);
        categoryStatusVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        addCategoryBtn.addActionListener(addClick -> {
            try {
                String newCategory = categoryVal.getText();
                String status = categoryStatusVal.getSelectedItem().toString();
                System.out.println(status);
                addCategory(newCategory, status);

            } catch (SQLException throwables) {
                System.out.println(throwables.getLocalizedMessage());
            }
        });
        editCategoryBtn.addActionListener(editClick -> {
            try {
                String newCategory = categoryVal.getText();
                String status = categoryStatusVal.getSelectedItem().toString();

                editCategory(newCategory, status);

            } catch (SQLException throwables) {
                System.out.println(throwables.getLocalizedMessage());
            }
        });
        deleteCategoryBtn.addActionListener(deleteClick -> {
            try {
                String newCategory = categoryVal.getText();

                deleteCategory(newCategory);

            } catch (SQLException throwables) {
                System.out.println(throwables.getLocalizedMessage());
            }
        });

        GridLayout grid = new GridLayout(0, 2);
        grid.setHgap(60);
        grid.setVgap(40);
        formPanel.setLayout(grid);

        formPanel.add(categoryLabel);
        formPanel.add(categoryVal);
        formPanel.add(categoryStatusLabel);
        formPanel.add(categoryStatusVal);
        formPanel.add(addCategoryBtn);
        formPanel.add(deleteCategoryBtn);
        formPanel.add(editCategoryBtn);
        this.centerPanel.add(formPanel);

        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            this.dispose();
        });
        buttonPanel.add(backButton);
        buttonPanel.setBackground(new Color(254, 251, 246));
        this.southPanel.add(buttonPanel);

    }

    public void addCategory(String category, String status) throws SQLException {
        // TODO: Error popup and validity conditions
        if (category.length() == 0) {
            System.out.println("Please enter a valid category");
            return;
        }
        Statement statement = this.conn.createStatement();
        String query = String.format("insert into category (name, status) values('%s', '%s')", category, status);
        // TODO: no empty strings

        try {
            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // TODO: update categories list view with new category after added, or close
        // window.
    }

    public void viewCategories() throws SQLException {
        JPanel categoryPanel = new JPanel();
        Statement statement = this.conn.createStatement();
        String getCategoriesQuery = "select * from category";
        ResultSet resultSet = statement.executeQuery(getCategoriesQuery);
        while (resultSet.next()) {
            String categoryId = resultSet.getString("id");
            JLabel categoryIdLabel = new JLabel(categoryId);
            String category = resultSet.getString("name");
            JLabel categoryLabel = new JLabel(category);
            String categoryStatus = resultSet.getString("status");
            JLabel categoryStatusLabel = new JLabel(categoryStatus);
            categoryPanel.add(categoryIdLabel);
            categoryPanel.add(categoryLabel);
            categoryPanel.add(categoryStatusLabel);

        }
        GridLayout layout = new GridLayout(0, 3);
        layout.setVgap(10);
        categoryPanel.setLayout(layout);
        this.centerPanel.add(categoryPanel);
    }

    public void deleteCategory(String category) throws SQLException {
        // TODO: Error Validation: if record doesn't exist
        Statement statement = this.conn.createStatement();
        String deleteCategoryQuery = String.format("delete from category where name='%s'", category);
        try {
            statement.execute(deleteCategoryQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editCategory(String category, String status) throws SQLException {
        // TODO: Error Validation: if record doesn't exist
        // TODO: reload panel with category update, success message
        Statement statement = this.conn.createStatement();
        String getCategoryQuery = String.format("select * from category where name='%s'", category);
        Integer categoryID;
        try {
            ResultSet resultSet = statement.executeQuery(getCategoryQuery);
            if (resultSet.next()) {
                categoryID = resultSet.getInt("id");

                String editCategoryQuery = String.format("update category set status='%s' where id=%d", status,
                        categoryID);
                statement.execute(editCategoryQuery);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    // public void getCategoryID(String category) {

    // }

}