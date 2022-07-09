package hust.soict.dsai.aims.screen.customer.controller;
import javax.naming.LimitExceededException;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
	private Media media;
	private Cart cart;
	private Store store;
	 public ItemController(Store store, Cart cart) {
		 super();
		 this.store = store;
		 this.cart = cart;

	 }
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceededException {
    	cart.addMedia(media);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
    	try {
		JOptionPane.showMessageDialog(null,((Playable)media).play());

    	}
    	catch(PlayerException e) {
    		JOptionPane.showMessageDialog(null,e.getMessage());

    	}
    }
    
    public void setData(Media media) {
    	this.media = media;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost() + " $");
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    		
    	}
    	else {
    		btnPlay.setVisible(false);
    		HBox.setMargin(btnAddToCart, new Insets(0,0,0,60));
    	}
    }
}

