package tut06;

import utils.DomainConstraint;

public class MobilePhone {

	@DomainConstraint(type = "Integer", mutable = false, optional = false, length = 30)
	private String manName;
	@DomainConstraint(type = "String", mutable = false, optional = false, length = 15)
	private String model;
	private char color;
	private int year;
	private boolean guaranteed;

	public String getManName() {
		return manName;
	}

	public void setManName(String manName) {
		this.manName = manName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isGuaranteed() {
		return guaranteed;
	}

	public void setGuaranteed(boolean guaranteed) {
		this.guaranteed = guaranteed;
	}

}
