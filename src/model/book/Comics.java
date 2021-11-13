package model.book;

public class Comics extends Book {

	private int ID;
	private String nameComics;
	private String seriesName;
	private String artist;

	
	public Comics(int iD, Publisher publisher, String iSBN, String title, int numberOfPage, String summary, int year, int iD2,
			String nameComics, String seriesName, String artist) {
		super(iD, publisher, iSBN, title, numberOfPage, summary, year);
		this.ID = iD2;
		this.nameComics = nameComics;
		this.seriesName = seriesName;
		this.artist = artist;
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

	public String getNameComics() {
		return this.nameComics;
	}

	/**
	 * 
	 * @param nameComics
	 */
	public void setNameComics(String nameComics) {
		this.nameComics = nameComics;
	}

	public String getSeriesName() {
		return this.seriesName;
	}

	/**
	 * 
	 * @param seriesName
	 */
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getArtist() {
		return this.artist;
	}

	/**
	 * 
	 * @param artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

}