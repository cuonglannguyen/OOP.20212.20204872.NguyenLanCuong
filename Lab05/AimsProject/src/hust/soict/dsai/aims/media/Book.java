package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();

	public void addAuthor(String authorName) {
		if (authors.contains(authorName) == false) {
		authors.add(authorName);}
		else {
			System.out.println("The authorName has been in the list already!");
			
		}
	}
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName) == false) {
			System.out.println("The authorname is not found.");
		}
		else {
			authors.remove(authorName);
		}
		
	}

	

	public Book() {
		// TODO Auto-generated constructor stub
	}

}
