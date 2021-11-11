package model.book;

public class Comics extends Book {

	private int ID;
	private String nameComics;
	private String seriesName;
	private String artist;

	public int getID() {
		// TODO - implement Comics.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Comics.setID
		throw new UnsupportedOperationException();
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