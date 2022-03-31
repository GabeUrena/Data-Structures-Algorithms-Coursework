
public class ArrayBasedList<I extends Comparable<? super I>>  implements ListInterface<I>{
	private Object[] array = new Object[0];
	int size = array.length;
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public void add(I element) {
		LinkedListNode<I> node = new LinkedListNode<I>(element);
		if(array.length < 0) {
		}else {
			array[array.length-1] = node;	
		}
	}

	@Override
	public boolean add(I element, int index) {
		LinkedListNode<I> node = new LinkedListNode<I>(element);
		if(index <= -1 || index > array.length-1) {
		return false;
		}else {
		array[index] = node;
		return true;
		}
	}

	@Override
	public void addSorted(I element) {
		add(element);
/*
		if (this.isEmpty()) {
			this.add(element);
			return;
		}
		
		LinkedListNode<I> node = new LinkedListNode<I>(element);
		I headElement = head.getData();
		I tailElement = tail.getData();
		
		if (headElement.compareTo(element) >= 0) {
			// inserting before the head
			node.setNext(this.head);
			this.head = node;
		} else if (tailElement.compareTo(element) <= 0) {
			tail.setNext(node);
			this.tail = node;
		} else {
			LinkedListNode<I> prev = head;
			LinkedListNode<I>	next = head.getNext();
			while ((prev != null) && (next != null)) {
				I prevData = prev.getData();
				I nextData = next.getData();
				if ((prevData.compareTo(element) <= 0) && (nextData.compareTo(element) > 0)) {
					break;
				} else {
					prev = next;
					next = prev.getNext();
				}
			}
			node.setNext(next);
			prev.setNext(node);
		}
		this.size++;
		*/
	}

	@Override
	public I get(int index) {
		//LinkedListNode<I> node = array.length-1;
		if (index < 0 || index > array.length-1) {
			return null;
		}
		//return node.getData();
	return null;
	}

	@Override
	public I replace(I element, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(int index) {
		if (size == 0) {
			return false;
		}else {
			Object[] newArray = new Object[array.length-1];
			for (int i = 0, j = 0; i < array.length; i++) {
				if(i == index) {
					continue;
				}
				newArray[j++] = array[i];
			}
			return true;
		}
	}

	@Override
	public void removeAll() {
		Object[] array = new Object[0];
	}

}
