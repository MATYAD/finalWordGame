package core.gamePanel;

import core.GridFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class ButtonPanel extends JPanel {
    Font backTo1982;
    Random random = new Random();
    static int xSize = Integer.parseInt(GridFrame.xTextField.getText());
    static int ySize = Integer.parseInt(GridFrame.yTextField.getText());

    public static ArrayList<JButton> buttons = new ArrayList<>();
    public  int charIndex;
    public static int numOfButtons;
    //array with alphabet
    public static String[] nameStrings = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public ButtonPanel() {

        this.setLayout(new GridLayout(ySize, xSize));
        this.setBounds(100,100,800,400);
        this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));


        try {
            InputStream is = getClass().getResourceAsStream("/res/backTo1982.TTF");
            assert is != null;
            backTo1982 = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        setGridSize();
    }

    public void setGridSize() {

        numOfButtons = xSize * ySize;
        //setting each button
        for (int i = 0; i < numOfButtons; i++){
            buttons.add(i,new JButton());
            this.add(buttons.get(i));
            buttons.get(i).setText("");
            buttons.get(i).setEnabled(false);
            buttons.get(i).setBackground(Color.DARK_GRAY);
            buttons.get(i).setForeground(Color.BLACK);
            buttons.get(i).setFont(backTo1982.deriveFont(Font.BOLD,50));
            buttons.get(i).setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
            buttons.get(i).setFocusable(false);

            final int index = i;
            //deleting button text when the button is clicked
            buttons.get(i).addActionListener(e -> {
                if (e.getSource()==buttons.get(index)){
                    if (FinalWordPanel.buttonList.get(0).getText().isEmpty()) {
                        FinalWordPanel.buttonList.get(0).setText(buttons.get(index).getText());
                    } else if (FinalWordPanel.buttonList.get(1).getText().isEmpty()) {
                        FinalWordPanel.buttonList.get(1).setText(buttons.get(index).getText());
                    } else if (FinalWordPanel.buttonList.get(2).getText().isEmpty()) {
                        FinalWordPanel.buttonList.get(2).setText(buttons.get(index).getText());
                    } else if (FinalWordPanel.buttonList.get(3).getText().isEmpty()) {
                        FinalWordPanel.buttonList.get(3).setText(buttons.get(index).getText());
                    } else if (FinalWordPanel.buttonList.get(4).getText().isEmpty()) {
                        FinalWordPanel.buttonList.get(4).setText(buttons.get(index).getText());
                    } else if (FinalWordPanel.buttonList.get(5).getText().isEmpty()) {
                        FinalWordPanel.buttonList.get(5).setText(buttons.get(index).getText());
                    }

                }
                
            });
        }
        //setting random number for the buttons
        GamePanel.startButton.addActionListener(e -> {
            if (e.getSource()==GamePanel.startButton) {
                for (int i = 0; i<numOfButtons;i++) {
                    charIndex = random.nextInt(26);
                    buttons.get(i).setText(nameStrings[charIndex]);
                    buttons.get(i).setEnabled(true);
                }
            }
        });
    }

}
