# algo-runtime-tester

A simple tester to compare execution time for any algorithm.


## How to use
### 1) Wrap your algorithm in a class 
### 2) Have your class implement ITestable
### 3) Create an instance of AlgoTester anywhere in your project
```
AlgoTester tester = new AlgoTester();
```
### 4) Call the addAlgo(ITestable t) function of AlgoTester and pass it an instance of your algorithm class
### 5) Call startTest(int n) of AlgoTester, with n as the desired sample size.

## Additional notes
AlgoTester will generate a random array of unsorted numbers from range 1 - n and runs copies of this randomly generated array on all your sorting algorithms. At the end of the test, key comparisons as well as CPU run time will be shown for each algorithm.

Project1.java contains the example driver code.

