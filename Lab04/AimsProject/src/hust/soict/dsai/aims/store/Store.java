package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public DigitalVideoDisc itemsinStore[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int itemsStore = 0;
	public void addDVD(DigitalVideoDisc disc) {
		if (itemsStore < MAX_NUMBERS_ORDERED) {
			this.itemsinStore[itemsStore] = disc;
			this.itemsStore += 1;
			System.out.println("The disc has been added!");
					
		}
		else {
			System.out.println("The cart is already full!");
		}
		
	}
	public void removeDVD(DigitalVideoDisc disc) {
		for (int i = 0; i < itemsStore; i+= 1) {
			if (itemsinStore[i].getId() == disc.getId()) {
				
				for (int j = i + 1; j< itemsStore; j += 1) {
					itemsinStore [j-1] = itemsinStore[j];
					
				}
				itemsStore -= 1;
				itemsinStore[itemsStore] = null;
				
				System.out.println("The disc has been removed! ");
			
			}
			
		}
		
	}
	public void addDVD(DigitalVideoDisc... all_dvds) {
		if (itemsStore + all_dvds.length <= MAX_NUMBERS_ORDERED) {
			for( int j = 0; j < all_dvds.length; j++) {
				
				addDVD(all_dvds[j]);
				
				
				
			}
		}
			else if (itemsStore + all_dvds.length > MAX_NUMBERS_ORDERED && itemsStore < MAX_NUMBERS_ORDERED) {
				for (int j = 0; j < MAX_NUMBERS_ORDERED - all_dvds.length ; j++) {
					addDVD(all_dvds[j]);
					
					
				}
				System.out.println("The first" +( MAX_NUMBERS_ORDERED- all_dvds.length )+"discs have been added");
			}
			else {
				System.out.println("The cart is already full!");
			}

	}
	public void removeDVD(DigitalVideoDisc... all_dvds) {
		for( int j = 0; j < all_dvds.length; j++) {
			
			removeDVD(all_dvds[j]);
			
			
			}
		System.out.println("The discs has been removed! ");
	}

	public DigitalVideoDisc SearchforDVDbytitle(String title) {
		
		DigitalVideoDisc foundDVD = null;
		for (int i = 0; i <itemsStore; i++) {
			if (itemsinStore[i].getTitle().equals(title) == true) {
				foundDVD = itemsinStore[i];
				
			}
				
		}
		return foundDVD;
		
			
		}
	
	
	
	

}
