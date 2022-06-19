package hust.soict.dsai.aims.screen.manager;


import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

	String authors;
	String content;
	ArrayList<String> authorList = new ArrayList<String>();
	public AddBookToStoreScreen(Store store, JPanel storeScreenCenter) throws HeadlessException {
		super(store, storeScreenCenter);
		JPanel content = super.createSubPanel("Content");
		JPanel authors = super.createSubPanel("Authors(seperated by comma)");
		super.centerPanel.add(content,BorderLayout.CENTER);
		super.centerPanel.add(authors, BorderLayout.CENTER);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new btnListener());
		super.centerPanel.add(btnAdd, BorderLayout.SOUTH);
		super.setTitle("Add Book");
	}
	private class btnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for(JTextField tf: textFields) {
				if(tf.getName().equals("Title")) {
					title = tf.getText();
				}
				if(tf.getName().equals("Cost")) {
					String text_float = tf.getText();
					if (text_float != null && !text_float.isEmpty()) {
					    cost = Float.parseFloat(text_float);
					}
				}
				if(tf.getName().equals("Category")) {
					category = tf.getText();
				} 
				if(tf.getName().equals("Content")) {
					content = tf.getText();
				} 
				if(tf.getName().equals("Authors(seperated by comma)")) {
					authors = tf.getText();
					String regex = "[!._,'@? ]";
					String[] wordArray = authors.split(regex);
					authorList =
				            new ArrayList<String>(Arrays.asList(wordArray));
				}
			}
			Book book;
			try {
				book = new Book(title, category, cost,content, authorList);
				if(store.SearchforMediabytitle(title) == null) {	
					StoreScreenCenter.add(new MediaStore(book));
					StoreScreenCenter.repaint();
					StoreScreenCenter.revalidate();
				}
				else {
					JOptionPane.showMessageDialog(centerPanel, "This book is already in your store!");
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			} 
			
		}
		
	}

}
