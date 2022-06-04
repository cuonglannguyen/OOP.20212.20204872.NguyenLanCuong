package hust.soict.dsai.aims.media;
import java.time.LocalDate;
public class DigitalVideoDisc extends Media{
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDisc += 1;
		num_id += 1;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDisc += 1;
		num_id += 1;


	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDisc += 1;
		num_id += 1;


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


	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	private String director;
	private int length;
	private LocalDate dateAdded = LocalDate.now();
	private static int nbDigitalVideoDisc = 0;
	private static int num_id =0;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
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
	

}
