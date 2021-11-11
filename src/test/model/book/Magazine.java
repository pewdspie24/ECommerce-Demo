package model.book;

public class Magazine extends Book {

	private int ID;
	private String nameBook;
	private String months;
	private String type;

	public int getID() {
		// TODO - implement Magazine.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Magazine.setID
		throw new UnsupportedOperationException();
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