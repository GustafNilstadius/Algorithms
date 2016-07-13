import java.util.Iterator;


public class NB7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<String> list = new SingleLinkedList<>();
		
		for (int i = 1; i < 11; i++) {
			list.add("Kaka " + i );
		}
		
		System.out.println("Added to liked list:");
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			System.out.println("\t" + iter.next());
		}
		
		
		iter = list.iterator();
		for (int i = 1; i < 11; i++) {
			iter.next();
			if(i%2 != 0 || i == 1){
				System.out.println("i = "+ i);
				iter.remove();
			}
		}
		
		System.out.println("Divisable with 2:");
		iter = list.iterator();
		while(iter.hasNext()){
			System.out.println("\t" + iter.next());
		}
		
		list.add("Kaka 123123");
		System.out.println(list.toString());
		

	}

}
