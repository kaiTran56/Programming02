package a2_180;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Employee em = new Employee(100, "Nguyên", "Đình Nguyên", "Trần", "Vinh Nghệ An", "(84) 398961689", new Date(2001, 8, 20), Gender.Male);
		System.out.println(em.toString());
	}
}
