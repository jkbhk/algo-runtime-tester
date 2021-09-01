
public class HybridSort implements ITestable{

	long comparisons = 0;
	
	private int S = 5;
	
	public void setCondition(int c) {
		this.S = c;
	}
	
	public long call(int[] arr) {
		hybridSort(arr,0, arr.length-1 , S);
		return comparisons;
	}
	
	public String getName() {
		return "Hybrid Sort";
	}
	
	private void hybridSort(int[] arr, int start, int end, int S) {

		if((end - start + 1) <= S) {

			// insertion sort
			
			for(int i = start; i < end; i++) {			
				for(int j = i; j > start; j--) {
					
					comparisons++;
					
					if(arr[j] < arr[j-1]) {
						int temp = arr[j-1];
						arr[j-1] = arr[j];
						arr[j] = temp;
					}else
						break;
				}	
			}
		} else {
			
			// merge sort
			
			int middle = ((end+start)/2);
			
			hybridSort(arr, start, middle, S);

			hybridSort(arr, middle+1, end, S);
			
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
}
