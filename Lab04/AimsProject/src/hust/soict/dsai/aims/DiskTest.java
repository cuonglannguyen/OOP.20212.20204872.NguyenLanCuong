package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class DiskTest {
	public static void main (String[] args) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Cinderella");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry Potter");
		System.out.println(dvd1.isMatch("jungle"));
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.SearchforDVDbytitle("Jungle");
	}

}
