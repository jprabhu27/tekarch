package Quiz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Q10 {

	public static void main(String[] args) {

		// Print today's date in the format DD/MM/yyyy

		LocalDate todaysDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = todaysDate.format(formatter);

		System.out.println("Todays date is: " + formattedDate);

		
		
	}

	
}
