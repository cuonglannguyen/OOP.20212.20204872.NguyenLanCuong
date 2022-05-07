import javax.swing.JOptionPane;
public class SolveSystemOfLinearEquations {
    public static void main(String[] args){
        String num_a11, num_a12, num_a21, num_a22,num_b1,num_b2;
        num_a11 = JOptionPane.showInputDialog(null, "Please input the value of first parameter of first equation(a11)",
            "Input the values", JOptionPane.INFORMATION_MESSAGE);
        num_a12 = JOptionPane.showInputDialog(null, "Please input the value of second parameter of first equation(a12)",
            "Input the values", JOptionPane.INFORMATION_MESSAGE);
        num_b1 = JOptionPane.showInputDialog(null, "Please input the result of first equation(b1)",
            "Input the values", JOptionPane.INFORMATION_MESSAGE);
        num_a21 = JOptionPane.showInputDialog(null, "Please input the value of first parameter of second quation(a21)",
            "Input the values", JOptionPane.INFORMATION_MESSAGE);
        num_a22 = JOptionPane.showInputDialog(null, "Please input the value of second parameter of second equation(a22)",
            "Input the values", JOptionPane.INFORMATION_MESSAGE);
        num_b2 = JOptionPane.showInputDialog(null, "Please input the result of second equation(b2)",
        "Input the values", JOptionPane.INFORMATION_MESSAGE);
        double a11 = Double.parseDouble(num_a11);
        double a12 = Double.parseDouble(num_a12);
        double a21 = Double.parseDouble(num_a21);
        double a22 = Double.parseDouble(num_a22);
        double b1 = Double.parseDouble(num_b1);
        double b2 = Double.parseDouble(num_b2);
        double determinant = a11 * a22 - a21 * a12;
        double first_determinant_factor = b1* a22 - b2 * a12;
        double second_determinat_factor = a11 * b2 - a21 * b1;
        String first_solution, second_solution,factor1,factor2,strNotification;
        if (determinant != 0){
            first_solution = Double.toString(first_determinant_factor/ determinant);
            second_solution = Double.toString(second_determinat_factor/ determinant);
            strNotification = "The solutions for the systems are:" + first_solution + " and " + second_solution;


        }
        else{
            if(first_determinant_factor != 0){
                strNotification = "The system has no solutions";

            }
            else{
                factor1= Double.toString(b2/a22);
                factor2 = Double.toString(a21/a22);
                strNotification ="The system has infinitely many solutions. x2 = "+ factor1 + " - "+ factor2 + " * x1";



            }
        } 
        JOptionPane.showMessageDialog(null, strNotification, "Show the result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    
}
