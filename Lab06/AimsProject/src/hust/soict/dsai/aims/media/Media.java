package hust.soict.dsai.aims.media;
import java.time.LocalDate;
public abstract class Media {
	protected String title;
	protected String category;
	protected float cost;
	protected LocalDate dateAdded = LocalDate.now();
	private static int nbMedia = 0;
	private static int num_id =0;
	protected int id = num_id;

	public Media() {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = id;
		this.dateAdded = dateAdded;
	}
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public String getTitle() {
		return title;
	}

	

	public String getCategory() {
		return category;
	}

	

	public float getCost() {
		return cost;
	}


	public LocalDate getDateAdded() {
		return dateAdded;
	}



	public int getId() {
		return id;
	}

	public boolean equals(Object mediacompared) {
		Media media = (Media) mediacompared;
		if (this.id == media.id) {
			return true;
		}
		else {
			return false;
		}
	}
	public int compareTo(Media mediacompare) {
		
	}

}

