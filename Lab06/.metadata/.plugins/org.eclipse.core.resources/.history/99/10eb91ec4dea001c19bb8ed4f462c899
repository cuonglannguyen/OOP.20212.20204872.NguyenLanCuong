package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public CompactDisc(String title, String category, String director,int length, float cost,String artist, ArrayList<Track> tracks) {
		// TODO Auto-generated constructor stub
		super(title,category,cost,length,director);
		this.artist = artist;
		this.tracks = tracks;
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
	public void play() {
		System.out.println("The artist is: "+ this.getArtist());
		for (int i = 0; i < tracks.size(); i++) {
			tracks.get(i).play();
		}
	}


}
