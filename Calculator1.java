import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class Calculator1 extends JFrame implements ActionListener {
    
	JTextField fr;
    In converter = new In();
    JButton sevenButton,eightButton,nineButton,sixButton,fiveButton,fourButton,oneButton,twoButton,threeButton,plusButton,minusButton,multiButton,divButton,pointButton,zeroButton,enterButton,powerButton,brack1,brack2,clear;
	public Calculator1() {
        fr = new JTextField();
        fr.setBounds(30, 50, 540, 40);
		//fr.setBackground(Color.GRAY);
		//fr.setOpaque(true);
		add(fr);
		
        setLayout(null); 
		sevenButton =new JButton("7");
		sevenButton.setBounds(30,130,80,80);
		add(sevenButton);
		
		eightButton=new JButton("8");
		eightButton.setBounds(130,130,80,80);
		add(eightButton);

		nineButton=new JButton("9");
		nineButton.setBounds(230,130,80,80);
		add(nineButton);

		fourButton=new JButton("4");
		fourButton.setBounds(30,230,80,80);
		add(fourButton);

		fiveButton=new JButton("5");
		fiveButton.setBounds(130,230,80,80);
		add(fiveButton);

		sixButton=new JButton("6");
		sixButton.setBounds(230,230,80,80);
		add(sixButton);

		oneButton=new JButton("1");
		oneButton.setBounds(30,330,80,80);
		add(oneButton);

		twoButton=new JButton("2");
		twoButton.setBounds(130,330,80,80);
		add(twoButton);

		threeButton=new JButton("3");
		threeButton.setBounds(230,330,80,80);
		add(threeButton);

		zeroButton=new JButton("0");
		zeroButton.setBounds(130,430,80,80);
		add(zeroButton);

		pointButton=new JButton(".");
		pointButton.setBounds(30,430,80,80);
		add(pointButton);

		plusButton=new JButton("+");
		plusButton.setBounds(330,130,80,80);
		add(plusButton);
		
		minusButton=new JButton("-");
		minusButton.setBounds(330,230,80,80);
		add(minusButton);
		
		multiButton=new JButton("*");
		multiButton.setBounds(330,330,80,80);
		add(multiButton);
		

		divButton=new JButton("/");
		divButton.setBounds(330,430,80,80);
		add(divButton);

		enterButton=new JButton("ENTER");
		enterButton.setBounds(230,430,80,80);
		add(enterButton);

        powerButton =new JButton("^");
		powerButton.setBounds(430,130,80,80);
		add(powerButton);
		
        brack1 =new JButton("(");
		brack1.setBounds(430,230,80,80);
		add(brack1);
		
        brack2 =new JButton(")");
		brack2.setBounds(430,330,80,80);
		add(brack2);
		
        clear =new JButton("clear");
		clear.setBounds(430,430,80,80);
		add(clear);
		
		
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sevenButton.addActionListener(this);
        eightButton.addActionListener(this);
        nineButton.addActionListener(this);
        fourButton.addActionListener(this);
        fiveButton.addActionListener(this);
        sixButton.addActionListener(this);
        oneButton.addActionListener(this);
        twoButton.addActionListener(this);
        threeButton.addActionListener(this);
        pointButton.addActionListener(this);
        plusButton.addActionListener(this);
        minusButton.addActionListener(this);
        multiButton.addActionListener(this);
        divButton.addActionListener(this);
        enterButton.addActionListener(this);
        zeroButton.addActionListener(this);
        powerButton.addActionListener(this);
        brack1.addActionListener(this);
        brack2.addActionListener(this);
        clear.addActionListener(this);
    
    
		
	}
    String k="";
    public void actionPerformed(ActionEvent ae){
        try{

      if(ae.getSource() == sevenButton)
        {
         k=k+"7";
         fr.setText(k);

        }
    else if(ae.getSource() == eightButton)
    {
     k=k+"8";
     fr.setText(k);

    } 
    else if(ae.getSource() == nineButton)
        {
         k=k+"9";
         fr.setText(k);

        }


    else if(ae.getSource() == fourButton)
        {
         k=k+"4";
         fr.setText(k);

        }
        else if(ae.getSource() == fiveButton)
        {
         k=k+"5";
         fr.setText(k);

        }
        else if(ae.getSource() == sixButton)
        {
         k=k+"6";
         fr.setText(k);

        }
        else if(ae.getSource() == oneButton)
        {
         k=k+"1";
         fr.setText(k);

        }
        else if(ae.getSource() == twoButton)
        {
         k=k+"2";
         fr.setText(k);

        }
        else if(ae.getSource() == threeButton)
        {
         k=k+"3";
         fr.setText(k);

        }
        else if(ae.getSource() == pointButton)
        {
         k=k+".";
         fr.setText(k);

        }
        else if(ae.getSource() == plusButton)
        {
         k=k+"+";
         fr.setText(k);

        }
        else if(ae.getSource() == minusButton)
        {
         k=k+"-";
         fr.setText(k);

        }
        else if(ae.getSource() == multiButton)
        {
         k=k+"*";
         fr.setText(k);

        }
        else if(ae.getSource() == divButton)
        {
        try{
         k=k+"/";
        }
        catch(ArithmeticException e)
        {
            fr.setText("INVALID INPUT") ; 
        }
         fr.setText(k);

        }
        else if(ae.getSource() == zeroButton)
        {
         k=k+"0";
         fr.setText(k);

        }
        else if(ae.getSource() == enterButton)
        {
            
            try{
                k=fr.getText();
            }
            catch(Exception e)
            {
             fr.setText("INVALID......");
            }
            k=String.valueOf(converter.evaluate( converter.convertToPostfix(k)));
        
         fr.setText(k);

        }
        else if(ae.getSource() == powerButton)
        {
         k=k+"^";
         fr.setText(k);

        }
        else if(ae.getSource() == brack1)
        {
         k=k+"(";
         fr.setText(k);

        }
        else if(ae.getSource() == brack2)
        {
         k=k+")";
         fr.setText(k);

        }
        else if(ae.getSource() == clear)
        {
         k="";
         fr.setText(k);

        }
    }
    catch(ArithmeticException e)
        {
            fr.setText("INVALID INPUT") ; 
        }


    }
public static void main(String[] args) throws NullPointerException
{
    try{
	new Calculator1();
    }
    catch(NullPointerException e)
    {
        System.out.print(e);
    }
	
}
}


class In{
	 private static final char ADD = '+', SUBTRACT = '-';
	    private static final char MULTIPLY = '*', DIVIDE = '/';
		private static final char POWER ='^';

	public In(){
		
	}
// Private methods:

   private boolean isOperator(char c) { // Tell whether c is an operator.

     return c == '+'  ||  c == '-'  ||  c == '*'  ||  c == '/'  ||  c == '^'
           || c=='(' || c==')';
   
   }//end isOperator

 

   private boolean isSpace(char c) {  // Tell whether c is a space.

     return (c == ' ');
   
   }//end isSpace


   private boolean lowerPrecedence(char op1, char op2) {
      // Tell whether op1 has lower precedence than op2, where op1 is an
      // operator on the left and op2 is an operator on the right.
      // op1 and op2 are assumed to be operator characters (+,-,*,/,^).
      
      switch (op1) {

         case '+':
         case '-':
            return !(op2=='+' || op2=='-') ;

         case '*':
         case '/':
            return op2=='^' || op2=='(';

         case '^':
            return op2=='(';

         case '(': return true;

         default:  // (shouldn't happen)
            return false;
      }
 
   } // end lowerPrecedence


// Method to convert infix to postfix:

   public String convertToPostfix(String infix) {
          Stack operatorStack = new Stack();  
     char c;       
     StringTokenizer parser = new StringTokenizer(infix,"+-*/^() ",true);
     StringBuffer postfix = new StringBuffer(infix.length());
        while (parser.hasMoreTokens()) {     
           String token = parser.nextToken();
           c = token.charAt(0);         
           if ( (token.length() == 1) && isOperator(c) ) {    
              while (!operatorStack.empty() &&
                  !lowerPrecedence(((String)operatorStack.peek()).charAt(0), c))
             
                 postfix.append(" ").append((String)operatorStack.pop());
              if (c==')') {
                    String operator = (String)operatorStack.pop();
                    while (operator.charAt(0)!='(') {
                       postfix.append(" ").append(operator);
                       operator = (String)operatorStack.pop();  
                    }
              }
              else
                 operatorStack.push(token);
           }
           else if ( (token.length() == 1) && isSpace(c) ) {   
               }
           else { 
             postfix.append(" ").append(token);  
           }
         }
        while (!operatorStack.empty())
           postfix.append(" ").append((String)operatorStack.pop());
     
        return postfix.toString();
   }

   public int evaluate(String expr) {
	     //   assert (isValid(expr));

	       Stack stack = new Stack();
	        int op1, op2, result = 0;
	        String token;
	        StringTokenizer tokenizer = new StringTokenizer(expr);

	        while (tokenizer.hasMoreTokens()) {
	            token = tokenizer.nextToken();
	            char c = token.charAt(0); 
	            if (isOperator(c)) {
	                op2 = ((Integer) stack.pop()).intValue();
	                op1 = ((Integer) stack.pop()).intValue();
	                result = evalSingleOp(token.charAt(0), op1, op2);
	                stack.push(new Integer(result));
	            }
	            else
	                stack.push(new Integer(Integer.parseInt(token)));
	        }

	        result = ((Integer) stack.pop()).intValue();
	        return result;
	    }
   
   private int evalSingleOp(char operation, int op1, int op2) {
	        int result = 0;

	        switch (operation) {
	            case ADD :
	                result = op1 + op2;
	                break;
	            case SUBTRACT :
	                result = op1 - op2;
	                break;
	            case MULTIPLY :
	                result = op1 * op2;
	                break;
	            case DIVIDE :
	                result = op1 / op2;
                    break;
	            case POWER :
	                result = (int) Math.pow(op1,op2);
	        }

	        return result;
	    }



   

}//end class InfixToPostfix