
public class InsertionSort implements ITestable{
	
	private long comparisons = 0;
	
	public String getName() {
		return "Insertion Sort";
	}

	public long call(int[] arr) {

		insertionSort(arr);
		return comparisons;
	}
	
	private void insertionSort(int[] arr) {
		
		for(int i = 1; i < arr.length; i++) {			
			for(int j = i; j > 0; j--) {
				
				comparisons++;
				
				if(arr[j] < arr[j-1]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}else
					break;
			}	
		}
	}
	
}
