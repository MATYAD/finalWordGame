package core.gamePanel;

import core.GridFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class ButtonPanel extends JPanel implements ActionListener {
    Font backTo1982;
    Random random = new Random();
    static int xSize = Integer.parseInt(GridFrame.xTextField.getText());
    static int ySize = Integer.parseInt(GridFrame.yTextField.getText());

    public JButton[] buttons;

    public JButton curentButton = new JButton();
    public String[] nameStrings = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public ButtonPanel() {
        this.setLayout(new GridLayout(ySize, xSize));
        this.setBounds(100,100,800,400);
        this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));

        try {
            InputStream is = getClass().getResourceAsStream("/res/backTo1982.TTF");
            backTo1982 = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setGridSize();
    }

    public void setGridSize() {

        int numOfButtons = xSize * ySize;
        buttons = new JButton[numOfButtons];

        for (int i = 0; i < numOfButtons; i++){
            buttons[i] = new JButton();
            this.add(buttons[i]);
            int charIndex = random.nextInt(26);
            buttons[i].setText(nameStrings[charIndex]);
            buttons[i].setBackground(Color.DARK_GRAY);
            buttons[i].setForeground(Color.BLACK);
            buttons[i].setFont(backTo1982.deriveFont(Font.BOLD,50));
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
            buttons[i].setFocusable(false);

            final int index = i;
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource()==buttons[index]){
                        if (FinalWordPanel.buttonList[0].getText().isEmpty()) {
                            FinalWordPanel.buttonList[0].setText(buttons[index].getText());
                        } else if (FinalWordPanel.buttonList[1].getText().isEmpty()) {
                            FinalWordPanel.buttonList[1].setText(buttons[index].getText());
                        } else if (FinalWordPanel.buttonList[2].getText().isEmpty()) {
                            FinalWordPanel.buttonList[2].setText(buttons[index].getText());
                        } else if (FinalWordPanel.buttonList[3].getText().isEmpty()) {
                            FinalWordPanel.buttonList[3].setText(buttons[index].getText());
                        } else if (FinalWordPanel.buttonList[4].getText().isEmpty()) {
                            FinalWordPanel.buttonList[4].setText(buttons[index].getText());
                        } else if (FinalWordPanel.buttonList[5].getText().isEmpty()) {
                            FinalWordPanel.buttonList[5].setText(buttons[index].getText());
                        }

                    }



                        //FinalWordPanel.buttonList.add(buttons[index]);
                        //System.out.println(FinalWordPanel.buttonList.size());

                        //FinalWordPanel.buttonList.remove(0);

                        //System.out.println(index);



                }
            });
        }
    }

    public void actionPerformed(ActionEvent e) {

    }
}
