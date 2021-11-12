package model.electronic;

public class Electronic {

	private int ID;
	private String name;
	private int year;
	private String certificates;
	private String safetyClaims;
	private ManufacturerElectronics man;
	
	public Electronic(int iD, ManufacturerElectronics man, String name, int year, String certificates, String safetyClaims) {
		super();
		this.ID = iD;
		this.man = man;
		this.name = name;
		this.year = year;
		this.certificates = certificates;
		this.safetyClaims = safetyClaims;
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

	public ManufacturerElectronics getMan() {
		return man;
	}

	public void setMan(ManufacturerElectronics man) {
		this.man = man;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return this.year;
	}

	/**
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	public String getCertificates() {
		return this.certificates;
	}

	/**
	 * 
	 * @param certificates
	 */
	public void setCertificates(String certificates) {
		this.certificates = certificates;
	}

	public String getSafetyClaims() {
		return this.safetyClaims;
	}

	/**
	 * 
	 * @param safetyClaims
	 */
	public void setSafetyClaims(String safetyClaims) {
		this.safetyClaims = safetyClaims;
	}

}