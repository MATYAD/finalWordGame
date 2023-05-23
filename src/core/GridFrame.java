package core;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;

public class GridFrame implements ActionListener {
    Font backTo1982;
    JFrame frame = new JFrame();
    ImageIcon icon = new ImageIcon("src/res/Icon.png");
    PlainDocument xDocument = new PlainDocument();
    PlainDocument yDocument = new PlainDocument();
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

        //setting up the Font
        try {
            InputStream is = getClass().getResourceAsStream("/res/backTo1982.TTF");
            assert is != null;
            backTo1982 = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

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
    //setting xDocument
    public void setXDocument() {
        xDocument.setDocumentFilter(new DocumentFilter() {
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);
                if ((newText.length() <= 1) && newText.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
    //setting yDocument
    public void setYDocument() {
        yDocument.setDocumentFilter(new DocumentFilter() {
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);
                if ((newText.length() <= 1) && newText.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
    //setting xTextField
    public void setXTextField() {
        xTextField.setBounds(275,150,100,50);
        xTextField.setText("");
        xTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
        xTextField.setBackground(Color.DARK_GRAY);
        xTextField.setFont(backTo1982.deriveFont(Font.BOLD,25));
        xTextField.setForeground(Color.BLACK);
        xTextField.setCaretColor(Color.WHITE);

        xTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (input == '0' || !Character.isDigit(input)) {
                    e.consume();
                }
            }
        });
        setXDocument();
        xTextField.setDocument(xDocument);
    }
    //setting yTextField
    public void setYTextField() {
        yTextField.setBounds(275,250,100,50);
        yTextField.setText("");
        yTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
        yTextField.setBackground(Color.DARK_GRAY);
        yTextField.setFont(backTo1982.deriveFont(Font.BOLD,25));
        yTextField.setForeground(Color.BLACK);
        yTextField.setCaretColor(Color.WHITE);

        yTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (input == '0' || !Character.isDigit(input)) {
                    e.consume();
                }
            }
        });
        setYDocument();
        yTextField.setDocument(yDocument);
    }
    //setting xLabel
    public void setXLabel() {
        xLabel.setText("X size");
        xLabel.setVerticalAlignment(JLabel.CENTER);
        xLabel.setHorizontalAlignment(JLabel.CENTER);
        xLabel.setFont(backTo1982.deriveFont(Font.BOLD,25));
        xLabel.setForeground(Color.BLACK);
        xLabel.setBounds(125,150,125,50);

    }
    //setting yLabel
    public void setYLabel() {
        yLabel.setText("Y size");
        yLabel.setVerticalAlignment(JLabel.CENTER);
        yLabel.setHorizontalAlignment(JLabel.CENTER);
        yLabel.setFont(backTo1982.deriveFont(Font.BOLD,25));
        yLabel.setForeground(Color.BLACK);
        yLabel.setBounds(125,250,125,50);

    }
    //setting textLabel
    public void setTextLabel() {
        textLabel.setText("Choose your grid size");
        textLabel.setVerticalAlignment(JLabel.CENTER);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setFont(backTo1982.deriveFont(Font.BOLD,30));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(25,0,550,150);

    }
    //setting setButton
    public void setSetButton() {
        setButton.addActionListener(this);
        setButton.setFocusable(false);
        setButton.setText("SET");
        setButton.setVerticalAlignment(JButton.CENTER);
        setButton.setHorizontalAlignment(JButton.CENTER);
        setButton.setBackground(Color.DARK_GRAY);
        setButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
        setButton.setFont(backTo1982.deriveFont(Font.BOLD,25));
        setButton.setForeground(Color.BLACK);
        setButton.setBounds(400,200,100,50);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==setButton) {//setting what happened when the button was clicked
            frame.dispose();

            if (yTextField.getText().isEmpty()) {
                yTextField.setText("4");
            }
            if (xTextField.getText().isEmpty()) {
                xTextField.setText("4");
            }
        }

    }
}
