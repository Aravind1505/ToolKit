import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CalculatorPanel extends JPanel{

    SpringLayout spL, spLl, spLu;
    JPanel u, l;
    int deg = 0;

    CalculatorPanel(Dimension d)
    {
        spL = new SpringLayout();
        spLl = new SpringLayout();
        spLu = new SpringLayout();
        this.setPreferredSize(d);
        this.setBackground(new Color(17, 50, 77));
//        this.add(new MenuButton("Hello",this.getPreferredSize()));
        this.setLayout(this.spL);
        init();
    }

    public void init()
    {
        this.u = this.upper();
        this.l = this.lower();

        this.add(u);
        this.add(l);

        spL.putConstraint(SpringLayout.NORTH, u, 10 , SpringLayout.NORTH, this);
        spL.putConstraint(SpringLayout.WEST, u, 10 , SpringLayout.WEST, this);
        spL.putConstraint(SpringLayout.NORTH, l, 10 , SpringLayout.SOUTH, u);
        spL.putConstraint(SpringLayout.WEST, l, 10 , SpringLayout.WEST, this);
    }

    public JPanel upper()
    {
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(1160,200));
        p.setBackground(new Color(231, 224, 201));
        p.setLayout(spLu);

        JTextArea Ota = new JTextArea("Output : ",10, 76);
        spLu.putConstraint(SpringLayout.WEST, Ota, 10, SpringLayout.WEST, p);
        spLu.putConstraint(SpringLayout.NORTH, Ota, 10, SpringLayout.NORTH, p);
        Ota.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        Ota.setLineWrap(true);
        Ota.setName("Output");
        p.add(Ota);

        return p;
    }

    public JPanel lower()
    {
        JPanel p = new JPanel();
        CalculatorMListener cml = new CalculatorMListener(p);
        p.setLayout(spLl);
        p.setPreferredSize(new Dimension(1160,650));
        p.setBackground(new Color(107, 122, 161));

        ArrayList<CalculatorButton> NLCB= new ArrayList<>();
        ArrayList<CalculatorButton> OLCB = new ArrayList<>();

        for(int i=0;i<9;i++)
        {
            NLCB.add(new CalculatorButton(Integer.toString(i), new Dimension(50,50)));
            NLCB.get(i).addMouseListener(cml);
            NLCB.get(i).setName(i+"");
            p.add(NLCB.get(i));
            spLl.putConstraint(SpringLayout.WEST, NLCB.get(i), 25 + (i%3) * 75, SpringLayout.WEST, p);
            spLl.putConstraint(SpringLayout.NORTH, NLCB.get(i), 400 + (i/3) * 75, SpringLayout.NORTH, p );
        }

        //Operator Buttons
        OLCB.add(new CalculatorButton("+", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("-", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("*", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("/", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("%", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("^", new Dimension(50,50)));
//        OLCB.add(new CalculatorButton("^y", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("√", new Dimension(50,50)));
//        OLCB.add(new CalculatorButton("∑", new Dimension(50,50)));
//        OLCB.add(new CalculatorButton("∏", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("(", new Dimension(50,50)));
        OLCB.add(new CalculatorButton(")", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("[", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("]", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("{", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("}", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("e", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("π", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("log", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("ln", new Dimension(50,50)));
//        OLCB.add(new CalculatorButton("x!", new Dimension(50,50)));
//        OLCB.add(new CalculatorButton("=", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("rad", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("deg", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("sin", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("cos", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("tan", new Dimension(50,50)));
//        OLCB.add(new CalculatorButton("Inv", new Dimension(50,50)));
        OLCB.add(new CalculatorButton("Clear", new Dimension(350,50), 1));
        OLCB.add(new CalculatorButton("Evaluate", new Dimension(350,50), 1));


        for(int i=0; i< OLCB.size();i++)
        {
            OLCB.get(i).setName(OLCB.get(i).getText());
            OLCB.get(i).addMouseListener(cml);
            p.add(OLCB.get(i));
            spLl.putConstraint(SpringLayout.WEST, OLCB.get(i), (OLCB.get(i).getText().equals("Evaluate")) ?  625 + 75 * (i % 11): 325 + 75 * (i % 11), SpringLayout.WEST, p);
            spLl.putConstraint(SpringLayout.NORTH, OLCB.get(i), 400 + (i/11) * 75, SpringLayout.NORTH, p );
        }

        //Equation
        JLabel eq = new JLabel("Equation : ");
        p.add(eq);
        eq.setFont(new Font("TimesRoman", Font.BOLD, 15));
        spLl.putConstraint(SpringLayout.NORTH, eq, 10, SpringLayout.NORTH, p);
        spLl.putConstraint(SpringLayout.WEST, eq, 10, SpringLayout.WEST, p);
        JTextArea eqta = new JTextArea("", 8, 76);
        eqta.setLineWrap(true);
        eqta.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        p.add(eqta);
        spLl.putConstraint(SpringLayout.NORTH, eqta, 10, SpringLayout.SOUTH, eq);
        spLl.putConstraint(SpringLayout.WEST, eqta, 10, SpringLayout.WEST, p);

        //Note Values
        JLabel val = new JLabel("Storage : ");
        p.add(val);
        val.setFont(new Font("TimesRoman", Font.BOLD, 15));
        spLl.putConstraint(SpringLayout.NORTH, val, 30, SpringLayout.SOUTH, eqta);
        spLl.putConstraint(SpringLayout.WEST, val, 10, SpringLayout.WEST, p);
        JTextArea valta = new JTextArea("Store Values here.", 5, 76);
        valta.setLineWrap(true);
        valta.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        p.add(valta);
        spLl.putConstraint(SpringLayout.NORTH, valta, 10, SpringLayout.SOUTH, val);
        spLl.putConstraint(SpringLayout.WEST, valta, 10, SpringLayout.WEST, p);

        cml.setEq(eqta);
        cml.setU(this.u);

        return p;
    }
}

class CalculatorMListener implements MouseListener{

    JPanel P, U;
    JTextArea eqta;
    String str;

    CalculatorMListener(JPanel p)
    {
        this.P = p;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getComponent().getName().equals("Clear"))
            this.eqta.setText("");
        else if(mouseEvent.getComponent().getName().equals("Evaluate"))
            this.str = new Calculator_Eval(this.eqta.getText()).Evaluate();
        else if(mouseEvent.getComponent().getName().charAt(0) >= 48 && mouseEvent.getComponent().getName().charAt(0) <= 57)
            this.eqta.setText(this.eqta.getText() + mouseEvent.getComponent().getName());
        else if(mouseEvent.getComponent().getName().equals("sin") ||
                mouseEvent.getComponent().getName().equals("cos") ||
                mouseEvent.getComponent().getName().equals("tan") ||
                mouseEvent.getComponent().getName().equals("log") ||
                mouseEvent.getComponent().getName().equals("ln"))
            this.eqta.setText(this.eqta.getText() + " " + mouseEvent.getComponent().getName() + " ( ");
        else if(mouseEvent.getComponent().getName().equals("e"))
            this.eqta.setText(this.eqta.getText() + " " + Math.E);
        else if(mouseEvent.getComponent().getName().equals("π"))
            this.eqta.setText(this.eqta.getText() + " " + Math.PI);
        else if(mouseEvent.getComponent().getName().equals("[") ||
                mouseEvent.getComponent().getName().equals("{")  )
            this.eqta.setText(this.eqta.getText() + " ( " );
        else if(mouseEvent.getComponent().getName().equals("]") ||
                mouseEvent.getComponent().getName().equals("}")  )
            this.eqta.setText(this.eqta.getText() + " ) " );
        else
            this.eqta.setText(this.eqta.getText() + " " + mouseEvent.getComponent().getName() + " ");

        for (Component x: this.U.getComponents()) {
            if(x.getName().equals("Output")){
                JTextArea jta = (JTextArea) x;
                jta.setText("Output : " + this.str);
            }
        }
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

    public void setEq(JTextArea eqta)
    {
        this.eqta = eqta;
    }

    public void setU(JPanel u)
    {
        this.U = u;
    }
}
