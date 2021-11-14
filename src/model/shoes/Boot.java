package model.shoes;

public class Boot extends Shoes {

	private int ID;
	private String height;
	private String type;
	private String brandName;
	private String style;
	private String fashionList;


	public Boot(int iD, ManufacturerShoes man, String gender, String weight, String launched, String material, int iD2,
			String height, String type, String brandName, String style, String fashionList) {
		super(iD, man, gender, weight, launched, material);
		ID = iD2;
		this.height = height;
		this.type = type;
		this.brandName = brandName;
		this.style = style;
		this.fashionList = fashionList;
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

	public String getHeight() {
		return this.height;
	}

	/**
	 * 
	 * @param height
	 */
	public void setHeight(String height) {
		this.height = height;
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

	public String getFashionList() {
		return this.fashionList;
	}

	/**
	 * 
	 * @param fashionList
	 */
	public void setFashionList(String fashionList) {
		this.fashionList = fashionList;
	}

}