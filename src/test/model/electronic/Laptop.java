package model.electronic;

public class Laptop extends Electronic {

	private int ID;
	private float screenWidth;
	private String resolution;
	private String disk;
	private String RAM;
	private String operationSystem;
	private Boolean touchable;

	public int getID() {
		// TODO - implement Laptop.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Laptop.setID
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param RAM
	 */
	public void setRAM(String RAM) {
		// TODO - implement Laptop.setRAM
		throw new UnsupportedOperationException();
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