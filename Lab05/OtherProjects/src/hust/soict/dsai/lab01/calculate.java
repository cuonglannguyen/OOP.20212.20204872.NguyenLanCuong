package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;
public class calculate {
    public static void main(String[] args){
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number:",
        "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number:",
        "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        String sum_of_two_num = Double.toString(num1 + num2);
        String diff_of_two_num = Double.toString(num1 - num2);
        String product_of_two_num = Double.toString(num1 * num2);
        String quotient_of_two_num;
        if(num2 == 0){
            quotient_of_two_num = "Not valid value of second number!";
        } 
        else{
            quotient_of_two_num = Double.toString(num1 / num2);
        }
        String strNotification ="Sum of two numbers is: " + sum_of_two_num + "\n";
        strNotification += "Difference of two numbers is: " + diff_of_two_num + "\n";
        strNotification += "Product of two numbers is: " + product_of_two_num + "\n";
        strNotification += "Quotient of two numbers is: " + quotient_of_two_num + "\n";
        JOptionPane.showMessageDialog(null, strNotification, "Show the result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);


    
    }
}