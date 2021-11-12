package model.shoes;

public class ShoesVariant {

	private int ID;
	private String produceDate;

	public ShoesVariant(int iD, String produceDate) {
		super();
		ID = iD;
		this.produceDate = produceDate;
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

	public String getProduceDate() {
		return this.produceDate;
	}

	/**
	 * 
	 * @param produceDate
	 */
	public void setProduceDate(String produceDate) {
		this.produceDate = produceDate;
	}

}