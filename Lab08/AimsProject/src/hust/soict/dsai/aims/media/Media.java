package hust.soict.dsai.aims.media;
import java.time.LocalDate;
import java.util.Comparator;
public abstract class Media implements Comparable<Media> {
	protected String title;
	protected String category;
	protected float cost;
	protected LocalDate dateAdded = LocalDate.now();
	private static int nbMedia = 0;
	private static int num_id =0;
	protected int id = num_id;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
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
		if (this.title == media.title) {
			return true;
		}
		else {
			return false;
		}
	}
	public int compareTo(Media mediacompare) {
		int i = this.title.compareTo(mediacompare.title);
		if (i != 0) {
			return i;
		}
		else {
			return this.category.compareTo(mediacompare.category);
		}
	}

}

