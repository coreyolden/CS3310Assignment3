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
			
			
			
			String[] updatedFoundArr = new String[numberFound]; //new array with only ones actually found
			
			
			int index = 0; 
			
			for(int i = 0; i<length; i++) {
				if(foundHDArr[i].getSerial().compareTo("notFound") != 0) {
					updatedFoundArr[index]=foundHDArr[i].getSerial(); //if an actual HD then add it to the new array
					index++;
				}
			}
			
			
			
			
			// do all sorts so I can print first and last 4.
			//do quick sort and print all results
			QuickSort qs = new QuickSort(hashTable);
			updatedFoundArr = qs.quickSort( updatedFoundArr, 0, numberFound-1);	
			System.out.println("first 4 after sorting on model name:");
			for(int i = 0; i<4; i++) {
				System.out.println(hashTable.get(updatedFoundArr[i]).getSerial()+"   "+hashTable.get(updatedFoundArr[i]).getModel());
			}
			System.out.println("\nlast 4 after sorting on model name:");
			for(int i = numberFound-4; i<numberFound; i++) {
				System.out.println(hashTable.get(updatedFoundArr[i]).getSerial()+"   "+hashTable.get(updatedFoundArr[i]).getModel());
			}
			System.out.println("\n---------------\n");
			
			
			//do merge sort and print all results
			MergeSort ms = new MergeSort(hashTable);
			updatedFoundArr = ms.mergeSort(updatedFoundArr, 0, numberFound-1);
			
			
			System.out.println("first 4 after sorting on capacity:");
			for(int i =0; i<4; i++) {
				System.out.println(hashTable.get(updatedFoundArr[i]).getSerial()+"   "+hashTable.get(updatedFoundArr[i]).getCapacity());
			}
			
			System.out.println("\nlast 4 after sorting on capacity:");
			for(int i = numberFound-4; i<numberFound; i++) {
				System.out.println(hashTable.get(updatedFoundArr[i]).getSerial()+"   "+hashTable.get(updatedFoundArr[i]).getCapacity());
			}
			
			System.out.println("\n---------------\n");
			
			HeapSort hs = new HeapSort(hashTable);
			updatedFoundArr = hs.heapSort(updatedFoundArr, numberFound);
			System.out.println("first 4 after sorting on powered on time:");
			for(int i =0; i<4; i++) {
				System.out.println(hashTable.get(updatedFoundArr[i]).getSerial()+"   "+hashTable.get(updatedFoundArr[i]).getPoweredOnTime());
			}
			
			System.out.println("\nlast 4 after sorting on powered on time:");
			for(int i = numberFound-4; i<numberFound; i++) {
				System.out.println(hashTable.get(updatedFoundArr[i]).getSerial()+"   "+hashTable.get(updatedFoundArr[i]).getPoweredOnTime());
			}
			
			
		}
			
		
	}
	
	
	
	
	

}
