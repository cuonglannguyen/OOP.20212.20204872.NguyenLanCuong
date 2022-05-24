package hust.soict.dsai.aims.disc;
import java.time.LocalDate;
public class DigitalVideoDisc {
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
	public int getId() {
		return id;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private LocalDate dateAdded = LocalDate.now();
	private static int nbDigitalVideoDisc = 0;
	private static int num_id =0;
	private int id = num_id;
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
	
		return cost;
	}
	public void setTitle(String N) {
		this.title = N;
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
