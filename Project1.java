public class Project1 {
	
	public static void main(String[] args) {	
		
		AlgoTester tester = new AlgoTester();
		tester.previewSequence = false;
		
		tester.addAlgo(new InsertionSort());
		tester.addAlgo(new MergeSort());
		tester.addAlgo(new HybridSort());
		
		// start test with array size of 1000 and starting condition of 10 for all algorithms
		tester.startTest(1000, 10);
		
	}
		
}
