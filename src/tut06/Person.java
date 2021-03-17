package tut06;

import tut05.MobilePhone;
import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

public class Person {

	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1)
	private int id;
	@DomainConstraint(type = "String", mutable = true, optional = false, length = 30)
	private String name;
	@DomainConstraint(type = "MobilePhone", mutable = true, optional = true)
	private MobilePhone phone;

	public Person(@AttrRef("id") int id, @AttrRef("name") String name) throws NotPossibleException {
		this.id = id;
		this.name = name;

	}

	@DOpt(type = OptType.Observer)
	@AttrRef("id")
	public int getId() {
		return id;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("id")
	public void setId(int id) {
		this.id = id;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("name")
	public String getName() {
		return name;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("name")
	public void setName(String name) {
		this.name = name;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("phone")
	public MobilePhone getPhone() {
		return phone;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("phone")
	public void setPhone(MobilePhone phone) {
		this.phone = phone;
	}

	@DOpt(type = OptType.Helper)
	@AttrRef("id")
	private boolean validateId(int id) {
		return false;
	}

	@DOpt(type = OptType.Helper)
	@AttrRef("name")
	private boolean validateName(String name) {
		return false;
	}

	@DOpt(type = OptType.Helper)
	public boolean repOk() {
		return false;
	}

	@Override
	@DOpt(type = OptType.Default)
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	@DOpt(type = OptType.Default)
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
