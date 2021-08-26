import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuButton extends JButton implements MouseListener{

    String Text;

    MenuButton(String str, Dimension d)
    {
        super(str);
        this.Text = str;
        addMouseListener(this);
        this.setPreferredSize(new Dimension((int) d.getWidth() - 20,40));
    }

    public void paintComponent(Graphics g)
    {
        g.setColor(new Color(23, 0, 85));
        g.fillRect(0,0,this.getWidth(),this.getHeight());

        g.setColor(new Color(62,0,255));
        g.drawString(this.Text, this.getWidth()/2 - g.getFontMetrics().stringWidth(this.Text)/2, 25);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getSource().getClass().getName() + " Entered");
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getSource().getClass().getName() + " Exited");
    }
}
