import java.util.LinkedList;


public class Dequeue<E> {

	LinkedList<E> list;
	int size;
	
	public Dequeue(){
		list = new LinkedList<E>();
		size = 0;
	}
	
	public E pollFirst(){
		if(size == 0){
			return null;
		} else {
			size--;
			return list.pollFirst();
		}
	}
	public E pollLast(){
		if(size == 0){
			return null;
		} else {
			size--;
			return list.pollLast();
		}
	}
	
	public void offerFirst(E offer){
		list.addFirst(offer);
		size++;
	}
	public void offerLast(E offer){
		list.addLast(offer);
		size++;
	}
	public void empty(){
		list = new LinkedList<E>();
		size = 0;
	}

}
