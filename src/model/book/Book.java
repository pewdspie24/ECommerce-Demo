package model.book;

public class Book {
	
	private int ID;
	private Publisher publisher;
	private String ISBN;
	private String title;
	private int numberOfPage;
	private String summary;
	private int year;

	
	
	public Book(int iD, Publisher publisher, String iSBN, String title, int numberOfPage, String summary, int year) {
		super();
		this.ID = iD;
		this.ISBN = iSBN;
		this.publisher = publisher;
		this.title = title;
		this.numberOfPage = numberOfPage;
		this.summary = summary;
		this.year = year;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getISBN() {
		return this.ISBN;
	}

	/**
	 * 
	 * @param ISBN
	 */
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
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

	public int getNumberOfPage() {
		return this.numberOfPage;
	}

	/**
	 * 
	 * @param numberOfPage
	 */
	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

	public String getSummary() {
		return this.summary;
	}

	/**
	 * 
	 * @param summary
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getYear() {
		return this.year;
	}

	/**
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

}