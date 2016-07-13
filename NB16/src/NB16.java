
public class NB16 {

	static int[] intArray = {1, 4, 87, 123, 5, 99, 1337, 2};
	public static void main(String[] args) {
		System.out.println("Largest int: " + largestInt(intArray));
		System.out.println("Rekursivt 4^8: " + powOfRek(4, 8));
		System.out.println("Itterativt 4^8: " + powOfItr(4, 8));
		System.out.println("sqr(9): " + rot(9));
	}
	
	public static double rot(double n){
		return rot(n, 1, 0.000000001d);
	}
	
	private static double rot(double n, double a, double e){
		if(Math.abs((Math.pow(a, 2)-n)) < e){
			return a;
		} else {
			return rot(n, ((Math.pow(a, 2)+n))/(2*a), e);
		}
	}
	
	public static int powOfItr(int x, int n){
		int ret = 1;
		for (int i = 0; i < n; i++) {
			ret*=x;
		}
		return ret;
	}
	
	public static int powOfRek(int x, int n){
		if(n == 1){
			return x;
		}
		return x*=powOfRek(x, n-1);
	}
	
	public static int largestInt(int[] array){
		return largestInt(array, 0, 0);
	}
	private static int largestInt(int[] array, int largest, int possition){
		if(possition == array.length){
			return largest;
		}
		if(largest < array[possition]){
			largest = array[possition];
		}
		return largestInt(array, largest, possition+1);

	}

}
