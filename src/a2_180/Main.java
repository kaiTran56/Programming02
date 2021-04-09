package a2_180;

import java.util.Date;

import a2_1801040175.Employee;
import a2_1801040175.Gender;

public class Main {
	public static void main(String[] args) {
		Employee em = new Employee(100, "Nguyên", "Đình Nguyên", "Trần", "Vinh Nghệ An", "(84) 398961689", new Date(101, 5, 5), Gender.Male);
		System.out.println(em.toString());
		System.out.println(new Date(0,0,1).toString());
	}
}
