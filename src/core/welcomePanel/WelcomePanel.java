package core.welcomePanel;

import core.GridFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

public class WelcomePanel extends JPanel implements ActionListener {


    Font backTo1982;
    private final JLabel gameNameLabel = new JLabel();
    private final JButton exitButton = new JButton();
    public static JButton playButton = new JButton();

    public static JSlider slider = new JSlider(20,120,60);
    JLabel timeLabel = new JLabel("SET TIME");
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
            assert is != null;
            backTo1982 = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        setGameNameLabel();
        setLettersLabels();
        setPlayButton();
        setGridButton();
        setTimeLabel();
        setSlider();
        setExitButton();

        this.add(gameNameLabel);
        this.add(playButton);
        this.add(gridButton);
        this.add(timeLabel);
        this.add(slider);
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
        gameNameLabel.setBounds(100,50,800,175);
        gameNameLabel.setText("WORD GAME");
        gameNameLabel.setForeground(Color.BLACK);
        gameNameLabel.setFont(backTo1982.deriveFont(Font.BOLD,90));
        gameNameLabel.setVerticalAlignment(JLabel.CENTER);
        gameNameLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    public void setLettersLabels() {
        nLabel.setBounds(650,220,80,85);
        nLabel.setFont(backTo1982.deriveFont(Font.BOLD,70));
        nLabel.setForeground(Color.BLACK);
        eLabel.setBounds(275,380,80,85);
        eLabel.setFont(backTo1982.deriveFont(Font.BOLD,70));
        eLabel.setForeground(Color.BLACK);
        lLabel.setBounds(100,250,80,85);
        lLabel.setFont(backTo1982.deriveFont(Font.BOLD,70));
        lLabel.setForeground(Color.BLACK);
        iLabel.setBounds(100,420,80,85);
        iLabel.setFont(backTo1982.deriveFont(Font.BOLD,70));
        iLabel.setForeground(Color.BLACK);
        sLabel.setBounds(750,375,80,85);
        sLabel.setFont(backTo1982.deriveFont(Font.BOLD,70));
        sLabel.setForeground(Color.BLACK);
        e2Label.setBounds(870,275,80,85);
        e2Label.setFont(backTo1982.deriveFont(Font.BOLD,70));
        e2Label.setForeground(Color.BLACK);
        kLabel.setBounds(675,525,80,85);
        kLabel.setFont(backTo1982.deriveFont(Font.BOLD,70));
        kLabel.setForeground(Color.BLACK);
        heartLabel.setBounds(825,550,125,125);
        heartLabel.setFont(backTo1982.deriveFont(Font.BOLD,70));
        heartLabel.setForeground(Color.BLACK);
    }

    public void setExitButton() {
        exitButton.setBounds(425,525,150,75);
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
        gridButton.setBounds(425,400,150,75);
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
        playButton.setBounds(425,275,150,75);
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

    public void setTimeLabel() {
        timeLabel.setBounds(135,550,180,50);
        timeLabel.setForeground(Color.BLACK);
        timeLabel.setFont(backTo1982.deriveFont(Font.BOLD,25));
        timeLabel.setVerticalAlignment(JLabel.CENTER);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    public void setSlider() {
        slider.setBounds(25,610,400,50);
        slider.setBackground(Color.DARK_GRAY);
        slider.setForeground(Color.BLACK);
        slider.setFont(backTo1982.deriveFont(Font.BOLD,15));
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(20);
        slider.setPaintLabels(true);
        slider.setOpaque(false);
        slider.setUI(new JSliderUI(slider));

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
