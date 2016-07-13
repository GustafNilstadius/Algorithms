
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackInt<String> stack = new ArrayListStack<String>();
		
		for (int i = 1; i < 11; i++) {
			stack.push("String" + i);
			System.out.println("Added to stack: String" + i);
		}
		
		System.out.println("peek : " + stack.peek());
		
		while(!stack.empty()){
			System.out.println("pop: " + stack.pop());
		}

	}

}
