import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		MyHashTable hashTable = new MyHashTable();
		BufferedReader input = new BufferedReader(new FileReader("data_main.csv"));
		String readline;
		input.readLine();
		long timeToStore = System.nanoTime();
		while((readline = input.readLine())!=null) {
			HDTestData hdd = new HDTestData();
			String[] fields = new String[4];
			fields= readline.split(",");
			hdd.setSerial(fields[0]);
			hdd.setModel(fields[1]);
			hdd.setCapacity(Long.parseLong(fields[2]));
			hdd.setPoweredOn(Integer.parseInt(fields[3]));
			hashTable.put(hdd);
		}
		timeToStore = System.nanoTime()-timeToStore; //total time to store the HDDs is current time minus original time
		
		input.close();
		System.out.println("\n\nAverage time to	insert into hash table:\n"+timeToStore+" nanoseconds");
		System.out.println("\n---------------\n");
		if(args.length>0) { //running in command line with an argument provided
			input = new BufferedReader(new FileReader(args[0]));
			int length = 0;
			while((readline = input.readLine())!=null) {
				length++; //get the number of lines in the file
			}
			input.close();//close previous buffer
			
			
			
			
			String[] searchArr = new String[length];
			HDTestData[] foundHDArr = new HDTestData[length];
			input = new BufferedReader(new FileReader(args[0]));//reopen to start from the top
			for(int i = 0; i<length; i++) { //fill array with serial numbers to search
				searchArr[i]=input.readLine();
			}
			input.close();
			
			
			long hashSearchTime = System.nanoTime();
			for(int i = 0; i<length;i++) { //search and fill table with data
				foundHDArr[i]= hashTable.get(searchArr[i]);
			}
			hashSearchTime = System.nanoTime()-hashSearchTime; //The time it takes to search and fill foundHDArr
			
			
			int numberFound = length; //this is used to count the number that were actually found
			
			for(int i = 0; i<length; i++) { 
				if(foundHDArr[i].getSerial().compareTo("notFound") == 0) { //if the serial is not found then it was not found in search
					numberFound--;
				}
			}
			
			
			
			HDTestData[] updatedFoundArr = new HDTestData[numberFound]; //new array with only ones actually found
			
			
			int index = 0; 
			
			for(int i = 0; i<length; i++) {
				if(foundHDArr[i].getSerial().compareTo("notFound") != 0) {
					updatedFoundArr[index]=foundHDArr[i]; //if an actual HD then add it to the new array
					index++;
				}
			}
			
			
			
			
			// do all sorts so I can print first and last 4.
			//do quick sort and print all results
			quickSort(updatedFoundArr, 0, numberFound-1);	
			System.out.println("first 4 after sorting on model name:");
			for(int i = 0; i<4; i++) {
				System.out.println(updatedFoundArr[i].getSerial());
			}
			System.out.println("\nlast 4 after sorting on model name:");
			for(int i = numberFound-4; i<numberFound; i++) {
				System.out.println(updatedFoundArr[i].getSerial());
			}
			System.out.println("\n---------------\n");
			
			
			//do merge sort and print all results
			mergeSort(updatedFoundArr, 0, numberFound-1);
			
			
			System.out.println("first 4 after sorting on capacity:");
			for(int i =0; i<4; i++) {
				System.out.println(updatedFoundArr[i].getSerial());
			}
			
			System.out.println("\nlast 4 after sorting on capacity:");
			for(int i = numberFound-4; i<numberFound; i++) {
				System.out.println(updatedFoundArr[i].getSerial());
			}
			
			System.out.println("\n---------------\n");
			
			heapSort(updatedFoundArr, numberFound);
			System.out.println("first 4 after sorting on powered on time:");
			for(int i =0; i<4; i++) {
				System.out.println(updatedFoundArr[i].getSerial());
			}
			
			System.out.println("\nlast 4 after sorting on powered on time:");
			for(int i = numberFound-4; i<numberFound; i++) {
				System.out.println(updatedFoundArr[i].getSerial());
			}
			
			PartC partC = new PartC();
			partC(hashTable);
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
