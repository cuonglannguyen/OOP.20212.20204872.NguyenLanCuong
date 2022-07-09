package hust.soict.dsai.aims.screen.customer.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CartController {
	private Store store;
	private Cart cart;
	private Media media;
	public CartController(Store store,Cart cart) {
		super();
		this.store = store;
		this.cart = cart;
	}

    @FXML
    private RadioButton BtnFIlterID;

    @FXML
    private RadioButton BtnFilterTitle;
    @FXML
    private Button ViewStore;
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	try {
		JOptionPane.showMessageDialog(null,((Playable)media).play());

    	}
    	catch(PlayerException e) {
    		JOptionPane.showMessageDialog(null,e.getMessage());

    	}
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	costLabel.setText("Total " + String.valueOf(cart.totalCost()-media.getCost()));

    	cart.removeMedia(media);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
    		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
    		fxmlLoader.setController(new ViewStoreController(store,cart));
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Store");
    		stage.show();
    		
    	}
    	catch(IOException e) {
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	}

    }
    
    @FXML
    public void initialize() {
    	colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	if (cart.getItemsOrdered() != null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    	}
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(true);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>(){
    	@Override
    	public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    		updateButtonBar(newValue);
    	}
    	});
    	costLabel.setText("Total " + cart.totalCost());

    	}
    	void updateButtonBar(Media media) {
    		if(media == null) {
    			btnPlay.setVisible(false);
    			btnRemove.setVisible(false);
    			
    		}
    		else {
    			btnRemove.setVisible(true);
    			if(media instanceof Playable) {
    				btnPlay.setVisible(true);}
    				else {
    					btnPlay.setVisible(false);
    				}
    			
    		}
    	
    }

        @FXML
        void btnPlaceOrderedPressed(MouseEvent event) {
        	costLabel.setText(Float.toString(cart.totalCost()));
    		JOptionPane.showMessageDialog(null, "An order has been placed");
        }
    	
}
