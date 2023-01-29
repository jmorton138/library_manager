import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;

public class Category implements ActionListener {
    JButton categoryBtn;
    String text;

    Category(String text) {
        this.categoryBtn = new JButton(text);
        this.categoryBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println(categoryBtn.getText());

    }

}
