package core.welcomePanel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;

public class JSliderUI extends BasicSliderUI {
    public JSliderUI(JSlider slider) {
        super(slider);
    }

    public void paintFocus(Graphics g) {

    }

    protected Dimension getThumbSize() {
        return new Dimension(17,17);
    }
    //making custom Thumb
    public void paintThumb(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(slider.getForeground());
        g2d.fillOval(thumbRect.x, thumbRect.y, thumbRect.width, thumbRect.height);
    }
    //making custom Track
    public void paintTrack(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(slider.getForeground());
        g2d.fillRoundRect(2,slider.getHeight()/2-11,slider.getWidth()-5,4,1,1);
    }
}
