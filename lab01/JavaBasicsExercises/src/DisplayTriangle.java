import java.util.Scanner;
public class DisplayTriangle {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a value of n: ");
		int value_of_n = keyboard.nextInt();
		String space = " ";
		String star = "*";
		for (int i = 0; i < value_of_n; i++) {
			
			System.out.println(space.repeat(value_of_n - i) + star.repeat(2 * i +1)+ space.repeat(value_of_n - i));
			
		}
	}

}
