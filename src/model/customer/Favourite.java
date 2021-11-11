package model.customer;

public class Favourite {

	private int ID;
	private String nameItem;
	private String link;
	private String timeStamp;

	
	public Favourite(int iD, String nameItem, String link, String timeStamp) {
		super();
		ID = iD;
		this.nameItem = nameItem;
		this.link = link;
		this.timeStamp = timeStamp;
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

	public String getNameItem() {
		return this.nameItem;
	}

	/**
	 * 
	 * @param nameItem
	 */
	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
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

}