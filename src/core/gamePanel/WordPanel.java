package core.gamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

public class WordPanel extends JPanel implements ActionListener {
    Font backTo1982;
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");


    public WordPanel() {
        this.setLayout(new GridLayout(1, 6));
        this.setBounds(100,520,800,150);
        this.setBackground(Color.BLACK);

        try {
            InputStream is = getClass().getResourceAsStream("/res/backTo1982.TTF");
            backTo1982 = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setButton1();
        this.add(button1);
        setButton2();
        this.add(button2);
        setButton3();
        this.add(button3);
        setButton4();
        this.add(button4);
        setButton5();
        this.add(button5);
        setButton6();
        this.add(button6);



    }

    public void setButton1() {
        button1.setForeground(Color.BLACK);
        button1.setBackground(Color.DARK_GRAY);
        button1.setFocusable(false);
        button1.setFont(backTo1982.deriveFont(Font.BOLD,50));
    }
    public void setButton2() {
        button2.setForeground(Color.BLACK);
        button2.setBackground(Color.DARK_GRAY);
        button2.setFocusable(false);
        button2.setFont(backTo1982.deriveFont(Font.BOLD,50));
    }
    public void setButton3() {
        button3.setForeground(Color.BLACK);
        button3.setBackground(Color.DARK_GRAY);
        button3.setFocusable(false);
        button3.setFont(backTo1982.deriveFont(Font.BOLD,50));
    }
    public void setButton4() {
        button4.setForeground(Color.BLACK);
        button4.setBackground(Color.DARK_GRAY);
        button4.setFocusable(false);
        button4.setFont(backTo1982.deriveFont(Font.BOLD,50));
    }
    public void setButton5() {
        button5.setForeground(Color.BLACK);
        button5.setBackground(Color.DARK_GRAY);
        button5.setFocusable(false);
        button5.setFont(backTo1982.deriveFont(Font.BOLD,50));
    }
    public void setButton6() {
        button6.setForeground(Color.BLACK);
        button6.setBackground(Color.DARK_GRAY);
        button6.setFocusable(false);
        button6.setFont(backTo1982.deriveFont(Font.BOLD,50));
    }

    public void actionPerformed(ActionEvent e) {

    }
}
