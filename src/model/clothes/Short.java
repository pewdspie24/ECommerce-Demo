package model.clothes;

public class Short extends Clothes {

	private int ID;
	private String type;
	private String length;
	private String age;
	private String fashionList;

	public Short(int iD, ManufacturerClothes man, String gender, String type, String material, int iD2, String type2, String length, String age,
			String fashionList) {
		super(iD, man, gender, type, material);
		ID = iD2;
		type = type2;
		this.length = length;
		this.age = age;
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

	public String getAge() {
		return this.age;
	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(String age) {
		this.age = age;
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