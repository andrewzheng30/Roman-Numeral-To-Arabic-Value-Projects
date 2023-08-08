import java.util.TreeMap;
import java.util.Comparator;

/**
 * the SortedRomanNumeralList extends RomanNumeralList sorts out the Roman numerals
 * it uses a tree map to sort out the values 
 */
public class SortedRomanNumeralList extends RomanNumeralList {
    private TreeMap<RomanNumeral, Integer> romanNumeralMap;
/**
 * this implements the TreeMap and sorts out the values by comparing the Roman numerals values 
 */
    public SortedRomanNumeralList() {
        romanNumeralMap = new TreeMap<RomanNumeral, Integer>(new Comparator<RomanNumeral>() {
            public int compare(RomanNumeral r1, RomanNumeral r2) {
                return r1.compareTo(r2);
            }
        });
    }
/**
 * adds the value of the Roman numeral value in the TreeMap in order
 * it then increases the list by 1 
 * @param romanNumeral to be added to the list 
 */
    public void add(RomanNumeral romanNumeral) {
        romanNumeralMap.put(romanNumeral, romanNumeral.getArabicValue());
        setSize(getSize() + 1);
    }
/**
 * gets the Arabic value from the Roman numeral 
 * @param romanNumeral value with the Arabic value 
 * @return the value of the Arabic value 
 */
    public int getArabicValue(RomanNumeral romanNumeral) {
        return romanNumeralMap.get(romanNumeral);
    }
}

