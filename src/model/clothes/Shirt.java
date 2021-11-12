package model.clothes;

public class Shirt extends Clothes {

	private int ID;
	private String type;
	private String fashionList;
	private String sleeveType;

	public Shirt(int iD, String gender, String type, String material, int iD2, String type2, String fashionList,
			String sleeveType) {
		super(iD, gender, type, material);
		ID = iD2;
		type = type2;
		this.fashionList = fashionList;
		this.sleeveType = sleeveType;
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