import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener {

    ArrayList<Pointx> alcp, aldp;
    Color c;

    PaintPanel(Dimension d)
    {
        this.c = Color.RED;
        this.alcp = new ArrayList<Pointx>();
        this.aldp = new ArrayList<Pointx>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setPreferredSize(d);
        this.setLayout(null);
        this.setBackground(new Color(255, 255, 255));
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for(int i =0; i < this.alcp.size(); i++) {
            g.setColor(this.alcp.get(i).getColor());
            g.fillOval((int) this.alcp.get(i).getPoint().getX(), (int) this.alcp.get(i).getPoint().getY(), 5, 5);
        }
        if(aldp.size() > 1) {
            g2d.setStroke(new BasicStroke(5));
            for (int i = 0; i < aldp.size() - 1; i++) {
                if(!(this.aldp.get(i).getStr().equals("End"))) {
                    g2d.setColor(this.aldp.get(i).getColor());
                    g2d.drawLine((int) this.aldp.get(i).getPoint().getX(), (int) this.aldp.get(i).getPoint().getY(), (int) this.aldp.get(i + 1).getPoint().getX(), (int) this.aldp.get(i + 1).getPoint().getY());
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == 1) {
            this.alcp.add(new Pointx("Point", mouseEvent.getPoint(), this.c));
            this.updateUI();
        }
        else if(mouseEvent.getButton() == 3)
        {
            this.c=JColorChooser.showDialog(this,"Select a color",this.c);
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
//        System.out.println("Start : " + mouseEvent.getX() + " " + mouseEvent.getY());
        if(mouseEvent.getButton() == 1)
            this.aldp.add(new Pointx("Start", mouseEvent.getPoint(), this.c));
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
//        System.out.println("End : " + mouseEvent.getX() + " " + mouseEvent.getY());
//        if(mouseEvent.getButton() == 1)
            this.aldp.add(new Pointx("End", mouseEvent.getPoint(), this.c));
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
//        if(mouseEvent.getButton() == 1)
        this.aldp.add(new Pointx("Cont", mouseEvent.getPoint(), this.c));
        this.updateUI();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        this.updateUI();
    }
}

class Pointx{
    String str;
    Point point;
    Color c;

    Pointx(String txt, Point p, Color c){
        this.str = txt;
        this.point = p;
        this.c = c;
    }

    public String getStr()
    {
        return this.str;
    }

    public Point getPoint()
    {
        return this.point;
    }

    public Color getColor(){return this.c;}
}
