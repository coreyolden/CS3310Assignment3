
public class MergeSort {
	
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
	
	
	
	
	public static void mergeSort(String[] arr, int low, int high) { // this splits it
		if(low < high) {
            int middle = (low +high)/2;
 
            mergeSort(arr, low, middle);
            mergeSort(arr , middle+1, high);
 
            merge(arr, low, middle, high);
        
		}
	}
	
	public static void merge(String[] arr, int low, int middle, int high) { //this combines it
		
		int lowerHalf = middle-low+1;
		int upperHalf= high-middle;
		
        String[] lowNumbers = new String[lowerHalf];
        String[] highNumbers = new String[upperHalf];
 
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
	
}
