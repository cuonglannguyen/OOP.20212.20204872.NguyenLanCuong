import java.util.Scanner;
public class AddMatrices {
	public static void main(String args[]) {
		int row,col,i,j;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");
		row = keyboard.nextInt();
		System.out.println("Enter the number of columns: ");
		col = keyboard.nextInt();
		double mat1[][] = new double[row][col];
		double mat2[][] = new double[row][col];
		double result[][] = new double[row][col];
		System.out.println("Enter the elements of matrix 1: ");
		i = 0;
		while( i< row) {
			j = 0;
			while (j < col) {
				mat1[i][j] = keyboard.nextDouble();
				j++;
			}
			i++;
		}
		System.out.println("Enter the elements of matrix 2: ");
		i = 0;
		while( i< row) {
			j = 0;
			while (j < col) {
				mat2[i][j] = keyboard.nextDouble();
				j++;
			}
			i++;
		}
		i = 0;
		while( i< row) {
			j = 0;
			while (j < col) {
				result[i][j] = mat1[i][j] + mat2[i][j];
				j++;
			}
			i++;
		}
		System.out.println("Sum of two matrices is: ");
		i = 0;
		while( i< row) {
			j = 0;
			while (j < col) {
				System.out.print(result[i][j]+"\t");
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
