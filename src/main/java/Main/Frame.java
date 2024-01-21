package Main;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    Frame()
    {
        setSize(1024,768);
        setFont(new Font("SansSerif",Font.PLAIN,25));
        setTitle("I Chat");
        ImageIcon mainIcon=new ImageIcon("icon.png");
        setIconImage(mainIcon.getImage());
        getContentPane().setBackground(Color.BLACK);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
