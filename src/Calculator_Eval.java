import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator_Eval {
    String str, outputx;
    ArrayList<String> tokens, infixexp;
    Calculator_Eval(String str)
    {
        this.tokens = new ArrayList<>();
        this.infixexp = new ArrayList<>();
        this.str = str;
        this.init();
        this.infix();
    }

    public int getPrecendence(String x)
    {
        if(x.equals("^") )
            return 3;
        else if(x.equals("*") || x.equals("/") || x.equals("%"))
            return 2;
        else if(x.equals("+") || x.equals("-"))
            return 1;
        return 0;
    }

    public String getAssociativity(String x)
    {
        if(x.equals("^"))
            return "Right";
        return "Left";
    }

    public int isOperator(String x)
    {
        if(x.equals("+") || x.equals("-" ) || x.equals("*" ) || x.equals("/" ) || x.equals("%" ) || x.equals("^")
                || x.equals("sin")|| x.equals("cos")|| x.equals("tan")|| x.equals("log")|| x.equals("ln"))
            return 1;
        return 0;
    }

    public void init()
    {
        StringTokenizer st = new StringTokenizer(this.str," ");

        while(st.hasMoreTokens())
            this.tokens.add(st.nextToken());
    }

    public void infix()
    {
        Stack<String> operators = new Stack<>();
        String output = "";

        for(String x : this.tokens)
        {
            if(isOperator(x)==1)
            {
                if(operators.isEmpty())
                    operators.push(x);
                else
                {
                    if((getAssociativity(x).equals("Left") && getPrecendence(x) <= getPrecendence(operators.peek())) ||
                            (getAssociativity(x).equals("Right") && getPrecendence(x) < getPrecendence(operators.peek())))
                    {
                        output += operators.pop() + " ";
                        operators.push(x);
                    }
                    else
                        operators.push(x);
                }
            }
            else if(x.equals("("))
                operators.push(x);
            else if(x.equals(")"))
            {
                while(!(operators.peek().equals("(")))
                    output += operators.pop() + " ";
                operators.pop();
            }
            else
                output += x+ " ";
        }

        while(operators.isEmpty() == false)
            output += operators.pop() + " ";

        StringTokenizer st = new StringTokenizer(output," ");
        this.outputx = output;

        while(st.hasMoreTokens())
            this.infixexp.add(st.nextToken());
    }

    public String Evaluate()
    {
        Stack<Double> operands = new Stack<Double>();
        for( String x : infixexp)
        {
//            System.out.println(x);
            if(isOperator(x)==0)
                operands.push(Double.parseDouble(x));
            else
            {
                if (x.equals("+") && operands.size() >= 2)
                    operands.push(operands.pop() + operands.pop());
                else if (x.equals("-") && operands.size() >= 2 )
                    operands.push(operands.pop() - operands.pop());
                else if (x.equals("*") && operands.size() >=2 )
                    operands.push(operands.pop() * operands.pop());
                else if (x.equals("%") && operands.size() >= 2)
                    operands.push(operands.pop() % operands.pop());
                else if (x.equals("/") && operands.size() >= 2)
                    operands.push(operands.pop() / operands.pop());
                else if (x.equals("^") && operands.size() >= 2)
                    operands.push(Math.pow(operands.pop(), operands.pop()));
                else if (x.equals("sin") && operands.size() >= 1)
                    operands.push(Math.sin(operands.pop()));
                else if (x.equals("cos") && operands.size() >= 1)
                    operands.push(Math.cos(operands.pop()));
                else if (x.equals("tan") && operands.size() >= 1)
                    operands.push(Math.tan(operands.pop()));
                else if (x.equals("log") && operands.size() >= 1)
                    operands.push(Math.log(operands.pop()));
                else if (x.equals("ln")&& operands.size() >= 1)
                    operands.push(Math.log10(operands.pop()));
            }
        }
        this.outputx = Double.toString(operands.pop());
        return this.outputx;
    }
}
