/**
 * This class basically converts the RomanNumeral to it's respective Arabic value. 
 *
 */
public class RomanNumeral implements Comparable<RomanNumeral> {
	private String romanNumeral;
	private int arabicValue;
	
	/**
	 * constructor to set the Roman numeral and convert it to its Arabic value
	 * @param romanNumeral it represents a string of romanNumeral 
	 */
	public RomanNumeral(String romanNumeral) {
		this.romanNumeral = romanNumeral;
		this.arabicValue = convertToArabic(romanNumeral); // converts the Roman numeral to it's Arabic value
    }
	
	/**
	 * the method for getRomanNumeral & returns it 
	 * @return the romanNumeral 
	 */
	public String getRomanNumeral() {
		return romanNumeral; 
    }
	
	/**
	 * the method set the romanNumeral value and converts the romanNumeral to it's Arabic value
	 * @param romanNumeral value 
	 */
	public void setRomanNumeral(String romanNumeral) {
        this.romanNumeral = romanNumeral;
        this.arabicValue = convertToArabic(romanNumeral);
    }
	
	/**
	 * the method for getArabicValue & returns it 
	 * @return the arabicValue
	 */
    public int getArabicValue() {
        return arabicValue; 
    }
    
    /**
     * a method to checks if they are equal
     */
    public boolean equals(Object obj) { // check if the object is an instance of the RomanNumeral class
    	if (obj instanceof RomanNumeral) {
    		RomanNumeral other = (RomanNumeral) obj;
    		return this.arabicValue == other.arabicValue && this.romanNumeral.equals(other.romanNumeral);
    		// returns true if both the arabicValue and romanNumeral are equal 
        }
    	return false; // otherwise, return false
    }
    
    /**
     * this toString method return romanNumeral as a string 
     */
    public String toString() {
    	return romanNumeral;
    }
    
    /**
     * this compareTo method compares the values 
     */
    public int compareTo(RomanNumeral other) {
        return Integer.compare(this.arabicValue, other.arabicValue);
    }
    
    /**
     * 
     * @param romanNumeral takes the romanNumeral and converts it to it's value.
     * @return returns the number (ArabicValue)
     */
    private int convertToArabic(String romanNumeral) {
    	int result = 0; // set integer result to 0
        int lastValue = 0; // set integer lastValue to 0 
        for (int i = romanNumeral.length() - 1; i >= 0; i--) { // determines the length of the romanNumeral
        	int currentValue; // integer currentValue tells you the decimal 
            char c = romanNumeral.charAt(i); // checks the character
            if (c == 'I') {   
            	currentValue = 1; // I = 1
            }
            else if (c == 'V') {
            	currentValue = 5; // V = 5
            } 
            else if (c == 'X') {
                currentValue = 10; // X = 10 
            } 
            else if (c == 'L') {
                currentValue = 50; // L = 50
            } 
            else if (c == 'C') {
                currentValue = 100; // C = 100
            } 
            else if (c == 'D') {
                currentValue = 500; // D = 500
            } 
            else if (c == 'M') {
                currentValue = 1000; // M = 1000
            } 
            /* if char does not equal one of those characters inform the user by throwing in IllegalArugmentException */
            else {
            	throw new IllegalArgumentException("Invalid Roman Numeral character: "); 
            }
            
            if (currentValue < lastValue) { // if currentValue is less than lastValue, subtract it 
            	result -= currentValue;
            } 
            else {
                result += currentValue; // or else add it
            }
            lastValue = currentValue;
        }
        return result; // returns the number 
    }
}



