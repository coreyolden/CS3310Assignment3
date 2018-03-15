
public class MyHashTable {

	 MyLinkedList[] table = new MyLinkedList[10000];
	 int flag = 0;
	private int hash(String input) {
		
		// an example I saw online with some modifications. I will modify it more.
		int hash = 7;
		for(int i = 0; i<input.length(); i++) {
			hash=hash*31 + input.charAt(i);
			
		}
			if(hash<0) {
				hash = hash*-1;
			}
			
		return hash%10000;
		
	}
	
	public void put(HDTestData input) {
		
		//instantiate the lists
		if(flag == 0) {
			for(int i = 0; i<10000; i++) {
				MyLinkedList list = new MyLinkedList();
				table[i]= list;
			}
			flag++; //flag so it only does this on first put
		}
		
		int hash = hash(input.getSerial()); //get the hash
		if(table[hash].getHead()==null) {//if the table has no head make this node the head
			table[hash].setHead(input);
		}else {
		table[hash].insert(input);}//if not then just add the node to the end of the list.
	}
	
	public HDTestData get(String toFind) {
		int hash = hash(toFind);
		HDTestData dataFound = new HDTestData();
		dataFound = table[hash].search(toFind);
		return dataFound;
	}
	
	
}
