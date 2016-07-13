


public class SingleLinkedList<E> {

	private static class Node<E>{
		private E data;
		private Node<E> next;
		
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public SingleLinkedList(){
		head = new Node<E>(null, null);
		tail = head;
		size = 0;
	}
	
	public void add(int index, E item) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index == 0) {			
			addFirst(item);
		} else if (index == size){
			tail = addAfter(tail, item);
		} else
		{
			Node<E> node = getNode(index-1);
			addAfter(node, item);
		}
	}
	
	public boolean add(E item) {
		add(size, item);
		return true;
	}
	
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		return node.data;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> p = head;
		if(p !=	null) {
			while(p.next != null) {
				sb.append(p.data.toString());
				sb.append(" ==> ");
				p = p.next;
			}
			sb.append(p.data.toString());
		}
		sb.append("]");
		return sb.toString();
	}
	
	public E remove(int index){
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> ret = null;
		if (index == 0){
			ret = getNode(0);
			head = ret.next;
			size--;
		} else {
			Node<E> tmp = null;
			tmp = getNode(index-1);
			ret = tmp.next;
			tmp.next = ret.next;
			size--;		
			if (index == size-1){
				tail = tmp;
			}
		}
		return ret.data;
		
	}
	
	private Node<E> getNode(int index) {
		if(index == size-1){
			return tail;
		}
		Node<E> node = head;
		for (int i = 0; i < index && node != null; i++) {
			node = node.next;
		}
		return node;
	}

	private Node<E> addAfter(Node<E> node, E item) {
			node.next = new Node<E>(item, node.next);
			size++;
			return node.next;
		
	}

	private void addFirst(E item) {
		head = new Node<E>(item, head.next);
		
	}

}
