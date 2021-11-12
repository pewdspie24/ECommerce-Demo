package model.clothes;

public class Clothes {

	private int ID;
	private ManufacturerClothes man;
	private String gender;
	private String type;
	private String material;

	public Clothes(int iD, ManufacturerClothes man, String gender, String type, String material) {
		super();
		this.man = man;
		this.ID = iD;
		this.gender = gender;
		this.type = type;
		this.material = material;
	}

	public ManufacturerClothes getMan() {
		return man;
	}

	public void setMan(ManufacturerClothes man) {
		this.man = man;
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