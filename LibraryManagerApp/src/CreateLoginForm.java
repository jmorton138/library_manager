import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;

public class CreateLoginForm extends JFrame implements ActionListener {
    JFrame frame;
    JTextField username;
    JTextField password;
    JButton signInButton;

    CreateLoginForm() {
        frame = new JFrame("Login");
        GridLayout loginGrid = new GridLayout(3, 1);
        frame.setLayout(loginGrid);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel usernamePanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JLabel usernameLabel = new JLabel("Username");
        username = new JTextField(10);
        JLabel passwordLabel = new JLabel("Password");
        password = new JTextField(10);

        signInButton = new JButton("Sign In");
        signInButton.setSize(100, 40);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(username);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(password);
        buttonPanel.add(signInButton);
        signInButton.addActionListener(this);
        frame.add(usernamePanel);
        frame.add(passwordPanel);
        frame.add(buttonPanel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String usernameInput = username.getText();
        String passwordInput = password.getText();

        // todo: make logins dynamic
        if (usernameInput.equals("1") && passwordInput.equals("1")) {
            // hide login
            // create app home page
            CreateHomePage homePage = new CreateHomePage();
            frame.setVisible(false);
            homePage.frame.setVisible(true);
            // System.out.println(homePage.frame.getSize());
        } else {
            // popup: login is incorrect
        }
    }

}
