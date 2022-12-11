import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;

public class CreateHomePage extends NewPage implements ActionListener {
    NewPage homePage;
    JButton viewCategoriesBtn;
    JPanel categoriesPanel;
    JPanel homePageHeaders;
    JPanel activePanel;
    JPanel pageContent;
    JTextField searchBar;

    CreateHomePage() {
        homePage = new NewPage();
        homePageHeaders = new JPanel();
        homePageHeaders.setSize(200, 30);
        homePageHeaders.setBorder(BorderFactory.createLineBorder(Color.black));
        pageContent = new JPanel();
        viewCategoriesBtn = new JButton("View Categories");
        searchBar = new JTextField(20);
        homePageHeaders.add(viewCategoriesBtn);
        homePageHeaders.add(searchBar);
        frame.add(homePageHeaders, BorderLayout.NORTH);
        frame.add(pageContent);
        viewCategoriesBtn.addActionListener(this);
        buildCategoriesView();

    }

    public void actionPerformed(ActionEvent event) {
        categoriesPanel.setVisible(true);

    }

    public void buildCategoriesView() {
        // create categories panel
        GridLayout categoriesGrid = new GridLayout(10, 1);
        categoriesPanel = new JPanel();
        categoriesPanel.setLayout(categoriesGrid);
        Category[] categories = new Category[10];
        for (int i = 0; i < 10; i++) {
            Category category = new Category("category" + i);
            categories[i] = category;
            categoriesPanel.add(categories[i].categoryBtn);
        }
        categoriesPanel.setVisible(false);
        pageContent.add(categoriesPanel);
    }
}
