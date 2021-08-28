import javax.swing.*;
import java.awt.*;

public class NotepadPanel extends JPanel {

    JMenu menu, sep;
    JMenuItem i1, i2, i3, i4, i5;
    JMenuBar mb;
    JTextArea ta;
    JScrollPane spta;
    Font f;

    NotepadPanel(Dimension d)
    {
        this.setPreferredSize(d);
        this.setBackground(new Color(243, 241, 245));

        this.mb = new JMenuBar();

        this.menu=new JMenu("Menu");
        this.sep = new JMenu("|");
        this.i1=new JMenuItem("New");
        this.i3=new JMenuItem("Save");
        this.i4=new JMenuItem("Save As");
        this.i2=new JMenuItem("Open");
        this.i5=new JMenuItem("Item 5");
        this.menu.add(i1); this.menu.add(i2); this.menu.add(i3); this.menu.add(i4); this.menu.add(i5);

        this.sep.setEnabled(false);
        this.mb.add(menu);
        this.mb.add(sep);

        this.mb.setBackground(new Color(181, 255, 217));

        this.ta = new JTextArea("Enter Text", 10, 84);
        this.ta.setCaretColor(new Color(181, 255, 217));
        this.f = new Font("TimesRoman", Font.PLAIN, 14);
        this.ta.setFont(f);
        this.ta.setForeground(new Color(243, 241, 245));
        this.ta.setBackground(new Color(23, 0, 85));
        this.spta = new JScrollPane(ta);

        this.spta.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.spta.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setLayout(new BorderLayout());
        this.add(mb, BorderLayout.NORTH);
        this.add(this.spta, BorderLayout.WEST);
    }
}
