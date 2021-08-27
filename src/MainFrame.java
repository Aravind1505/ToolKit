import javax.swing.*;

public class MainFrame extends JFrame {

    int Width, Height;
    MenuPanel mp;
    AppPanel ap;

    public MainFrame()
    {
        this.setResizable(false);

        this.Width = 1600;
        this.Height = 900;

        mp = new MenuPanel(this.Width, this.Height, this);
        ap = new AppPanel(this.Width, this.Height, this);

        this.setSize(this.Width, this.Height);
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

    public void setPanel(int ch)
    {
        ap.setPanel(ch);
    }

    public int getPanel()
    {
        return this.ap.getPanel();
    }
}
