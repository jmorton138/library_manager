import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Button extends JButton {
    Button(String text) {
        this.setText(text);
        this.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        this.setFocusPainted(false);
    }

}
