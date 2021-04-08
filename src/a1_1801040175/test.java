package a1_1801040175;


import java.util.Date;

public class test {
    public static void main(String [] args){
        Date dob = new Date(2000, 10, 9);
        Employee e = new Employee(1801040161, "nghiem", "Duong", "Duc", "he@s.hanu.vn", "hanam", "(84) 360909929", dob, Gender.Male);
        System.out.println(e);
    }
}
