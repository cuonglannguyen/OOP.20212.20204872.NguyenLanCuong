package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		Store store = new Store();
		store.addMedia(cinderellaDVD);
		store.addMedia(jungleDVD,cinderellaDVD);
		
		System.out.println(store.SearchforMediabytitle("Jungle"));

}
}
