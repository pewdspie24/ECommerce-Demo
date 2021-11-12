package model.shoes;

public class ShoesColor {

	private int ID;
	private String name;
	private String colorCode;

	public ShoesColor(int iD, String name, String colorCode) {
		super();
		ID = iD;
		this.name = name;
		this.colorCode = colorCode;
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

	public String getColorCode() {
		return this.colorCode;
	}

	/**
	 * 
	 * @param colorCode
	 */
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

}