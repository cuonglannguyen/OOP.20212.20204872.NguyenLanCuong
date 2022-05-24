import javax.swing.JOptionPane;
import java.lang.Math;
public class SolveSecondDegreeEquation {
    public static void main(String[] args){
        String num_a,num_b,num_c;
        num_a = JOptionPane.showInputDialog(null, "Please input the value of a:",
        "Input the value of a", JOptionPane.INFORMATION_MESSAGE);
        num_b = JOptionPane.showInputDialog(null, "Please input the value of b:",
        "Input the value of b", JOptionPane.INFORMATION_MESSAGE);
        num_c = JOptionPane.showInputDialog(null, "Please input the value of c:",
        "Input the value of c", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(num_a);
        double b = Double.parseDouble(num_b);
        double c = Double.parseDouble(num_c);
        double delta_value;
        String strNotification;
        delta_value = b*b - 4*a*c;
        if (delta_value != 0){
            if (delta_value < 0){
                strNotification = "The equation has no solutions.";


            }
            else{
                String first_solution = Double.toString((- b + Math.sqrt(delta_value))/(2 * a));
                String second_solution = Double.toString((- b - Math.sqrt(delta_value))/(2 * a));
                strNotification = "The equation has two solutions:" +first_solution + " and "+ second_solution;

            }
        }
        else{
            String double_solution = Double.toString( -b/(2*a));
            strNotification = "The equation has one double solution:" + double_solution;
        }
        JOptionPane.showMessageDialog(null, strNotification, "Show the result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }
    
}
