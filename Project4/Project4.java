import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 * this Project4 contains all the contents that needs to work displaying the GUI and reading out the file input. 
 *
 */
public class Project4 {
	/**
	 * creates an instance of the RomanNumeralGUI and makes it visible to the user 
	 * @param args
	 */
	public static void main(String[] args) {
		RomanNumeralGUI gui = new RomanNumeralGUI();
		gui.createAndShowGUI();
	}
	/**
	 * this reads the contents of each line of the file input
	 * it will then inform the user if any of the Roman numerals are invalid 
	 * @param fileName the name of the file
	 * @param displayArea displays the contents in the file
	 */
	public static void displayFileContent(String fileName, JTextArea displayArea) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String input;
			
			while ((input = br.readLine()) != null) {
				String[] romanNumerals = input.split(" "); // reads in between the Roman numerals
				for (String romanNumeral : romanNumerals) {
					try {
						new RomanNumeral(romanNumeral);
					} catch (IllegalRomanNumeralException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}




