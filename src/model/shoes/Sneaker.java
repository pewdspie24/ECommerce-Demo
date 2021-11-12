package model.shoes;

public class Sneaker extends Shoes {

	private int ID;
	private String style;
	private String type;
	private String brandName;

	public Sneaker(int iD, String gender, String weight, String launched, String material, int iD2, String style,
			String type, String brandName) {
		super(iD, gender, weight, launched, material);
		ID = iD2;
		this.style = style;
		this.type = type;
		this.brandName = brandName;
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

	public String getStyle() {
		return this.style;
	}

	/**
	 * 
	 * @param style
	 */
	public void setStyle(String style) {
		this.style = style;
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

	public String getBrandName() {
		return this.brandName;
	}

	/**
	 * 
	 * @param brandName
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

}