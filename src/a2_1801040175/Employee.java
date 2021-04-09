package a2_1801040175;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @author tranuyet
 * 
 * @overview Employee is a person with attributes such as id; firstName;
 *           givenName; lastName; email; address; phone; dob; gender
 * 
 * @attributes
 * 
 *             <pre>
 *          id 			Integer 		int
 *          firstName	String 			String
 * 			lastName	String 			String
 * 			email		String 			String
 * 			address		String 			String
 * 			phone 		String 			String
 * 			dob			Date 			Date
 * 			gender 		Gender			Gender
 *             </pre>
 * 
 * @object A typical Employee is <i, f, g, l, e, a, p, d,g> where id(i),
 *         firstName(f), givenName(g), lastName(l), email(e), address(a),
 *         phone(p), dob(d), gender(g)
 * 
 * @abstract_properties
 * 
 *                      <pre>
 * mutable(id) = false /\ optional(id)= false /\ min(id) = 100
 * 
 * mutable(firstName) = true /\ optional(firstName) =false /\ length(firstName) = 35
 * 
 * mutable(givenName) = true /\ optional(givenName) = false /\ length(givenName) = 35
 * 
 * mutable(lastName) = true /\ optional(lastName) = false /\ length(lastName) = 35
 * 
 * mutable(email) = true /\ optional(email) = true /\ length(email) = 200
 * 
 * mutable(address) = true /\ optional(address) = false /\ length(address) = 1500
 * 
 * mutable(phone) = true /\ optional(phone) = false /\ length(phone) = 20
 * 
 * mutable(dob) = false /\ optional(dob) = false /\ min(dob) = 1/1/1900
 * 
 * mutable(gender) = false /\ optional(gender) = false
 * 
 * 
 *                      </pre>
 */
public class Employee {

	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = 100)
	private int id;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 35)
	private String firstName;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 35)
	private String givenName;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 35)
	private String lastName;

	@DomainConstraint(type = "String", mutable = true, optional = true, length = 200)
	private String email;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 1500)
	private String address;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 20)
	private String phone;

	@DomainConstraint(type = "Date", mutable = false, optional = false, min = 1 / 1 / 1900)
	private Date dob;

	@DomainConstraint(type = "Gender", mutable = false, optional = false)
	private Gender gender;

	// constant for the min value of id
	private final int MIN_ID = 100;

	// constant for the max length of first name
	private final int MAX_LENGTH_FIRSTNAME = 35;

	// constant for the max length of given name
	private final int MAX_LENGTH_GIVENNAME = 35;

	// constant for the max length of last name
	private final int MAX_LENGTH_LASTNAME = 35;

	// constant for the max length of email
	private final int MAX_LENGTH_EMAIL = 200;

	// constant for the max length of address
	private final int MAX_LENGTH_ADDRESS = 1500;

	// constant for the max length of phone
	private final int MAX_LENGTH_PHONE = 20;

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if id, firstName, givenName, lastName, address, phone, dob, gender are valid 
	 * 		initialise this as <id, firstName, givenName, lastName, address, phone, dob, gender>
	 * else
	 * 		throws NotPossibleException
	 *          </pre>
	 * 
	 */
	@DOpt(type = OptType.Constructor)
	public Employee(@AttrRef("id") int id, @AttrRef("firstName") String firstName,
			@AttrRef("givenName") String givenName, @AttrRef("lastName") String lastName,
			@AttrRef("address") String address, @AttrRef("phone") String phone, @AttrRef("dob") Date dob,
			@AttrRef("gender") Gender gender) throws NotPossibleException {

		if (!validateId(id)) {
			throw new NotPossibleException("Employee.init: Invalid employee id: " + id);
		}
		if (!validateFirstName(firstName)) {
			throw new NotPossibleException("Employee.init: Invalid employee firstName: " + firstName);
		}
		if (!validateGivenName(givenName)) {
			throw new NotPossibleException("Employee.init: Invalid employee givenName: " + givenName);
		}
		if (!validateLastName(lastName)) {
			throw new NotPossibleException("Employee.init: Invalid employee lastName: " + lastName);
		}

		if (!validateAddress(address)) {
			throw new NotPossibleException("Employee.init: Invalid employee address: " + address);
		}
		if (!validatePhone(phone)) {
			throw new NotPossibleException("Employee.init: Invalid employee phone: " + phone);
		}
		if (!validateDob(dob)) {
			throw new NotPossibleException("Employee.init: Invalid employee dob: " + dob);
		}
		if (!validateGender(gender)) {
			throw new NotPossibleException("Employee.init: Invalid employee gender: " + gender);
		}

		this.id = id;
		this.firstName = firstName;
		this.givenName = givenName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
	}

	/**
	 * 
	 * @effects return full name of employee
	 */
	@DOpt(type = OptType.Observer)
	public String getName() {
		return String.format("%s %s %s", lastName, givenName, firstName);
	}

	/**
	 * 
	 * @effects return year of dob
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("dob")
	public int getYob() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dob);
		return calendar.get(Calendar.YEAR);
	}

	// ------------Observer-----------------

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
	 * 
	 * @effects return firstName
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("firstName")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @effects return givenName
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("givenName")
	public String getGivenName() {
		return givenName;
	}

	/**
	 * 
	 * @effects return lastName
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("lastName")
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @effects return email
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("email")
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @effects return address
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("address")
	public String getAddress() {
		return address;
	}

	/**
	 * 
	 * @effects return phone
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("phone")
	public String getPhone() {
		return phone;
	}

	/**
	 * 
	 * @effects return dob
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("dob")
	public Date getDob() {
		return dob;
	}

	/**
	 * 
	 * @effects return gender
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("gender")
	public Gender getGender() {
		return gender;
	}

	// ----------------Mutator----------------
	/**
	 * @effects
	 * 
	 *          <pre>
	 *  if id is valid 
	 *  	set this.id = id
	 *  	return true
	 *  else
	 *  	return false
	 *          </pre>
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
	 * @effects
	 * 
	 *          <pre>
	 *  if firstName is valid 
	 *  	set this.firstName = firstName
	 *  	return true
	 *  else
	 *  	return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("firstName")
	public boolean setFirstName(String firstName) {
		if (validateFirstName(firstName)) {
			this.firstName = firstName;
			return true;
		}
		return false;

	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 *  if givenName is valid 
	 *  	set this.givenName = givenName
	 *  	return true
	 *  else
	 *  	return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("givenName")
	public boolean setGivenName(String givenName) {
		if (validateGivenName(givenName)) {
			this.givenName = givenName;
			return true;
		}
		return false;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 *  if lastName is valid 
	 *  	set this.lastName = lastName
	 *  	return true
	 *  else
	 *  	return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("lastName")
	public boolean setLastName(String lastName) {
		if (validateLastName(lastName)) {
			this.lastName = lastName;
			return true;
		}
		return false;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 *  if email is valid 
	 *  	set this.email = email
	 *  	return true
	 *  else
	 *  	return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("email")
	public boolean setEmail(String email) {
		if (validateEmail(email)) {
			this.email = email;
			return true;
		}
		return false;

	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 *  if address is valid 
	 *  	set this.address = address
	 *  	return true
	 *  else
	 *  	return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("address")
	public boolean setAddress(String address) {
		if (validateAddress(address)) {
			this.address = address;
			return true;
		}
		return false;

	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 *  if phone is valid 
	 *  	set this.phone = phone
	 *  	return true
	 *  else
	 *  	return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("phone")
	public boolean setPhone(String phone) {
		if (validatePhone(phone)) {
			this.phone = phone;
			return true;
		}
		return false;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 *  if dob is valid 
	 *  	set this.dob = dob
	 *  	return true
	 *  else
	 *  	return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("dob")
	public boolean setDob(Date dob) {
		if (validateDob(dob)) {
			this.dob = dob;
			return true;
		}
		return false;

	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 *  if gender is valid 
	 *  	set this.gender = gender
	 *  	return true
	 *  else
	 *  	return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("gender")
	public boolean setGender(Gender gender) {
		if (validateGender(gender)) {
			this.gender = gender;
			return true;
		}
		return false;
	}

	// -----------------Helper-----------------
	/**
	 * @effects
	 * 
	 *          <pre>
	 * if id is valid 
	 * 		return true
	 * else
	 * 		return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Helper)
	@AttrRef("id")
	private boolean validateId(int id) {
		return id >= MIN_ID;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if firstName is valid 
	 * 		return true
	 * else
	 * 		return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Helper)
	@AttrRef("firstName")
	private boolean validateFirstName(String firstName) {
		if (firstName == null || firstName.length() > MAX_LENGTH_FIRSTNAME) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if givenName is valid 
	 * 		return true
	 * else
	 * 		return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Helper)
	@AttrRef("givenName")
	private boolean validateGivenName(String givenName) {
		if (givenName == null || givenName.length() > MAX_LENGTH_GIVENNAME) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if lastName is valid 
	 * 		return true
	 * else
	 * 		return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Helper)
	@AttrRef("lastName")
	private boolean validateLastName(String lastName) {
		if (lastName == null || lastName.length() > MAX_LENGTH_LASTNAME) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if email is valid 
	 * 		return true
	 * else
	 * 		return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Helper)
	@AttrRef("email")
	private boolean validateEmail(String email) {
		String EMAIL_PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
		return (email != null && email.length() <= MAX_LENGTH_EMAIL && Pattern.matches(EMAIL_PATTERN, email));

	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if address is valid 
	 * 		return true
	 * else
	 * 		return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Helper)
	@AttrRef("address")
	private boolean validateAddress(String address) {
		if (address == null || address.length() > MAX_LENGTH_ADDRESS) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if phone is valid 
	 * 		return true
	 * else
	 * 		return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Helper)
	@AttrRef("phone")
	private boolean validatePhone(String phone) {
		if (phone == null || !phone.startsWith("(84) ") || phone.length() > MAX_LENGTH_PHONE) {
			return false;
		}
		String phoneTemp = phone.substring(5, phone.length());
		if (phoneTemp.length() < 8 || phoneTemp.length() > 15) {
			return false;
		}
		if (Pattern.matches("\\d+", phoneTemp)) {
			return true;
		}

		return false;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if dob is valid 
	 * 		return true
	 * else
	 * 		return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Helper)
	@AttrRef("dob")
	public boolean validateDob(Date dob) {
		Date dobMin = new Date(0, 0, 1);
		return dob.after(dobMin);
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if gender is valid 
	 * 		return true
	 * else
	 * 		return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Helper)
	@AttrRef("gender")
	private boolean validateGender(Gender gender) {
		return gender != null;
	}

	/**
	 * 
	 * @effects
	 * 
	 *          <pre>
	 * if this is valid 
	 * 		return true
	 * else
	 * 		return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Helper)
	public boolean repOK() {
		return (validateId(id) && validateFirstName(firstName) && validateGivenName(givenName)
				&& validateLastName(lastName) && validateAddress(address) && validatePhone(phone) && validateDob(dob)
				&& validateGender(gender));
	}

	// ----Default------

	@Override
	@DOpt(type = OptType.Default)
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Employee)) {
			return false;
		} else {
			Employee other = (Employee) o;
			return id == other.getId() && firstName.equals(other.getFirstName())
					&& givenName.equals(other.getGivenName()) && lastName.equals(other.getLastName())
					&& address.equals(other.getAddress()) && phone.equals(other.getPhone())
					&& dob.equals(other.getDob()) && gender.equals(other.getGender());
		}

	}

	@Override
	@DOpt(type = OptType.Default)
	public String toString() {
		return "Employee:<" + id + "," + firstName + "," + givenName + "," + lastName + "," + email + "," + address
				+ "," + phone + "," + dob + "," + gender + ">";
	}

}
