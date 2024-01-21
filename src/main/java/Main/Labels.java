package Main;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class Labels extends JLabel {

    public void Construct()
    {
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.LEFT);
        setVerticalAlignment(SwingConstants.CENTER);
        setFont(new Font("CONSOLAS",Font.BOLD,30));
        setForeground(Color.white);
        setBackground(new Color(8,1,43));
        setOpaque(true);
    }
    public Labels(String text)
    {
        Construct();
        setText(text);
    }
    public Labels()
    {
        Construct();
    }
}
