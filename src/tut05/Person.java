package tut05;

public class Person {
	
	private String name;
	//initialize the Person object
	public Person() {
		super();
	}
	//initilize the Person object with parameter
	public Person(String name) {
		super();
		this.name = name;
	}
	//show the name 
	public String getName() {
		return name;
	}
	//change the name of person
	public void setName(String name) {
		this.name = name;
	}
	
}
