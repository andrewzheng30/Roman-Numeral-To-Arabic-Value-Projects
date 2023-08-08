import java.util.HashMap;

/**
 * This class basically converts the RomanNumeral to it's respective Arabic value
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
     * this is used by using a HashMap converting the Roman numerals to Arabic values
     * @param romanNumeral takes the romanNumeral and converts it to it's value
     * @return returns the number (ArabicValue)
     */
    private int convertToArabic(String romanNumeral) {
        HashMap<Character, Integer> romanToArabic = new HashMap<>();
        romanToArabic.put('I', 1);
        romanToArabic.put('V', 5);
        romanToArabic.put('X', 10);
        romanToArabic.put('L', 50);
        romanToArabic.put('C', 100);
        romanToArabic.put('D', 500);
        romanToArabic.put('M', 1000);

        int result = 0;
        int lastValue = 0;
        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            char c = romanNumeral.charAt(i);
            Integer currentValue = romanToArabic.get(c);
            if (currentValue == null) {
                throw new IllegalArgumentException("Invalid Roman Numeral character: ");
            }
            if (currentValue < lastValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            lastValue = currentValue;
        }
        return result;
    }
 }


