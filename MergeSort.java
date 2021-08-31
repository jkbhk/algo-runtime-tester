
public class MergeSort implements ITestable{

	private long comparisons = 0;
	
	public String getName() {
		return "Merge Sort";
	}
	
	public long call(int[] arr) {
		
		mergeSort(arr,0,arr.length-1);
		return comparisons;
	}
	
	private void mergeSort(int[] arr, int start, int end) {
		
		if(start >= end)
			return;
		
		int middle = ((end+start)/2);
		
		mergeSort(arr, start, middle);

		mergeSort(arr, middle+1, end);
		
		int leftStart = start;
		int rightStart = middle+1;
		
		int leftSize = (middle - start) + 1;
	    int rightSize = end - (middle+1)  +1;
		
		boolean sorted = false;
		
		// clone subarrays
		int[] leftClone = new int[leftSize];
		for(int x = 0; x < (leftSize); x++) {
			leftClone[x] = arr[leftStart + x];
			
		}
		
		int[] rightClone = new int[rightSize];
		for(int y = 0; y < (rightSize); y++) {
			rightClone[y] = arr[rightStart + y];
			
		}

		int leftIter = 0;
		int rightIter = 0;
		int mainIter = leftStart;
		
		while(!sorted) {
			
			if(leftClone[leftIter] <= rightClone[rightIter]) {
				arr[mainIter] = leftClone[leftIter];
				leftIter++;
			}else {
				arr[mainIter] = rightClone[rightIter];
				rightIter++;
			}
			
			comparisons++;
			mainIter++;

			// dump leftover values
			
			if(leftIter >= leftSize || rightIter >= rightSize) {
				
				for(int k = leftIter; k < leftSize; k++) {
					arr[mainIter] = leftClone[k];
					mainIter++;
				}
				
				for(int j = rightIter; j < rightSize; j++) {
					arr[mainIter] = rightClone[j];
					mainIter++;
				}
					
				sorted = true;
			}
			
		}
	}
	
}
