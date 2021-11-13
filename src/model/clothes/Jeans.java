package model.clothes;

public class Jeans extends Clothes {

	private int ID;
	private String type;
	private String length;
	private String pocketAvailable;

	public Jeans(int iD, ManufacturerClothes man, String gender, String type, String material, int iD2, String type2, String length,
			String pocketAvailable) {
		super(iD, man, gender, type, material);
		ID = iD2;
		this.type = type2;
		this.length = length;
		this.pocketAvailable = pocketAvailable;
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

	public String getLength() {
		return this.length;
	}

	/**
	 * 
	 * @param length
	 */
	public void setLength(String length) {
		this.length = length;
	}

	public String getPocketAvailable() {
		return this.pocketAvailable;
	}

	/**
	 * 
	 * @param pocketAvailable
	 */
	public void setPocketAvailable(String pocketAvailable) {
		this.pocketAvailable = pocketAvailable;
	}

}