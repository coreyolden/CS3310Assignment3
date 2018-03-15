import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class PartC {

	public void Main(MyHashTable[] arr) {
		int n = 10;
		int m = 5;
		BufferedReader input = new BufferedReader(new FileReader("snum_70k.csv"));
		String readline;
		int numberInFile = 0;
		while((readline = input.readLine())!=null) {
			numberInFile++;
		}
		input.close();
		input = new BufferedReader(new FileReader("snum_70k.csv"));
		String[] hold70k = new String[numberInFile];
		for(int i=0; i<numberInFile; i++) {
			hold70k[i]=input.readLine();
		}
		String[] holdSearches = new String[n];
		
		Random rand = new Random();
		//m quicksorts
		long totalQuickSort=System.nanoTime();
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<n; j++) {
				int random = rand.nextInt(numberInFile)+1;
				holdSearches[j]= hold70k[random];
			}
			long quickSortTime = System.nanoTime();
			quickSort()
			
		}
	}
	

	public static void quickSort(HDTestData[] arr, int low, int high) {
		if(arr.length == 0) {
			return; //The array is empty
		}
		if(high <= low) {
			return; 
		}
		int pivot = low + (high - low) / 2; //the middle
		int l = low;
		int h = high;
		while(l <= h) {
			while (arr[l].getModel().compareTo(arr[pivot].getModel()) < 0) {
				l++;
			}
 
			while (arr[h].getModel().compareTo(arr[pivot].getModel()) > 0) {
				h--;
			}
 
			if (l <= h) {
				HDTestData hold = arr[l];
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
		
	}
	
	
	public static void mergeSort(HDTestData[] arr, int low, int high) { // this splits it
		if(low < high) {
            int middle = (low +high)/2;
 
            mergeSort(arr, low, middle);
            mergeSort(arr , middle+1, high);
 
            merge(arr, low, middle, high);
        
		}
	}
	
	public static void merge(HDTestData[] arr, int low, int middle, int high) { //this combines it
		
		int lowerHalf = middle-low+1;
		int upperHalf= high-middle;
		
        HDTestData lowNumbers[] = new HDTestData [lowerHalf];
        HDTestData highNumbers[] = new HDTestData [upperHalf];
 
        for (int i=0; i<lowNumbers.length; ++i)
            lowNumbers[i] = arr[low + i];
        for (int i=0; i<highNumbers.length; ++i)
            highNumbers[i] = arr[middle + 1+ i];
 
 
        int i = 0;
        
        int j = 0;
 
        int k = low;
        while (i < lowerHalf && j < upperHalf)
        {
            if (lowNumbers[i].getCapacity() <= highNumbers[j].getCapacity())
            {
                arr[k] = lowNumbers[i];
                i++;
            }
            else
            {
                arr[k] = highNumbers[j];
                j++;
            }
            k++;
        }
        while (i < lowerHalf)
        {
            arr[k] = lowNumbers[i];
            i++;
            k++;
        }
 
        while (j < upperHalf)
        {
            arr[k] = highNumbers[j];
            j++;
            k++;
        }
    
		
	}
	
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
