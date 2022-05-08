
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0;
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
				for (int j = 0; j < MAX_NUMBERS_ORDERED ; j++) {
					addDigitalVideoDisc(all_dvds[j]);
					
					
				}
				System.out.println("The first" +( MAX_NUMBERS_ORDERED- all_dvds.length )+"discs have been added");
			}
			else {
				System.out.println("The cart is already full!");
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
				for (int j = 0; j < MAX_NUMBERS_ORDERED ; j++) {
					addDigitalVideoDisc(all_dvds[j]);
					
					
				}
				System.out.println("The first" +( MAX_NUMBERS_ORDERED- all_dvds.length )+"discs have been added");
			}
			else {
				System.out.println("The cart is already full!");
			}

	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered + 2 < MAX_NUMBERS_ORDERED) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
		}
		else {
			System.out.println("Too many discs added!");
		}
	}
}

