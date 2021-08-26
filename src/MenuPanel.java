import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    MenuPanel()
    {
        this.setPreferredSize(new Dimension(400,900));
        this.add(new MenuButton("HELLO 1",this.getPreferredSize()));
    }
}
