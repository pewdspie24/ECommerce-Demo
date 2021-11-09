package model.book;

public class Book {
	private int ID;
	private String title;
	private String author;
	private int years;
	private String publication;
	private float price;
	
	public Book(int ID, String title, String author, int years,
			String publication, float price) {
		super();
		this.ID = ID;
		this.title = title;
		this.author = author;
		this.years = years;
		this.publication = publication;
		this.price = price;
	}
	
	public int getID() {
		return this.ID;
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		this.ID = ID;
	}

	public String getTitle() {
		return this.title;
	}

	/**
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	/**
	 * 
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYears() {
		return this.years;
	}

	/**
	 * 
	 * @param years
	 */
	public void setYears(int years) {
		this.years = years;
	}

	public String getPublication() {
		return this.publication;
	}

	/**
	 * 
	 * @param publication
	 */
	public void setPublication(String publication) {
		this.publication = publication;
	}

	public float getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

}