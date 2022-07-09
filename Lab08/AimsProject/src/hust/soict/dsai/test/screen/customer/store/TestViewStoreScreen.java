package hust.soict.dsai.test.screen.customer.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
	private static Cart cart;
	private static Store store;
	@Override
	public void start(Stage primaryStage) throws Exception{
		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store,cart);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	public static void main(String[] args) {
		store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		store.addMedia(new DigitalVideoDisc("Jungle"));



		store.addMedia(new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f));
		store.addMedia(new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f));
		store.addMedia(new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f));
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		store.addMedia(dvd5);
		store.addMedia(dvd4);
		cart = new Cart();
		DigitalVideoDisc dvd_1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd_2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd_3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);

		launch(args);
	}

}
