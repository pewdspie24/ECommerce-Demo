package model.electronic;

public class MobilePhone extends Electronic {

	private int ID;
	private String storage;
	private String RAM;
	private String operationSystem;
	private float screenWidth;
	private String resolution;
	private Boolean touchable;

	public int getID() {
		// TODO - implement MobilePhone.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement MobilePhone.setID
		throw new UnsupportedOperationException();
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
		// TODO - implement MobilePhone.getRAM
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param RAM
	 */
	public void setRAM(String RAM) {
		// TODO - implement MobilePhone.setRAM
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