
public class MyNode {

	private HDTestData data;
	private MyNode next;
	
	/**returns the next node in the linked list 
	 * 
	 * @return
	 */
	public MyNode getNext() {
		return next;
	}
	
	/** sets the next node in the linked list
	 * 
	 * @param nextNode
	 */
	public void setNext(MyNode nextNode) {
		next = nextNode;
	}
	
	/**returns the HDTestData as data 
	 * 
	 * @return
	 */
	public HDTestData getData() {
		
		return data;
	}
	
	/**sets an HDTestData as data 
	 * 
	 * @param input
	 */
	public void setData(HDTestData input) {
		data = input;
	}
	
}
