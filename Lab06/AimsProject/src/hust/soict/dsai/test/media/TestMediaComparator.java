package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.*;

public class TestMediaComparator {
	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
        ArrayList<Media> ar = new ArrayList<Media>();
        ar.add(dvd2);
        ar.add(dvd1);
        ar.add(dvd3);
        Collections.sort(ar,Media.COMPARE_BY_TITLE_COST); 
        //Collections.sort(ar,Media.COMPARE_BY_COST_TITLE); //

        for (int i =0; i<ar.size();i++) {
        	System.out.println(ar.get(i));
        }
	}

}
