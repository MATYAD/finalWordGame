package core;

import core.gamePanel.FinalWordPanel;
import core.gamePanel.GamePanel;
import core.gamePanel.OverviewFrame;
import core.welcomePanel.WelcomePanel;

import javax.swing.*;
import java.awt.*;

public class GameFrame {
    public JFrame frame;
    ImageIcon image = new ImageIcon("src/res/Icon.png");
    public WelcomePanel welcomePanel = new WelcomePanel();
    public GamePanel gamePanel;
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

        //adding welcomePanel to frame
        frame.add(welcomePanel);
        //adds playButton functionality
        WelcomePanel.playButton.addActionListener(e -> {
            if (e.getSource()== WelcomePanel.playButton) {
                welcomePanel.setVisible(false);
                gamePanel = new GamePanel();
                frame.add(gamePanel);

            }
        });
        //adds backButton functionality
        GamePanel.backButton.addActionListener(e -> {
            if (e.getSource()==GamePanel.backButton) {
                //deleting buttons
                for (int i=0; i<FinalWordPanel.buttonList.size(); i++) {
                    FinalWordPanel.buttonList.get(i).setText("");
                }
                GamePanel.score = 0;
                GamePanel.scoreLabel.setText(String.valueOf(GamePanel.score));
                gamePanel.setVisible(false);
                welcomePanel.setVisible(true);
                GamePanel.startButton.setEnabled(true);

            }
        });

        //adds homeButton functionality
        OverviewFrame.homeButton.addActionListener(e -> {
            if (e.getSource()==OverviewFrame.homeButton) {
                gamePanel.setVisible(false);
                welcomePanel.setVisible(true);
            }

        });
        frame.setVisible(true);
    }
}
