package model.book;

public class Book {

	private String ISBN;
	private String title;
	private int numberOfPage;
	private String summary;
	private int year;

	public String getISBN() {
		// TODO - implement Book.getISBN
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ISBN
	 */
	public void setISBN(String ISBN) {
		// TODO - implement Book.setISBN
		throw new UnsupportedOperationException();
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