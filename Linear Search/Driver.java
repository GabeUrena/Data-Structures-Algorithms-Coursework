public class Driver implements DriverInterface{
	public static void main(System[] args) {
		
		
		
		
		
		
		
		
	}
	
	
	@Override
	public int[] getListOfNumbers() {
		int[] ListOfNumbers = new int[10000000];
		for(int i = 0 ; i < 10000000;i++) {
			ListOfNumbers[i]=i+1;
		}
		return ListOfNumbers;
	}

	@Override
	public int[] getTargets() {
		int[] targets = {500,10000, 100000, 1000000,5000000,7500000,10000000};
		return targets;
	}

	@Override
	public TestTimes runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes) {
		LinearSearch apple = new LinearSearch();
		TestTimes mango = new TestTimes();
		int i = 0;
		while(i < numberOfTimes) {
			long TimeBefore = System.nanoTime();
			apple.search(listOfNumbers, target);
			long TimeAfter = System.nanoTime();
			long Time = TimeAfter - TimeBefore;
			mango.addTestTime(Time);
			i++;
		}
		
		return mango;
	}

	@Override
	public TestTimes runBinarySearch(int[] listOfNumbers, int target, int numberOfTimes) {
		BinarySearch apple = new BinarySearch();
		TestTimes mango = new TestTimes();
		int i = 0;
		while(i < numberOfTimes) {
			long TimeBefore = System.nanoTime();
			apple.search(listOfNumbers, target);
			long TimeAfter = System.nanoTime();
			long Time = TimeAfter - TimeBefore;
			mango.addTestTime(Time);
			i++;
		}
		
		return mango;
	}

}
