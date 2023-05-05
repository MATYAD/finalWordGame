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
    public String[] nameStrings = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public ButtonPanel() {
        this.setLayout(new GridLayout(xSize, ySize));
        this.setBounds(100,100,800,400);
        this.setBackground(Color.BLACK);

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
            buttons[i] = new JButton("Button " + (i+1));
            this.add(buttons[i]);
            int charIndex = random.nextInt(26);
            buttons[i].setText(nameStrings[charIndex]);
            buttons[i].setBackground(Color.DARK_GRAY);
            buttons[i].setForeground(Color.BLACK);
            buttons[i].setFont(backTo1982.deriveFont(Font.BOLD,50));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }
    }

    public void actionPerformed(ActionEvent e) {


    }
}
