import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener{
    private JFrame mainFrame;
    private JPanel top, gridPanel;
    private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16;
    private JTextArea textArea;
    private String buttonType;
    private boolean isFirstNum = true;
    private int firstNum;
    private int secondNum;
    private String operation = "";
    private int result;
    private String displayedResult;


    public static void main(String[] args) {
        Calculator myCode = new Calculator();
    }

    public Calculator(){
        mainFrame = new JFrame("Calculator");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new BorderLayout());

        top = new JPanel();
        mainFrame.add(top, BorderLayout.NORTH);

        gridPanel = new JPanel(new GridLayout(4,4));
        mainFrame.add(gridPanel);

        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("+");
        button5 = new JButton("4");
        button6 = new JButton("5");
        button7 = new JButton("6");
        button8 = new JButton("-");
        button9 = new JButton("7");
        button10 = new JButton("8");
        button11 = new JButton("9");
        button12 = new JButton("x");
        button13 = new JButton("CLEAR");
        button14 = new JButton("0");
        button15 = new JButton("=");
        button16 = new JButton("÷");
        textArea = new JTextArea("enter here");

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button10.addActionListener(this);
        button11.addActionListener(this);
        button12.addActionListener(this);
        button13.addActionListener(this);
        button14.addActionListener(this);
        button15.addActionListener(this);
        button16.addActionListener(this);

        gridPanel.add(button1);
        gridPanel.add(button2);
        gridPanel.add(button3);
        gridPanel.add(button4);
        gridPanel.add(button5);
        gridPanel.add(button6);
        gridPanel.add(button7);
        gridPanel.add(button8);
        gridPanel.add(button9);
        gridPanel.add(button10);
        gridPanel.add(button11);
        gridPanel.add(button12);
        gridPanel.add(button13);
        gridPanel.add(button14);
        gridPanel.add(button15);
        gridPanel.add(button16);
        //borderPanel.add(gridPanel, BorderLayout.CENTER);
        top.add(textArea);


        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        buttonType = e.getActionCommand();
        //textArea.setText(buttonType);

        if(buttonType.matches("\\d")) {
            if (isFirstNum == true) {
                firstNum = (firstNum * 10) + Integer.parseInt(buttonType);
                textArea.setText(String.valueOf(firstNum));
            }
            if (isFirstNum == false) {
                secondNum = (secondNum * 10) + Integer.parseInt(buttonType);
                textArea.setText(String.valueOf(secondNum));
            }
        }
            if(buttonType.equals("+")||buttonType.equals("-")||buttonType.equals("÷")||buttonType.equals("x")){
            isFirstNum = false; //put everywhere in this sequence
            operation=buttonType;
            //textArea.setText(operation);
        }else if(buttonType.equals("=")){
            if(operation.equals("+")){
                isFirstNum=false;
                result = add(firstNum,secondNum);
                displayedResult = Integer.toString(result);
                textArea.setText(displayedResult);
            }else if(operation.equals("-")){
                isFirstNum = false;
                result = subtract(firstNum,secondNum);
                System.out.println(result);
                displayedResult = Integer.toString(result);
                textArea.setText(displayedResult);
            }else if(operation.equals("÷")){
                isFirstNum = false;
                result = divide(firstNum,secondNum);
                System.out.println(result);
                displayedResult = Integer.toString(result);
                textArea.setText(displayedResult);
            }else if(operation.equals("x")){
                isFirstNum = false;
                result = multiply(firstNum,secondNum);
                System.out.println(result);
                displayedResult = Integer.toString(result);
                textArea.setText(displayedResult);
            }
        }else if(buttonType.equals("CLEAR")){
            reset();
        }








    }
    public void reset(){
        firstNum =0;
        secondNum = 0;
        isFirstNum = true;
        result = 0;
        textArea.setText("enter here");
    }

    public int add(int a, int b){
        int sum = a+b;
        return sum;
    }

    public int subtract(int a, int b){
        int difference = a - b;
        return difference;
    }

    public int multiply(int a, int b){
        int product = a*b;
        return product;
    }

    public int divide(int a, int b){
        int quotient = a/b;
        return quotient;
    }

}
