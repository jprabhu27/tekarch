package hackathon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q31 {

	public static void main(String[] args) {
		// Q31. Read a file content and write it to a new file in reverse order.
		// (reverse line 1-10 to line 10-1)

		String dir = System.getProperty("user.dir") + "\\datafiles\\";
		String inputFilePath = dir + "Text1.txt";
		String outputFilePath = dir + "Text2.txt";

		try {
			List<String> lines = new ArrayList<>();

			// Read file...store lines in List "lines"
			try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
				
				String line;
				while ((line = reader.readLine()) != null) {
					lines.add(line);
				}
			}

			System.out.println("File content of input file " + inputFilePath);
			for (String s1 : lines)
				System.out.println(s1);

			// reverse the lines
			Collections.reverse(lines);

			// Write file to file path specified in outputFile
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
				for (String line : lines) {
					writer.write(line);
					writer.newLine();
				}
			}

			System.out.println("\nFile content reversed successfully.\n");

			System.out.println("File content of output file " + outputFilePath);
			for (String s2 : lines)
				System.out.println(s2);
		} catch (IOException e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

}