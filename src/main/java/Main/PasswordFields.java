package Main;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class PasswordFields extends JPasswordField {
    public PasswordFields()
    {
        setFont(new Font("CONSOLAS",Font.PLAIN,25));
        setBackground(new Color(8,1,43));
        setForeground(Color.white);
        setCaretColor(Color.white);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
}
