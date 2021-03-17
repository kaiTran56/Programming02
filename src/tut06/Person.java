package tut06;

import tut05.MobilePhone;
import utils.DomainConstraint;

public class Person {

	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1)
	private int id;
	@DomainConstraint(type = "String", mutable = true, optional = false, length = 30)
	private String name;
	@DomainConstraint(type = "MobilePhone", mutable = true, optional = true)
	private MobilePhone phone;

	public Person(int id, String name, MobilePhone phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MobilePhone getPhone() {
		return phone;
	}

	public void setPhone(MobilePhone phone) {
		this.phone = phone;
	}

}
