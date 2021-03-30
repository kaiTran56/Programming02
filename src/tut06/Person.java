package tut06;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * 
 * @author tranquyet
 * 
 * @overview represents a person
 * 
 * @attributes <tt>
 * 
 *             id Integer int
 * 
 *             name String String
 * 
 *             phone MobilePhone MobilePhone<tt>
 * @object a typical of Person is <i , n , p> where id(i), name(n), phone(p)
 * 
 * @abstract <tt>
 * 
 *           mutable(id) = false /\ optional(id) = false /\ min(id) =1/\
 * 
 *           mutable(name) = false /\ optional(name) = false /\ length(name) =
 *           30/\
 * 
 *           mutable(phone) = false /\ optional(phone) = true /\<tt>
 *
 */
public class Person {

	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1)
	private int id;
	@DomainConstraint(type = "String", mutable = true, optional = false, length = 30)
	private String name;
	@DomainConstraint(type = "MobilePhone", mutable = true, optional = true)
	private MobilePhone phone;

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if id , name are valid
	 * 		initialize this as <id, name>
	 * else 
	 * 		throw NotPossibleException
	 * 
	 *          </pre>
	 * 
	 */
	@DOpt(type = OptType.Constructor)
	public Person(@AttrRef("id") int id, @AttrRef("name") String name) throws NotPossibleException {
		if (!validateId(id)) {
			throw new NotPossibleException("Person.init: Invalid person id: " + id);
		}
		if (!validateName(name)) {
			throw new NotPossibleException("Person.init: Invalid person name: " + name);
		}

		this.id = id;
		this.name = name;

	}

	/**
	 * 
	 * @effects return id
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("id")
	public int getId() {
		return id;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 
	 * if id is valid 
	 * 		set this.id = id 
	 * 		return true
	 * else 
	 * 		return false
	 * 
	 *          </pre>
	 * 
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("id")
	public boolean setId(int id) {
		if (validateId(id)) {
			this.id = id;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @effects return name
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("name")
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @effects
	 * 
	 *          <pre>
	 * 
	 * if name is valid 
	 * 		set this.name = name;
	 * 		return true
	 * else
	 * 		return false
	 * 
	 * 
	 *          </pre>
	 * 
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("name")
	public boolean setName(String name) {
		if (validateName(name)) {
			this.name = name;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @effects return phone
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("phone")
	public MobilePhone getPhone() {
		return phone;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * set this.phone = phone 
	 * return true;
	 *          </pre>
	 * 
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("phone")
	public boolean setPhone(MobilePhone phone) {
		this.phone = phone;
		return true;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 
	 *if id is valid 
	 *		return true
	 *else
	 *		return false
	 * 
	 *          </pre>
	 */
	@DOpt(type = OptType.Helper)
	@AttrRef("id")
	private boolean validateId(int id) {
		return id >= 1;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 *               if name is valid return true
	 * 
	 *               else return false
	 * 
	 *          </pre>
	 */
	@DOpt(type = OptType.Helper)
	@AttrRef("name")
	private boolean validateName(String name) {
		return name != null && name.length() <= 30;
	}

	/**
	 * 
	 * @effects
	 * 
	 *          <pre>
	 * 
	 * if this satisfies abstarct properties
	 * 		return true
	 * 
	 *	else 
	 *		return false
	 * 
	 *          </pre>
	 */
	@DOpt(type = OptType.Helper)
	public boolean repOk() {
		return validateId(id) && validateName(name);
	}

	@Override
	@DOpt(type = OptType.Default)
	public String toString() {
		// TODO Auto-generated method stub
		return "Person:<" + id + ", " + name + ", " + phone.toString() + ">";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || (obj instanceof Person)) {
			return false;
		} else {
			Person other = (Person) obj;
			return id == other.getId() && name.equals(other.getName());
		}
	}

}
