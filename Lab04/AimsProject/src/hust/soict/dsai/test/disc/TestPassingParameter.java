package hust.soict.dsai.test.disc;
import java.util.Collections;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		
		

	}
	public static void swap(DigitalVideoDisc d1, DigitalVideoDisc d2) {
		String Category = d1.getCategory();
		String tittle = d1.getTitle();
		String director = d1.getDirector();
		float cost = d1.getCost();
		int length = d1.getLength();
		
		d1.setCategory(d2.getCategory());
		d1.setCost(d2.getCost());
		d1.setDirector(d2.getDirector());
		d1.setLength(d2.getLength());
		d1.setTitle(d2.getTitle());
		
		d2.setCategory(Category);
		d2.setCost(cost);
		d2.setDirector(director);
		d2.setLength(length);
		d2.setTitle(tittle);
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
		
	}

		
	

}

	

