package model.customer;

public class SearchHistory {

	private int ID;
	private String timeStamp;
	private String link;

	
	public SearchHistory(int iD, String timeStamp, String link) {
		super();
		ID = iD;
		this.timeStamp = timeStamp;
		this.link = link;
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

	public String getTimeStamp() {
		return this.timeStamp;
	}

	/**
	 * 
	 * @param timeStamp
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getLink() {
		return this.link;
	}

	/**
	 * 
	 * @param link
	 */
	public void setLink(String link) {
		this.link = link;
	}

}