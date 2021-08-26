import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    MenuPanel mp;
    AppPanel ap;

    public MainFrame()
    {
        mp = new MenuPanel();
        ap = new AppPanel();

        this.setSize(1600, 900);
        this.setVisible(true);
        this.setTitle("ToolKit");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE );

        this.add(mp);
        this.add(ap);

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.X_AXIS));
    }

    public static void main(String[] args)
    {
        MainFrame m = new MainFrame();
    }

}
