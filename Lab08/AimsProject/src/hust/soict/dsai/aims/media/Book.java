package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens;
	private Map<String, Integer> wordFrequency;
	

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
	public void processContent() {
		String regex = "[!._,'@? ]";
		String[] wordArray = this.content.split(regex);
		Arrays.sort(wordArray);
		this.contentTokens = Arrays.asList(wordArray);
		wordFrequency = new TreeMap<>();

		for (String word : contentTokens) {
		   if(!wordFrequency.containsKey(word)){
		            wordFrequency.put(word, 1);
		        } 
		   else {
		            int count = wordFrequency.get(word);
		            wordFrequency.put(word, count + 1);
		        }
		    
		}
	}	

	public Book(String title, String category, float cost,String content, ArrayList<String> authors) {
		// TODO Auto-generated constructor stub
		super(title,category,cost);
		this.content = content;
		this.authors = authors;
		num_id += 1;
		this.id = num_id;
	}
	public String toString(){
		processContent();
		String result;
		result = this.getTitle() +" "+ this.getCategory()+" " + this.getCost()+" " + this.content+" " +this.authors+"\n"+this.contentTokens.size()+" "+ "words" + this.contentTokens;
		for (Entry<String, Integer> entry : wordFrequency.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();

		    result += "\n"+ key+  " "+ value;
		    
			}
	return result;
}
	}
