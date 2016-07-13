import java.util.EmptyStackException;
public class LinkedStack<E> implements StackInt<E> {
	
	private static class Node<E> {
		private E data;
		private Node<E> next;
		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
	}
	
	private Node<E> top;
	
	public LinkedStack(){
		top = null;
	}
	
	@Override
	public E push(E obj) {
		top = new Node<E>(obj, top);
		return obj;
	}
	
	@Override
	public E pop() {
		if (empty()) {
			throw new EmptyStackException();
		} else {
			E result = top.data;
			top = top.next;
			return result;
		}
	}
	
	@Override
	public E peek() {
		if (empty()) {
			throw new EmptyStackException();
		} else {
			return top.data;
		}
	}
	
	@Override
	public boolean empty() {
		return top == null;
	}
	
	public int size(){
		int ret = 0;
		Node tmp = top;
		while (tmp != null){
			ret++;
			tmp = tmp.next;
		}
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public E peek(int n){
		Node tmp = top;
		for(int i = 0; i < n; i++){
			tmp = tmp.next;
			if(tmp == null){
				throw new IndexOutOfBoundsException();
			}
		}
		return (E)tmp.data;
	}
	
	public E pop(int n){
		Node tmp = top;
		Node ret;
		for(int i = 0; i < n-1; i++){
			tmp = tmp.next;
			if(tmp.next == null){
				throw new IndexOutOfBoundsException();
			}
		}
		ret = tmp.next;
		
		tmp.next = tmp.next.next;
		return (E) ret.data;
		
	}
	
	public E flush(){
		Node tmp = top;
		while(tmp.next != null){
			tmp = tmp.next;
		}
		top = null;
		return (E) tmp.data;
	}
	
}