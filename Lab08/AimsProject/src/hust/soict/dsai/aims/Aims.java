package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import MemoryDaemon.MemoryDaemon;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Track;

import java.util.ArrayList;
import java.util.Scanner;
public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Cart anOrder = new Cart();
		
		Media Media1 = new Media("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		anOrder.addMedia(Media1);
		
		Media Media2 = new Media("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addMedia(Media2);
		
		Media Media3 = new Media("Aladin",
				"Animation", 18.99f);
		anOrder.addMedia(Media3);
		
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());
		anOrder.removeMedia(Media2);
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());*/
		Cart anOrder = new Cart();
		DigitalVideoDisc jungleMedia = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaMedia = new DigitalVideoDisc("Cinderella");
		Store store = new Store();
		store.addMedia(cinderellaMedia);
		store.addMedia(jungleMedia);
		boolean mainmenustate = false;
		boolean storemenustate = false;
		boolean cartmenustate = false;
		MemoryDaemon memo = new MemoryDaemon();
		
		Thread thd = new Thread(memo);
		thd.setDaemon(true);
		thd.start();
		while(mainmenustate = true) {
			
		
		showMenu();
		Scanner keyboard = new Scanner(System.in);
		int firstoption = keyboard.nextInt();
		if (firstoption == 1) {
			while(storemenustate = true) {
			storeMenu();
			int secondoption = keyboard.nextInt();
			if (secondoption == 1) {
				System.out.println("Please enter the title of Media: ");
				keyboard.nextLine();
				String MediaTitle = keyboard.nextLine();
				if (store.SearchforMediabytitle(MediaTitle) != null) {
					Media Mediafound = store.SearchforMediabytitle(MediaTitle);
					System.out.println("Media- " +Mediafound.getTitle()+ " - "+ Mediafound.getCategory() + ": " + Mediafound.getCost()+"$");
					System.out.println("Do you want to add this Media to your cart? Press 0 for yes,1 for No ");
					int thirdoption = keyboard.nextInt();
					if (thirdoption == 0) {
						anOrder.addMedia(Mediafound);
						System.out.println("Your Media has been added to your cart");
						storemenustate = true;
					}
					else {
						storemenustate = true;
					}
				
				}
				else{
					System.out.println("Media not found.");
					storemenustate = true;
				}
			}
			else if (secondoption == 2) {
				System.out.println("Please enter the title of Media: ");
				keyboard.nextLine();
				String MediaTitleadded = keyboard.nextLine();
				if (store.SearchforMediabytitle(MediaTitleadded) != null) {
					Media Mediafoundadded = store.SearchforMediabytitle(MediaTitleadded);
					anOrder.addMedia(Mediafoundadded);
					System.out.println("The number of Media in your cart is"+ anOrder.size);
					storemenustate = true;

				}
				else {
					System.out.println("Media not found");
					storemenustate = true;
				}
			}
			else if (secondoption == 3) {
				anOrder.print();
				storemenustate = true;
			}
			else if (secondoption == 4) {
				System.out.println("Please enter the title of the Media you want to play:");
				keyboard.nextLine();
				String Mediatitle = keyboard.nextLine();

				Media Mediafounded = store.SearchforMediabytitle(Mediatitle);
				if(Mediafounded instanceof Playable) {
						((Playable) Mediafounded).play();
					
					}
				else {
						System.out.println("Can't play");
					}
					storemenustate = true;
				}
				
			else if (secondoption == 0 ){
				mainmenustate = true;
				break;
				
			}
			
		}
			}
		else if (firstoption == 2) {

			System.out.println("Do you want to add Media or remove Media? Press 0 for add,1 for remove. ");
			int fourthoption = keyboard.nextInt();
			if (fourthoption == 0) {
				System.out.println("Please enter the Type of Media:");
				keyboard.nextLine();
				String Typeadded = keyboard.nextLine();

				System.out.println("Please enter the title of Media: ");
				keyboard.nextLine();
				String Titleadded = keyboard.nextLine();

				System.out.println("Please enter the cost of Media: ");
				float Costadded = (float) keyboard.nextDouble();
				System.out.println("Please enter the Category of Media: ");
				keyboard.nextLine();
				String Categoryadded = keyboard.nextLine();
				if (Typeadded.equals("DigitalVideoDisc") == true) {

					System.out.println("Please enter the director of DVD: ");
					keyboard.nextLine();
					String Directoradded = keyboard.nextLine();
					System.out.println("Please enter the length of DVD: ");
					int Lengthadded = keyboard.nextInt();
					DigitalVideoDisc DVDAdded = new DigitalVideoDisc(Titleadded,Categoryadded,Directoradded,Lengthadded,Costadded);

					store.addMedia(DVDAdded);
					System.out.println("The digital video disc has already been added.");
					mainmenustate = true;
					
				}
				else if(Typeadded.equals("CompactDisc") == true) {
					ArrayList<Track> tracks = new ArrayList<Track>();
					System.out.println("Please enter the director of CD: ");
					String Directoradded = keyboard.nextLine();
					System.out.println("Please enter the length of CD: ");
					int Lengthadded = keyboard.nextInt();
					System.out.println("Please enter the artist of CD: ");

					String Artistadded = keyboard.nextLine();

					int statetrackadded = 0;
					while(statetrackadded == 0) {
						System.out.println("Please enter the length of a track: ");
						int Lengthtrackadded = keyboard.nextInt();
						System.out.println("Please enter the title of a track: ");
						keyboard.nextLine();
						String Titletrackadded = keyboard.nextLine();
						Track newTrack = new Track(Titletrackadded,Lengthtrackadded);
						tracks.add(newTrack);
						System.out.println("Do you want to add more tracks? Enter 0 for Yes, 1 for No: ");
						int state = keyboard.nextInt();
						statetrackadded = state;
					}
					CompactDisc CompactDiscadded = new CompactDisc(Titleadded,Categoryadded,Directoradded,Lengthadded,Costadded,Artistadded,tracks);
					store.addMedia(CompactDiscadded);
					System.out.println("The compact disc has already been added.");
					mainmenustate = true;
					
				}
				else {
					int stateauthoradded = 0;
					ArrayList<String> authors = new ArrayList<String>();
					System.out.println("Please enter the content of Book:");
					keyboard.nextLine();
					String content = keyboard.nextLine();

					while(stateauthoradded == 0) {
						System.out.println("Please enter an author of a book: ");
						keyboard.nextLine();
						String Authoradded = keyboard.nextLine();
						authors.add(Authoradded);
						System.out.println("Do you want to add more authors? Enter 0 for Yes, 1 for No: ");
						int state = keyboard.nextInt();
						stateauthoradded = state;
					}
					Book Bookadded = new Book(Titleadded,Categoryadded,Costadded,content,authors);
					store.addMedia(Bookadded);
					System.out.println("The book has already been added.");
					mainmenustate = true;
				}


			}
			else {
				System.out.println("Please enter the title of Media: ");
				keyboard.nextLine();
				String Titleremoved = keyboard.nextLine();
				if (store.SearchforMediabytitle(Titleremoved) != null) {
					store.removeMedia(store.SearchforMediabytitle(Titleremoved));
					System.out.println("The disc has been removed.");
					mainmenustate = true;

				}
				else {
					System.out.println("Media not found.");
					mainmenustate = true;				}
			}

		}
		else if (firstoption == 3) {
			while(cartmenustate = true) {
				cartMenu();
				int fifthoption = keyboard.nextInt();
				if (fifthoption == 1) {
					System.out.println("Please choose a way to find Media: Press 0 for id, 1 for Title ");
					int waytofilter = keyboard.nextInt();
					if(waytofilter == 0) {
						System.out.println("Please enter the id of Media: ");			
						int id_filter = keyboard.nextInt();

						anOrder.SearchforMedia(id_filter);
						cartmenustate = true;
					}
					else {
						System.out.println("Please enter the title of Media: ");
						keyboard.nextLine();
						String Titlefilter = keyboard.nextLine();
						anOrder.SearchforMediabytitle(Titlefilter);
						cartmenustate = true;
					}
				}
				else if (fifthoption == 2) {
					System.out.println("Please choose a way to sort Media: Press 0 for title, 1 for cost ");
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
					System.out.println("Please enter the title of Media: ");
					keyboard.nextLine();
					String Titleremoved = keyboard.nextLine();

						if (anOrder.SearchforMediaforcart(Titleremoved) != null) {
							anOrder.removeMedia(anOrder.SearchforMediaforcart(Titleremoved));
							System.out.println("The disc has been removed.");
							mainmenustate = true;

						}
						else {
							System.out.println("Media not found.");
							mainmenustate = true;				}
					}
				else if(fifthoption == 4) {
					System.out.println("An order is created");
					anOrder.getALuckyItem();
					anOrder =null;
				}
				else if(fifthoption == 5) {
					System.out.println("Please enter the title of the Media you want to play:");
					keyboard.nextLine();
					String Mediatitle = keyboard.nextLine();

					Media Mediafounded = store.SearchforMediabytitle(Mediatitle);
					if(Mediafounded instanceof Playable) {
							((Playable) Mediafounded).play();
						
						}
					else {
							System.out.println("Can't play");
						}
						storemenustate = true;
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
		System.out.println("1. See a Media's details");
		System.out.println("2. Add a Media to cart");
		System.out.println("3. See current cart");
		System.out.println("4. Choose a media to play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
		}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter Medias in cart");
		System.out.println("2. Sort Medias in cart");
		System.out.println("3. Remove Media from cart");
		System.out.println("4. Place order");
		System.out.println("5. Choose a media to play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		
	}

}
