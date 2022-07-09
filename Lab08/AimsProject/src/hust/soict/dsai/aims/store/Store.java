package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_NUMBERS_ORDERED = 9;
	protected ArrayList<Media> itemsinStore = new ArrayList<Media>();
	
	private int itemsStore = 0;
	public ArrayList<Media> getItemsInStore() {
		return this.itemsinStore;
	}
	
	public void addMedia(Media media) {
		if (this.itemsinStore.contains(media) == false) {
		this.itemsinStore.add(media);
		itemsStore++;}
		else {
			System.out.println("The media has been in the list already!");
			
		}
	}
	public void removeMedia(Media media) {
		if(this.itemsinStore.contains(media) == false) {
			System.out.println("The media is not found.");
		}
		else {
			this.itemsinStore.remove(media);
			itemsStore -= 1;
		}
		
	}
			
		
		
	
	/*public void addMedia(Media... all_media) {
		if (itemsinStore.size() + all_media.length <= MAX_NUMBERS_ORDERED) {
			for( int j = 0; j < all_media.length; j++) {
				
				addMedia(all_media[j]);
				
				
				
			}
		}
			else if (itemsStore + all_media.length > MAX_NUMBERS_ORDERED && itemsStore < MAX_NUMBERS_ORDERED) {
				for (int j = 0; j < MAX_NUMBERS_ORDERED - all_media.length ; j++) {
					addMedia(all_media[j]);
					
					
				}
				System.out.println("The first" +( MAX_NUMBERS_ORDERED- all_media.length )+"discs have been added");
			}
			else {
				System.out.println("The cart is already full!");
			}

	}
	public void removeMedia(Media... all_media) {
		for( int j = 0; j < all_media.length; j++) {
			
			removeMedia(all_media[j]);
			
			
			}
		System.out.println("The discs has been removed! ");
	}*/

	public Media SearchforMediabytitle(String title) {
		
		Media foundDVD = null;
		for (int i = 0; i <itemsStore; i++) {
			if (itemsinStore.get(i).getTitle().equals(title) == true) {
				foundDVD = itemsinStore.get(i);
				
			}
				
		}
		return foundDVD;
		
			
		}
	
	
	
	

}
