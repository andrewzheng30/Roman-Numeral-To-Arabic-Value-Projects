import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Project1 {
  public static int romanToDecimal(String romanNumeral) {
    int decimalValue = 0; //initialize both decimalValue and PreValue to 0
    int prevValue = 0;
    
    for (int i = romanNumeral.length() - 1; i >= 0; i--) { // goes to the string of characters
      char c = romanNumeral.charAt(i); // makes i char c. Therefore, this will allow the if statements to execute checking the letter (char) to see which result it is correspond with 
      int result = 0;
      //conversion: Roman numeral to decimal
      if (c == 'I') {
        result = 1;
      } 
      else if (c == 'V') {
        result = 5;
      } 
      else if (c == 'X') {
        result = 10;
      } 
      else if (c == 'L') {
        result = 50;
      } 
      else if (c == 'C') {
        result = 100;
      } 
      else if (c == 'D') {
        result = 500;
      } 
      else if (c == 'M') {
        result = 1000;
      }
      
      if (result < prevValue) { // if the result is < preValue, you subtract. Otherwise, you add
        decimalValue -= result;
      } 
      else {
        decimalValue += result;
      }
      prevValue = result;
    }
    return decimalValue;
  }
  
  public static void inputFromFile(String[] array, String filename) {
    Scanner input;
    try {
      FileReader fr = new FileReader(filename);
      input = new Scanner(fr);
    } 
    catch (FileNotFoundException e) { // if the file is not found, the system will notify the user
      System.out.println("File not Found!!");
      return;
    }
    while (input.hasNextLine()) {
      String line = input.nextLine();
      String[] numerals = line.split(","); // read in between the ",". This makes the output more accurate
      for (int i = 0; i < numerals.length; i++) {
        int decimalValue = romanToDecimal(numerals[i]);
        System.out.printf(numerals[i], decimalValue);
      }
    }
    input.close();
  }
  public static void main(String[] args) {
    // create an instance of the GUI
    RomanNumeralGUI gui = new RomanNumeralGUI();
    gui.setVisible(true); // makes it appear on the screen
  }
}
