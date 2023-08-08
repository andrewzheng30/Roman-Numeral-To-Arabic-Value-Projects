/**
 * this class basically creates a GUI and displays it. 
 * The GUI is broken up into 3 columns. One for RomanNumeral and one for unsorted and sorted Arabic value 
 */
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RomanNumeralGUI {
	private UnsortedRomanNumeralList unsortedList; // instance variables to store unsortedList & storedList
	private SortedRomanNumeralList sortedList;
	
	// constructor to initialize unsorted and sorted RomanNumeralList
	public RomanNumeralGUI(UnsortedRomanNumeralList unsortedList, SortedRomanNumeralList sortedList) {
		this.unsortedList = unsortedList;
        this.sortedList = sortedList;
    }
	/**
	 * this displays the GUI with the title and all the other features
	 */
	public void createAndShowGUI() {
		JFrame frame = new JFrame("Roman Numerals Converter"); // creates the title 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to exit the program on GUI
		JPanel panel = new JPanel(new GridLayout(0, 3)); // sets the GUI into three columns 
		panel.add(new JTextArea("Roman Numerals")); // the 1st column's title
        panel.add(new JTextArea("Unsorted Arabic Value")); // the 2nd column's title
        panel.add(new JTextArea("Sorted Arabic Value")); // the 3rd column's title
        
        // get the next node after the head unsortedList
        // get the next node after head of sortedList
        RomanNumeralList.Node currentUnsorted = unsortedList.getHead().getNext(); 
        RomanNumeralList.Node currentSorted = sortedList.getHead().getNext();
        while (currentUnsorted != null || currentSorted != null) {
        	JTextArea label1;
        	/* if current node in Unsorted list is null, set TextArea to " " (empty space)
        	 * or else you set the JTextArea to the Roman numeral of the current node in the unsorted list 
        	*/
        	if (currentUnsorted == null) { 
        		label1 = new JTextArea(" ");
        	} 
        	else {
        		label1 = new JTextArea(currentUnsorted.getData().getRomanNumeral());
        	}
        	/* if the current node in unsorted is null setText to empty space
        	 * or else set it to the Arabic value of the current node in unsorted 
        	 */
        	JTextArea label2 = new JTextArea();
        	if (currentUnsorted == null) {
        		label2.setText(" ");
        	} 
        	else {
        		label2.setText(String.valueOf(currentUnsorted.getData().getArabicValue()));
        	}
        	/* if the current node in the sorted is null, set JtextArea to " "
        	 * Or else set it to the Arabic value of the current sorted node
        	 */
        	JTextArea label3;
        	if (currentSorted == null) {
        		label3 = new JTextArea(" ");
        	} 
        	else {
        		label3 = new JTextArea(String.valueOf(currentSorted.getData().getArabicValue()));
        	}
        	// this method sets it, so therefore, you won't be able to edit it when GUI opens 
        	label1.setEditable(false); 
        	label2.setEditable(false);
        	label3.setEditable(false);
        	// adds the panel label 1-3
            panel.add(label1);
            panel.add(label2);
            panel.add(label3);
            /* checks to see if the current node Unsorted is not null. 
             * then it sets it to the next currentUnsorted node to the next node 
             * the same principle applies for the currentSorted 
             */
            if (currentUnsorted != null) {
                currentUnsorted = currentUnsorted.getNext();
            }
            if (currentSorted != null) { 
                currentSorted = currentSorted.getNext();
            }
        }
        frame.getContentPane().add(panel); // adds panel to the ContentPane of frame
        frame.pack(); // makes sure it fits in the screen 
        frame.setVisible(true); // makes it visible for us to see 
    }
}


