import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

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
        // Create a TreeMap to store the Roman numerals and their Arabic values
        TreeMap<Integer, String> arabicToRoman = new TreeMap<>();

        // Iterate over the unsorted list to populate the TreeMap
        RomanNumeralList.Node currentUnsorted = unsortedList.getHead().getNext();
        while (currentUnsorted != null) {
            int arabicValue = currentUnsorted.getData().getArabicValue();
            String romanNumeral = currentUnsorted.getData().getRomanNumeral();
            arabicToRoman.put(arabicValue, romanNumeral);
            currentUnsorted = currentUnsorted.getNext();
        }

        // Create a JPanel with a GridLayout to display the Roman numerals and their corresponding Arabic values
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Roman Numerals"));
		panel.add(new JLabel("Arabic Value"));

        // Iterate over the TreeMap to add the Roman numerals and their corresponding Arabic values to the panel
        for (Map.Entry<Integer, String> entry : arabicToRoman.entrySet()) {
            panel.add(new JLabel(entry.getValue()));
            panel.add(new JLabel(String.valueOf(entry.getKey())));
        }

        // Update the GUI
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
            public void actionPerformed(ActionEvent user) {
                String romanNumeralInput = JOptionPane.showInputDialog(null, "Please enter a Roman numeral:");
                if (romanNumeralInput != null && !romanNumeralInput.isEmpty()) {
                    try {
                        RomanNumeral romanNumeral = new RomanNumeral(romanNumeralInput);
                        int arabicValue = romanNumeral.getArabicValue();
                        JOptionPane.showMessageDialog(null, "The Arabic value for " + romanNumeralInput + " is " + arabicValue, "Result", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IllegalArgumentException ex) {
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

