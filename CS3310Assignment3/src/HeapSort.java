
public class HeapSort {

	
	public static void heapSort(HDTestData[] arr, int number) {
		
		//parent location = number/2-1
		
		for(int i = number/2-1; i>=0; i--) {
			heapify(arr, number, i);
		}
		
		for(int i = number-1; i>=0; i--) {
			HDTestData hold = arr[0];
			arr[0]= arr[i];
			arr[i]= hold;
			
			heapify(arr, i, 0);
		}
		
		
	}
	public static void heapify(HDTestData[] arr, int count, int i) {
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left < count && arr[left].getPoweredOnTime() > arr[largest].getPoweredOnTime()) {
			largest = left;
		}
		
		if(right < count && arr[right].getPoweredOnTime() >arr[largest].getPoweredOnTime()) {
			largest= right;
		}
		
		if(largest != i) {
			HDTestData swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			
			heapify(arr, count, largest);
			
		}
	}
}
