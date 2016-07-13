
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedStack<String> stack = new LinkedStack<String>();
		for (int i = 1; i < 11; i++) {
			stack.push("String" + i);
			System.out.println("Added to stack: String" + i);
		}
		
		System.out.println("peek : " + stack.peek() + "\n\n");
		
		System.out.println("Peek at " + stack.size()/2 + " : " + stack.peek(stack.size()/2) + "\n\n");
		
		System.out.println("Pop at " + stack.size()/2 + " : " + stack.pop(stack.size()/2) + "\n\n");
		
		int x = stack.size();
		for (int i = 0; i < x; i++) {
			System.out.println("peek at " + i + " : " + stack.peek(i));
		}
		
		System.out.println("Flush return : " + stack.flush());
		
		System.out.println("Flush donne, size: " + stack.size());
		
		

	}

}
