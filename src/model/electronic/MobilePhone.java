package model.electronic;

public class MobilePhone extends Electronic {

	private int ID;
	private String storage;
	private String RAM;
	private String operationSystem;
	private float screenWidth;
	private String resolution;
	private Boolean touchable;

	public MobilePhone(int iD, ManufacturerElectronics man, String name, int year, String certificates, String safetyClaims, int iD2, String storage,
			String rAM, String operationSystem, float screenWidth, String resolution, Boolean touchable) {
		super(iD, man, name, year, certificates, safetyClaims);
		ID = iD2;
		this.storage = storage;
		RAM = rAM;
		this.operationSystem = operationSystem;
		this.screenWidth = screenWidth;
		this.resolution = resolution;
		this.touchable = touchable;
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

	public String getStorage() {
		return this.storage;
	}

	/**
	 * 
	 * @param storage
	 */
	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getRAM() {
		// TODO - implement Laptop.getRAM
		return this.RAM;
	}

	/**
	 * 
	 * @param RAM
	 */
	public void setRAM(String RAM) {
		// TODO - implement Laptop.setRAM
		this.RAM = RAM;
	}

	public String getOperationSystem() {
		return this.operationSystem;
	}

	/**
	 * 
	 * @param operationSystem
	 */
	public void setOperationSystem(String operationSystem) {
		this.operationSystem = operationSystem;
	}

	public float getScreenWidth() {
		return this.screenWidth;
	}

	/**
	 * 
	 * @param screenWidth
	 */
	public void setScreenWidth(float screenWidth) {
		this.screenWidth = screenWidth;
	}

	public String getResolution() {
		return this.resolution;
	}

	/**
	 * 
	 * @param resolution
	 */
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Boolean getTouchable() {
		return this.touchable;
	}

	/**
	 * 
	 * @param touchable
	 */
	public void setTouchable(Boolean touchable) {
		this.touchable = touchable;
	}

}