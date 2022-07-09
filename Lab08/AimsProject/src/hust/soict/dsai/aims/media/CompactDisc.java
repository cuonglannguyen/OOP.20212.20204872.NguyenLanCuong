package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public CompactDisc(String title, String category, String director,int length, float cost,String artist, ArrayList<Track> tracks) {
		// TODO Auto-generated constructor stub
		super(title,category,cost,length,director);
		this.artist = artist;
		this.tracks = tracks;
		num_id += 1;
		this.id = num_id;
	}

	public String getArtist() {
		return artist;
	}
	public void addTrack(Track t) {
		if (tracks.contains(t) == false) {
			tracks.add(t);
		}
		else {
			System.out.println("The track has been in the list already!");
			
		}
		
	}
	public void removeTrack(Track t) {
		if (tracks.contains(t) == false) {
			System.out.println("The track is not found");
		}
		else {
			tracks.remove(t);
		}
	}


	public int getLength() {
		int totalLength = 0;
		for (int i = 0; i <tracks.size(); i++) {
			totalLength += tracks.get(i).getLength();
		}
		return totalLength;
	}
	public String play() throws PlayerException  {
		if(this.getLength()>0) {
			String result = new String();

		result += "The artist is: "+ this.getArtist();
		for (int i = 0; i < tracks.size(); i++) {
			result += tracks.get(i).play();
		}
		
		java.util.Iterator iter = tracks.iterator();
		Track nextTrack;
		while(iter.hasNext()) {
			nextTrack = (Track) iter.next();
			try {
				nextTrack.play();
			}catch(PlayerException e){
				throw e;
				
			}
		}
		return result;
	}
	else {
		JOptionPane.showMessageDialog(null,"ERROR: CD length is non-positive!");

		throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}
	public String toString() {
		String result;
		result = this.getTitle()+" " + this.getCategory()+" "+ this.getArtist()+" " + this.getDirector() +" "+ this.getLength()+" "+this.getCost();
		for (int i = 0; i <tracks.size();i++) {
			result += "\n";
			result += tracks.get(i).getTitle()+" ";
			result += tracks.get(i).getLength();
		}
		return result;
	}
	public String playString() {
		return this.toString();
	}


}
