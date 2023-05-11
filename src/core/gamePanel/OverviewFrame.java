package core.gamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

public class OverviewFrame {
    JFrame frame = new JFrame();
    Font backTo1982;
    ImageIcon icon = new ImageIcon("src/res/Icon.png");
    public JLabel gameOverLabel = new JLabel("GAME OVER");
    public JLabel scoreLabel = new JLabel("YOUR SCORE IS : " + GamePanel.score);
    public JLabel bestScoreLabel = new JLabel("BEST SCORE IS : ");
    public JButton playAgainButton = new JButton("↺");
    public static JButton homeButton = new JButton("⌂");

    public OverviewFrame() throws HeadlessException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Word Game");
        frame.setIconImage(icon.getImage());
        frame.setUndecorated(true);
        frame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(null);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        try {
            InputStream is = getClass().getResourceAsStream("/res/backTo1982.TTF");
            assert is != null;
            backTo1982 = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        setGameOverLabel();
        frame.add(gameOverLabel);

        setScoreLabel();
        frame.add(scoreLabel);

        setBestScoreLabel();
        frame.add(bestScoreLabel);

        setPlayAgainButton();
        frame.add(playAgainButton);

        setHomeButton();
        frame.add(homeButton);
    }

    public void setGameOverLabel() {
        gameOverLabel.setBounds(25, 25, 550, 100);
        gameOverLabel.setText("GAME OVER");
        gameOverLabel.setForeground(Color.BLACK);
        gameOverLabel.setFont(backTo1982.deriveFont(Font.BOLD, 50));
        gameOverLabel.setVerticalAlignment(JLabel.CENTER);
        gameOverLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    public void setScoreLabel() {
        scoreLabel.setBounds(50, 225, 500, 50);
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setFont(backTo1982.deriveFont(Font.BOLD, 25));
        scoreLabel.setVerticalAlignment(JLabel.CENTER);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    public void setBestScoreLabel() {
        bestScoreLabel.setBounds(50, 150, 500, 50);
        bestScoreLabel.setForeground(Color.BLACK);
        bestScoreLabel.setFont(backTo1982.deriveFont(Font.BOLD, 25));
        bestScoreLabel.setVerticalAlignment(JLabel.CENTER);
        bestScoreLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    public void setPlayAgainButton() {
        playAgainButton.setBounds(125,300,125,65);
        playAgainButton.setFocusable(false);
        playAgainButton.setVerticalAlignment(JButton.CENTER);
        playAgainButton.setHorizontalAlignment(JButton.CENTER);
        playAgainButton.setBackground(Color.DARK_GRAY);
        playAgainButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
        playAgainButton.setFont(new Font("Dialog", Font.BOLD,70));
        playAgainButton.setForeground(Color.BLACK);
        playAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==playAgainButton) {
                    for (int i = 0; i<ButtonPanel.buttons.length; i++) {
                        ButtonPanel.buttons[i].setText("");
                    }
                    for (int j = 0; j<FinalWordPanel.buttonList.size(); j++) {
                        FinalWordPanel.buttonList.get(j).setText("");
                    }
                    GamePanel.score = 0;
                    GamePanel.scoreLabel.setText(String.valueOf(GamePanel.score));
                    frame.dispose();
                }
            }
        });
    }

    public void setHomeButton() {
        homeButton.setBounds(350,300,125,65);
        homeButton.setFocusable(false);
        homeButton.setVerticalAlignment(JButton.CENTER);
        homeButton.setHorizontalAlignment(JButton.CENTER);
        homeButton.setBackground(Color.DARK_GRAY);
        homeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
        homeButton.setFont(new Font("Dialog", Font.BOLD,60));
        homeButton.setForeground(Color.BLACK);

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==homeButton) {
                    frame.dispose();
                }
            }
        });
    }
}
