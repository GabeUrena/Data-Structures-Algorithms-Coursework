
public class LinkedList<I extends Comparable<? super I>> implements ListInterface<I> {

	private int size = 0;
	private LinkedListNode<I> head = null;
	private LinkedListNode<I> tail = null;
	
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
		if (this.size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.setNext(node);
			this.tail = node;
		}
		
		size++;
	} 

	@Override
	public boolean add(I element, int index) {
		if (index <= this.size) {
			if (index == this.size) {
				this.add(element);
				return true;
			} else if (index == 0) {
				LinkedListNode<I> node = new LinkedListNode<I>(element);
				node.setNext(this.head);
				this.head = node;
				this.size++;
				return true;
			} else {
				LinkedListNode<I> node = new LinkedListNode<I>(element);
				LinkedListNode<I> previous = this.head;
				index--;
				while (index != 0) {
					previous = previous.getNext();
					index--;
				}
				node.setNext(previous.getNext());
				previous.setNext(node);
				this.size++;
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public void addSorted(I element) {

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
	}

	@Override
	public I get(int index) {
		LinkedListNode<I> node = head;
		while (index != 0) {
			node = node.getNext();
			index--;
		}
		return node.getData();
	}

	@Override
	public I replace(I element, int index) {
		I data = null;
		if (index == 0 ) {
			data = head.getData();
			head.setData(element);
			return data;
		} else if (index == this.size - 1) {
			data = tail.getData();
			tail.setData(element);
			return data;
		} else if (index < this.size) {
			LinkedListNode<I> node = head;
			while (index != 0) {
				node = node.getNext();
				index--;
			}
			data = node.getData();
			node.setData(element);
			return data;
		} else {
			return null;
		}
	}

	@Override
	public boolean remove(int index) {
		if (index > this.size - 1) {
			return false;
		} else if (index == 0) {
			// removing head
			this.head = this.head.getNext();
		} else {
			// removing a middle node
			LinkedListNode<I> previous = this.head;
			index--;
			while (index != 0) {
				previous = previous.getNext();
				index--;
			}
			LinkedListNode<I> nodeToRemove = previous.getNext();
			previous.setNext(nodeToRemove.getNext());
			if (nodeToRemove == tail) {
				this.tail = previous;
			}
		}

		size--;
		return true;
	}

	@Override
	public void removeAll() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public String toString() {
		String s = "";
		LinkedListNode<I> curNode = head;
		while (curNode != null) {
			s = s + curNode.getData() + " - ";
			curNode = curNode.getNext();
		}
		s = s + "Size Of List = " + this.size;
		return s;
	}
	
	
}