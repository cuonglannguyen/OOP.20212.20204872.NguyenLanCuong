
public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		DVDWrapper DVDW1 = new DVDWrapper(jungleDVD);
		DVDWrapper DVDW2 = new DVDWrapper(cinderellaDVD);
		
		swap(DVDW1, DVDW2);
		System.out.println("jungle dvd title: " + DVDW1.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		
		

	}
	public static void swap(DVDWrapper o1, DVDWrapper o2) {
		DigitalVideoDisc tmp = o1.d;
		o1.d = o2.d;
		o2.d = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
		
	}
	public static class DVDWrapper{
		DigitalVideoDisc d;
		DVDWrapper(DigitalVideoDisc d){
			this.d = d;
		
	}

}

	
}
