/**
 * this class is for the sorted column for the Roman numerals, which is located on the 3rd column  
 */
public class SortedRomanNumeralList extends RomanNumeralList {
	/**
	 * finds the correct position to place the new node based on the Roman Numeral value and compares it
	 * sets it and stores it 
	 * increase the size by 1
	 * @param add the romanNumeral to the list 
	 */
    public void add(RomanNumeral add) {
        Node newNode = new Node(add);
        Node current = getHead();
        while (current.getNext() != null && current.getNext().getData().compareTo(add) < 0) {
            current = current.getNext();
        } 
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        setSize(getSize() + 1); 
    }
}

