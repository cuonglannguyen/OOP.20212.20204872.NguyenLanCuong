package hust.soict.dsai.test.screen.customer.store;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.customer.controller.CartController;
import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestCartStoreScreen extends Application{
	private Store store;
	private static Cart cart;
	@Override
	public void start(Stage primaryStage) throws Exception{
		final String CART_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Cart.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
		CartController viewStoreController = new CartController(store,cart);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Cart");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	public static void main(String[] args) throws LimitExceededException {
		cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		cart.addMedia(new DigitalVideoDisc("Jungle"));



		cart.addMedia(new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f));
		cart.addMedia(new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f));
		cart.addMedia(new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f));
		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		cart.addMedia(dvd5);
		cart.addMedia(dvd4);
		launch(args);
	}

}
