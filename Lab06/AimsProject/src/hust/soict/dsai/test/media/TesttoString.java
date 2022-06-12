package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.*;

public class TesttoString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		Track track1 = new Track("aa",5);
		ArrayList<Track> tracks = new ArrayList<Track>();
		tracks.add(track1);
		CompactDisc cd = new CompactDisc("aaa","bbb","ccc",4,(float) 4.0,"ddd",tracks);
		ArrayList<String> authors = new ArrayList<String>();
		
		Book book1 = new Book("aa","bb",(float) 4.0, "Real Madrid wins Champions League",authors);
		book1.addAuthor("Carlo Ancelotti");
		List<Media> mediae = new ArrayList<Media>();
		mediae.add(cd);
		mediae.add(dvd2);
		mediae.add(book1);
		for (Media m: mediae) {
			System.out.println(m.toString());
		}
		
		

	}

}
