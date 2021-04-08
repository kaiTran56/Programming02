package a2_180;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		@Deprecated
		Date checkDate = new Date();
		checkDate.setYear(2000);
		checkDate.setMonth(6);
		checkDate.setDate(5);
		
		System.out.println(checkDate.toString());

	}
}
