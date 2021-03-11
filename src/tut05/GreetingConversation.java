package tut05;

public class GreetingConversation {

	private Person person;
	private MobilePhone phone;

	// initalize the GreettingConservation Object with Person and Phone
	public GreetingConversation() {
		this.person = new Person();
		this.phone = new MobilePhone();

	}

	// show name of person
	public String getNamePerson() {
		return person.getName();
	}

	// show name of phone
	public String getNamePhone() {
		return phone.getModel();
	}

	// show person
	public Person getPerson() {
		return person;
	}

	// change the Person
	public void setPerson(Person person) {
		this.person = person;
	}

	// show the MobilePhone
	public MobilePhone getPhone() {
		return phone;
	}

	// change the MobilePhone
	public void setPhone(MobilePhone phone) {
		this.phone = phone;
	}

}
