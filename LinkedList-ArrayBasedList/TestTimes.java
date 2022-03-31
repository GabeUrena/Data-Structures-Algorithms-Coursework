public class TestTimes implements TestTimesInterface{
	private long[] testTimes = new long[10];
	private int numTestTimes = 0;
	@Override
	public long getLastTestTime() {
		return testTimes[numTestTimes-1];
	}
	@Override
	public long[] getTestTimes() {
		return testTimes.clone();
	}
	@Override
	public void resetTestTimes() {
		for (int i = 0; i <= testTimes.length-1; i++) {
			testTimes[i] = 0;
		}
		numTestTimes = 0;
	}
	@Override
	public void addTestTime(long testTime) {
		numTestTimes++;
		if (numTestTimes > testTimes.length) {
			for(int i = 0; i < testTimes.length-2; i++) {
				testTimes[i] = testTimes[i+1];
			}
			testTimes[testTimes.length-1] = testTime;
		}else {
		testTimes[numTestTimes-1] = testTime;
		}
	}
	@Override
	public double getAverageTestTime() {
		long sum = 0;
		double average;
		for(int i = 0; i < testTimes.length-1; i++) {
			 sum = Long.sum(testTimes[i], testTimes[i+1]);  
	            testTimes[i+1]=sum;  
		}
		average = sum;
		average= average / testTimes.length;
		return average;
	}
}
