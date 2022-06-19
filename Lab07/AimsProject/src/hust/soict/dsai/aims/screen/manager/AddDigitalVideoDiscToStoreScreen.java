package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

	String director;
	int length;
	public AddDigitalVideoDiscToStoreScreen(Store store, JPanel storeScreenCenter) throws HeadlessException {
		super(store,storeScreenCenter);
		JPanel dirP = super.createSubPanel("Director");
		JPanel lenP = super.createSubPanel("Length");
		super.getCenterPanel().add(dirP, BorderLayout.CENTER);
		super.getCenterPanel().add(lenP, BorderLayout.CENTER);
		JButton btn = new JButton("Add");
		btn.addActionListener(new btnListener());
		super.getCenterPanel().add(btn, BorderLayout.SOUTH);
		super.setTitle("add DVD");
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
					}}
				if(tf.getName().equals("Category")) {
					category = tf.getText();
				}
				if(tf.getName().equals("Director")) {
					director = tf.getText();
				}
				if(tf.getName().equals("Length")) {
					String text_length = tf.getText();
					if (text_length != null && !text_length.isEmpty()) {
					    length = Integer.parseInt(text_length);
				}	
			}
			}
			DigitalVideoDisc dvd;
			try {
				dvd = new DigitalVideoDisc(title, category, director,length, cost);
				if(store.SearchforMediabytitle(title) == null) {
					StoreScreenCenter.add(new MediaStore(dvd));
					StoreScreenCenter.repaint();
					StoreScreenCenter.revalidate();
				}else {
					JOptionPane.showMessageDialog(centerPanel, "This DVD is already in your store!");
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
	