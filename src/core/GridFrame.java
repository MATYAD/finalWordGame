package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GridFrame implements ActionListener {
    JFrame frame = new JFrame();
    ImageIcon icon = new ImageIcon("src/res/Icon.png");
    public static JTextField xTextField = new JTextField();
    JLabel xLabel = new JLabel();
    JLabel yLabel = new JLabel();
    public static JTextField yTextField = new JTextField();
    JLabel textLabel = new JLabel();
    JButton setButton = new JButton();

    public GridFrame() throws HeadlessException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Word Game");
        frame.setIconImage(icon.getImage());
        frame.setUndecorated(true);
        frame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(null);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        setXTextField();
        frame.add(xTextField);
        setXLabel();
        frame.add(xLabel);

        setYTextField();
        frame.add(yTextField);
        setYLabel();
        frame.add(yLabel);

        setTextLabel();
        frame.add(textLabel);
        setSetButton();
        frame.add(setButton);

    }

    public void setXTextField() {
        xTextField.setBounds(250,150,100,50);
        xTextField.setText("3");
        xTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        xTextField.setBackground(Color.DARK_GRAY);
        xTextField.setFont(new Font("Didot", Font.BOLD, 30));
        xTextField.setForeground(Color.BLACK);
        xTextField.setCaretColor(Color.WHITE);

        xTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if ((input < '0' || input > '9') && input != '\b') {
                    e.consume();

                }
            }
        });
    }

    public void setYTextField() {
        yTextField.setBounds(250,250,100,50);
        yTextField.setText("3");
        yTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        yTextField.setBackground(Color.DARK_GRAY);
        yTextField.setFont(new Font("Didot", Font.BOLD, 30));
        yTextField.setForeground(Color.BLACK);
        yTextField.setCaretColor(Color.WHITE);

        yTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if ((input < '0' || input > '9') && input != '\b') {
                    e.consume();
                }
            }
        });
    }

    public void setXLabel() {
        xLabel.setText("X size");
        xLabel.setVerticalAlignment(JLabel.CENTER);
        xLabel.setHorizontalAlignment(JLabel.CENTER);
        xLabel.setFont(new Font("Didot", Font.BOLD, 30));
        xLabel.setForeground(Color.BLACK);
        xLabel.setBounds(150,150,100,50);

    }

    public void setYLabel() {
        yLabel.setText("Y size");
        yLabel.setVerticalAlignment(JLabel.CENTER);
        yLabel.setHorizontalAlignment(JLabel.CENTER);
        yLabel.setFont(new Font("Didot", Font.BOLD, 30));
        yLabel.setForeground(Color.BLACK);
        yLabel.setBounds(150,250,100,50);

    }

    public void setTextLabel() {
        textLabel.setText("Choose your grid size");
        textLabel.setVerticalAlignment(JLabel.CENTER);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setFont(new Font("Didot", Font.BOLD, 45));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(50,25,500,100);

    }

    public void setSetButton() {
        setButton.addActionListener(this);
        setButton.setFocusable(false);
        setButton.setText("SET");
        setButton.setVerticalAlignment(JButton.CENTER);
        setButton.setHorizontalAlignment(JButton.CENTER);
        setButton.setBackground(Color.DARK_GRAY);
        setButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
        setButton.setFont(new Font("Didot", Font.BOLD, 30));
        setButton.setForeground(Color.BLACK);
        setButton.setBounds(375,200,100,50);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==setButton) {
            frame.dispose();
            System.out.println(xTextField.getText());
            System.out.println(yTextField.getText());
        }

    }
}
