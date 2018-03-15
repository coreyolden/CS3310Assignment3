
public class QuickSort {

	MyHashTable hash;
	
	QuickSort(MyHashTable hashTable){
		hash = hashTable;
	}
	
	public String[] quickSort( String[] arr, int low, int high) {
		if(arr.length == 0) {
			return arr; //The array is empty
		}
		if(high <= low) {
			return arr; 
		}
		int pivot = low + (high - low) / 2; //the middle
		int l = low;
		int h = high;
		while(l <= h) {
			while (hash.get(arr[l]).getModel().compareTo(hash.get(arr[pivot]).getModel()) < 0) {
				l++;
			}
 
			while (hash.get(arr[h]).getModel().compareTo(hash.get(arr[pivot]).getModel()) > 0) {
				h--;
			}
 
			if (l <= h) {
				String hold = arr[l];
				arr[l] = arr[h];
				arr[h] = hold;
				l++;
				h--;
			}
		}
		
		if (low < h)
			quickSort(arr, low, h);
 
		if (high > l)
			quickSort(arr, l, high);
		return arr;
		
	}
}
