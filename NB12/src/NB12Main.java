
public class NB12Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayQ<String> que = new ArrayQ<String>(4);
		
		System.out.println("Que maxSize: " + que.maxSize());
		for (int i = 0; i < 8; i++) {
			que.offer("String" + i);
		}
		System.out.println("Currently first in que: " + que.peek() + " Que maxSize: " + que.maxSize());
		while(que.size() >= 2){
			System.out.println("Poll:" + que.poll() );
		}
		System.out.println("Que maxSize: " + que.maxSize());

	}

}
