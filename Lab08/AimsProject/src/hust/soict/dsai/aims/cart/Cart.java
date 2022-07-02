package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import hust.soict.dsai.aims.media.Media;

import java.util.Collections;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public int size = itemsOrdered.size();
	public static int getMaxNumbersOrdered() {
		return MAX_NUMBERS_ORDERED;
	}
	public void addMedia(Media media) {
		if (itemsOrdered.contains(media) == false) {
		itemsOrdered.add(media);}
		else {
			System.out.println("The media has been in the list already!");
			
		}
	}
	public void removeMedia(Media media) {
		if(itemsOrdered.contains(media) == false) {
			System.out.println("The media is not found.");
		}
		else {
			itemsOrdered.remove(media);
		}
		
	}
		
	public float totalCost() {
		float sum = 0;
		if (itemsOrdered.size() <5){
			for (int i = 0; i< itemsOrdered.size(); i++)
			sum += itemsOrdered.get(i).getCost();

		}
		else {
		for (int i = 0; i< itemsOrdered.size(); i++) {
			sum += itemsOrdered.get(i).getCost();
			sum -= this.getALuckyItem().getCost();
					
		}
		}
		return sum;
	}
	 Comparator<Media> compareByTitle
	 = Comparator.comparing(Media::getTitle);
	            
	 Comparator<Media> compareByCost 
	 = Comparator.comparing(Media::getCost)
	            .thenComparing(Comparator.comparingDouble(Media::getCost).reversed());
public Media[] CartsortByCost() {
		itemsOrdered.sort(compareByCost);
		Media[] arr = itemsOrdered.toArray(new Media[0]);
        return arr;
	}
	public Media[] CartsortByTitle() {
		itemsOrdered.sort(compareByTitle);
		Media[] arr = itemsOrdered.toArray(new Media[0]);
        return arr;
	}
	public void SearchforMedia(int id) {
		boolean found = false;
		for (int i = 0; i <itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				found = true;
				System.out.println("Media- " +itemsOrdered.get(i).getTitle()+ " - "+ itemsOrdered.get(i).getCategory() + ": " + itemsOrdered.get(i).getCost()+"$");
			}
				
		}
		if (found == false) {
			System.out.println("Media not found.");
			
		}
	}
	public void SearchforMediabytitle(String title) {
		boolean found = false;
		for (int i = 0; i <itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(title) == true) {
				found = true;
				System.out.println("Media- " +itemsOrdered.get(i).getTitle()+ " - "+ itemsOrdered.get(i).getCategory() +": " + itemsOrdered.get(i).getCost()+"$");
			}
				
		}
		if (found == false) {
			System.out.println("Media not found.");
			
		}
	}
	
	 Comparator<Media> compare 
	 = Comparator.comparing(Media::getTitle)
	            .thenComparing(Comparator.comparingDouble(Media::getCost).reversed());
	 Comparator<Media> comparebyTitle 
	 = Comparator.comparing(Media::getTitle)
	            .thenComparing(Comparator.comparingDouble(Media::getCost).reversed());
	 Comparator<Media> comparebyCost 
	 = Comparator.comparingDouble(Media::getCost).reversed()
	            .thenComparing(Comparator.comparing(Media::getTitle));
	 
	 
	public void print() {
		List<Media> listMedia = new ArrayList<Media>();
		for (int i = 0; i< itemsOrdered.size(); i++) {
			listMedia.add(itemsOrdered.get(i));
		}
		listMedia.sort(compare);
		Media[] arr = listMedia.toArray(new Media[0]);
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 1; i <itemsOrdered.size() +1; i++) {
			System.out.println( "Media - " +arr[i-1].getTitle()+ " - "+ arr[i-1].getCategory() +": " + arr[i-1].getCost()+"$");
		}
			System.out.println("Total cost:" +this.totalCost());
		System.out.println("***************************************************");
		
		
		
	}//Use for AIMS//
	public void sortByTitle() {
		List<Media> listMedia = new ArrayList<Media>();
		for (int i = 0; i< itemsOrdered.size(); i++) {
			listMedia.add(itemsOrdered.get(i));
		}
		listMedia.sort(comparebyTitle);
		Media[] arr = listMedia.toArray(new Media[0]);
		System.out.println("Sort by title");
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 1; i <itemsOrdered.size() +1; i++) {
			System.out.println( "Media - " +arr[i-1].getTitle()+ " - "+ arr[i-1].getCategory() +": " + arr[i-1].getCost()+"$");
		}
			System.out.println("Total cost:" +this.totalCost());
		System.out.println("***************************************************");
		
		
		
		
	}
	public void sortByCost() {
		List<Media> listMedia = new ArrayList<Media>();
		for (int i = 0; i< itemsOrdered.size(); i++) {
			listMedia.add(itemsOrdered.get(i));
		}
		listMedia.sort(comparebyCost);
		Media[] arr = listMedia.toArray(new Media[0]);
		System.out.println("Sort by title");
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 1; i <itemsOrdered.size() +1; i++) {
			System.out.println( "Media - " +arr[i-1].getTitle()+ " - "+ arr[i-1].getCategory() +": " + arr[i-1].getCost()+"$");
		}
			System.out.println("Total cost:" +this.totalCost());
		System.out.println("***************************************************");
		
	}
	public Media SearchforMediaforcart(String title) {
		
		Media foundMedia = null;
		for (int i = 0; i <itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(title) == true) {
				foundMedia = itemsOrdered.get(i);
				
			}
				
		}
		return foundMedia;
		//Use for implementation in Aims//
			
		}
	public Media getALuckyItem() {

		if (itemsOrdered.size() <5) {
			System.out.println("Not enough media to pick a lucky item.");
			return null;
		}
		else {
			int index = (int) ((Math.random() * (itemsOrdered.size()-1)));

			System.out.println( "Media - " +itemsOrdered.get(index).getTitle()+ " - "+ itemsOrdered.get(index).getCategory() +": " + itemsOrdered.get(index).getCost()+"$");
			return itemsOrdered.get(index);
		}
	}
	
}
