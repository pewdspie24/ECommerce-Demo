package model.electronic;

public class Computer extends Electronic {

	private int ID;
	private String disk;
	private String RAM;
	private String OperationSystem;
	
	public Computer(int iD, String name, int year, String certificates, String safetyClaims, int iD2, String disk,
			String rAM, String operationSystem) {
		super(iD, name, year, certificates, safetyClaims);
		ID = iD2;
		this.disk = disk;
		RAM = rAM;
		OperationSystem = operationSystem;
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
		// TODO - implement Computer.getRAM
		return this.RAM;
	}

	/**
	 * 
	 * @param RAM
	 */
	public void setRAM(String RAM) {
		// TODO - implement Computer.setRAM
		this.RAM = RAM;
	}

	public String getOperationSystem() {
		return this.OperationSystem;
	}

	/**
	 * 
	 * @param OperationSystem
	 */
	public void setOperationSystem(String OperationSystem) {
		// TODO - implement Computer.setOperationSystem
		this.OperationSystem = OperationSystem;
	}

}