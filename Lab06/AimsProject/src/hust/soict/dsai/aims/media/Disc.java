package hust.soict.dsai.aims.media;

public class Disc extends Media {
	protected int length;
	protected String director;
	

	public int getLength() {
		return length;
	}


	public String getDirector() {
		return director;
	}


	public Disc(String title,String category,float cost,int length, String director) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.length = length;
		this.director = director;
				
		
	}
	public Disc() {
		super();}

		public Disc(String title, String category, String director, float cost) {
			this.title = title;
			this.category = category;
			this.director = director;
			this.cost = cost;
		}
		public Disc(String title, String category, float cost) {
			this.title = title;
			this.category = category;
			this.cost = cost;


		}
		public Disc(String title) {
			this.title = title;


		}
		public Disc(String title, String category, String director, int length, float cost) {
			
			this.title = title;
			this.category = category;
			this.director = director;
			this.length = length;
			this.cost = cost;
		}

}
