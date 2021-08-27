import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuButton extends JButton implements MouseListener {

    String Text;
    int Entered = 0;
    int Pressed = 0;

    MenuButton(String str, Dimension d)
    {
        super(str);
        this.Text = str;
        addMouseListener(this);
        this.setPreferredSize(new Dimension((int) d.getWidth() - 20,40));
        this.setBorder(null);
    }

    public void paintComponent(Graphics g)
    {
        if(this.Pressed == 0) {
            g.setColor(new Color(182, 25, 25));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(new Color(255, 107, 107));
            g.fillRect(10, 10, this.getWidth() - 20, this.getHeight() - 20);
        }
        else{
            g.setColor(new Color(255, 107, 107));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(new Color(255, 107, 107));
            g.fillRect(10, 10, this.getWidth() - 20, this.getHeight() - 20);
        }

        if(this.Entered == 0) {
            g.setColor(new Color(253, 210, 199));
            g.drawString(this.Text, this.getWidth() / 2 - g.getFontMetrics().stringWidth(this.Text) / 2, 25);
        }
        else{
            g.setColor(new Color(1, 36, 67));
            g.drawString(this.Text, this.getWidth() / 2 - g.getFontMetrics().stringWidth(this.Text) / 2, 25);
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {}

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        this.Pressed = 1;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        this.Pressed = 0;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        this.Entered = 1;
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        this.Entered = 0;
    }
}
