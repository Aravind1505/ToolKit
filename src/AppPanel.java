import javax.swing.*;
import java.awt.*;

public class AppPanel extends JPanel{

    SpringLayout spL;
    int Width, Height;
    MainFrame MF_OBJ;
    int ch;

    AppPanel(int width, int height, MainFrame obj)
    {
        spL = new SpringLayout();
        this.MF_OBJ = obj;
        this.setPreferredSize(new Dimension(3 * width/ 4, height));
        this.Width = this.getWidth();
        this.Height = this.getHeight();
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(spL);
    }

    public void updateX(JPanel p)
    {
        this.removeAll();
        if(p!=null) {
            this.add(p);
            this.spL.putConstraint(SpringLayout.NORTH, p, 10, SpringLayout.NORTH, this);
            this.spL.putConstraint(SpringLayout.WEST, p, 10, SpringLayout.WEST, this);
        }
        this.updateUI();
    }

    public void setPanel(int ch)
    {
        this.ch = ch;
        if(ch==1)
            this.updateX(new CalculatorPanel(new Dimension(1180, 880)));
        if(ch==2)
            this.updateX(new NotepadPanel(new Dimension(1180, 880)));
        if(ch==3)
            this.updateX(null);
    }

    public int getPanel()
    {
        return this.ch;
    }
}
