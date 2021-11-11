package model.clothes;

public class Clothes {

	private int ID;
	private String gender;
	private String type;
	private String material;

	public int getID() {
		// TODO - implement Clothes.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Clothes.setID
		throw new UnsupportedOperationException();
	}

	public String getGender() {
		return this.gender;
	}

	/**
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
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

	public String getMaterial() {
		return this.material;
	}

	/**
	 * 
	 * @param material
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

}