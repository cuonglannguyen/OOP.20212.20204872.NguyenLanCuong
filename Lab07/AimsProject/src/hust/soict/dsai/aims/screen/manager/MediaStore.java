package hust.soict.dsai.aims.screen.manager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel{
	private Media media;
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN,15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		JLabel cost = new JLabel(""+media.getCost()+" $ ");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonListener buttonListener = new buttonListener();
		if(media instanceof Playable) {
			 JButton playButton = new JButton("Play");
			 container.add(playButton);
			 playButton.addActionListener(buttonListener);
		 }
		 this.add(Box.createVerticalGlue());
		 this.add(title);
		 this.add(cost);
		 this.add(Box.createVerticalGlue());
		 this.add(container);
		 this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	private class buttonListener implements ActionListener {
		
		JLabel l;
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if (button.equals("Play")) {
	            // create a dialog Box
	            JDialog d = new JDialog(new JFrame(), "Playing Media");
	 
	            // create a label
	            if (media instanceof DigitalVideoDisc ) {
	            	DigitalVideoDisc dvdmedia = (DigitalVideoDisc) media;
	            l = new JLabel();
	            l.setText(dvdmedia.playString());
	            }
	            else if (media instanceof CompactDisc ) {
	            	CompactDisc  cdmedia = (CompactDisc ) media;
	            l = new JLabel();
	            l.setText(cdmedia.playString());
	            }
	            d.add(l);
	 
	            d.setSize(750, 500);
	            d.setVisible(true);
	        }
	}
		}

}

