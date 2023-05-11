package core.gamePanel;

import core.welcomePanel.WelcomePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class GamePanel extends JPanel implements ActionListener {

    public ButtonPanel buttonPanel = new ButtonPanel();
    public FinalWordPanel finalWordPanel = new FinalWordPanel();
    Font backTo1982;
    Random random = new Random();
    public static JButton startButton = new JButton("START");
    public JProgressBar timerBar = new JProgressBar(0,WelcomePanel.slider.getValue());
    public Timer timer = new Timer(1000,this);
    public JLabel timeLabel = new JLabel();
    public static JLabel scoreLabel = new JLabel();
    public static JButton checkButton = new JButton("✓");
    public JButton exitButton = new JButton("EXIT");
    public static JButton backButton = new JButton("BACK");
    public int remainingTime;
    public ArrayList<String> letters = new ArrayList<>();
    public ArrayList<String> usedWords = new ArrayList<>();
    boolean containsWord;
    public String finalWord;
    public static int score = 0;

    public GamePanel() {
        this.setLayout(null);
        this.setSize(1000,700);
        this.setBackground(Color.DARK_GRAY);

        try {
            InputStream is = getClass().getResourceAsStream("/res/backTo1982.TTF");
            assert is != null;
            backTo1982 = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        this.add(buttonPanel);
        this.add(FinalWordPanel.panel);
        
        setStartButton();
        this.add(startButton);
        setScoreLabel();
        this.add(scoreLabel);

        setExitButton();
        this.add(exitButton);

        setBackButton();
        this.add(backButton);

        setCheckButton();
        this.add(checkButton);

        setTimerBar();
        this.add(timerBar);

        setTimeLabel();
        this.add(timeLabel);
    }
    
    public void setStartButton() {
        startButton.setBounds(245, 25, 100, 50);
        startButton.setFont(backTo1982.deriveFont(Font.BOLD,15));
        startButton.setForeground(Color.BLACK);
        startButton.setBackground(Color.DARK_GRAY);
        startButton.setVerticalAlignment(JButton.CENTER);
        startButton.setHorizontalAlignment(JButton.CENTER);
        startButton.setFocusable(false);
        startButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==startButton) {
                    startButton.setEnabled(false);
                    startCountdown();
                }
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

    public void setBackButton() {
        backButton.setBounds(135,25,100,50);
        backButton.setFont(backTo1982.deriveFont(Font.BOLD,15));
        backButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.DARK_GRAY);
        backButton.setVerticalAlignment(JButton.CENTER);
        backButton.setHorizontalAlignment(JButton.CENTER);
        backButton.setFocusable(false);
        backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));

    }

    public void setCheckButton() {
        checkButton.setBounds(775,520,125,150);
        checkButton.setFont(new Font("Dialog", Font.BOLD,70));
        checkButton.setForeground(Color.BLACK);
        checkButton.setBackground(Color.DARK_GRAY);
        checkButton.setVerticalAlignment(JButton.CENTER);
        checkButton.setHorizontalAlignment(JButton.CENTER);
        checkButton.setFocusable(false);
        checkButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,8,true));
        checkButton.addActionListener(e -> {
            if (e.getSource()==checkButton) {
                for (int i=0; i<FinalWordPanel.buttonList.size(); i++) {
                    if (FinalWordPanel.buttonList.get(i).getText().matches("[A-Z]")) {
                        letters.add(i,FinalWordPanel.buttonList.get(i).getText());
                    }
                }
                StringBuffer stringBuffer = new StringBuffer();
                for (String letter : letters) {
                    stringBuffer.append(letter);
                }
                finalWord = stringBuffer.toString();
                letters.clear();

                try {
                    File wordsFile = new File("src/res/words.txt");
                    Scanner scanner = new Scanner(wordsFile);

                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if ((line.contains(finalWord) && containsWord == usedWords.contains(finalWord) && line.length() == finalWord.length())) {
                            score += finalWord.length()*100;
                            scoreLabel.setText(String.valueOf(score));
                            usedWords.add(finalWord);
                            for (int i = 0; i <FinalWordPanel.buttonList.size(); i++) {
                                FinalWordPanel.buttonList.get(i).setText("");
                            }
                            scanner.close();
                            return;
                        }
                    }
                    for (int i=0; i<FinalWordPanel.buttonList.size(); i++) {
                        FinalWordPanel.buttonList.get(i).setText("");
                    }

                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    
    public void setScoreLabel() {
        scoreLabel.setBounds(425, 25, 150, 70);
        scoreLabel.setVerticalAlignment(JLabel.CENTER);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setFont(backTo1982.deriveFont(Font.BOLD,30));
    }

    public void setTimerBar() {
        timerBar.setBounds(775,25,200,50);
        timerBar.setBackground(Color.DARK_GRAY);
        timerBar.setForeground(Color.BLACK);
        timerBar.setFocusable(false);
        timerBar.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));
    }

    public void setTimeLabel() {
        timeLabel.setBounds(890,75,100,50);
        timeLabel.setVerticalAlignment(JLabel.CENTER);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setForeground(Color.BLACK);
        timeLabel.setFont(backTo1982.deriveFont(Font.BOLD,25));

    }
    public  void startCountdown() {
        remainingTime = WelcomePanel.slider.getValue();
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {

        remainingTime--;
        timerBar.setValue(remainingTime);
        timeLabel.setText(String.valueOf(remainingTime));

        if (remainingTime == 0) {
            startButton.setEnabled(true);
            OverviewFrame frame = new OverviewFrame();
            timer.stop();
        }

        if (e.getSource()==exitButton) {
            System.exit(1);
        }
    }
}
