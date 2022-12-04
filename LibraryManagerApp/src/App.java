
import java.awt.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Login!");
        JFrame frame = new JFrame("My First GUI");
        GridLayout loginGrid = new GridLayout(3, 1);
        frame.setLayout(loginGrid);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);

        JPanel usernamePanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JLabel usernameLabel = new JLabel("Username");
        JTextField username = new JTextField(10);
        JLabel passwordLabel = new JLabel("Password");
        JTextField password = new JTextField(10);

        JButton signInButton = new JButton("Sign In");
        signInButton.setSize(50, 20);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(username);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(password);
        buttonPanel.add(signInButton);

        frame.add(usernamePanel);
        frame.add(passwordPanel);
        frame.add(buttonPanel);
        frame.setVisible(true);
    }
}
