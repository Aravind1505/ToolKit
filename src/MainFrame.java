import javax.swing.JFrame;

public class MainFrame extends JFrame{

    public MainFrame()
    {
        this.setSize(1600, 900);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("ToolKit");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE );
    }

    public static void main(String[] args)
    {
        new MainFrame();
    }

}
