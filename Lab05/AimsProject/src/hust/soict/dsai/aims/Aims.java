package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;
public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());
		anOrder.removeDigitalVideoDisc(dvd2);
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());*/
		Cart anOrder = new Cart();
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		Store store = new Store();
		store.addDVD(cinderellaDVD);
		store.addDVD(jungleDVD);
		boolean mainmenustate = false;
		boolean storemenustate = false;
		boolean cartmenustate = false;
		while(mainmenustate = true) {
			
		
		showMenu();
		Scanner keyboard = new Scanner(System.in);
		int firstoption = keyboard.nextInt();
		if (firstoption == 1) {
			while(storemenustate = true) {
			storeMenu();
			int secondoption = keyboard.nextInt();
			if (secondoption == 1) {
				System.out.println("Please enter the title of DVD: ");
				keyboard.nextLine();
				String DVDTitle = keyboard.nextLine();
				if (store.SearchforDVDbytitle(DVDTitle) != null) {
					DigitalVideoDisc DVDfound = store.SearchforDVDbytitle(DVDTitle);
					System.out.println("DVD- " +DVDfound.getTitle()+ " - "+ DVDfound.getCategory() + " - "+DVDfound.getDirector()+" - " + DVDfound.getLength()+": " + DVDfound.getCost()+"$");
					System.out.println("Do you want to add this DVD to your cart? Press 0 for yes,1 for No ");
					int thirdoption = keyboard.nextInt();
					if (thirdoption == 0) {
						anOrder.addDigitalVideoDisc(DVDfound);
						System.out.println("Your DVD has been added to your cart");
						storemenustate = true;
					}
					else {
						storemenustate = true;
					}
				
				}
				else{
					System.out.println("DVD not found.");
					storemenustate = true;
				}
			}
			else if (secondoption == 2) {
				System.out.println("Please enter the title of DVD: ");
				keyboard.nextLine();
				String DVDTitleadded = keyboard.nextLine();
				if (store.SearchforDVDbytitle(DVDTitleadded) != null) {
					DigitalVideoDisc DVDfoundadded = store.SearchforDVDbytitle(DVDTitleadded);
					anOrder.addDigitalVideoDisc(DVDfoundadded);
					System.out.println("The number of DVD in your cart is"+ anOrder.getQtyOrdered());
					storemenustate = true;

				}
				else {
					System.out.println("DVD not found");
					storemenustate = true;
				}
			}
			else if (secondoption == 3) {
				anOrder.print();
				storemenustate = true;
			}
			else if (secondoption ==0 ){
				mainmenustate = true;
				break;
				
			}
			
		}
			}
		else if (firstoption == 2) {

			System.out.println("Do you want to add DVD or remove DVD? Press 0 for add,1 for remove. ");
			int fourthoption = keyboard.nextInt();
			if (fourthoption == 0) {
				System.out.println("Please enter the title of DVD: ");
				keyboard.nextLine();
				String Titleadded = keyboard.nextLine();
				DigitalVideoDisc DVDAdded = new DigitalVideoDisc(Titleadded);

				System.out.println("Please enter the cost of DVD: ");
				float Costadded = (float) keyboard.nextDouble();
				System.out.println("Please enter the Category of DVD: ");
				keyboard.nextLine();
				String Categoryadded = keyboard.nextLine();
				System.out.println("Please enter the director of DVD: ");
				String Directoradded = keyboard.nextLine();
				System.out.println("Please enter the length of DVD: ");
				int Lengthadded = keyboard.nextInt();
				DVDAdded.setCategory(Categoryadded);
				DVDAdded.setCost(Costadded);
				DVDAdded.setDirector(Directoradded);
				DVDAdded.setLength(Lengthadded);
				store.addDVD(DVDAdded);
				System.out.println("The disc has already been added.");
				mainmenustate = true;
				
			}
			else {
				System.out.println("Please enter the title of DVD: ");
				keyboard.nextLine();
				String Titleremoved = keyboard.nextLine();
				if (store.SearchforDVDbytitle(Titleremoved) != null) {
					store.removeDVD(store.SearchforDVDbytitle(Titleremoved));
					System.out.println("The disc has been removed.");
					mainmenustate = true;

				}
				else {
					System.out.println("DVD not found.");
					mainmenustate = true;				}
			}

		}
		else if (firstoption == 3) {
			while(cartmenustate = true) {
				cartMenu();
				int fifthoption = keyboard.nextInt();
				if (fifthoption == 1) {
					System.out.println("Please choose a way to find DVD: Press 0 for id, 1 for Title ");
					int waytofilter = keyboard.nextInt();
					if(waytofilter == 0) {
						System.out.println("Please enter the id of DVD: ");			
						int id_filter = keyboard.nextInt();

						anOrder.SearchforDVD(id_filter);
						cartmenustate = true;
					}
					else {
						System.out.println("Please enter the title of DVD: ");
						keyboard.nextLine();
						String Titlefilter = keyboard.nextLine();
						anOrder.SearchforDVDbytitle(Titlefilter);
						cartmenustate = true;
					}
				}
				else if (fifthoption == 2) {
					System.out.println("Please choose a way to sort DVD: Press 0 for title, 1 for cost ");
					int waytosort = keyboard.nextInt();
					if(waytosort == 0) {
						anOrder.sortByTitle();
						cartmenustate = true;
					}
					else {
						anOrder.sortByCost();
						cartmenustate = true;
					}

				}
				else if(fifthoption == 3) {
					System.out.println("Please enter the title of DVD: ");
					keyboard.nextLine();
					String Titleremoved = keyboard.nextLine();

						if (anOrder.SearchforDVDforcart(Titleremoved) != null) {
							anOrder.removeDigitalVideoDisc(anOrder.SearchforDVDforcart(Titleremoved));
							System.out.println("The disc has been removed.");
							mainmenustate = true;

						}
						else {
							System.out.println("DVD not found.");
							mainmenustate = true;				}
					}
				else if(fifthoption == 4) {
					System.out.println("An order is created");
					anOrder =null;
				}
				else {
					mainmenustate = true;
					break;
				}
			
			
		}

		}
		else {
			mainmenustate = false;
			System.out.println("You have exited");
			break;
		}
		}
		
	}
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
	}
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a DVD's details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
		}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter DVDs in cart");
		System.out.println("2. Sort DVDs in cart");
		System.out.println("3. Remove DVD from cart");
		System.out.println("4. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		
	}

}
