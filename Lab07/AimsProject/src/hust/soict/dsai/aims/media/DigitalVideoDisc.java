package hust.soict.dsai.aims.media;
import java.time.LocalDate;
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
			nbDigitalVideoDisc += 1;
		}
		public DigitalVideoDisc(String title, String category, float cost) {
			super();
			this.title = title;
			this.category = category;
			this.cost = cost;
			nbDigitalVideoDisc += 1;


		}
		public DigitalVideoDisc(String title) {
			super();
			this.title = title;
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
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: "+this.getLength());
	
		
		
	}
	public String playString() {
		String result = "Playing DVD: " + this.getTitle() + "DVD length: "+this.getLength();
		return result;
	}

	

}
