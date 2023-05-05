package core.welcomePanel;

import core.GridFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

public class WelcomePanel extends JPanel implements ActionListener {


    GridFrame gridFrame;
    Font backTo1982;
    private final JLabel gameNameLabel = new JLabel();
    private final JButton exitButton = new JButton();
    public JButton playButton = new JButton();
    private final JButton gridButton = new JButton();
    private final JLabel nLabel = new JLabel("N");
    private final JLabel eLabel = new JLabel("E");
    private final JLabel lLabel = new JLabel("L");
    private final JLabel iLabel = new JLabel("I");
    private final JLabel sLabel = new JLabel("S");
    private final JLabel e2Label = new JLabel("E");
    private final JLabel kLabel = new JLabel("K");
    private final JLabel heartLabel = new JLabel("<3");
    public WelcomePanel() {
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

        setGameNameLabel();
        setLettersLabels();
        setPlayButton();
        setGridButton();
        setExitButton();

        this.add(gameNameLabel);
        this.add(playButton);
        this.add(gridButton);
        this.add(exitButton);

        this.add(nLabel);
        this.add(eLabel);
        this.add(lLabel);
        this.add(iLabel);
        this.add(sLabel);
        this.add(e2Label);
        this.add(kLabel);
        this.add(heartLabel);
    }

    public void setGameNameLabel() {
        gameNameLabel.setBounds(250,50,500,250);
        gameNameLabel.setText("WORD GAME");
        gameNameLabel.setForeground(Color.BLACK);
        gameNameLabel.setFont(backTo1982.deriveFont(Font.BOLD,60));
        gameNameLabel.setVerticalAlignment(JLabel.CENTER);
        gameNameLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    public void setLettersLabels() {
        nLabel.setBounds(50,50,50,69);
        nLabel.setFont(backTo1982.deriveFont(Font.BOLD,50));
        nLabel.setForeground(Color.BLACK);
        eLabel.setBounds(500,20,50,69);
        eLabel.setFont(backTo1982.deriveFont(Font.BOLD,50));
        eLabel.setForeground(Color.BLACK);
        lLabel.setBounds(200,250,50,69);
        lLabel.setFont(backTo1982.deriveFont(Font.BOLD,50));
        lLabel.setForeground(Color.BLACK);
        iLabel.setBounds(100,420,50,69);
        iLabel.setFont(backTo1982.deriveFont(Font.BOLD,50));
        iLabel.setForeground(Color.BLACK);
        sLabel.setBounds(800,350,50,69);
        sLabel.setFont(backTo1982.deriveFont(Font.BOLD,50));
        sLabel.setForeground(Color.BLACK);
        e2Label.setBounds(200,600,50,69);
        e2Label.setFont(backTo1982.deriveFont(Font.BOLD,50));
        e2Label.setForeground(Color.BLACK);
        kLabel.setBounds(700,500,50,69);
        kLabel.setFont(backTo1982.deriveFont(Font.BOLD,50));
        kLabel.setForeground(Color.BLACK);
        heartLabel.setBounds(800,150,100,100);
        heartLabel.setFont(backTo1982.deriveFont(Font.BOLD,50));
        heartLabel.setForeground(Color.BLACK);

    }

    public void setExitButton() {
        exitButton.setBounds(400,550,200,100);
        exitButton.setText("EXIT");
        exitButton.setFont(backTo1982.deriveFont(Font.BOLD,30));
        exitButton.setForeground(Color.BLACK);
        exitButton.setBackground(Color.DARK_GRAY);
        exitButton.setVerticalAlignment(JButton.CENTER);
        exitButton.setHorizontalAlignment(JButton.CENTER);
        exitButton.setFocusable(false);
        exitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));
        exitButton.addActionListener(this);
    }
    
    public void setGridButton() {
        gridButton.setBounds(400,425,200,100);
        gridButton.setText("GRID");
        gridButton.setFont(backTo1982.deriveFont(Font.BOLD,30));
        gridButton.setForeground(Color.BLACK);
        gridButton.setBackground(Color.DARK_GRAY);
        gridButton.setVerticalAlignment(JButton.CENTER);
        gridButton.setHorizontalAlignment(JButton.CENTER);
        gridButton.setFocusable(false);
        gridButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));
        gridButton.addActionListener(this);
    }

    public void setPlayButton() {
        playButton.setBounds(400,300,200,100);
        playButton.setText("PLAY");
        playButton.setFont(backTo1982.deriveFont(Font.BOLD,30));
        playButton.setForeground(Color.BLACK);
        playButton.setBackground(Color.DARK_GRAY);
        playButton.setVerticalAlignment(JButton.CENTER);
        playButton.setHorizontalAlignment(JButton.CENTER);
        playButton.setFocusable(false);
        playButton.setEnabled(false);
        playButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));
        playButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==exitButton) {
            System.exit(1);
        }
        if (e.getSource()==gridButton) {
            GridFrame gridFrame = new GridFrame();
            playButton.setEnabled(true);
        }

    }
}
