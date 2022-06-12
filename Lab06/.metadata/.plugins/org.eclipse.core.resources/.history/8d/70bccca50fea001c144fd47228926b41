package hust.soict.dsai.aims.media;

public class Track implements Playable, Comparable<Track>{
	private String title;
	private int length;

	public Track(String title, int length) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.length = length;
		
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: "+this.getLength());
	
		}
	public boolean equals(Object trackcompared) {
		Track track = (Track) trackcompared;
		if (track.title == this.title && track.length == this.length) {
			return true;
		}
		else {
			return false;
		}
	}
}
