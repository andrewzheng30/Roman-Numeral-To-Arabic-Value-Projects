import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * the FileMenuHandler handles the GUI
 */
public class FileMenuHandler implements ActionListener {
    public FileMenuHandler(RomanNumeralGUI gui) {
    }

    /**
     * the actionPerformed choose a file and displays the text file in addition, it
     * also has certain options like Open and Quit.
     */
    public void actionPerformed(ActionEvent e) {
        String options = e.getActionCommand();

        if (options.equals("Open")) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                loadRomanNumeralsFromFile(selectedFile);
            }
        } else if (options.equals("Quit")) {
            System.exit(0);
        }
    }

    /**
     * the private method loadRomanNumeralsFromFile reads the selected file and puts
     * them in an unsorted and sorted list
     * 
     * @param file it reads the file that was selected from the user
     */
    private void loadRomanNumeralsFromFile(File file) {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] romanNumerals = line.split(" ");
                for (String romanNumeral : romanNumerals) {
                    try {
                        new RomanNumeral(romanNumeral);
                    } catch (IllegalRomanNumeralException e) {
                        System.out.println("Invalid Roman Numeral");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}


