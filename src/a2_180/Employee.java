package a2_180;

import java.util.Date;
import java.util.Objects;
import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview Employees are those who work in an organization
 * 
 * @attributes
 * 
 *             <pre>
 * 		id 			Integer 
 * 		firstName 	String
 * 		givenName 	String 
 * 		lastName 	String
 * 		email 		String 
 * 		address 	String 
 * 		phone 		String 
 * 		dob 		Date 
 * 		gender 		Gender
 *             </pre>
 * 
 * @object
 * 
 *         <pre>
 * 		A typical Employee is e=<i,f,g,l,a,p,d,r>, 
 * 		where id(d)	, 	firstName(f)	,givenName(g),
 * 		lastName(l)	,	address(a)		,phone(p)	 , 
 * 		dob(d)		,	gender(r).
 *         </pre>
 * 
 * @abstract_properties
 * 
 *                      <pre>
 * 	mutable(id)=false 			/\ optional(id)=false 			/\ min(id)=100 				/\
 * 	mutable(firstName)=true 	/\ optional(firstName)=false 	/\ length(firstName) = 35	/\
 * 	mutable(givenName)=true 	/\ optional(givenName)=false 	/\ length(givenName) = 35	/\
 * 	mutable(lastName)=true 		/\ optional(lastName)=false 	/\ length(lastName) = 35	/\
 * 	mutable(email)=true 		/\ optional(email)=true	 		/\ length(email) = 200		/\
 * 	mutable(address)=true 		/\ optional(address)=false 		/\ length(address) = 1500	/\
 * 	mutable(phone)=true 		/\ optional(phone)=false 		/\ length(phone) = 20		/\
 * 	mutable(dob)=false 			/\ optional(dob)=false 			/\ min(dob) = 1/1/1900		/\	
 * 	mutable(gender)=false 		/\ optional(gender)=false
 *                      </pre>
 * 
 * @author nguyendz
 */
public class Employee {

	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = 100)
	private int id;

	@DomainConstraint(type = "String", optional = false, length = 35)
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

	/**
	 * 
	 *@effects <pre>
	 *if id, firstName, givenName, lastName, 
	 *		address, phone, dob, gender are valid
	 *initialize this as <id, firstName, givenName, lastName, 
	 *		address, phone, dob, gender>
	 *else
	 *throws NotPossibleException
	 */
	@DOpt(type = OptType.Constructor)
	public Employee(@AttrRef("id") 	int id,
			@AttrRef("firstName") 	String firstName,
			@AttrRef("givenName") 	String givenName,
			@AttrRef("lastName") 	String lastName,
			@AttrRef("address") 	String address,
			@AttrRef("phone") 		String phone,
			@AttrRef("dob") 		Date dob,
			@AttrRef("gender") 		 Gender gender
			) throws NotPossibleException {
		if (!validateId(id)) 			throw new NotPossibleException("Employee.init: Invalid employee id:"		+id); 
		if (!validateFirstName(firstName)) 	throw new NotPossibleException("Employee.init: Invalid employee first name:"+firstName); 
		if (!validateGivenName(givenName)) 	throw new NotPossibleException("Employee.init: Invalid employee given name:"+givenName);
		if (!validateLastName(lastName)) 	throw new NotPossibleException("Employee.init: Invalid employee last name:"	+lastName); 
		if (!validateAddress(address)) 	throw new NotPossibleException("Employee.init: Invalid employee address:"	+address); 
		if (!validatePhone(phone)) 		throw new NotPossibleException("Employee.init: Invalid employee phone:"		+phone); 
		if (!validateDob(dob)) 		throw new NotPossibleException("Employee.init: Invalid employee dob:"		+dob); 
		if (!validateGender(gender)) 		throw new NotPossibleException("Employee.init: Invalid employee gender:"	+gender); 
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
	 *@effects <pre>
	 *if id, firstName, givenName, lastName, email 
	 *		address, phone, dob, gender are valid
	 *initialize this as <id, firstName, givenName, lastName, email
	 *		address, phone, dob, gender>
	 *else
	 *throws NotPossibleException
	 */
	@DOpt(type = OptType.Constructor)
	public Employee(@AttrRef("id") int id,
			@AttrRef("firstName") 	String firstName,
			@AttrRef("givenName") 	String givenName,
			@AttrRef("lastName") 	String lastName,
			@AttrRef("email") 		String email,
			@AttrRef("address") 	String address,
			@AttrRef("phone") 		String phone,
			@AttrRef("dob") 		Date dob,
			@AttrRef("gender") 		Gender gender
			) throws NotPossibleException {
		this(id, firstName, givenName, lastName, address, phone, dob, gender);
		if (!validateEmail())throw new NotPossibleException("Employee.init: Invalid employee email:"	+email); 
		this.email = email;
	}
	
	

	
	//____________________________ Observer_____________________

	/**
	* @effects return fullName = lastName + givenName
	*/
	@DOpt(type = OptType.Observer)
	@AttrRef("lastName")
	public String getName() {
		return String.format("%s %s", lastName, givenName);
	}

	/**
	* @effects return yob = dob.getYear()
	*/
	@DOpt(type = OptType.Observer)
	@AttrRef("dob")
	public int getYob() {
		return dob.getYear();
	}

	/**
	* @effects return <tt>id</tt>
	*/
	@DOpt(type = OptType.Observer)
	@AttrRef("id")
	public int getId() {
		return id;
	}

	/**
	* @effects return <tt>firstName</tt>
	*/
	@DOpt(type = OptType.Observer)
	@AttrRef("firstName")
	public String getFirstName() {
		return firstName;
	}

	/**
	* @effects return <tt>givenName</tt>
	*/
	@DOpt(type = OptType.Observer)
	@AttrRef("givenName")
	public String getGivenName() {
		return givenName;
	}

	/**
	* @effects return <tt>lastName</tt>
	*/
	@DOpt(type = OptType.Observer)
	@AttrRef("lastName")
	public String getLastName() {
		return lastName;
	}

	/**
	* @effects return <tt>email</tt>
	*/
	@DOpt(type = OptType.Observer)
	@AttrRef("email")
	public String getEmail() {
		return email;
	}

	/**
	* @effects return <tt>email</tt>
	*/
	@DOpt(type = OptType.Observer)
	@AttrRef("address")
	public String getAddress() {
		return address;
	}

	/**
	* @effects return <tt>phone</tt>
	*/
	@DOpt(type = OptType.Observer)
	@AttrRef("phone")
	public String getPhone() {
		return phone;
	}

	/**
	* @effects return <tt>dob</tt>
	*/
	@DOpt(type = OptType.Observer)
	@AttrRef("dob")
	public Date getDob() {
		return dob;
	}

	/**
	* @effects return <tt>gender</tt>
	*/
	@DOpt(type = OptType.Observer)
	@AttrRef("gender")
	public Gender getGender() {
		return gender;
	}
	//____________________________ Mutator_____________________

	
	
	/**
	 * @effects <pre>
	 * if id is valid
	 * set this.id=id
	 * return true
	 * else
	 * return false</pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("id")
	public boolean setId(int id) {
		if (!validateId(id)) 	return false;
		this.id = id;		return true;
	}

	/**
	 * @effects <pre>
	 * if firstName is valid
	 * set this.firstName=firstName
	 * return true
	 * else
	 * return false</pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("firstName")
	public boolean setFirstName(String firstName) {
		if (!validateFirstName(firstName)) 	return false;
		this.firstName = firstName;	return true;
	}

	/**
	 * @effects <pre>
	 * if givenName is valid
	 * set this.givenName=givenName
	 * return true
	 * else
	 * return false</pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("givenName")
	public boolean setGivenName(String givenName) {
		if (!validateGivenName(givenName)) 	return false;
		this.givenName = givenName;	return true;
	}

	/**
	 * @effects <pre>
	 * if lastName is valid
	 * set this.lastName=lastName
	 * return true
	 * else
	 * return false</pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("lastName")
	public boolean setLastName(String lastName) {
		if (!validateLastName(lastName)) 	return false;
		this.lastName = lastName;	return true;
	}

	/**
	 * @effects <pre>
	 * if email is valid
	 * set this.email=email
	 * return true
	 * else
	 * return false</pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("email")
	public boolean setEmail(String email) {
		if (!validateEmail()) 	return false;
		this.email = email;		return true;
	}

	/**
	 * @effects <pre>
	 * if address is valid
	 * set this.address=address
	 * return true
	 * else
	 * return false</pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("address")
	public boolean setAddress(String address) {
		if (!validateAddress(address)) 	return false;
		this.address = address;		return true;
	}

	/**
	 * @effects <pre>
	 * if phone is valid
	 * set this.phone=phone
	 * return true
	 * else
	 * return false</pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("phone")
	public boolean setPhone(String phone) {
		if (!validatePhone(phone)) 	return false;
		this.phone = phone;		return true;
	}

	/**
	 * @effects <pre>
	 * if dob is valid
	 * set this.dob=dob
	 * return true
	 * else
	 * return false</pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("dob")
	public boolean setDob(Date dob) {
		if (!validateDob(dob)) return false;
		this.dob = dob;		return true;
	}

	/**
	 * @effects <pre>
	 * if gender is valid
	 * set this.gender=gender
	 * return true
	 * else
	 * return false</pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("gender")
	public boolean setGender(Gender gender) {
		if (!validateGender(gender)) 	return false;
		this.gender = gender;	return true;
	}
	
	//____________________________ Helper_____________________
	/**
	* @effects <pre>
	* if id is valid
	* return true
	* else
	* return false
	* </pre>
	*/
	@DOpt(type = OptType.Helper)
	@AttrRef("id")
	public boolean validateId(int id) {
		return id >= 100;
	}

	/**
	 * @effects <pre>
	* if firstName is valid
	* return true
	* else
	* return false
	* </pre>
	*/
	@DOpt(type = OptType.Helper)
	@AttrRef("firstName")
	public boolean validateFirstName(String firstName) {
		return firstName != null && 
				firstName.length() >0 && 
				firstName.length() <= 35;
	}

	/**
	* @effects <pre>
	* if givenName is valid
	* return true
	* else
	* return false
	* </pre>
	*/
	@DOpt(type = OptType.Helper)
	@AttrRef("givenName")
	public boolean validateGivenName(String givenName) {
		return givenName != null
				&& givenName.length()>0 
				&& givenName.length() <= 35;
	}

	/**
	* @effects <pre>
	* if lastName is valid
	* return true
	* else
	* return false
	* </pre>
	*/
	@DOpt(type = OptType.Helper)
	@AttrRef("lastName")
	public boolean validateLastName(String lastName) {
		return lastName != null 
				&& lastName.length() > 0
				&& lastName.length() <= 35;
	}

	/**
	* @effects <pre>
	* if email is valid
	* return true
	* else
	* return false
	* </pre>
	*/
	@DOpt(type = OptType.Helper)
	@AttrRef("email")
	public boolean validateEmail() {
		if (lastName == null 
				|| lastName.length() <=0
				|| lastName.length() > 200)
			return false;
		int indexOfDot = -1;
		int indexOfA = -1;
		for (int i = email.length() - 1; i >= 0; i--) {
			char character = email.charAt(i);
			if (indexOfDot > 0 && character == '@') {
				indexOfA = i;
			}
			if (indexOfA == -1 && character == '.') {
				indexOfDot = i;
			}
		}
		return indexOfA > 0 && indexOfDot-indexOfA>1;
	}

	/**
	* @effects <pre>
	* if address is valid
	* return true
	* else
	* return false
	* </pre>
	*/
	@DOpt(type = OptType.Helper)
	@AttrRef("address")
	public boolean validateAddress(String address) {
		return address!= null 
				&&address.length()>0
				&&address.length()<=1500;
	}

	/**
	* @effects <pre>
	* if phone is valid
	* return true
	* else
	* return false
	* </pre>
	*/
	@DOpt(type = OptType.Helper)
	@AttrRef("phone")
	public boolean validatePhone(String phone) {
		if(phone== null 
				||phone.length()<=0
				||phone.length()>20
				||!phone.startsWith("(84) "))
			return false;
		String n = phone.substring(5, phone.length());
		if (n.length()<8) return false; 
		for (int i = 5; i < phone.length(); i++) {
			if (phone.charAt(i)<'0'|| phone.charAt(i)>'9')
				return false;
		}
		return true;
	}

	/**
	* @effects <pre>
	* if dob is valid
	* return true
	* else
	* return false
	* </pre>
	*/
	@DOpt(type = OptType.Helper)
	@AttrRef("dob")
	public boolean validateDob(Date dob) {
		return dob.getTime()>= new Date(1900, 1, 1).getTime();
	}

	/**
	* @effects <pre>
	* if gender is valid
	* return true
	* else
	* return false
	* </pre>
	*/
	@DOpt(type = OptType.Helper)
	@AttrRef("gender")
	public boolean validateGender(Gender gender) {
		return gender != null;
	}
	
	
	/**
	* @effects <pre>
	* if this satisfies abstract properties
	* return true
	* else
	* return false</pre>
	*/
	@DOpt(type = OptType.Helper)
	public boolean repOK() {
		return validateId(id)
				&&validateFirstName(firstName)
				&&validateGivenName(givenName)
				&&validateLastName(lastName)
				&&validateAddress(address)
				&&validatePhone(phone)
				&&validateDob(dob)
				&&validateGender(gender)
				&&(email == null|| validateEmail());
	}
	
	//____________________________ Default_____________________
	
	/**
	* @effects <pre>
	* if all properties of this and that are equal
	* return true
	* else
	* return false</pre>
	*/
	@DOpt(type = OptType.Default)
	@Override
	public boolean equals(Object that) {
		if (this == that) return true;
		if (!(that instanceof Employee)) return false;
		Employee employee = (Employee) that;
		return getId() == employee.getId() &&
				getFirstName().equals(employee.getFirstName()) &&
				getGivenName().equals(employee.getGivenName()) &&
				getLastName().equals(employee.getLastName()) &&
				Objects.equals(getEmail(), employee.getEmail()) &&
				getAddress().equals(employee.getAddress()) &&
				getPhone().equals(employee.getPhone()) &&
				getDob().equals(employee.getDob()) &&
				getGender().equals(employee.getGender());
	}
	
	/**
	* @effects <pre>
	* return the data contains all properties of Employee
	*/
	@DOpt(type = OptType.Default)
	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", givenName='" + givenName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				", dob=" + dob +
				", gender=" + gender +
				'}';
	
	}
	
	/**
	* @effects <pre>
	* return the id of Employee
	*/
	@DOpt(type = OptType.Default)
	@Override
	public int hashCode() {
		return id;
	}
}
