package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.util.Collections;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0;
	public static int getMaxNumbersOrdered() {
		return MAX_NUMBERS_ORDERED;
	}
	public DigitalVideoDisc[] getItemsOrdered() {
		return itemsOrdered;
	}
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			this.itemsOrdered[qtyOrdered] = disc;
			this.qtyOrdered += 1;
			System.out.println("The disc has been added!");
					
		}
		else {
			System.out.println("The cart is already full!");
		}
		
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i+= 1) {
			if (itemsOrdered[i].getTitle() == disc.getTitle()) {
				
				for (int j = i + 1; j< qtyOrdered; j += 1) {
					itemsOrdered [j-1] = itemsOrdered[j];
					
				}
				qtyOrdered -= 1;
				itemsOrdered[qtyOrdered] = null;
				
				System.out.println("The disc has been removed! ");
			
			}
			
		}
		
	}

	public float totalCost() {
		float sum = 0;
		for (int i = 0; i< qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
					
		}
		return sum;
		
	}
/*	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		if (qtyOrdered + all_dvds.length <= MAX_NUMBERS_ORDERED) {
			for( int j = 0; j < all_dvds.length; j++) {
				
				addDigitalVideoDisc(all_dvds[j]);
				
				
				
			}
		}
			else if (qtyOrdered + all_dvds.length > MAX_NUMBERS_ORDERED && qtyOrdered < MAX_NUMBERS_ORDERED) {
				for (int j = 0; j < MAX_NUMBERS_ORDERED - all_dvds.length ; j++) {
					addDigitalVideoDisc(all_dvds[j]);
					
					
				}
				System.out.println("The first" +( MAX_NUMBERS_ORDERED- all_dvds.length )+"discs have been added");
			}
			else {
				System.out.println("The cart is already full!");
			}
	}
}
*/
	public void addDigitalVideoDisc(DigitalVideoDisc... all_dvds) {
		if (qtyOrdered + all_dvds.length <= MAX_NUMBERS_ORDERED) {
			for( int j = 0; j < all_dvds.length; j++) {
				
				addDigitalVideoDisc(all_dvds[j]);
				
				
				
			}
		}
			else if (qtyOrdered + all_dvds.length > MAX_NUMBERS_ORDERED && qtyOrdered < MAX_NUMBERS_ORDERED) {
				for (int j = 0; j < MAX_NUMBERS_ORDERED - all_dvds.length ; j++) {
					addDigitalVideoDisc(all_dvds[j]);
					
					
				}
				System.out.println("The first" +( MAX_NUMBERS_ORDERED- all_dvds.length )+"discs have been added");
			}
			else {
				System.out.println("The cart is already full!");
			}

	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
		}
		else {
			System.out.println("Too many discs added!");
		}
	}
	public DigitalVideoDisc[] CartsortByCost() {
		for (int i = 0; i < qtyOrdered; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < qtyOrdered; j++){  
                if (itemsOrdered[j].getCost()< itemsOrdered[index].getCost()){  
                    index = j;//searching for lowest index  
                }  
            }  
            DigitalVideoDisc tmp= itemsOrdered[index];   
            itemsOrdered[index] = itemsOrdered[i];  
            itemsOrdered[i] = tmp;
        }
        return itemsOrdered;
	}
	public DigitalVideoDisc[] CartsortByTitle() {
		 for (int i = 0; i < qtyOrdered ; i++)  
	        {  
	            int index = i;  
	            for (int j = i + 1; j < qtyOrdered; j++){  
	                if (itemsOrdered[j].getTitle().compareTo(itemsOrdered[index].getTitle())< 0){  
	                    index = j;//searching for lowest index  
	                }  
	            }  
	            DigitalVideoDisc tmp= itemsOrdered[index];   
	            itemsOrdered[index] = itemsOrdered[i];  
	            itemsOrdered[i] = tmp;
	        }
	        return itemsOrdered;
	}
	public void SearchforDVD(int id) {
		boolean found = false;
		for (int i = 0; i <qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				found = true;
				System.out.println("DVD- " +itemsOrdered[i].getTitle()+ " - "+ itemsOrdered[i].getCategory() + " - "+itemsOrdered[i].getDirector()+" - " + itemsOrdered[i].getLength()+": " + itemsOrdered[i].getCost()+"$");
			}
				
		}
		if (found == false) {
			System.out.println("DVD not found.");
			
		}
	}
	public void SearchforDVDbytitle(String title) {
		boolean found = false;
		for (int i = 0; i <qtyOrdered; i++) {
			if (itemsOrdered[i].getTitle().equals(title) == true) {
				found = true;
				System.out.println("DVD- " +itemsOrdered[i].getTitle()+ " - "+ itemsOrdered[i].getCategory() + " - "+itemsOrdered[i].getDirector()+" - " + itemsOrdered[i].getLength()+": " + itemsOrdered[i].getCost()+"$");
			}
				
		}
		if (found == false) {
			System.out.println("DVD not found.");
			
		}
	}
	
	 Comparator<DigitalVideoDisc> compare 
	 = Comparator.comparing(DigitalVideoDisc::getTitle)
	            .thenComparing(Comparator.comparingDouble(DigitalVideoDisc::getCost).reversed())
	            .thenComparing(Comparator.comparingInt(DigitalVideoDisc::getLength).reversed());
	 Comparator<DigitalVideoDisc> comparebyTitle 
	 = Comparator.comparing(DigitalVideoDisc::getTitle)
	            .thenComparing(Comparator.comparingDouble(DigitalVideoDisc::getCost).reversed());
	 Comparator<DigitalVideoDisc> comparebyCost 
	 = Comparator.comparingDouble(DigitalVideoDisc::getCost).reversed()
	            .thenComparing(Comparator.comparing(DigitalVideoDisc::getTitle));
	 
	 
	public void print() {
		List<DigitalVideoDisc> listDVD = new ArrayList<DigitalVideoDisc>();
		for (int i = 0; i< qtyOrdered; i++) {
			listDVD.add(itemsOrdered[i]);
		}
		listDVD.sort(compare);
		DigitalVideoDisc[] arr = listDVD.toArray(new DigitalVideoDisc[0]);
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 1; i <qtyOrdered +1; i++) {
			System.out.println( "DVD - " +arr[i-1].getTitle()+ " - "+ arr[i-1].getCategory() + " - "+arr[i-1].getDirector()+" - " + arr[i-1].getLength()+": " + arr[i-1].getCost()+"$");
		}
			System.out.println("Total cost:" +this.totalCost());
		System.out.println("***************************************************");
		
		
		
	}//Use for AIMS//
	public void sortByTitle() {
		List<DigitalVideoDisc> listDVD = new ArrayList<DigitalVideoDisc>();
		for (int i = 0; i< qtyOrdered; i++) {
			listDVD.add(itemsOrdered[i]);
		}
		listDVD.sort(comparebyTitle);
		DigitalVideoDisc[] arr = listDVD.toArray(new DigitalVideoDisc[0]);
		System.out.println("Sort by title");
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 1; i <qtyOrdered +1; i++) {
			System.out.println( "DVD - " +arr[i-1].getTitle()+ " - "+ arr[i-1].getCategory() + " - "+arr[i-1].getDirector()+" - " + arr[i-1].getLength()+": " + arr[i-1].getCost()+"$");
		}
			System.out.println("Total cost:" +this.totalCost());
		System.out.println("***************************************************");
		
		
		
		
	}
	public void sortByCost() {
		List<DigitalVideoDisc> listDVD = new ArrayList<DigitalVideoDisc>();
		for (int i = 0; i< qtyOrdered; i++) {
			listDVD.add(itemsOrdered[i]);
		}
		listDVD.sort(comparebyCost);
		DigitalVideoDisc[] arr = listDVD.toArray(new DigitalVideoDisc[0]);
		System.out.println("Sort by title");
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 1; i <qtyOrdered +1; i++) {
			System.out.println( "DVD - " +arr[i-1].getTitle()+ " - "+ arr[i-1].getCategory() + " - "+arr[i-1].getDirector()+" - " + arr[i-1].getLength()+": " + arr[i-1].getCost()+"$");
		}
			System.out.println("Total cost:" +this.totalCost());
		System.out.println("***************************************************");
		
		
		
	}
	public DigitalVideoDisc SearchforDVDforcart(String title) {
		
		DigitalVideoDisc foundDVD = null;
		for (int i = 0; i <qtyOrdered; i++) {
			if (itemsOrdered[i].getTitle().equals(title) == true) {
				foundDVD = itemsOrdered[i];
				
			}
				
		}
		return foundDVD;
		//Use for implementation in Aims//
			
		}
	
	
}
