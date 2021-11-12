package model.book;

public class LightNovel extends Book {

	private int ID;
	private String national;
	private String translateLanguage;
	private String seasons;
	
	public LightNovel(int iD, Publisher publisher, String iSBN, String title, int numberOfPage, String summary, int year, int iD2,
		String national, String translateLanguage, String seasons) {
		super(iD, publisher, iSBN, title, numberOfPage, summary, year);
		this.ID = iD2;
		this.national = national;
		this.translateLanguage = translateLanguage;
		this.seasons = seasons;
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