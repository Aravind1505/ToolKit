import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CalculatorButton extends JButton implements MouseListener {

    String Text;
    int Entered = 0;
    int Pressed = 0;
    Color c1, c2, c3;

    CalculatorButton(String str, Dimension d)
    {
        super(str);
        this.Text = str;
        addMouseListener(this);
        this.setPreferredSize(d);
        this.setBorder(null);

        c1 = new Color(38, 28, 44);
        c2 = new Color(92, 82, 127);
        c3 = new Color(255, 218, 185);

    }

    public void paintComponent(Graphics g)
    {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        if(this.Pressed == 0) {
            g.setColor(c1);
            g.fillOval(0, 0, this.getWidth(), this.getHeight());

            g.setColor(c2);
            g.fillOval(5, 5, this.getWidth() - 10, this.getHeight() - 10);
        }
        else{
            g.setColor(c2);
            g.fillOval(0, 0, this.getWidth(), this.getHeight());

            g.setColor(c2);
            g.fillOval(5, 5, this.getWidth() - 10, this.getHeight() - 10);
        }

        if(this.Entered == 0) {
            g.setColor(c3);
            g.drawString(this.Text, this.getWidth() / 2 - g.getFontMetrics().stringWidth(this.Text) / 2, 30);
        }
        else{
            g.setColor(new Color(1, 36, 67));
            g.drawString(this.Text, this.getWidth() / 2 - g.getFontMetrics().stringWidth(this.Text) / 2, 30);
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
