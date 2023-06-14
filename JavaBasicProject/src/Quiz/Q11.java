package Quiz;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Q11 {
	public static void main(String[] args) {
		// Write A Java program to print current time in the format hh:mm:ss with time
		// zone
		// Ex : 03:15:45 PST

		// get the current time
		LocalDateTime currentTime = LocalDateTime.now();

		// set the time zone to be used
		ZoneId timeZone = ZoneId.systemDefault();

		// format the time with time zone
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss z").withZone(timeZone);

		// print the formatted time
		System.out.println(formatter.format(currentTime));
	}
}
