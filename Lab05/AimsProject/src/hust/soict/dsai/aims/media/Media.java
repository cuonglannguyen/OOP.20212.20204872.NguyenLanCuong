package hust.soict.dsai.aims.media;
import java.time.LocalDate;
public abstract class Media {
	protected String title;
	protected String category;
	protected float cost;
	private LocalDate dateAdded = LocalDate.now();
	private static int nbMedia = 0;
	private static int num_id =0;
	protected int id = num_id;

	public Media() {
		// TODO Auto-generated constructor stub
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

}
