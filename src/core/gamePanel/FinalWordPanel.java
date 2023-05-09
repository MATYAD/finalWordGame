package core.gamePanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;


public class FinalWordPanel{
    Font backTo1982;
    public static JPanel panel = new JPanel();
    public static JButton[] buttonList;
    public FinalWordPanel() {
        panel.setLayout(new GridLayout(1, 6));
        panel.setBounds(100,520,800,150);
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));

        try {
            InputStream is = getClass().getResourceAsStream("/res/backTo1982.TTF");
            backTo1982 = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        buttonList = new JButton[6];
        for (int i = 0; i < 6; i++) {
            buttonList[i] = new JButton();
            panel.add(buttonList[i]);

            buttonList[i].setBackground(Color.DARK_GRAY);
            buttonList[i].setForeground(Color.BLACK);
            buttonList[i].setFont(backTo1982.deriveFont(Font.BOLD,50));
            buttonList[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
            buttonList[i].setFocusable(false);

        }




    }
}
