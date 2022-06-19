package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		cart.addMedia(dvd3);
		//cart.print()//
		
		Media[] sorted = cart.CartsortByCost();
		System.out.println("sort by cost: ");
		System.out.println(sorted[0].getTitle());
		for (int i = 0; i< cart.size; i++) {
			System.out.println(sorted[i].toString());
		}
		Media[] sorted_title = cart.CartsortByTitle();
		System.out.println("sort by Title: ");
		System.out.println(sorted_title[0].getTitle());
		for (int i = 0; i< cart.size; i++) {
			System.out.println(sorted_title[i].toString());
		}
		cart.SearchforMedia(2);
		cart.print();
		
	}

}
