import java.util.ArrayList;


public class ArrayListStack <E> implements StackInt<E> {

	private ArrayList<E> list;
	
	public ArrayListStack (){
		list = new ArrayList<E>();
	}
	@Override
	public E push(E obj) {
		list.add(obj);
		return obj;
	}

	@Override
	public E peek() {
		return list.get(list.size() - 1 );
	}

	@Override
	public E pop() {
		return list.remove(list.size()-1);
	}

	@Override
	public boolean empty() {
		return list.size() == 0;
	}

}
