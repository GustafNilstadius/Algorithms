
/**
 * @author Gustaf Nilstadius
 * @version 0
 */
public class NB18 {

	public static void main(String[] args) {
		System.out.println("Binary string('00101010') to int : " + binaryStringToInt("00101010"));
		System.out.println("Integer 1337 to binary : " + intToBinaryString(1337));

	}

	public static String intToBinaryString(int toBinary){
		return intToBinaryString(toBinary, new StringBuilder()).toString();
	}

	private static StringBuilder intToBinaryString(int toBinary, StringBuilder sb){
		if(toBinary == 0){
			return null;
		}
		intToBinaryString(toBinary >>> 1, sb);
		return sb.append(toBinary & 1);
	}


	public static int binaryStringToInt(String s){
		return binaryStringToInt(s, 0);
	}

	private static int binaryStringToInt (String s, int n){
		if(n == s.length()){
			return 0;
		}
		if(s.charAt(s.length()-(n+1)) == '1'){
			return (int) (Math.pow(2, n) + binaryStringToInt(s, n+1));
		} else {
			return binaryStringToInt(s, n+1);
		}

	}

}
