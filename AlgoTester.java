import java.util.ArrayList;
import java.util.Random;

public class AlgoTester {

	private ArrayList<ITestable> algos = new ArrayList<ITestable>();
	private int[] generated;
	private int ARRAY_SIZE = 10;
	
	public boolean previewSequence = false;
	
	public static AlgoTester instance;
	
	public AlgoTester() {
		instance = this;
	}
	
	public void addAlgo(ITestable t) {
		algos.add(t);
	}
	
	public void startTest(int arraySize) {
		
		this.ARRAY_SIZE = arraySize;
		generateRandomArray();
		testALLAlgorithms();
	}
	
	
	
	private void generateRandomArray() {
		Random r = new Random();
		generated = new int[ARRAY_SIZE];
		
		for(int i = 0 ; i < ARRAY_SIZE; i++){
			generated[i] = r.nextInt(ARRAY_SIZE) + 1;
		}	
	}
	
	private static void copyArray(int[] from, int[] to) {
		
		for(int i = 0 ; i < from.length; i++) {
			to[i] = from[i];
		}
	}
	
	private void testALLAlgorithms() {
		
		System.out.println("Testing with sample size of " + ARRAY_SIZE);
		System.out.println("============================================\n");
		
		for(ITestable t : algos) {
			int[] copy = new int[ARRAY_SIZE];
			copyArray(generated, copy);
			
			testAlgo(t,copy);
		}
		
		System.out.println("Test complete.");
		
	}
	
	private void printArr(int[] arr) {
		for(int i : arr) {
			System.out.print(i +" ");
		}
		
		System.out.println("\n");
	}
	
	private void testAlgo(ITestable t, int[] arr) {
		
		if(previewSequence)
			printArr(arr);
		
		String algoName = t.getName();
		
		System.out.println(algoName +" is sorting... ");
		long startTime = System.currentTimeMillis();
		long comparisons = t.call(arr);
		long endTime = System.currentTimeMillis();
		System.out.println(algoName +" done!");
		
		if(previewSequence)
			printArr(arr);
		
		
		System.out.println(algoName + " timing: " + (endTime - startTime) + " ms");
		System.out.println("Key comparisons: " + comparisons);
		System.out.println();
		
	}
	
	
	
}
