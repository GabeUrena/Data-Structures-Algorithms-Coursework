import java.util.Random;
public class Driver implements DriverInterface{
	public static void main(String[] args) {
		BubbleSort BSTest = new BubbleSort();
		InsertionSort ISTest = new InsertionSort();
		SelectionSort SSTest = new SelectionSort();
		Driver driver = new Driver();
		
		int arrayLength = 10000;
		
		
		//ArrayLength: 1000   ArrayType: Equal     				BubbleSort: 9084100     InsertionSort: 148300     SelectionSort: 135500
		//ArrayLength: 1000   ArrayType: Random   				BubbleSort: 17100100     InsertionSort: 5488100     SelectionSort: 2292900
		//ArrayLength: 1000   ArrayType: Increasing     		BubbleSort: 8829800     InsertionSort: 161200     SelectionSort: 135700
		//ArrayLength: 1000   ArrayType: Decreasing     		BubbleSort: 17516200    InsertionSort: 8040400    SelectionSort: 975900
		//ArrayLength: 1000   ArrayType: IncreasingAndRandom    BubbleSort: 11773900     InsertionSort: 2101700     SelectionSort: 1853200
		//ArrayLength: 10000   ArrayType: Equal    				BubbleSort: 9084100     InsertionSort: 148300     SelectionSort: 135500
		//ArrayLength: 10000   ArrayType: Random     			BubbleSort: 316139300     InsertionSort: 50589300     SelectionSort: 39425000
		//ArrayLength: 10000   ArrayType: Increasing    		BubbleSort: 47536300     InsertionSort: 2043500    SelectionSort: 1427700
		//ArrayLength: 10000   ArrayType: Decreasing     		BubbleSort: 326261000     InsertionSort: 80600500     SelectionSort: 73971700
		//ArrayLength: 10000   ArrayType: IncreasingAndRandom   BubbleSort: 161875400    InsertionSort: 16355300    SelectionSort: 6171300
		
		long TimeBefore = System.nanoTime();
		BSTest.sort(driver.createArray(ArrayType.Decreasing,arrayLength));
		long TimeAfter = System.nanoTime();
		long Time = TimeAfter - TimeBefore;
		System.out.println("Total time for BubbleSort: " + Time);
		
		
		TimeBefore = System.nanoTime();
		ISTest.sort(driver.createArray(ArrayType.Decreasing,arrayLength));
		TimeAfter = System.nanoTime();
		Time = TimeAfter - TimeBefore;
		System.out.println("Total time for InsertionSort: " + Time);
		
		TimeBefore = System.nanoTime();
		SSTest.sort(driver.createArray(ArrayType.Decreasing,arrayLength));
		TimeAfter = System.nanoTime();
		Time = TimeAfter - TimeBefore;
		System.out.println("Total time for SelectionSort: " + Time);
	
	}
	
	@Override
	public Integer[] createArray(ArrayType arrayType, int arraySize) {
		if(arrayType == ArrayType.Equal) {
			Integer[] Equal = new Integer[arraySize];
			for(int i = 0 ; i < arraySize;i++) {
				Equal[i] = arraySize;
			}
			return Equal;
			
		}else if(arrayType == ArrayType.Random) {
			Integer[] Random = new Integer[arraySize];
			Random rand = new Random();
			for(int i = 0 ; i < arraySize;i++) {
				rand = new Random();
				int randGenNum = rand.nextInt(arraySize);
				Random[i] = randGenNum;
			}	
			return Random;
			
		}else if(arrayType == ArrayType.Increasing) {
			Integer[] Increasing = new Integer[arraySize];
			for(int i = 0 ; i < arraySize;i++) {
				Increasing[i]=i+1;
			}
			return Increasing;
			
		}else if(arrayType == ArrayType.Decreasing) {
			Integer[] Decreasing = new Integer[arraySize];
			for(int i = arraySize ; i > 0;i--) {
				Decreasing[arraySize-i]=i;
			}
			return Decreasing;
			
		}else if(arrayType == ArrayType.IncreasingAndRandom) {
			Integer[] IncreasingAndRandom = new Integer[arraySize];
			for(int i = 0 ; i < arraySize;i++) {
				IncreasingAndRandom[i]=i+1;
			}
			int TenPercent = (arraySize / 10 ) * 9;
			for(int i = TenPercent ; i < arraySize;i++) {
				Random rand = new Random();
				int randGenNum = rand.nextInt(arraySize);
				IncreasingAndRandom[i] = randGenNum;
			}
			return IncreasingAndRandom; 
		}
		return null;
	}
	@Override
	public TestTimes runSort(SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes) {
		SelectionSort SSort = new SelectionSort();
		InsertionSort ISort = new InsertionSort();
		BubbleSort BSort = new BubbleSort();
		TestTimes runTime = new TestTimes();
		
		
		if(sortType == SortType.BubbleSort) {
		int i = 0;
		while(i < numberOfTimes) {
			long TimeBefore = System.nanoTime();
			BSort.sort(createArray(arrayType,arraySize));
			long TimeAfter = System.nanoTime();
			long Time = TimeAfter - TimeBefore;
			runTime.addTestTime(Time);
			i++;
			}
		}
		
		else if(sortType == SortType.SelectionSort) {
			int i = 0;
			while(i < numberOfTimes) {
				long TimeBefore = System.nanoTime();
				SSort.sort(createArray(arrayType,arraySize));
				long TimeAfter = System.nanoTime();
				long Time = TimeAfter - TimeBefore;
				runTime.addTestTime(Time);
				i++;
				}
			}
		
		else if(sortType == SortType.InsertionSort) {
			int i = 0;
			while(i < numberOfTimes) {
				long TimeBefore = System.nanoTime();
				ISort.sort(createArray(arrayType,arraySize));
				long TimeAfter = System.nanoTime();
				long Time = TimeAfter - TimeBefore;
				runTime.addTestTime(Time);
				i++;
				}
			}		
		
		return runTime;
	}

}
