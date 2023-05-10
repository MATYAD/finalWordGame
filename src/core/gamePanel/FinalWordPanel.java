package core.gamePanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class FinalWordPanel{
    Font backTo1982;
    public static JPanel panel = new JPanel();
    public static ArrayList<JButton> buttonList = new ArrayList<>();
    public FinalWordPanel() {
        panel.setLayout(new GridLayout(1, 6));
        panel.setBounds(100,520,650,150);
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));

        try {
            InputStream is = getClass().getResourceAsStream("/res/backTo1982.TTF");
            assert is != null;
            backTo1982 = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        if (buttonList.size() <6){
            for (int i = 0; i < 6; i++) {
                buttonList.add(i,new JButton());
                panel.add(buttonList.get(i));

                buttonList.get(i).setBackground(Color.DARK_GRAY);
                buttonList.get(i).setForeground(Color.BLACK);
                buttonList.get(i).setFont(backTo1982.deriveFont(Font.BOLD,50));
                buttonList.get(i).setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
                buttonList.get(i).setFocusable(false);

                final int index = i;
                buttonList.get(i).addActionListener(e -> {
                    if (e.getSource()==buttonList.get(index)) {
                        buttonList.get(index).setText("");
                    }

                });

            }

        }


    }
}
