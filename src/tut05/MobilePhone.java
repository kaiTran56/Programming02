package tut05;

public class MobilePhone {
	
	private String manufName ;
	private String model;
	/**
	 * @effects: initialize the MobilePhone Object
	 */
	public MobilePhone() {
		super();
	}
	/**
	 * @effects: initialize the MobilePhone Object with 2 parameter
	 */
	public MobilePhone(String manufName, String model) {
		super();
		this.manufName = manufName;
		this.model = model;
	}
	//change the manufacture name
	public void setManufName(String manufName) {
		this.manufName = manufName;
	}
	//change the model
	public void setModel(String model) {
		this.model = model;
	}
	//store name of person
	public String record(String name) {
		return name;
	}
	//show the name of manufacture
	public String getManufName() {
		return manufName;
	}
	//show the model
	public String getModel() {
		return model;
	}
	

}
