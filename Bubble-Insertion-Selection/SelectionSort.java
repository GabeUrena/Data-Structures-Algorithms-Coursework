
public class SelectionSort extends TestTimes implements SortInterface {

	@Override
	public void sort(Integer[] arrayToSort) {
		
	        for (int i = 0; i < arrayToSort.length-1; i++)  { 
	            int min = i; 
	            for (int j = i+1; j < arrayToSort.length; j++) { 
	                if (arrayToSort[j] <= arrayToSort[min]) { min = j; }
	            }
	            int temp = arrayToSort[min]; 
	            arrayToSort[min] = arrayToSort[i]; 
	            arrayToSort[i] = temp; 
	}
	        
}
}
