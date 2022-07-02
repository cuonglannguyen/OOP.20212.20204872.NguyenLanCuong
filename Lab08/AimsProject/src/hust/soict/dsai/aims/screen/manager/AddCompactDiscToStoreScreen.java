package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	String director;
	String titles;
	String lengths;
	int length; 
	String artist;
	ArrayList<String> titlesList = new ArrayList<String>();
	ArrayList<String> lengthsList = new ArrayList<String>();
	ArrayList<Integer> newList = new ArrayList<Integer>();
	ArrayList<Track> trackList = new ArrayList<Track>();
	public AddCompactDiscToStoreScreen(Store store, JPanel StoreScreenCenter){
		super(store, StoreScreenCenter);
		JPanel director = super.createSubPanel("Director");
		JPanel length = super.createSubPanel("Length");
		JPanel artist = super.createSubPanel("Artist");
		JPanel title_track = super.createSubPanel("Titles of tracks( seperated by comma)");
		JPanel length_track = super.createSubPanel("Length of tracks(seperarted by comma)");
		super.centerPanel.add(director, BorderLayout.CENTER);
		super.centerPanel.add(length, BorderLayout.CENTER);
		super.centerPanel.add(artist, BorderLayout.CENTER);
		super.centerPanel.add(title_track,BorderLayout.CENTER);
		super.centerPanel.add(length_track,BorderLayout.CENTER);
		
		JButton btn = new JButton("Add");

		btn.addActionListener(new btnListener());
		super.centerPanel.add(btn);
		super.setTitle("Add CD");
	}
	
	private class btnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
				for (JTextField tf : textFields) {
					if (tf.getName().equals("Title")) {
						title = tf.getText();
					}
					else if (tf.getName().equals("Cost")) {
						String text_float = tf.getText();
						if (text_float != null && !text_float.isEmpty()) {
						    cost = Float.parseFloat(text_float);
						}
						}
					else if (tf.getName().equals("Category")) {
						category = tf.getText();
					}
						
					else if (tf.getName().equals("Director")) {
						director = tf.getText();
					}
					else if (tf.getName().equals("Length")) {
						String text_length = tf.getText();
						if (text_length != null && !text_length.isEmpty()) {
						    length = Integer.parseInt(text_length);
						}
					}
					else if (tf.getName().equals("Artist")) {
						artist = tf.getText();
					}
					else if (tf.getName().equals("Titles of tracks( seperated by comma)")) {
						titles = tf.getText();
						String regex = "[!._,'@? ]";
						String[] titlesArray = titles.split(regex);
						titlesList =
					            new ArrayList<String>(Arrays.asList(titlesArray));
					
					
				} 
					else if (tf.getName().equals("Lengths of tracks( seperated by comma)")) {
						lengths = tf.getText();
						String regex = "[!._,'@? ]";
						String[] lengthsArray = lengths.split(regex);
						lengthsList =
					            new ArrayList<String>(Arrays.asList(lengthsArray));
						 for (String myInt : lengthsList) 
				            { 
				              newList.add(Integer.valueOf(myInt)); }
					
					}
				}
				for (int i = 0; i< newList.size(); i++) {
					Track track_i = new Track(titlesList.get(i),newList.get(i));
					trackList.add(track_i);
				}
				
				try {
					CompactDisc cd = new CompactDisc(title,category,director,length,cost,artist,trackList);
					if(store.SearchforMediabytitle(title) == null) {
						StoreScreenCenter.add(new MediaStore(cd));
						StoreScreenCenter.repaint();
						StoreScreenCenter.revalidate();
					}else {
						JOptionPane.showMessageDialog(centerPanel, "The CD has been in the list already!");
					}
					}
					catch (NumberFormatException e1){
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
				
			}
			

			}
			
		
	}

