/**
 * This class is a RomanNumeralListNode class that stores RomanNumeral as an object. 
 * It has RomanNumeral as data 
 */
public class RomanNumeralListNode {
    private RomanNumeral data;
    private RomanNumeralListNode next;
    
    /**
     * constructor that has a node that is data and sets the next node to null
     * @param data this makes data stored in node 
     */
    public RomanNumeralListNode(RomanNumeral data) {
        this.data = data;
        this.next = null;
    }
    
    /**
     * get method for the RomanNumeral object stored in this node
     * @return the data of the node which was stored 
     */
    public RomanNumeral getData() {
        return data;
    }
    
    /**
     * set method for the data stored in this node
     * @param data the RomanNumeral will be the setData for this node
     */
    public void setData(RomanNumeral data) {
        this.data = data;
    }
    
    /**
     * get method that returns the next node
     * @return the next node in link list 
     */
    public RomanNumeralListNode getNext() {
        return next;
    }
    
    /**
     * sets the next node in the list
     * @param next get the next node on the list 
     */ 
    public void setNext(RomanNumeralListNode next) {
        this.next = next;
    }
    
    /**
     * get method for the Arabic value of the RomanNumeral
     * @return the Arabic value of the RomanNumeral stored in node
     */
    public int getArabicValue() {
        return data.getArabicValue();
    }
}