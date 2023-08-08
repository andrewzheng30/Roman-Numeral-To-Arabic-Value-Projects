/**
 */
public class RomanNumeralList {
	private Node head;
    private int size;
    
    /**
     * constructor that initializes head to new Node and sets the size equals to 0
     */
    public RomanNumeralList() {
    	head = new Node(null);
        size = 0;
    }
    
    /**
     * get methods that returns the size
     * @return the size 
     */
    public int getSize() {
        return size;
    }
    
    /**
     * it sets the size to a value of the list 
     * @param size this setSie the size of the list
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * method to append RomanNumeral. it starts from the list and keeps going until it reaches
     * the end of the list. it then sets the current pointer to the last node and increase size by 1
     * @param add creates a new Node for RomanNumeral
     */
    public void append(RomanNumeral add) {
        Node newNode = new Node(add); 
        Node current = head; 
        while (current.getNext() != null) { 
        	current = current.getNext();
        }
        current.setNext(newNode); 
        size++; 
    }
    
    /**
     * get method to return the head
     * @return head
     */
    public Node getHead() {
        return head;
    }
    
    /**
     * set method to the head of the list
     * @param head the new head of the list
     */
    public void setHead(Node head) {
        this.head = head;
    }

    public class Node {
        private RomanNumeral data;
        private Node next;
        /**
         * constructor that initialize data and set the next pointer to null
         * @param data that the node stores
         */
        public Node(RomanNumeral data) {
            this.data = data;
            this.next = null;
        }
        /**
         * get method that returns data
         * @return data
         */
        public RomanNumeral getData() {
            return data;
        }
        /**
         * set method that allows data to store in node
         * @param data the data that is stored in node
         */
        public void setData(RomanNumeral data) {
            this.data = data;
        }
        /**
         * get method that returns next
         * @return next node
         */
        public Node getNext() {
            return next;
        }
        /**
         * set method that sets the next node in the list
         * @param next it checks the next node of the list 
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }
}


