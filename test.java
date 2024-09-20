// WAP in java to do the following.
// 1.Age calculator where any date is input by the user and it gives the age

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.Period;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your date of birth (yyyy-MM-dd): ");
        String input = scanner.nextLine();
        
        LocalDate dateOfBirth = LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        DayOfWeek dayOfWeek = dateOfBirth.getDayOfWeek();
        
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(dateOfBirth, currentDate);
        
        System.out.println("You were born on a " + dayOfWeek);
        System.out.println("Your age is: " + age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days.");
        
        scanner.close();
    }
}