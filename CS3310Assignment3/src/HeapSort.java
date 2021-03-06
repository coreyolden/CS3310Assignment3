
public class HeapSort {

MyHashTable hash;
	
/**basic constructor for passing in the hash table 
 * 
 * @param hashTable
 */
	HeapSort(MyHashTable hashTable){
		hash = hashTable;
	}
	
	/**forms the array as a heap and calls heapify to sort it
	 * 
	 * @param arr
	 * @param number
	 * @return
	 */
	public String[] heapSort(String[] arr, int number) {
		
		//parent location = number/2-1
		
		for(int i = number/2-1; i>=0; i--) {
			heapify(arr, number, i);
		}
		
		for(int i = number-1; i>=0; i--) {
			String hold = arr[0];
			arr[0]= arr[i];
			arr[i]= hold;
			
			heapify(arr, i, 0);
		}
		
		return arr;
		
	}
	
	/** heapify data to bring largest data to the top 
	 * 
	 * @param arr
	 * @param count
	 * @param i
	 */
	public void heapify(String[] arr, int count, int i) {
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left < count && hash.get(arr[left]).getPoweredOnTime() > hash.get(arr[largest]).getPoweredOnTime()) {
			largest = left;
		}
		
		if(right < count && hash.get(arr[right]).getPoweredOnTime() >hash.get(arr[largest]).getPoweredOnTime()) {
			largest= right;
		}
		
		if(largest != i) {
			String swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			
			heapify(arr, count, largest);
			
		}
	}
}
