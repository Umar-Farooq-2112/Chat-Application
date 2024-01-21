package Main;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class TextFields  extends JTextField{
    public TextFields()
    {
        setFont(new Font("CONSOLAS",Font.ITALIC,25));
        setBackground(new Color(8,1,43));
        setForeground(Color.white);
        setCaretColor(Color.white);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
}
