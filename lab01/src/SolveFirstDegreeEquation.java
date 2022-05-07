import javax.swing.JOptionPane;
public class SolveFirstDegreeEquation {
    public static void main(String[] args){
        String a, b;
        a = JOptionPane.showInputDialog(null, "Please input the value of a:",
            "Input the value of a", JOptionPane.INFORMATION_MESSAGE);
            
            
        b = JOptionPane.showInputDialog(null, "Please input the value of b:",
            "Input the value of b", JOptionPane.INFORMATION_MESSAGE);
        double num_a = Double.parseDouble(a);
        double num_b = Double.parseDouble(b);
        String root_of_equation;
        String strNotification;
        if(num_a == 0){
            
            strNotification = "The value of a is not valid!";

        }
        else{
            root_of_equation = Double.toString(-num_b / num_a);
            strNotification ="The root of the equation is: " + root_of_equation;
        }
        
        JOptionPane.showMessageDialog(null, strNotification, "Show the result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
