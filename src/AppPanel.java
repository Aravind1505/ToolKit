import javax.swing.*;
import java.awt.*;

public class AppPanel extends JPanel {

    AppPanel()
    {
        this.setPreferredSize(new Dimension(1200,900));
        this.add(new MenuButton("HELLO",this.getPreferredSize()));
    }
}
