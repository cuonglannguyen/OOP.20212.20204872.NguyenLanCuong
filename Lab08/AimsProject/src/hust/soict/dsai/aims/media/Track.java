package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

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
	public String play() throws PlayerException {
		String result = new String();

		result += "Playing DVD: " + this.getTitle();
		result += "DVD length: "+this.getLength();
		return result;
		}
	public String playString() {
		String result = "Playing DVD: " + this.getTitle()+"DVD length: "+this.getLength();
		return result;
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
	public int compareTo(Track trackcompare) {
		int i = this.title.compareTo(trackcompare.title);
		if (i != 0) {
			return i;
		}
		else {
			return Integer.compare(this.length, trackcompare.length);
		}
	}
}
