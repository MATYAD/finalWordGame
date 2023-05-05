package core.gamePanel;

import core.gamePanel.ButtonPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;


public class GamePanel extends JPanel implements ActionListener {

    public ButtonPanel gridPanel = new ButtonPanel();
    public WordPanel wordPanel = new WordPanel();
    Font backTo1982;
    public JButton startButton = new JButton("START");
    public JProgressBar timerBar = new JProgressBar(0,60);
    public Timer timer = new Timer(1000,this);
    public JLabel timeLabel = new JLabel();
    public JButton exitButton = new JButton("EXIT");
    public int remainingTime;

    public GamePanel() {
        this.setLayout(null);
        this.setSize(1000,700);
        this.setBackground(Color.DARK_GRAY);

        try {
            InputStream is = getClass().getResourceAsStream("/res/backTo1982.TTF");
            backTo1982 = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.add(gridPanel);
        this.add(wordPanel);
        
        setStartButton();
        this.add(startButton);

        setExitButton();
        this.add(exitButton);

        setTimerBar();
        this.add(timerBar);

        setTimeLabel();
        this.add(timeLabel);
    }
    
    public void setStartButton() {
        startButton.setBounds(450, 25, 100, 50);
        startButton.setFont(backTo1982.deriveFont(Font.BOLD,15));
        startButton.setForeground(Color.BLACK);
        startButton.setBackground(Color.DARK_GRAY);
        startButton.setVerticalAlignment(JButton.CENTER);
        startButton.setHorizontalAlignment(JButton.CENTER);
        startButton.setFocusable(false);
        startButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                startCountdown();
            }
        });
    }

    public void setExitButton() {
        exitButton.setBounds(25,25,100,50);
        exitButton.setFont(backTo1982.deriveFont(Font.BOLD,15));
        exitButton.setForeground(Color.BLACK);
        exitButton.setBackground(Color.DARK_GRAY);
        exitButton.setVerticalAlignment(JButton.CENTER);
        exitButton.setHorizontalAlignment(JButton.CENTER);
        exitButton.setFocusable(false);
        exitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));
        exitButton.addActionListener(this);

    }

    public void setTimerBar() {
        timerBar.setBounds(775,25,200,50);
        timerBar.setBackground(Color.DARK_GRAY);
        timerBar.setForeground(Color.BLACK);
        timerBar.setFocusable(false);
        timerBar.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));
    }

    public void setTimeLabel() {
        timeLabel.setBounds(625,25,200,50);
        timeLabel.setVerticalAlignment(JLabel.CENTER);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setForeground(Color.BLACK);
        timeLabel.setFont(backTo1982.deriveFont(Font.BOLD,25));

    }
    public void startCountdown() {
        remainingTime = 60;
        timer.start();
    }
    public void actionPerformed(ActionEvent e) {
        remainingTime--;
        timerBar.setValue(remainingTime);
        timeLabel.setText(String.valueOf(remainingTime));

        if (remainingTime == 0) {
                timer.stop();
        }

        if (e.getSource()==exitButton){
            System.exit(1);
        }
    }
}
