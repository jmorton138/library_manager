import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;

public class NewPage extends JFrame {
    JPanel centerPanel;
    JPanel northPanel;
    JPanel southPanel;
    JPanel eastPanel;
    JPanel westPanel;

    NewPage() {
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(900, 900);
        this.centerPanel = new JPanel();
        this.centerPanel.setBackground(Color.orange);
        this.northPanel = new JPanel();
        this.northPanel.setBackground(Color.red);
        this.southPanel = new JPanel();
        this.southPanel.setBackground(Color.blue);
        this.eastPanel = new JPanel();
        this.eastPanel.setBackground(Color.green);
        this.westPanel = new JPanel();
        this.westPanel.setBackground(Color.magenta);

        this.northPanel.setPreferredSize(new Dimension(100, 100));
        this.centerPanel.setPreferredSize(new Dimension(100, 100));
        this.eastPanel.setPreferredSize(new Dimension(100, 100));
        this.northPanel.setPreferredSize(new Dimension(100, 100));
        this.southPanel.setPreferredSize(new Dimension(100, 100));
        this.westPanel.setPreferredSize(new Dimension(100, 100));
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(westPanel, BorderLayout.WEST);

    }
}
