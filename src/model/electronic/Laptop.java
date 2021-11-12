package model.electronic;

public class Laptop extends Electronic {

	private int ID;
	private float screenWidth;
	private String resolution;
	private String disk;
	private String RAM;
	private String operationSystem;
	private Boolean touchable;
	
	public Laptop(int iD, String name, int year, String certificates, String safetyClaims, int iD2, float screenWidth,
			String resolution, String disk, String rAM, String operationSystem, Boolean touchable) {
		super(iD, name, year, certificates, safetyClaims);
		ID = iD2;
		this.screenWidth = screenWidth;
		this.resolution = resolution;
		this.disk = disk;
		RAM = rAM;
		this.operationSystem = operationSystem;
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

	public String getDisk() {
		return this.disk;
	}

	/**
	 * 
	 * @param disk
	 */
	public void setDisk(String disk) {
		this.disk = disk;
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