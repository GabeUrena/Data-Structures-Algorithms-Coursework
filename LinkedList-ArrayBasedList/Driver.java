
public class Driver implements DriverInterface{

	@Override
	public ListInterface<Integer> createList(ListType listType, TestType forTestType) {
		if(forTestType == TestType.AddSortedOdd ) {
			if(listType == ListType.ArrayBasedList) {
				int[] array = new int[5000];
				for(int i = 0; i<10000;) {
					int j = 0;
					j++;
					i = i+2;
					array[j]=i;
				}
				
				//return array[];
			}else if(listType == ListType.LinkedList){
				
			} else {
				return null;
			}
		}
		return null;
		
		
	}

	@Override
	public ListInterface<Integer> initializeList(ListInterface<Integer> list, int firstNumber, int lastNumber,int increment) {
		
		return null;
	}

	@Override
	public double memoryUsage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TestTimes runTestCase(ListType listType, TestType testType, int numberOfTimes) {
		// TODO Auto-generated method stub
		return null;
	}

}
