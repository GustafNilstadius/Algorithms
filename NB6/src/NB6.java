
public class NB6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<String> list = new SingleLinkedList<>();
		list.add("Kakor");
		list.add("är");
		list.add("gott");
		list.add("!");
		
		System.out.println(list.toString());
		

		list.add(2, "väldigt");
		System.out.println(list.toString());
		
		list.remove(0);
		list.remove(list.getSize()-1);
		list.add(1, "kakor");
		list.add("?");
		System.out.println(list.toString());
		
		System.out.println(list.get(0));
		System.out.println(list.get(list.getSize()-1));
		
	}

}
