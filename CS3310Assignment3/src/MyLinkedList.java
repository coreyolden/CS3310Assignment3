
public class MyLinkedList {
	//all node pointers to keep track of.
	 private MyNode head = null;
	 private MyNode current;
	 private int size = 0;
	
	/** If the hash is a duplicate then it creates a new node to to store the hash and inserts it. 
	 * 
	 * @param num
	 */
	public void insert(HDTestData hd) {
		
		current = head;
		while(current.getNext()!= null) {
			current=current.getNext();
		}
		MyNode newNode = new MyNode();
		newNode.setData(hd);
		current.setNext(newNode);
		size++;
		
	}
	
	/**returns the number stored in node if found
	 * 
	 * @return
	 */
	public HDTestData search(String toFind) {
		current = head;
		HDTestData notFound = new HDTestData();
		notFound.setSerial("notFound");
		for(int i = 0; i<size; i++) {
			HDTestData hd = new HDTestData();
			hd = current.getData();
			if(hd.getSerial().compareTo(toFind)==0) {
				return hd;
			}
			
			current= current.getNext();	
		}
		return notFound;
	}
	
	/**returns the number of elements in the linked list
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}
	
	
	
	/**allows head to be set
	 * 
	 * @param node
	 */
	public void setHead(HDTestData data) {
		MyNode newNode = new MyNode();
		newNode.setData(data);
		head = newNode;
		size++;
	}
	
	
	
	/**returns a pointer to the head node
	 * 
	 * @return
	 */
	public MyNode getHead() {
		return head;
	}
	
	
	
	
}
