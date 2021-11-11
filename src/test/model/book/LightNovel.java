package model.book;

public class LightNovel extends Book {

	private int ID;
	private String national;
	private String translateLanguage;
	private String seasons;

	public int getID() {
		// TODO - implement LightNovel.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement LightNovel.setID
		throw new UnsupportedOperationException();
	}

	public String getNational() {
		return this.national;
	}

	/**
	 * 
	 * @param national
	 */
	public void setNational(String national) {
		this.national = national;
	}

	public String getTranslateLanguage() {
		return this.translateLanguage;
	}

	/**
	 * 
	 * @param translateLanguage
	 */
	public void setTranslateLanguage(String translateLanguage) {
		this.translateLanguage = translateLanguage;
	}

	public String getSeasons() {
		return this.seasons;
	}

	/**
	 * 
	 * @param seasons
	 */
	public void setSeasons(String seasons) {
		this.seasons = seasons;
	}

}