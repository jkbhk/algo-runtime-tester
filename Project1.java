public class Project1 {
	
	public static void main(String[] args) {	
		
		AlgoTester tester = new AlgoTester();
		tester.previewSequence = false;
		
		tester.addAlgo(new InsertionSort());
		tester.addAlgo(new MergeSort());
		tester.addAlgo(new HybridSort());
		
		tester.startTest(1000);
		
	}
		
}
