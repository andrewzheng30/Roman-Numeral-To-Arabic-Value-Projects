import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * This class reads the file form input.txt and converts them into romanNumeral objects.
 * This way the other files can convert them and do their functions 
 *
 */
public class Project2 {
  
  private static final String FILENAME = "input.txt"; // stores the filename for input.txt 
  /**
   * this reads the file and appends the Roman numerals 
   * @param args this allows it to extend the RomanNumberalList for both
   */
  public static void main(String[] args) {
	  UnsortedRomanNumeralList unsortedList = new UnsortedRomanNumeralList();
	  SortedRomanNumeralList sortedList = new SortedRomanNumeralList();
	  
	  // trying to read the data from a file 
	  try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
		  String line; // declare line as string 
		  while ((line = br.readLine())!= null) {
			  String[] romanNumerals = line.split(" ");
			  for (String romanNumeral : romanNumerals) {
				  RomanNumeral add = new RomanNumeral(romanNumeral);
				  // adds it and categorized it by (unsorted & sorted) 
				  unsortedList.append(add);
				  sortedList.add(add);
			  }
          }
	  }
	  
	  // handles an exception that may occur when reading the file
	  catch (IOException e) {
		  e.printStackTrace();
		  System.exit(1);
      }
	  // This passes unsortedList and sortedList to GUI ready for it to be display 
	  RomanNumeralGUI gui = new RomanNumeralGUI(unsortedList, sortedList);
	  gui.createAndShowGUI();
  }
}


