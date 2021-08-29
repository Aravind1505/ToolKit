import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener {

    ArrayList<Point> alp;

    PaintPanel(Dimension d)
    {
        this.alp = new ArrayList<Point>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setPreferredSize(d);
        this.setLayout(null);
        this.setBackground(new Color(243, 241, 245));
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.RED);
        for(int i =0; i < alp.size(); i++)
            g.fillOval((int)this.alp.get(i).getX(), (int)this.alp.get(i).getY(), 10, 10);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        this.alp.add(mouseEvent.getPoint());
        this.updateUI();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        this.alp.add(mouseEvent.getPoint());
        this.updateUI();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        this.updateUI();
    }
}
