package model.book;

public class Author {

	private int ID;
	private String name;
	private String biography;
	
	public Author(int iD, String name, String biography) {
		super();
		ID = iD;
		this.name = name;
		this.biography = biography;
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

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getBiography() {
		return this.biography;
	}

	/**
	 * 
	 * @param biography
	 */
	public void setBiography(String biography) {
		this.biography = biography;
	}

}