package Main;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class ChatPanel extends JPanel{

    ChatPanel(int x, int y, int width, int height, int R, int G, int B)
    {
        setBackground(new Color(R,G,B));
        setBounds(x,y,width, height);
        setVisible(true);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
}
