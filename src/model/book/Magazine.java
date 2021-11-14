package model.book;

public class Magazine extends Book {

	private int ID;
	private String nameBook;
	private String months;
	private String type;

	public Magazine(int iD, Publisher publisher, String iSBN, String title, int numberOfPage, String summary, int year, int iD2,
			String nameBook, String months, String type) {
		super(iD, publisher, iSBN, title, numberOfPage, summary, year);
		this.ID = iD2;
		this.nameBook = nameBook;
		this.months = months;
		this.type = type;
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

	public String getNameBook() {
		return this.nameBook;
	}

	/**
	 * 
	 * @param nameBook
	 */
	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public String getMonths() {
		return this.months;
	}

	/**
	 * 
	 * @param months
	 */
	public void setMonths(String months) {
		this.months = months;
	}

	public String getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

}