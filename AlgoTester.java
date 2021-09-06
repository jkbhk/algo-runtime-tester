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
	
	public void startTest(int arraySize, int condition) {
		
		this.ARRAY_SIZE = arraySize;
		generateRandomArray();
		testALLAlgorithms(condition);
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
	
	private void testALLAlgorithms(int condition) {
		
		System.out.println("Testing with sample size of " + ARRAY_SIZE);
		System.out.println("============================================\n");
		
		for(ITestable t : algos) {
			int[] copy = new int[ARRAY_SIZE];
			copyArray(generated, copy);
			
			// set starting conditions(if any) before testing
			t.setCondition(condition);
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
	
	public void compare(ITestable a, ITestable b, int fromN, int toN, int interval, boolean multiply) {
		
		System.out.println("N"+"\t\t\t" +a.getName()+ "(comparisons)\t\t" + a.getName()+ "(ms)\t\t\t" + b.getName() + "(comparisons)\t\t\t" + b.getName()+"(ms)");
		
		long acomparisons = 0;
		long bcomparisons = 0;
		long atime;
		long btime;
	
		
		int[] temp1;
		int[] temp2;
		
		if(multiply) {
			
			for(int n= fromN; n<=toN; n*=interval) {
				
				int[] reversed = new int[n];
				reversed = generateRandomArray(n);
				
				temp1 = new int[n];
				temp2 = new int[n];
				
				copyArray(reversed,temp1);
				copyArray(reversed,temp2);
				
				
				long startTime = System.currentTimeMillis();
				acomparisons = a.call(temp1);
				long endTime = System.currentTimeMillis();
				atime = endTime - startTime;
				
				startTime = System.currentTimeMillis();
				bcomparisons = b.call(temp2);
				endTime = System.currentTimeMillis();
				btime = endTime - startTime;
			
				
				System.out.println(n+"\t\t\t" +acomparisons+ "\t\t\t\t\t" + atime+ "\t\t\t\t" + bcomparisons + "\t\t\t\t\t" + btime);
				
				
			}
		} else {
			
			for(int n= fromN; n<=toN; n+=interval) {
				
				int[] reversed = new int[n];
				reversed = generateRandomArray(n);
				
				temp1 = new int[n];
				temp2 = new int[n];
				
				copyArray(reversed,temp1);
				copyArray(reversed,temp2);
				
				
				long startTime = System.currentTimeMillis();
				acomparisons = a.call(temp1);
				long endTime = System.currentTimeMillis();
				atime = endTime - startTime;
				
				startTime = System.currentTimeMillis();
				bcomparisons = b.call(temp2);
				endTime = System.currentTimeMillis();
				btime = endTime - startTime;
			
				
				System.out.println(n+"\t\t\t" +acomparisons+ "\t\t\t\t\t" + atime+ "\t\t\t\t" + bcomparisons + "\t\t\t\t\t" + btime);
				
				
			}
		}
		
	}
	
	
	
}
