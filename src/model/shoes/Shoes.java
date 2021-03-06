package model.shoes;

public class Shoes {

	private int ID;
	private ManufacturerShoes man;
	private String gender;
	private String weight;
	private String launched;
	private String material;

	public Shoes(int iD, ManufacturerShoes man, String gender, String weight, String launched, String material) {
		super();
		this.ID = iD;
		this.man = man;
		this.gender = gender;
		this.weight = weight;
		this.launched = launched;
		this.material = material;
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

	public ManufacturerShoes getMan() {
		return man;
	}

	public void setMan(ManufacturerShoes man) {
		this.man = man;
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

	public String getWeight() {
		return this.weight;
	}

	/**
	 * 
	 * @param weight
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getLaunched() {
		return this.launched;
	}

	/**
	 * 
	 * @param launched
	 */
	public void setLaunched(String launched) {
		this.launched = launched;
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