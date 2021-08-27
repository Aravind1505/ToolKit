import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuPanel extends JPanel implements MouseListener {
    SpringLayout spL;
    JLabel l_AppMenu;
    int Width, Height;
    MenuButton mb1, mb2;
    MainFrame MF_OBJ;

    MenuPanel(int width, int height, MainFrame obj)
    {
        this.MF_OBJ = obj;
        spL = new SpringLayout();
        this.setPreferredSize(new Dimension(width/ 4, height));
        this.Width = this.getWidth();
        this.Height = this.getHeight();
        this.mb1 = new MenuButton("Calculator",this.getPreferredSize());
        this.mb2 = new MenuButton("Notepad",this.getPreferredSize());
        this.setBackground(Color.BLACK);

        l_AppMenu = new JLabel("App Menu");

        l_AppMenu.setForeground(Color.WHITE);
        this.add(l_AppMenu);
        this.add(mb1);
        this.add(mb2);

        this.setLayout(spL);

        spL.putConstraint(SpringLayout.WEST, l_AppMenu, 150, SpringLayout.WEST, this);
        spL.putConstraint(SpringLayout.NORTH, l_AppMenu, 10, SpringLayout.NORTH, this);

        spL.putConstraint(SpringLayout.WEST, mb1, 10, SpringLayout.WEST, this);
        spL.putConstraint(SpringLayout.NORTH, mb1, 10, SpringLayout.SOUTH, l_AppMenu);

        spL.putConstraint(SpringLayout.WEST, mb2, 10, SpringLayout.WEST, this);
        spL.putConstraint(SpringLayout.NORTH, mb2, 10, SpringLayout.SOUTH, mb1);

        mb1.addMouseListener(this);
        mb2.addMouseListener(this);

        mb1.setName("B1");
        mb2.setName("B2");
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        this.MF_OBJ.setPanel((((MenuButton)mouseEvent.getSource()).getName().charAt(1))-48);
        System.out.println("xyz " + ((MenuButton)mouseEvent.getSource()).getName() + " " + this.MF_OBJ.getPanel());
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
}
