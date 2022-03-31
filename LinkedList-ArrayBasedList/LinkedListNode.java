public class LinkedListNode<I> {

	private I data;
	private LinkedListNode<I> next;
	
	public LinkedListNode() {
		this.data = null;
		this.next = null;
	}
	
	public LinkedListNode(I data) {
		this.data = data;
		this.next = null;
	}
	
	public LinkedListNode(I data, LinkedListNode<I> next) {
		this.data = data;
		this.next = next;
	}

	public I getData() {
		return data;
	}

	public void setData(I data) {
		this.data = data;
	}

	public LinkedListNode<I> getNext() {
		return next;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}
}
