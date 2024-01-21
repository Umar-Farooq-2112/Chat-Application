package Main;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class Button extends JButton {
    public void Constructor()
    {
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.CENTER);
        setFont(new Font("Segue Script",Font.ITALIC,40));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setSize(200,150);
        setBackground(new Color(8,1,43));
        setForeground(Color.white);
        setFocusable(false);
    }
    public Button(String text)
    {
        setText(text);
        Constructor();
    }
    public Button(Image img)
    {
        setIcon(new ImageIcon(img));
        Constructor();
    }
}
