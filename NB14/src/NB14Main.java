
public class NB14Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dequeue<String> que = new Dequeue<String>();
		
		for (int i = 0; i < 8; i++) {
			que.offerFirst("String" + i);
		}
		for (int i = 0; i < 4; i++) {
			System.out.println("PollFirst: " + que.pollFirst());
		}
		for (int i = 100; i < 108; i++) {
			que.offerLast("String" + i);
		}
		for (int i = 0; i < 4; i++) {
			System.out.println("PollLast: " + que.pollLast());
		}
		que.empty();
		System.out.println("que empty: " + que.pollFirst());

	}

}
