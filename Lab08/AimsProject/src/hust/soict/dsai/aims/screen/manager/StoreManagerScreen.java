package hust.soict.dsai.aims.screen.manager;
import hust.soict.dsai.aims.media.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.store.Store;

public class StoreManagerScreen extends JFrame {
	private Store store;
	private JPanel center;
	public StoreManagerScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		this.center = createCenter();
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(center, BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024,768);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addbook = new JMenuItem("Add Book");
		JMenuItem addcd = new JMenuItem("Add CD");
		JMenuItem adddvd= new JMenuItem("Add DVD");

		smUpdateStore.add(addbook);
		smUpdateStore.add(addcd);
		smUpdateStore.add(adddvd);

		addbook.addActionListener(new btnListener());
		addcd.addActionListener(new btnListener());
		adddvd.addActionListener(new btnListener());
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("Logout"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	public static void main (String[] args) {
		Store store1 = new Store();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		store1.addMedia(new DigitalVideoDisc("Jungle"));



		store1.addMedia(new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f));
		store1.addMedia(new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f));
		store1.addMedia(new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f));
		store1.addMedia(dvd1);
		store1.addMedia(dvd2);
		store1.addMedia(dvd3);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		store1.addMedia(dvd5);
		store1.addMedia(dvd4);


		new StoreManagerScreen(store1);
	}
	private class btnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

			if(command.equals("View Store")) {
				new StoreManagerScreen(store);
				dispose();
			}
			else if(command.equals("Add DVD")) {
				new AddDigitalVideoDiscToStoreScreen(store, center);
			}
			else if(command.equals("Add Book")) {
				new AddBookToStoreScreen(store, center);
			}
			else if(command.equals("Add CD")) {
				new AddCompactDiscToStoreScreen(store,center);
			}
		}
		
		
}
	}

