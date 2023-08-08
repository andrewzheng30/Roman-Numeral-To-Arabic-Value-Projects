import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextArea;

public class Project3 {
/**
 * this method creates/shows the RomanNumeralGUI
 * @param args
 */
    public static void main(String[] args) {
        RomanNumeralGUI gui = new RomanNumeralGUI();
        gui.createAndShowGUI();
    }
/**
 * shows the contents in the file and reads off the Roman numerals
 * @param fileName the filename which has the Roman numerals
 * @param displayArea shows the Roman numerals and it's Arabic values
 */
    public static void displayFileContent(String fileName, JTextArea displayArea) {
        UnsortedRomanNumeralList unsortedList = new UnsortedRomanNumeralList();
        SortedRomanNumeralList sortedList = new SortedRomanNumeralList();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String input;
            while ((input = br.readLine()) != null) {
                String[] romanNumerals = input.split(" "); // reads in between the Roman numerals
                for (String romanNumeral : romanNumerals) {
                    try {
                        RomanNumeral rn = new RomanNumeral(romanNumeral);
                        unsortedList.append(rn);
                        sortedList.add(rn);
                    } catch (IllegalRomanNumeralException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        StringBuilder unsortedArabicValues = new StringBuilder();
        StringBuilder sortedArabicValues = new StringBuilder();

        RomanNumeralList.Node currentUnsorted = unsortedList.getHead().getNext();
        RomanNumeralList.Node currentSorted = sortedList.getHead().getNext();
        while (currentUnsorted != null || currentSorted != null) {
            if (currentUnsorted != null) {
                unsortedArabicValues.append(currentUnsorted.getData().getArabicValue()).append("\n");
                currentUnsorted = currentUnsorted.getNext();
            }
            if (currentSorted != null) {
                sortedArabicValues.append(currentSorted.getData().getArabicValue()).append("\n");
                currentSorted = currentSorted.getNext();
            }
        }

        displayArea.setText("Unsorted Arabic Values:\n" + unsortedArabicValues.toString() +
                "\nSorted Arabic Values:\n" + sortedArabicValues.toString());
    }
}



