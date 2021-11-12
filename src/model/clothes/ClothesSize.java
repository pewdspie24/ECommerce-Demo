package model.clothes;

public class ClothesSize {

	private int ID;
	private String sign;
	private int size;

	public ClothesSize(int iD, String sign, int size) {
		super();
		ID = iD;
		this.sign = sign;
		this.size = size;
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

	public String getSign() {
		return this.sign;
	}

	/**
	 * 
	 * @param sign
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	public int getSize() {
		return this.size;
	}

	/**
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

}