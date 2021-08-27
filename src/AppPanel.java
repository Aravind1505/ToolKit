import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class AppPanel extends JPanel{

    int Width, Height;
    MenuButton mb1, mb2;
    MainFrame MF_OBJ;
    int ch;

    AppPanel(int width, int height, MainFrame obj)
    {
        this.MF_OBJ = obj;
        this.Width = width;
        this.Height = height;
        this.setPreferredSize(new Dimension(3 * this.Width/ 4, this.Height));
        this.mb1 = new MenuButton("HELLO 1 AP",this.getPreferredSize());
        this.mb2 = new MenuButton("HELLO 2 AP",this.getPreferredSize());
        this.setBackground(Color.GREEN);

        this.add(mb1);
        this.add(mb2);
    }

    public void setPanel(int ch)
    {
        this.ch = ch;
    }

    public int getPanel()
    {
        return this.ch;
    }
}
