package a1_1801040175;




import java.util.Date;
import java.util.regex.Pattern;

public class Employee {
    private int id;
    private String firstName;
    private String givenName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private Date dob;
    private Gender gender;

    public Employee(int id, String firstName, String givenName, String lastName, String email, String address, String phone, Date dob, Gender gender)  {
        if (!validateId(id)){
            System.err.println("Invalid id: " + id);
            return;
        }

        if (!validateFirstName(firstName)){
            System.err.println("Invalid firstName: " + firstName);
            return;
        }

        if (!validateGivenName(givenName)){
            System.err.println("Invalid givenName: " + givenName);
            return;
        }

        if (!validateLastName(lastName)){
            System.err.println("Invalid lastName: " + lastName);
            return;
        }

        if (!validateEmail(email)){
            System.err.println("Invalid email: " + email);
            return;
        }

        if (!validateAddress(address)){
            System.err.println("Invalid address: " + address);
            return;
        }

        if (!validatePhone(phone)){
            System.err.println("Invalid phone: " + phone);
            return;
        }

        if (!validateDob(dob)){
            System.err.println("Invalid dob: " + dob);
            return;
        }

        if (!validateGender(gender)){
            System.err.println("Invalid gender: " + gender);
            return;
        }

        this.id = id;
        this.firstName = firstName;
        this.givenName = givenName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    private boolean validateId(int id){
        return id > 100;
    }

    private boolean validateFirstName(String firstName){
        return firstName != null && firstName.length() > 0 && firstName.length() <= 35;
    }

    private boolean validateGivenName(String givenName){
        return givenName != null && givenName.length() > 0 && givenName.length() <= 35;
    }

    private boolean validateLastName(String lastName){
        return lastName != null && lastName.length() > 0 && lastName.length() <= 35;
    }

    private boolean validateEmail(String email){
        String EMAIL_PATTERN =
                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        return email != null && email.length() > 0 && email.length() <= 200 && Pattern.matches(EMAIL_PATTERN, email);
    }

    private boolean validateAddress(String address){
        return address != null && address.length() > 0 && address.length() <= 1500;
    }

    private boolean validatePhone(String phone){
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

    private boolean validateDob(Date dob){
        Date dobMin = new Date(1900,1,1);
        
        return dob.compareTo(dobMin)>0;
    }
// Date SimpleDateFormat simple = new Sim("yyyy MM dd ")
    private boolean validateGender(Gender gender){
        return gender != null;
    }

    @Override
    public boolean equals(Object o) {
        if(o==null){
            return false;
        }else{
            Employee employee = (Employee) o;
            return id == employee.getId() && firstName.equals(employee.getFirstName())&&givenName.equals(employee.getGivenName())&&lastName.equals(employee)&&email.equals(employee.getEmail())&&dob.equals(employee.getDob())&&gender.equals(employee.getGender()) ;

        }
        }



    public boolean repOK(){
        return validateId(id) && validateFirstName(firstName) && validateGivenName(givenName) && validateLastName(lastName)
                && validateEmail(email) && validateDob(dob) && validateGender( gender);
    }

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
}
