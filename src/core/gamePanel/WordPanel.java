package core.gamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordPanel extends JPanel implements ActionListener {
    public WordPanel() {
        this.setLayout(new GridLayout(5, 1));
        this.setBounds(100,520,800,150);
        this.setBackground(Color.BLACK);

    }

    public void actionPerformed(ActionEvent e) {

    }
}
