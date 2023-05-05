package core;

import core.gamePanel.GamePanel;
import core.welcomePanel.WelcomePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame {
    public JFrame frame;
    ImageIcon image = new ImageIcon("src/res/Icon.png");
    public WelcomePanel welcomePanel = new WelcomePanel();
    public GameFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setIconImage(image.getImage());
        frame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK,7));
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setTitle("WordGame");
        frame.setLocationRelativeTo(null);

        frame.add(welcomePanel);

        welcomePanel.playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==welcomePanel.playButton) {
                    welcomePanel.setVisible(false);
                    GamePanel gamePanel = new GamePanel();
                    frame.add(gamePanel);
                }
            }
        });
        frame.setVisible(true);
    }
}
