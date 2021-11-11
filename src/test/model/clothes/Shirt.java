package model.clothes;

public class Shirt extends Clothes {

	private int ID;
	private String type;
	private String fashionList;
	private String sleeveType;

	public int getID() {
		// TODO - implement Shirt.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Shirt.setID
		throw new UnsupportedOperationException();
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

	public String getSleeveType() {
		return this.sleeveType;
	}

	/**
	 * 
	 * @param sleeveType
	 */
	public void setSleeveType(String sleeveType) {
		this.sleeveType = sleeveType;
	}

}