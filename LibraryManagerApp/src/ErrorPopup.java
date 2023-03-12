import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;
import javax.swing.border.EmptyBorder;

public class ErrorPopup extends NewPage {
    JLabel popupMsg;

    public ErrorPopup(String message) {
        this.setTitle("Invalid input");
        this.popupMsg = new JLabel(message);
        this.centerPanel.add(popupMsg);
        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(actionListener -> {
            this.dispose();
        });

        // buttonPanel.add(closeButton);
        // buttonPanel.setBackground(new Color(254, 251, 246));
        this.southPanel.add(closeButton);
        this.setVisible(true);

    }

    // popupMsg.setBounds(20, 10, 300, 50);
    // popupMsg.setFont(new Font("Times New
    // Roman",Font.PLAIN,20));popup.add(popupMsg);

    // JButton button = new JButton(
    // "OK");button.setBounds(120,60,70,20);button.setFont(new Font("Times New
    // Roman",Font.PLAIN,20));

    // button.addActionListener(actionEvent2->
    // {
    // popup.dispose();
    // });popup.add(button);

    // popup.setLayout(null);popup.setSize(350,150);popup.setVisible(true);return
    // false;

}
