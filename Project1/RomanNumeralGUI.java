import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextArea;

public class RomanNumeralGUI extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JTextArea[] romanArea;
  private JTextArea[] decimalArea;
  private static JFrame romanNumeralFrame;
  
  public static void initialize() {
    romanNumeralFrame = new JFrame(); // sets it up 
    romanNumeralFrame.setTitle("Roman to Arabic Conversion"); // the title of the panel 
    romanNumeralFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    romanNumeralFrame.setSize(400, 200);
    romanNumeralFrame.setLocation(100,100);
    romanNumeralFrame.setLayout(new GridLayout(1, 2));
    
    RomanNumeralGUI gui = new RomanNumeralGUI(); // create the RomanNumeralGUI and add it to the window
    romanNumeralFrame.add(gui);
    romanNumeralFrame.pack(); // makes it fit in the screen. It packs it
    romanNumeralFrame.setLocationRelativeTo(null);
    romanNumeralFrame.setVisible(true); // makes it visible
  }
  
  public RomanNumeralGUI() {
    setTitle("Roman to Arabic Conversion"); // sets the title 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    
    String[] numerals = readInputFile("input.txt"); // reads the input.txt for the Roman numerals 
    int numNumerals = numerals.length;
    
    JPanel panel = new JPanel(new GridLayout(numNumerals, 2)); // creates the layout of the panel 
    romanArea = new JTextArea[numNumerals];
    decimalArea = new JTextArea[numNumerals];
    
    for (int i = 0; i < numNumerals; i++) {
      String romanNumeral = numerals[i];
      int decimalValue = Project1.romanToDecimal(romanNumeral);
      romanArea[i] = new JTextArea(romanNumeral);
      decimalArea[i] = new JTextArea(Integer.toString(decimalValue));
      panel.add(romanArea[i]);
      panel.add(decimalArea[i]);
    }
    add(panel); // adds the panel to the screen
    pack(); // sets it up in the center of the screen
    setLocationRelativeTo(null);
  }
  
  private static String[] readInputFile(String filename) {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      StringBuilder sb = new StringBuilder();
      while ((line = br.readLine()) != null) {
        sb.append(line);
        sb.append("\n");
      }
      return sb.toString().split("\\s*,\\s*");
    }
      catch (IOException e) {
        System.err.format("IOException: %s%n", e);
        return new String[0];
      }
  }
}