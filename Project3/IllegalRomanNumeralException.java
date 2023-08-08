/**
 * throws in an IllegalArgumentExecption when a invalid Roman numeral appears 
 *
 */
public class IllegalRomanNumeralException extends IllegalArgumentException {
    /**
	 * a unique identifier for the class
	 */
	private static final long serialVersionUID = 1L;
/**
 * constructs an IllegalRomanNumeralException when invalid Roman numeral appears
 * @param message it will display a message informing the user the Roman numeral is incorrect
 */
	public IllegalRomanNumeralException(String message) {
        super(message);
    }
}
