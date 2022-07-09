package hust.soict.dsai.aims.media;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.exception.PlayerException;
public class DigitalVideoDisc extends Disc implements Playable{
	private static int nbDigitalVideoDisc = 0;


	public DigitalVideoDisc() {
		super();
		nbDigitalVideoDisc +=1;}

		public DigitalVideoDisc(String title, String category, String director, float cost) {
			super();
			this.title = title;
			this.category = category;
			this.director = director;
			this.cost = cost;
			num_id += 1;
			this.id = num_id;
			nbDigitalVideoDisc += 1;
		}
		public DigitalVideoDisc(String title, String category, float cost) {
			super();
			this.title = title;
			this.category = category;
			this.cost = cost;
			num_id += 1;
			this.id = num_id;
			nbDigitalVideoDisc += 1;


		}
		public DigitalVideoDisc(String title) {
			super();
			this.title = title;
			num_id += 1;
			this.id = num_id;

			nbDigitalVideoDisc += 1;


		}
		public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
			super();
			this.title = title;
			this.category = category;
			this.director = director;
			this.length = length;
			this.cost = cost;
			nbDigitalVideoDisc += 1;
			num_id += 1;
			this.id = num_id;

		}

	

	public String toString() {
		String result = new String();
		result = "DVD - " +this.getTitle()+ " - "+ this.getCategory() + " - "+this.getDirector()+" - " + this.getLength()+": " + this.getCost()+"$";
		return result;
	}
	public boolean isMatch(String title) {
		boolean result = false;
		String titlelowercase = title.toLowerCase();
		String[] Listoftokens = titlelowercase.trim().split("\\s+");
		for (int i =0; i< Listoftokens.length; i++) {
			if (this.getTitle().toLowerCase().contains(Listoftokens[i])) {
				result = true;
				
			}
		}
		return result;
		}
	public String play() throws PlayerException{
		if(this.getLength()>0) {
			String result = new String();
			result += "Playing DVD: " + this.getTitle();
			result +="DVD length: "+this.getLength();
			return result;
		}
		else {
			System.err.println("ERROR");
			JOptionPane.showMessageDialog(null,"ERROR: DVD length is non-positive!");

			throw new PlayerException("ERROR: DVD length is non-positive!");

		}
		
		
	}
	public String playString() {
		String result = "Playing DVD: " + this.getTitle() + "DVD length: "+this.getLength();
		return result;
	}

	

}
