package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
	JPanel centerPanel;
	JPanel StoreScreenCenter;
	Store store; 
	Cart cart;
	String title, category;
	float cost;

	ArrayList<JTextField> textFields = new ArrayList<JTextField>(); 

	public AddItemToStoreScreen(Store store, JPanel storeScreenCenter) {
		this.store = store;
		this.StoreScreenCenter = storeScreenCenter;
		this.setSize(1000, 750);
		
		this.setLayout(new BorderLayout());
		this.add(createCenter(), BorderLayout.CENTER);
		this.setVisible(true);
	}
	protected JPanel getCenterPanel() {
		return this.centerPanel;
	}
	
	protected JPanel createSubPanel(String text) {
		JPanel subContainer = new JPanel(new FlowLayout());
		JTextField tf = new JTextField(50);
		tf.setName(text);
		textFields.add(tf);
		JLabel lb = new JLabel(text);
		subContainer.add(lb);
		subContainer.add(tf);
		subContainer.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		return subContainer;
		
	}
	JPanel createCenter() {
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(8,2, 3, 3));
		
		JPanel titleP = createSubPanel("Title");
		JPanel categoryP = createSubPanel("Category");

		JPanel costP = createSubPanel("Cost");
		
		centerPanel.add(titleP);
		centerPanel.add(costP);
		centerPanel.add(categoryP);
		
		return centerPanel;
	}

}