import java.util.Iterator;
import java.util.NoSuchElementException;


//NB7

public class SingleLinkedList<E> {

	private static class Node<E>{
		private E data;
		private Node<E> next;
		
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private class Itr implements Iterator<E>{
		Node<E> current;
		Node<E> sleeper;
		int stepNr;
		public Itr(Node<E> start) {
			current = start;
			sleeper = new Node<E>(null, new Node<E>(null, head));
			stepNr = 0;
		}
		@Override
		public boolean hasNext() {
			return current != null;
		}
		@Override
		public E next() {
			if(current == null) {
				throw new NoSuchElementException();
			}
			E returnValue = current.data;
			
			stepNr++;
			if(sleeper.next != current){
				sleeper = sleeper.next;
			}
			
			current = current.next;
						
			return returnValue;
		}
		@Override
		public void remove() {
			if (stepNr == 0){
				throw new NoSuchElementException();
			} else if(stepNr == 1){
				sleeper.next = current;
				head = sleeper.next;
			} else {
				sleeper.next = current;
			}
			size--;
		}
	}
	
	private Node<E> head;
	private int size;
	
	public SingleLinkedList(){
		head = new Node<E>(null, null);
		size = 0;
	}
	public Iterator<E> iterator(){
		return new Itr(head);
	}
	
	public void add(int index, E item) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index == 0) {			
			addFirst(item);
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
		}
		return ret.data;
		
	}
	
	private Node<E> getNode(int index) {
		Node<E> node = head;
		for (int i = 0; i < index && node != null; i++) {
			node = node.next;
		}
		return node;
	}

	private void addAfter(Node<E> node, E item) {
			node.next = new Node<E>(item, node.next);
			size++;
		
	}

	private void addFirst(E item) {
		head = new Node<E>(item, head.next);
		size++;
		
	}

}
