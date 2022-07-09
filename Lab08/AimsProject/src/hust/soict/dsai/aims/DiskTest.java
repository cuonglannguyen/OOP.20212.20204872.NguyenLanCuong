package hust.soict.dsai.aims;
import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
public class DiskTest {
	public static void main (String[] args) throws LimitExceededException {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Cinderella");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry Potter");
		System.out.println(dvd1.isMatch("jungle"));
		anOrder.addMedia(dvd1);
		anOrder.addMedia(dvd2);
		anOrder.addMedia(dvd3);
		anOrder.SearchforMediabytitle("Jungle");
	}

}
