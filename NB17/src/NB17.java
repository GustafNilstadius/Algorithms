
public class NB17 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Öre för att nå 109 poäng: " + myntmaskin(109));

	}

	public static int myntmaskin(int goal){
		return myntmaskin(goal, 1, 0);
	}

	private static int myntmaskin(int goal, int current, int cent){
		if(goal == current){
			return cent;
		} else if(current < goal){
			int path1 = myntmaskin(goal, current*3, cent+10);
			int path2 = myntmaskin(goal, current+4, cent+5);
			if(path1 < path2){
				return path1;
			} else {
				return path2;
			} 
		} else {
			return Integer.MAX_VALUE;
		}
	}

}
