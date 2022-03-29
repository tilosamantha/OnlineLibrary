package libraryProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * Allows creation of new book instances to build our library book database
 * allBooks
 * 
 * @author Mark MacDonald and Samantha Tilo
 */
public class Book {
	private String author;
	private String title;
	private Genre genre;
	private int availability;

	/**
	 * Creates a new instance of Book
	 * 
	 * @param newAuthor       Author of Book
	 * @param newTitle        Title of Book
	 * @param genre           Genre Book belongs to
	 * @param newAvailability Available copies of Book
	 */
	public Book(String newTitle, String newAuthor, Genre genre, int newAvailability) {
		this.title = newTitle;
		this.author = newAuthor;
		this.genre = genre;
		this.availability = newAvailability;
	}

	/**
	 * @return the availability
	 */
	public int getAvailability() {
		return availability;
	}

	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(int availability) {
		this.availability = availability;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * Adds selected book to cart. Decrements selected books availability by 1.
	 * 
	 * @param myCart Books currently in cart
	 */
	public void addToCart(ArrayList<Book> myCart) {
		// decrement book availability count
		this.setAvailability(availability - 1);
		// add book to cart
		myCart.add(this);
	}
}
