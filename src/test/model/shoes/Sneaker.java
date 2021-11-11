package model.shoes;

public class Sneaker extends Shoes {

	private int ID;
	private String style;
	private String type;
	private String brandName;

	public int getID() {
		// TODO - implement Sneaker.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Sneaker.setID
		throw new UnsupportedOperationException();
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