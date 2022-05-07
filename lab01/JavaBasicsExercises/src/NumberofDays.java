import java.util.Arrays;
import java.util.Scanner;
public class NumberofDays {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a Month: ");
		String strMonth = keyboard.nextLine();
		System.out.println("Enter a Year: ");
		String strYear = keyboard.nextLine();
		String[] Days31_list = {"January","Jan.","Jan","1","March","Mar.","Mar","3","May","5","July","Jul","7",
				"August","Aug.","Aug","8","October","Oct.","Oct","10","December","Dec.","Dec","12"};
		String[] Days30_list = {"April","Apr.","Apr","4","June","Jun","6","September","Sept.","Sep","9", "November","Nov.","Nov","11"};
		String[] February_list = {"February","Feb.","Feb","2"};
		if(Arrays.asList(Days31_list).contains(strMonth) || Arrays.asList(Days30_list).contains(strMonth) || Arrays.asList(February_list).contains(strMonth)) {
			try {
			    int year = Integer.parseInt(strYear);
			    if(year>= 0) {
			       if (Arrays.asList(Days31_list).contains(strMonth)) {
			    	   System.out.println("There are 31 days in this month");
			       }
			       else if(Arrays.asList(Days30_list).contains(strMonth)) {
			    	   System.out.println("There are 30 days in this month");
			       }
			       else {
			    	   if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
				    	   System.out.println("There are 29 days in this month");

			    	   }
			    	   else {
				    	   System.out.println("There are 28 days in this month");

			    	   }
			       }
			       }
			    else {
			    	System.out.println("This is not a valid year.");
			    	
			    }
			       
			} catch (NumberFormatException e) {
			    System.out.println("This is not a valid year. ");
			}
			
		}
		else {
			System.out.println("This is not a valid month.");
		}
	}
}
