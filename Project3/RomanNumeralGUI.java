import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class RomanNumeralGUI represents the instance variables for unsortedList and sortedList 
 * unsortedList & sortedList
 */
public class RomanNumeralGUI {
    private UnsortedRomanNumeralList unsortedList;
    private SortedRomanNumeralList sortedList;
    private JFrame frame;
/**
 * constructs unsortedList and sortedList to their UnsortedRomanList and SortedRomanNumeralList
 */
    public RomanNumeralGUI() {
        unsortedList = new UnsortedRomanNumeralList();
        sortedList = new SortedRomanNumeralList();
    }
/**
 * creates and displays the contents to show for the GUI
 */
    public void createAndShowGUI() {
        frame = new JFrame("Roman Numerals Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        attachHandlers();
        frame.pack();
        frame.setVisible(true);
    }
/**
 * updates the table by showing the grid layout and also the headings and columns 
 */
    private void updateTable() {
        JPanel panel = new JPanel(new GridLayout(0, 3));
            panel.add(new JLabel("Roman Numerals"));
            panel.add(new JLabel("Unsorted Arabic Value"));
            panel.add(new JLabel("Sorted Arabic Value"));
            
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
            	
            	if (currentUnsorted != null) {
            		currentUnsorted = currentUnsorted.getNext();
            	}
            	if (currentSorted != null) {
            		currentSorted = currentSorted.getNext();
            	}
            }
            
            frame.getContentPane().removeAll();
            frame.getContentPane().add(panel, BorderLayout.CENTER);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
   }
/**
 * attach menu items like File, Open, and Convert
 */
    private void attachHandlers() {
    	JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        
        JMenuItem openMenuItem = new JMenuItem("Open");
        fileMenu.add(openMenuItem);
        openMenuItem.addActionListener(new ActionListener() {
/**
 * displays the file chosen by the user. and then calls updateTable to update the conversion table 
 * @param contents 
 */
        	public void actionPerformed(ActionEvent contents) {
        		JFileChooser fileChooser = new JFileChooser();
        		int result = fileChooser.showOpenDialog(null);
        		
        		if (result == JFileChooser.APPROVE_OPTION) {
        			File selectedFile = fileChooser.getSelectedFile();
        			try {
        				displayFileContent(selectedFile.getAbsolutePath());
        				updateTable();
                    } 
        			catch (IOException ex) {
        				JOptionPane.showMessageDialog(null, "Error reading file.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
               }
           }
        });
        
        JMenuItem quitMenuItem = new JMenuItem("Quit");
        fileMenu.add(quitMenuItem);
        quitMenuItem.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent contents) {
        		System.exit(0);
            }
        });

        JMenu convertMenu = new JMenu("Convert");
        menuBar.add(convertMenu);

        JMenuItem romanToArabicMenuItem = new JMenuItem("Roman to Arabic");
        convertMenu.add(romanToArabicMenuItem);
        romanToArabicMenuItem.addActionListener(new ActionListener() {
/**
 * this creates and displays the converter
 * it then asks the user to enter a Roman numeral and then converts it to an Arabic value
 * if the Roman numeral entered by the user is invalid, the user will be informed with a message dialog
 * @param user representing the menu and input/output dialog
 */
        	public void actionPerformed(ActionEvent user) {
        		String romanNumeralInput = JOptionPane.showInputDialog(null, " Please enter a Roman numeral:");
        		if (romanNumeralInput != null && !romanNumeralInput.isEmpty()) {
        			try {
        				RomanNumeral romanNumeral = new RomanNumeral(romanNumeralInput);
        				int arabicValue = romanNumeral.getArabicValue();
        				JOptionPane.showMessageDialog(null, "The Arabic value for " + romanNumeralInput + " is " + arabicValue, "Result", JOptionPane.INFORMATION_MESSAGE);
                    } 
        			catch (IllegalRomanNumeralException ex) {
        				JOptionPane.showMessageDialog(null, "Invalid Roman numeral. Please enter a valid Roman numeral.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
               }
           }
       });
   }
/**
 * this reads the contents displayed in the text file and converts it to the unsorted and sorted lists
 * as it reads, it also looks for any invalid Roman numeral on the text file 
 * @param fileName the name of the text file the user selects 
 * @throws IOException throws in an IllegalRomanNumeralException for invalid characters 
 */
    private void displayFileContent(String fileName) throws IOException {
    	unsortedList = new UnsortedRomanNumeralList();
        sortedList = new SortedRomanNumeralList();
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        	String line;
        	while ((line = br.readLine()) != null) {
        		String[] romanNumerals = line.split(" ");
        		for (String romanNumeral : romanNumerals) {
        			try {
        				RomanNumeral rn = new RomanNumeral(romanNumeral);
                        unsortedList.append(rn);
                        sortedList.add(rn);
                    } 
        			catch (IllegalRomanNumeralException e) {
        				System.out.println("Invalid Roman numeral");
                    }
               }
           }
       }
   }
}

