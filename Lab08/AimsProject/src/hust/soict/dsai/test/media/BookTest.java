package hust.soict.dsai.test.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> authors = new ArrayList<String>();
		Book book = new Book("Kangaroos in the street and a suitcase of iguanas: India�s exotic pet problem",
				"Article",(float) 4.0, "The kangaroos were the latest in a series of trafficking cases"
						+ " of exotic species into India in the last few years: in April, five exotic monkeys and "
						+ "a wallaby were rescued in Assam, shortly after five siamang gibbons"
						+ " were found in the same state; 30 exotic birds and a red-eared guenon, native to Africa and listed as vulnerable "
						+ "on the International Union for Conservation of Nature (IUCN) red list, were intercepted at the Mizoram-Assam border in January 2021; in July 2020, also in Assam, a kangaroo,"
						+ " blue macaws, capuchin monkeys and Aldabra giant tortoises were rescued; and in October 2019, the customs department at Tiruchirappalli international airport in Tamil Nadu seized a suitcase packed with exotic reptiles, including iguanas.",authors);
		book.addAuthor("Kalpana Sunder");
		System.out.println(book.toString());



	}

}
