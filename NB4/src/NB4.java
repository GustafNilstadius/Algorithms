
/**
 * @author Gustaf Nilstadius
 * @since	2015-01-27
 */
public class NB4 {

	private static class Node{
		public String data;
		public Node next;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Node head = new Node();
		head.data = null;
		
		head.next = new Node();
		Node tmp = head.next;
		tmp.data = new String("Gilgamesh");
		tmp.next = new Node();
		tmp = tmp.next;
		tmp.data = new String("löper");
		tmp.next = new Node();
		tmp = tmp.next;
		tmp.data = new String("på");
		tmp.next = new Node();
		tmp = tmp.next;
		tmp.data = new String("steppen");
		tmp.next = null;
		
		tmp = head.next;
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		} 
		System.out.println("");
		
		tmp = head.next;
		while(tmp.next != null) {
			if (tmp.next.data.equals("på")){
				tmp.next = tmp.next.next;
			} else {
				tmp = tmp.next;
			}
		} 
		
		tmp = head.next;
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		} 



	}

	

}

